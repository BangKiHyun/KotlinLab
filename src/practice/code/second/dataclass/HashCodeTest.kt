package practice.code.second.dataclass

data class User6(val name: String, val age: Int)

class User7(val name: String, val age: Int) {
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is User7) return false
        return name == other.name && age == other.age
    }
}

class User8(val name: String, val age: Int) {
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is User8) return false
        return name == other.name && age == other.age
    }

    override fun hashCode(): Int {
        return name.hashCode() * 31 + age
    }
}

fun main() {
    val userSet1 = hashSetOf(User7("Bang", 25))
    println("hashCode() 재정의 안했을 때 결과")
    println(userSet1.contains(User7("Bang", 25)))

    val userSet2 = hashSetOf(User8("Bang", 25))
    println("\nhashCode() 재정의 했을 때 결과")
    println(userSet2.contains(User8("Bang", 25)))

    val userSet = hashSetOf(User6("Bang", 25))
    println("\n데이터 클래스 출력 결과")
    println(userSet.contains(User6("Bang", 25)))
}