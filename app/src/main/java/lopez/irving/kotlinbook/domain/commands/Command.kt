package lopez.irving.kotlinbook.domain.commands

/**
 *
 * @author irving.lopez
 * @since 31/01/2018.
 */
public interface Command<out T> {
    fun execute(): T
}