package practice.code.third.nullable

class Map(val width: Int, val height: Int) {
    val size: Int
        get() = width * height
}

fun CreateMap(width: Int, height: Int): Map? {
    if (width > 0 && height > 0) return Map(width, height)
    else return null
}

class Address(val city: String, val detail: String?)
class User(val name: String, val addr: Address?)

// ?: 연산자
fun User.detailName(): String {
    val detail = this.addr?.detail
    return detail?: "Unknown"
}

fun main() {
    val map: Map? = CreateMap(10, 0)
    //if (map != null) println(map.size)
    println(map?.size)
    println(map!!.size)

    val addr = Address("도시이름", null)
    val user = User("bang", addr)
    println("?: 연산자 테스트 실행 결과")
    println(user.detailName())
}