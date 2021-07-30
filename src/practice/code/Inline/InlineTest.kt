package practice.code.Inline

inline fun calculator(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

inline fun newCalculator(a: Int, b: Int, operation: (Int, Int) -> Int, noinline func: () -> Unit): Int {
    func()
    return operation(a, b)
}

fun main() {
    println(calculator(1, 2) { a: Int, b: Int -> a + b })
    println(newCalculator(1, 2, { a: Int, b: Int -> a + b }, { println("noinline function") }))
}