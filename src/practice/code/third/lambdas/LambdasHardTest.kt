package practice.code.third.lambdas

val nullableReturn: (Int, Int) -> Int? = { x, y -> null }
val nullableParam = { x: Int?, y: Int? -> (x ?: 0) + (y ?: 0) }
var nullableFun: ((Int, Int) -> Int)? = null

fun cal(x: Int, y: Int, operation: (Int, Int) -> Int) = operation(x, y)

fun main() {
    println(nullableReturn(2, 3))
    println(nullableParam(2, null))

    nullableFun = { x, y -> x - y }
    println(nullableFun?.invoke(2, 3))

    val sum = { x: Int, y: Int -> x + y }
    println(cal(10, 20, sum))
    println(cal(10, 20) { x: Int, y: Int -> x + y })
}
