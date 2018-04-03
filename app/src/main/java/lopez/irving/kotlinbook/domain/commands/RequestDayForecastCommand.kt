package lopez.irving.kotlinbook.domain.commands

import lopez.irving.kotlinbook.domain.datasource.ForecastProvider
import lopez.irving.kotlinbook.domain.model.Forecast

/**
 *
 * @author irving.lopez
 * @since 03/04/2018.
 */
class RequestDayForecastCommand(val id: Long,
                                private val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<Forecast> {

    override fun execute(): Forecast = forecastProvider.requestForecast(id)
}