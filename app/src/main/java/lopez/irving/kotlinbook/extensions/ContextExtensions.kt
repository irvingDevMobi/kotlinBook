package lopez.irving.kotlinbook.extensions

import android.content.Context
import android.support.v4.content.ContextCompat

/**
 *
 * @author irving.lopez
 * @since 03/04/2018.
 */
fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)