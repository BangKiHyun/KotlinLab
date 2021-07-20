package practice.code.third.lambdas

fun calculator(a: Int, b: Int, p: (Int, Int) -> Int) {
    println("$a, $b -> ${p(a, b)}")
}

fun square(a: Int, p: (Int) -> Int) {
    println("$a -> ${p(a)}")
}

fun printVersion(p: (() -> Unit)? = null) {
    print("version: ")
    p ?: println("noting")
}

fun main() {
    // 익명 함수
    calculator(2, 3) { x: Int, y: Int -> x + y }

    // 매개 변수가 하나일 때 it 키워드 사용
    square(3) { it * it }

    // nullable
    printVersion()
}