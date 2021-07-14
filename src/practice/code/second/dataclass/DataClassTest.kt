package practice.code.second.dataclass

data class User3(val name: String, val age: Int)

class User4(val name: String, val age: Int)

class User5(val name: String, val age: Int) {
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is User3) return false
        return name == other.name && age == other.age
    }
}

fun main() {
    val user1 = User4("Bang", 25)
    val user2 = User4("Bang", 25)
    println("equals() 제정의 안했을 때 출력 결과")
    println(user1 == user2)

    val user3 = User5("Bang", 25)
    val user4 = User5("Bang", 25)
    println("\nequals() 제정의 했을 때 출략 결과")
    println(user3 == user4)

    val user5 = User3("Bang", 25)
    val user6 = User3("Bang", 25)
    println("\n데이터 클래스 출력 결과")
    println(user5 == user6)
}
