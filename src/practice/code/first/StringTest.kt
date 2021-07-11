package practice.code.first

class StringTest {

    fun run() {
        var id: Int = 10
        val name: String = "bang"

        //String의 plus 메서드는 return값이 String이다.
        //Java StringBuilder의 append와는 다른 개념인 것 같다.
        val newString = name.plus(", ").plus(id)
        println(name) // "bang"
        println(newString) //"bang, 10"
    }
}