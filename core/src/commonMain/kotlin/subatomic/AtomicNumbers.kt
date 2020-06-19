package subatomic

/**
 * Add to the current value of the reference.
 */
fun AtomicReference<Int>.getAndAdd(delta: Int): Int {
    return getAndUpdate { it + delta }
}

/**
 * Add to the current value of the reference.
 */
fun AtomicReference<Double>.getAndAdd(delta: Double): Double {
    return getAndUpdate { it + delta }
}

/**
 * Add to the current value of the reference.
 */
fun AtomicReference<Float>.getAndAdd(delta: Float): Float {
    return getAndUpdate { it + delta }
}

/**
 * Add to the current value of the reference.
 */
fun AtomicReference<Long>.getAndAdd(delta: Long): Long {
    return getAndUpdate { it + delta }
}

operator fun AtomicReference<Int>.plusAssign(delta: Int) {
    getAndAdd(delta)
}
operator fun AtomicReference<Double>.plusAssign(delta: Double) {
    getAndAdd(delta)
}
operator fun AtomicReference<Float>.plusAssign(delta: Float) {
    getAndAdd(delta)
}
operator fun AtomicReference<Long>.plusAssign(delta: Long) {
    getAndAdd(delta)
}

operator fun AtomicReference<Int>.minusAssign(delta: Int) {
    getAndAdd(-delta)
}
operator fun AtomicReference<Double>.minusAssign(delta: Double) {
    getAndAdd(-delta)
}
operator fun AtomicReference<Float>.minusAssign(delta: Float) {
    getAndAdd(-delta)
}
operator fun AtomicReference<Long>.minusAssign(delta: Long) {
    getAndAdd(-delta)
}

operator fun AtomicReference<Int>.inc(): AtomicReference<Int> {
    getAndAdd(1)
    return this
}
operator fun AtomicReference<Double>.inc(): AtomicReference<Double> {
    getAndAdd(1.0)
    return this
}
operator fun AtomicReference<Float>.inc(): AtomicReference<Float> {
    getAndAdd(1f)
    return this
}
operator fun AtomicReference<Long>.inc(): AtomicReference<Long> {
    getAndAdd(1)
    return this
}
operator fun AtomicReference<Int>.dec(): AtomicReference<Int> {
    getAndAdd(-1)
    return this
}
operator fun AtomicReference<Double>.dec(): AtomicReference<Double> {
    getAndAdd(-1.0)
    return this
}
operator fun AtomicReference<Float>.dec(): AtomicReference<Float> {
    getAndAdd(-1f)
    return this
}
operator fun AtomicReference<Long>.dec(): AtomicReference<Long> {
    getAndAdd(-1)
    return this
}
