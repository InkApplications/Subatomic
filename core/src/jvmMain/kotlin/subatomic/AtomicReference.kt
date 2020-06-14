package subatomic

import java.util.concurrent.atomic.AtomicReference as JavaAtomicReference

/**
 * Atomic operations backed by the JVM's Atomic Reference class.
 */
actual class AtomicReference<T>(initial: T) {
    private val backingReference = JavaAtomicReference(initial)

    actual var value: T
        get() = backingReference.get()
        set(newValue) { backingReference.set(newValue) }
}
