package practice.code.third.lambdas

fun main() {
    // 타입 추론
    val sum = { a: Int, b: Int -> a + b }
    println(sum(2, 3))

    // 정식 포맷
    val minus: (Int, Int) -> Int = { a, b -> a - b }
    println(minus(3, 1))
}