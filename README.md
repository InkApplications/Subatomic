Subatomic
=========

Multiplatform implementations of atomic operations for Kotlin.

 - Currently supports JVM and JavaScript Platforms.
 - Does not require use of a gradle plugin.

Usage
-----

Create simple references with the Atomic class:

```kotlin
val atomicString = Atomic("example")

atomicString.getAndUpdate { current ->
    "Previously $current"
}
```

Use provided extensions for number operations:

```kotlin
val atomicInt = Atomic(0)

atomicInt.getAndAdd(3)

// or modify with operators:
atomicInt += 5
atomicInt--
```

Works with Nullable references:

```kotlin
val atomicNullable = Atomic<Int?>(null)
```
