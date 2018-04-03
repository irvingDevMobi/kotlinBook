package lopez.irving.kotlinbook.data.db

import lopez.irving.kotlinbook.data.db.mappers.DbDataMapper
import lopez.irving.kotlinbook.data.db.model.CityForecast
import lopez.irving.kotlinbook.data.db.model.DayForecast
import lopez.irving.kotlinbook.domain.datasource.ForecastDataSource
import lopez.irving.kotlinbook.domain.model.Forecast
import lopez.irving.kotlinbook.domain.model.ForecastList
import lopez.irving.kotlinbook.extensions.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 *
 * @author irving.lopez
 * @since 14/03/2018.
 */
class ForecastDb(private val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
                 private val dataMapper: DbDataMapper = DbDataMapper()) : ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use {
        val dailyRequest = "${DayForecastTable.CITY_ID} = ? AND ${DayForecastTable.DATE} >= ?"
        val dailyForecast = select(DayForecastTable.NAME).whereSimple(dailyRequest, zipCode.toString(), date.toString())
                .parseList { DayForecast(HashMap(it)) }
        val city = select(CityForecastTable.NAME).whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
                .parseOpt { CityForecast(HashMap(it), dailyForecast) }
        if (city != null) dataMapper.convertToDomain(city) else null
    }

    override fun requestDayForecast(id: Long): Forecast? = forecastDbHelper.use {
        val forecast = select(DayForecastTable.NAME).byId(id).parseOpt { DayForecast(HashMap(it)) }
        if (forecast == null) {
            null
        } else {
            dataMapper.convertDayToDomain(forecast)
        }
    }

    fun saveForecast(forecast: ForecastList) = forecastDbHelper.use {
        clear(CityForecastTable.NAME)
        clear(DayForecastTable.NAME)
        with(dataMapper.convertFromDomain(forecast)) {
            insert(CityForecastTable.NAME, *map.toVarargArray())
            dailyForecast.forEach { insert(DayForecastTable.NAME, *it.map.toVarargArray()) }
        }
    }
}
