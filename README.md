Subatomic
=========

Simple Multiplatform implementation of atomic operations for Kotlin.

 - Supports JVM, JavaScript and Native Platforms.
 - Does not require use of a gradle plugin.

Installation
------------

Published to Maven Central

### Core Module Coordinates

`com.inkapplications.subatomic:core`

Usage
-----

Create simple references with the Atomic class:

```kotlin
val atomicString = Atomic("example")

atomicString.getAndUpdate { current ->
    "Previously $current"
}
```

Works with Nullable references:

```kotlin
val atomicNullable = Atomic<Int?>(null)
```
