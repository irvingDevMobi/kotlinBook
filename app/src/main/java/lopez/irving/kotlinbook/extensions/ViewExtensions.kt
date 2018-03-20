package lopez.irving.kotlinbook.extensions

import android.content.Context
import android.view.View

/**
 *
 * @author irving.lopez
 * @since 08/03/2018.
 */
val View.ctx: Context
    get() = context