package practice.code.second.dataclass

data class User (val name: String) {
    var age: Int = 0
}

fun main() {
    val user1 = User("Bang")
    val user2 = User("Bang")
    user1.age = 10
    user2.age = 20

    println("equals 결과")
    println(user1 == user2)

    println("\ntoString 결과")
    println(user1)
    println(user2)
}