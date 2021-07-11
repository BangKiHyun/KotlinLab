package practice.code.first.clazz

class InitBlockTest {

    // 초기화 블록
    class Button(var id: Int) {
        var text = ""

        init {
            println("Initializer Block Execution")
        }

        constructor(id: Int, text: String) : this(id) {
            this.text = text
            println("Secondary Constructor Execution")
        }
    }

    class Button2 {
        var id = 10
        var text = ""

        init {
            println("Initializer Block Execution")
        }

        constructor(id: Int) {
            this.id = id
            println("Secondary Constructor Execution ${this.id}")
        }

        constructor(id: Int, text: String) {
            this.text = text
            println("Secondary Constructor Execution ${this.id}, ${this.text}")
        }
    }

    // 다중 초기화 블록
    class Button3 {
        var id = 10
        var text = ""

        init {
            println("First Initializer Block Execution")
        }

        init {
            println("Second Initializer Block Execution")
        }

        constructor(id: Int) {
            this.id = id
            println("Secondary Constructor Execution ${this.id}")
        }

        constructor(id: Int, text: String) {
            this.text = text
            println("Secondary Constructor Execution ${this.id}, ${this.text}")
        }

        init {
            println("Third Initializer Block Execution")
        }
    }
}