package lopez.irving.kotlinbook.extensions

import java.text.DateFormat
import java.util.*

/**
 *
 * @author irving.lopez
 * @since 03/04/2018.
 */
fun Long.toDateString(dateformat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateformat, Locale.getDefault())
    return df.format(this)
}