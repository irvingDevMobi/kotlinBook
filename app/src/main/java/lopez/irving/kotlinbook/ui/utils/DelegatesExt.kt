package lopez.irving.kotlinbook.ui.utils

import kotlin.reflect.KProperty

/**
 *
 * @author irving.lopez
 * @since 12/03/2018.
 */
object DelegatesExt {
    fun <T> nonNullSingleValue() = NontNullSingleValueVar<T>()
}

class NontNullSingleValueVar<T> {
    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T =
            value ?: throw IllegalStateException("${property.name} " + "not initialized")

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("${property.name} already initialized")
    }
}