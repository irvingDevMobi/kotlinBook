package lopez.irving.kotlinbook.data.db.mappers

import lopez.irving.kotlinbook.data.db.model.CityForecast
import lopez.irving.kotlinbook.data.db.model.DayForecast
import lopez.irving.kotlinbook.domain.model.Forecast
import lopez.irving.kotlinbook.domain.model.ForecastList


/**
 *
 * @author irving.lopez
 * @since 14/03/2018.
 */
class DbDataMapper {

    fun convertToDomain(forecast: CityForecast) = with(forecast) {
        val daily = dailyForecast.map { convertDayToDomain(it) }
        ForecastList(_id, city, country, daily)
    }

    private fun convertDayToDomain(dayForecast: DayForecast) = with(dayForecast) {
        Forecast(date, description, high, low, iconUrl)
    }

    fun convertFromDomain(forecast: ForecastList) = with(forecast) {
        val daily = dailyForecast.map { convertDayFromDomain(id, it) }
        CityForecast(id, ciy, country, daily)
    }

    private fun convertDayFromDomain(cityId: Long, forecast: Forecast) = with(forecast) {
        DayForecast(date, description, high, low, iconUrl, cityId)
    }
}