package practice.code.first

class ClassTest {

    fun run() {
        var id: Int = 10
        val name: String = "bang"

        val newString = name.plus(", ").plus(id)
        println(newString)
    }

    class User(var name: String) {
        var id: Int = 10

        fun print() = println(name.plus(id))
    }
}
