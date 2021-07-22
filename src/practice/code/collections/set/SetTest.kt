package practice.code.collections.set

fun main() {
    val set: Set<Int> = setOf(1, 1, 4, 3)
    println(set)

    val mutableSet = mutableSetOf(1, 1, 4, 3)
    mutableSet.add(5)
    println(mutableSet)

    val hashSet = hashSetOf(1, 4, 2, 2)
    hashSet.add(5)
    println(hashSet)
}