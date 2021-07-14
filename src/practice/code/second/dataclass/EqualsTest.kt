package practice.code.second.dataclass

data class User1(val name: String, val age: Int)

class User2(val name: String, val age: Int)

fun main() {
    val user1 = User1("Bang", 25)
    val user2 = User2("Bang", 25)

    println("데이터 클래스 출력 결과")
    println(user1)
    println("\n일반 클래스 출력 결과")
    println(user2)
}
