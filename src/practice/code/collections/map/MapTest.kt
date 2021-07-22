package practice.code.collections.map

fun main() {
    val map: Map<String, Int> = mapOf("One" to 1, "Two" to 2, "Three" to 3)
    println(map)

    val mapPair: Map<String, Int> = mapOf(Pair("One", 1), Pair("Two", 2), Pair("Three", 3))
    println(mapPair)

    val mutableMap = mutableMapOf("One" to 1, "Two" to 2, "Three" to 3)
    mutableMap.put("Four", 4)
    mutableMap.put("Two", 22)
    println(mutableMap)

    val mutableHashMap = hashMapOf(Pair("One", 1), Pair("Two", 2), Pair("Three", 3))
    mutableHashMap["Four"] = 4
    println(mutableHashMap)
}