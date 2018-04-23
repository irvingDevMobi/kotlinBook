package lopez.irving.kotlinbook.extensions

import android.content.Context
import java.text.DateFormat
import java.util.*
import kotlin.reflect.KProperty

/**
 *
 * @author irving.lopez
 * @since 03/04/2018.
 */
fun Long.toDateString(dateformat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateformat, Locale.getDefault())
    return df.format(this)
}
fun longPreference(context: Context, name: String, default: Long) = LongPreferences(context, name, default)

class LongPreferences(private val context: Context, private val name: String, val default: Long) {

    private val prefs by lazy {
        context.getSharedPreferences("default", Context.MODE_PRIVATE)
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Long = prefs.getLong(name, default)

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
        prefs.edit().putLong(name, value).apply()
    }

}