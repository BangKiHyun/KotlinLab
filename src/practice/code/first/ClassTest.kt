package practice.code.first

class ClassTest {

    fun run() {
        var id: Int = 10
        val name: String = "bang"

        val newString = name.plus(", ").plus(id)
        println(newString)
    }

    // 주 생성자
    class User1 {
        var id: Int = 10
    }

    class User2(inputId: Int) {
        var id = inputId
    }

    class User3(var id: Int)

    // 부 생성자
    class User4() {
        var id: Int = 10
        var name: String = "bang"

        // 주 생성자를 정의한 경우 부 생성자에서는 this를 통해 주 생성자를 호출해야함
        constructor(id: Int) : this() {
            this.id = id
        }

        constructor(id: Int, name: String) : this() {
            this.id = id
            this.name = name
        }
    }

    class User5(var id: Int) {
        var name: String = "bang"

        constructor(id: Int, name: String) : this(id) {
            this.name = name
        }
    }
}
