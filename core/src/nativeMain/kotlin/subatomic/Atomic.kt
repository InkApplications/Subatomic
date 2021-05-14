package subatomic

import kotlin.native.concurrent.AtomicReference

actual open class Atomic<T> actual constructor(initial: T) {
    private val backingReference = AtomicReference<T>(initial)
    actual var value: T
        get() = backingReference.value
        set(value) { backingReference.value = value }

    /**
     * Eventually set the value.
     */
    actual fun lazySet(newValue: T) {
        backingReference.value = newValue
    }

    /**
     * Set the value if the current value matches the expected value.
     *
     * @return Whether the value matched as expected.
     */
    actual fun compareAndSet(expected: T, newValue: T): Boolean {
        return backingReference.compareAndSet(expected, newValue)
    }

    /**
     * Set the value and get the old value
     *
     * @return the previous value before updating.
     */
    actual fun getAndSet(newValue: T): T {
        while (true) {
            val current = backingReference.value
            if (current === value) return current
            if (backingReference.compareAndSwap(current, value) === current) return current
        }
    }

    /**
     * Update the value based on its previous value.
     */
    actual fun update(update: (T) -> T) {
        while (true) {
            val current = backingReference.value
            val updated = update(current)
            if (compareAndSet(current, updated)) return
        }
    }

    /**
     * Update the value based on its previous value.
     *
     * @return The previous value before updating.
     */
    actual fun getAndUpdate(update: (T) -> T): T {
        while (true) {
            val current = backingReference.value
            val updated = update(current)
            if (compareAndSet(current, updated)) return current
        }
    }

    /**
     * Update the value based on its previous value.
     *
     * @return The new value after updating.
     */
    actual fun updateAndGet(update: (T) -> T): T {
        while (true) {
            val current = backingReference.value
            val updated = update(current)
            if (compareAndSet(current, updated)) return updated
        }
    }
}
