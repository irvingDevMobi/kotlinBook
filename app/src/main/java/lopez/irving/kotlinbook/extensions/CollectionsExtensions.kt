package lopez.irving.kotlinbook.extensions

/**
 *
 * @author irving.lopez
 * @since 20/03/2018.
 */
fun <K, V : Any> MutableMap<K, V?>.toVarargArray():
        Array<out Pair<K, V>> = map({ Pair(it.key, it.value!!) }).toTypedArray()
