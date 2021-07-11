package practice.code

class NullableTest {

    fun main() {
        var nullableString: String? = null
        var nullableStringNotEmpty: String? = "hi"
        nullableStringNotEmpty = null

        var notNullString = "bye"
//        notNullString = null
//        var notNullStringNotEmpty: String = null //compile error
    }
}