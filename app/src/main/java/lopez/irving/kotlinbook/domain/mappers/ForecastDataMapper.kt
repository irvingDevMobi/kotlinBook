package lopez.irving.kotlinbook.domain.mappers

import lopez.irving.kotlinbook.data.server.Forecast
import lopez.irving.kotlinbook.data.server.ForecastResult
import lopez.irving.kotlinbook.domain.model.ForecastList
import java.util.*
import java.util.concurrent.TimeUnit
import lopez.irving.kotlinbook.domain.model.Forecast as ModelForecast

/**
 *
 * @author irving.lopez
 * @since 31/01/2018.
 */
class ForecastDataMapper {

    fun convertFromDataModel(zipCode: Long, forecast: ForecastResult) = with(forecast) {
        ForecastList(zipCode, city.name, city.country, convertForecastListToDomain(list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast) = with(forecast) {
        ModelForecast(dt, weather[0].description, temp.max.toInt(), temp.min.toInt(), generateIconUrl(weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String): String = "http://openweathermap.org/img/w/$iconCode.png"
}