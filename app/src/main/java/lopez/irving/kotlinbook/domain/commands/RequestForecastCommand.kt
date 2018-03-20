package lopez.irving.kotlinbook.domain.commands

import lopez.irving.kotlinbook.data.server.ForecastRequest
import lopez.irving.kotlinbook.domain.mappers.ForecastDataMapper
import lopez.irving.kotlinbook.domain.model.ForecastList

/**
 *
 * @author irving.lopez
 * @since 31/01/2018.
 */
class RequestForecastCommand(private val zipCode: Long): Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(zipCode, forecastRequest.execute())
    }
}