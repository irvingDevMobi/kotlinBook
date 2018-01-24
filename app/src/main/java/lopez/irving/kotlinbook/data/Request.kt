package lopez.irving.kotlinbook.data

import android.util.Log
import java.net.URL

/**
 *
 * @author irving.lopez
 * @since 24/01/2018.
 */
class Request(private val url: String) {

    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }
}