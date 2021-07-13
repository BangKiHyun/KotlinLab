package practice.code.second.property

// 기본 접근자
class Rectangle {
    var height: Int = 0
        get() = field
        set(value) {
            field = value
        }
    var width: Int = 0
        get() = field
        set(value) {
            field = value
        }
}

// 커스텀 접근자 방법 1
class Rectangle2(var height: Int, var width: Int) {
    val isSquare: Boolean

    init {
        isSquare = height == width
    }
}

// 커스텀 접근자 방법 2
class Rectangle3(var height: Int, var width: Int) {
    val isSquare: Boolean
        get() = height == width
}

// 접근자의 가시성 변경자 Test
class Rectangle4 {
    var height: Int = 0
        private set(value) {
            field = value
        }

    fun addHeight() {
        this.height++;
    }
}

fun main() {
    val rectangle = Rectangle()
    rectangle.width = 5
    println(rectangle.width)

    val rectangle2 = Rectangle2(10, 10)
    rectangle2.height = 2
    println(rectangle2.isSquare)

    val rectangle3 = Rectangle3(10, 10)
    rectangle3.height = 2
    println(rectangle2.isSquare)

    val rectangle4 = Rectangle4()
    rectangle4.addHeight()
    //rectangle4.height = 3
    println(rectangle4.height)
}