package lopez.irving.kotlinbook.ui

import android.app.Application
import lopez.irving.kotlinbook.ui.utils.DelegatesExt

/**
 *
 * @author irving.lopez
 * @since 12/03/2018.
 */
class App : Application() {

    companion object {
        var instance: App by DelegatesExt.nonNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}