package subatomic

/**
 * Atomic operations for a contained reference.
 */
expect class AtomicReference<T>(initial: T) {
    /**
     * Volatile read/write access to the contained reference.
     */
    var value: T
}
