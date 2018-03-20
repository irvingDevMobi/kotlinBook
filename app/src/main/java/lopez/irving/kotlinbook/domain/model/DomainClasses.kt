package lopez.irving.kotlinbook.domain.model

/**
 *
 * @author irving.lopez
 * @since 31/01/2018.
 */
data class ForecastList(val id: Long, val ciy: String, val country: String, val dailyForecast: List<Forecast>) {
    val size: Int
        get() = dailyForecast.size

    operator fun get(position: Int): Forecast = dailyForecast[position]
}

data class Forecast(val date: Long, val description: String, val high: Int, val low: Int, val iconUrl: String)