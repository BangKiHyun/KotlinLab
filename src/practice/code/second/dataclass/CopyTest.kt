package practice.code.second.dataclass

data class User9(val name: String, val age: Int)

fun main(){
    val user = User9("Bang", 25)
    val copyUser = user.copy("Bang", 26)
    println(user)
    println(copyUser)
}