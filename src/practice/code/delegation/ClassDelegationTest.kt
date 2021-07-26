package practice.code.delegation

class CountingList<T>(val innerList: MutableList<T>) : MutableList<T> by innerList {
    var addedCount = 0
    override fun add(element: T): Boolean {
        addedCount++
        return innerList.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        addedCount += elements.size
        return innerList.addAll(elements)
    }
}

fun main() {
    val countingList = CountingList<Int>(mutableListOf())
    countingList.addAll(listOf(1, 2, 3))
    println("List: ${countingList.addedCount} objects were added, remain: ${countingList.size}")

    countingList.clear()
    println("List: ${countingList.addedCount} objects were added, remain: ${countingList.size}")
}