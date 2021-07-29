package practice.code.third.lambdas

val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
val minus: (Int, Int) -> Int = { x, y -> x - y }
val mul = { x: Int, y: Int -> x * y }
val noReturn: () -> Unit = { println("no return type test!") }
val noReturnInference = { println("no return type inference!") }

fun main() {
    println("sum: ${sum(10, 20)}")
    println("minus: ${minus(20, 10)}")
    println("mul: ${mul(10, 20)}")
    noReturn()
    noReturnInference()
}
