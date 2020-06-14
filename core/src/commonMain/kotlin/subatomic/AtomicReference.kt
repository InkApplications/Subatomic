package subatomic

/**
 * Atomic operations for a contained reference.
 */
expect class AtomicReference<T>(initial: T) {
    /**
     * Volatile read/write access to the contained reference.
     */
    var value: T

    /**
     * Eventually set the value.
     */
    fun lazySet(newValue: T)

    /**
     * Set the value if the current value matches the expected value.
     *
     * @return Whether the value matched as expected.
     */
    fun compareAndSet(expected: T, newValue: T): Boolean
}
