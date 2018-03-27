package lopez.irving.kotlinbook.domain.datasource

import lopez.irving.kotlinbook.data.db.ForecastDb
import lopez.irving.kotlinbook.data.server.ForecastServer
import lopez.irving.kotlinbook.domain.model.ForecastList
import lopez.irving.kotlinbook.extensions.firstResult

/**
 *
 * @author irving.lopez
 * @since 20/03/2018.
 */
class ForecastProvider(private val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {

    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES = listOf(ForecastDb(), ForecastServer())
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = sources.firstResult { requestSource(it, days, zipCode) }

    private fun requestSource(source: ForecastDataSource, days: Int, zipCode: Long): ForecastList? {
        val res = source.requestForecastByZipCode(zipCode, todayTimeSpan())
        return if (res != null && res.size >= days) res else null
    }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS
}