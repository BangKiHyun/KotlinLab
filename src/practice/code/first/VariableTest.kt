package practice.code.first

class VariableTest {

    fun main(args: Array<String>) {
        var a = 10 //변경 가능한 변수 선언
        val b = 20 // 변경 불가능한 변수 선언
        val c = a + b
        print(c)

        var intArr = arrayOf(1, 2, 3, 4, 5) //array 선언 방법 1
        var nullArr = arrayOfNulls<Int>(5) //array 선언 방법 2
        intArr[2] = 2

        // val로 선언했지만 해당 객체의 멤버 변수가 var로 되어있으면 해당 멤버 변수는 변경 가능
        val person = Person("bang", 20)
        person.age = 21
    }

    class Person(
        val name: String,
        var age: Int
    )
}
