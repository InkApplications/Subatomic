package subatomic

/**
 * Add to the current value of the reference.
 */
fun Atomic<Int>.getAndAdd(delta: Int): Int {
    return getAndUpdate { it + delta }
}

/**
 * Add to the current value of the reference.
 */
fun Atomic<Double>.getAndAdd(delta: Double): Double {
    return getAndUpdate { it + delta }
}

/**
 * Add to the current value of the reference.
 */
fun Atomic<Float>.getAndAdd(delta: Float): Float {
    return getAndUpdate { it + delta }
}

/**
 * Add to the current value of the reference.
 */
fun Atomic<Long>.getAndAdd(delta: Long): Long {
    return getAndUpdate { it + delta }
}

operator fun Atomic<Int>.plusAssign(delta: Int) {
    getAndAdd(delta)
}
operator fun Atomic<Double>.plusAssign(delta: Double) {
    getAndAdd(delta)
}
operator fun Atomic<Float>.plusAssign(delta: Float) {
    getAndAdd(delta)
}
operator fun Atomic<Long>.plusAssign(delta: Long) {
    getAndAdd(delta)
}

operator fun Atomic<Int>.minusAssign(delta: Int) {
    getAndAdd(-delta)
}
operator fun Atomic<Double>.minusAssign(delta: Double) {
    getAndAdd(-delta)
}
operator fun Atomic<Float>.minusAssign(delta: Float) {
    getAndAdd(-delta)
}
operator fun Atomic<Long>.minusAssign(delta: Long) {
    getAndAdd(-delta)
}

operator fun Atomic<Int>.inc(): Atomic<Int> {
    getAndAdd(1)
    return this
}
operator fun Atomic<Double>.inc(): Atomic<Double> {
    getAndAdd(1.0)
    return this
}
operator fun Atomic<Float>.inc(): Atomic<Float> {
    getAndAdd(1f)
    return this
}
operator fun Atomic<Long>.inc(): Atomic<Long> {
    getAndAdd(1)
    return this
}
operator fun Atomic<Int>.dec(): Atomic<Int> {
    getAndAdd(-1)
    return this
}
operator fun Atomic<Double>.dec(): Atomic<Double> {
    getAndAdd(-1.0)
    return this
}
operator fun Atomic<Float>.dec(): Atomic<Float> {
    getAndAdd(-1f)
    return this
}
operator fun Atomic<Long>.dec(): Atomic<Long> {
    getAndAdd(-1)
    return this
}
