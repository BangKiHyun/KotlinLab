package practice.code.third.제어함수

fun isLessThanTen(number: Int) = number in 1..9

fun main() {
    //.. 연산자
    var oneToTen = 1..10
    println("first number: ${oneToTen.first}")
    println("last number: ${oneToTen.last}")

    // in + .. 연산자
    var number = 10
    println(isLessThanTen(number))

    // in 연산자 collection 사용
    val coll = setOf("Hello", "Bang")
    println("Bang" in coll)

    // for + in + .. 연산자
    for (idx in 0..9) {
        print("$idx ")
    }

    // for + in + downTo 연산자
    println()
    for (number in 10 downTo 1) {
        print("$number ")
    }

    // for + in + downTo + step 연산자
    println()
    for (number in 10 downTo 1 step 2) {
        print("$number ")
    }

    // 중위 호출
    println()
    for (number in 10.downTo(1).step(2)) {
        print("$number ")
    }

    // 구조 분해
    println()
    var list = arrayListOf("Hello", "Bang", "Bye")
    for ((index, value) in list.withIndex()) {
        println("$index: $value")
    }
}