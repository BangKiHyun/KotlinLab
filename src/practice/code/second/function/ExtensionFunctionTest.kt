package practice.code.second.function

class Calculator {
    val result: Int = 0
    fun sum(a: Int, b: Int) = a + b
    fun minus(a: Int, b: Int) = a - b
}

fun Calculator.sum(a: Int, b: Int, c: Int) = sum(a, b) + c
fun Calculator.minus(a: Int, b: Int, c: Int) = minus(a, b) - c

// 프로퍼티 확장
val Calculator.sign: Char
    get() {
        if (result < 0)
            return '-'
        else return '+'
    }

fun main() {
    val calc = Calculator()
    println("1 + 2 = ${calc.sum(1, 2)}")
    println("2 - 1 = ${calc.minus(2, 1)}")

    println("1 + 2 + 3 = ${calc.sum(1, 2, 3)}")
    println("3 - 2 - 1 = ${calc.minus(3, 2, 1)}")

    println()
}