package practice.code.collections

fun main() {
    val list = listOf("One", "Two", "Three", "Four", "Five")
    println(list.size)
    println(list.isEmpty())
    println(list.contains("Two"))
    println(list.containsAll(listOf("One", "Three", "Four")))

    println()
    println(list.get(1))
    println(list.indexOf("One"))
    println(list.subList(0, 3))

    println()
    println(list.all { s -> s.startsWith("T") })
    println(list.any { s -> s.startsWith("T") })
    println(list.drop(2))

    println()
    val list2 = listOf("One", "Two", "Three", "Two", "Four", "Five")
    println(list2.minus("Two"))
    println(list.plus("Fix"))
    println(list.shuffled())
    println(list.take(2))
}