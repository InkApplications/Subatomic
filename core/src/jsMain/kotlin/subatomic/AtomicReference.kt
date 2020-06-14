package subatomic

/**
 * Plain value implementation of atomic operations.
 */
actual class AtomicReference<T>(initial: T) {
    actual var value: T = initial
}
