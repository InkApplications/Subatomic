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

    /**
     * Set the value and get the old value
     *
     * @return the previous value before updating.
     */
    fun getAndSet(newValue: T): T

    /**
     * Update the value based on its previous value.
     */
    fun update(update: (T) -> T)

    /**
     * Update the value based on its previous value.
     *
     * @return The previous value before updating.
     */
    fun getAndUpdate(update: (T) -> T): T
}
