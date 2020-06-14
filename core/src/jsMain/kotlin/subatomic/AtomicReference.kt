package subatomic

/**
 * Plain value implementation of atomic operations.
 */
actual class AtomicReference<T> actual constructor(initial: T) {
    actual var value: T = initial

    actual fun lazySet(newValue: T) {
        value = newValue
    }

    actual fun compareAndSet(expected: T, newValue: T): Boolean = when (value) {
        expected -> {
            value = newValue
            true
        }
        else -> false
    }
}
