package practice.code.third.제어함수

fun calculate(a: Int, b: Int, operation: String): Int {
    when (operation) {
        "+" -> return a + b
        "-" -> return a - b
        "*" -> return a * b
        else -> return a / b
    }
}

fun printValue(number: Int, str: String) {
    when (number) {
        str.toInt() -> println("str is number")
        else -> println("str is not number")
    }
}

fun isStartPrefix(x: Any) = when (x) {
    is String -> x.startsWith("prefix")
    else -> false
}

fun checkValue(text: String) {
    when {
        text.startsWith("hi") -> println("$text is start hi")
        text.startsWith("bye") -> println("$text is start bye")
        else -> println("text is $text")
    }
}

fun main() {
    printValue(10, "10")
    printValue(10, "20")

    println(isStartPrefix("prefixTrue"))
    println(isStartPrefix(10))

    checkValue("hi man")
    checkValue("bye man")
    checkValue("good man")
}
