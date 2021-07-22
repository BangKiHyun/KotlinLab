package practice.code.collections.lists

fun main() {
    println("mutable list 실행 결과")
    val mutableList: MutableList<Int> = MutableList(5) { i -> i }
    println(mutableList)

    val mutableListOf = mutableListOf(1, 2, 3, 4, 5)
    println(mutableListOf)

    println("\narray list 실행 결과")
    val arrayList: ArrayList<Int> = ArrayList(5)
    println(arrayList)

    val arrayListOf = arrayListOf(1,2,3,4,5)
    println(arrayListOf)
}