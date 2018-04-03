package lopez.irving.kotlinbook.domain.datasource

import lopez.irving.kotlinbook.domain.model.Forecast
import lopez.irving.kotlinbook.domain.model.ForecastList

/**
 *
 * @author irving.lopez
 * @since 20/03/2018.
 */
interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?
}