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
        expected -> true.also {
            value = newValue
        }
        else -> false
    }

    actual fun getAndSet(newValue: T): T {
        return value.also {
            value = newValue
        }
    }

    actual fun update(update: (T) -> T) {
        value = update(value)
    }
}
