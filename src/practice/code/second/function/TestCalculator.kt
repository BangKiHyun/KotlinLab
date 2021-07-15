package practice.code.second.function

class TestCalculator {

    fun Calculator.sum(a: Int, b: Int, c: Int) = sum(a, b) + c
    fun Calculator.minus(a: Int, b: Int, c: Int) = minus(a, b) - c
}