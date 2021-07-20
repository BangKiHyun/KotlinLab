package practice.code.third.제어함수

fun main() {
    var number = 0
    println("while test")
    while (number < 10) print("${number++} ")

    println("\n\ndo-while test")
    do {
        print("${number--} ")
    } while (number > 0)
}