package lopez.irving.kotlinbook.domain.commands

import lopez.irving.kotlinbook.domain.datasource.ForecastProvider
import lopez.irving.kotlinbook.domain.model.ForecastList

/**
 *
 * @author irving.lopez
 * @since 31/01/2018.
 */
class RequestForecastCommand(private val zipCode: Long,
                             private val forecastProvider: ForecastProvider = ForecastProvider()) : Command<ForecastList> {
    companion object {
        const val DAYS = 7
    }

    override fun execute(): ForecastList = forecastProvider.requestByZipCode(zipCode, DAYS)
}