package subatomic

/**
 * Plain value implementation of atomic operations.
 */
actual open class AtomicReference<T> actual constructor(initial: T) {
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

    actual fun getAndUpdate(update: (T) -> T): T {
        return value.also {
            value = update(it)
        }
    }

    actual fun updateAndGet(update: (T) -> T): T {
        return update(value).also {
            value = it
        }
    }
}
