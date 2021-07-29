package practice.code.delegation

data class Menu(val name: String, var price: Int) {
}

class Market(val name: String) {
//    var menuList: List<Menu>? = null
//        get() {
//            if (field == null) menuList = loadMenuList(this)
//            return field
//        }

    // lazy 메서드 자동 동기화 적용 -> 스레드 세입함
    // 자동으로 동기화 적용해주기 떄문에 따로 동기화 시켜줄 시 deadlock 발생할 수 있음
    val menuList by lazy { loadMenuList(this) }
}

fun loadMenuList(market: Market): List<Menu> {
    println("Load ${market.name} menu list")
    return listOf(Menu("과자", 1000))
}

fun main() {
    val market = Market("Bang Market")
    println("첫 번째 호출")
    println(market.menuList)

    println("\n두 번째 호출")
    println(market.menuList)
}