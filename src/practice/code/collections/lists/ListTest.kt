package practice.code.collections.lists

fun main() {
    val list: List<Int> = List(5) { i -> i }
    println(list)

    val listOf: List<Int> = listOf(1, 2, 3, 4, 5)
    println("\n$listOf")

    val listWrapper = listOf(listOf(1, 2, 3, 4, 5).toMutableList())
    val newList = listWrapper[0]
    newList.add(6)
    println("\n$listWrapper")
}