package practice.code.third.제어함수

fun getMax1(a: Int, b: Int): Int {
    val max: Int
    if (a < b) max = b
    else max = a
    return max
}

fun getMax2(a: Int, b: Int): Int {
    val max = if (a < b) b else a
    return max
}

fun getMax3(a: Int, b: Int) = if (a < b) b else a

fun getMax4(a: Int, b: Int): Int {
    return if (a < b) {
        println("b bigger than a")
        b
    } else {
        println("a bigger than b")
        a
    }
}