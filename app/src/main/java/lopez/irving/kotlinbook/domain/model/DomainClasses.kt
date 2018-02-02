package lopez.irving.kotlinbook.domain.model

/**
 *
 * @author irving.lopez
 * @since 31/01/2018.
 */
data class ForecastList(val ciy: String, val country: String, val dailyForecast: List<Forecast>)

data class Forecast(val date: String, val description: String, val high: Int, val low: Int)