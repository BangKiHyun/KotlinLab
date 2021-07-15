package practice.code.third.nullable

class Text(private val value: String) {
    fun length() = value.length
}

class NullableText(private val value: String?) {
    fun length(): Int {
        if (value != null) return value.length
        else return 0
    }
}

fun main() {
    val text = Text("")
    println(text.length())

    val nullableText = NullableText(null)
    nullableText.length()
}