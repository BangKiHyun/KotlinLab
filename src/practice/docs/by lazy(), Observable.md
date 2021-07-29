# by lazy(), observable()

## by lazy()

`by lazy()`는 지연 초기화를 사용하기 위한 키워드다.

지연 초기화란 해당 객체를 미리 생성해 놓지 않고, 필요할 때 생성해주는 것을 말한다. 즉, 초기화에 대한 시점을 늦추는 것을 의미한다.

예를 들어, `Market` 클래스는 메뉴를 저장하는 `MenuList` 필드를 가지고 있다고 하자. 리스트는 데이터베이스에 저장되어 있고, 리스트를 읽어오는데 시간이 오래 걸려 메뉴를 `Matket` 생성시점에 초기화하지 않고, 메뉴가 필요할 때 데이터베이스에서 값을 읽어온 값으로 초기화하고 싶다.

```kotlin
package practice.code.delegation

data class Menu(val name: String, var price: Int) {
}

class Market(val name: String) {
    var menuList: List<Menu>? = null
        get() {
            if (field == null) menuList = loadMenuList(this)
            return field
        }
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
```

![image](https://user-images.githubusercontent.com/43977617/127431911-f10f96de-8bf4-4913-92ff-002b8d5beea8.png)

위 코드를 보면 `munuList`필드를 `null`로 초기화하고, `menuList`를 호출하는 시점에 값이 `null`일 경우 `loadMenuList()`를 실행하여 값을 얻어온다. 즉, 필요한 시점에 값을 얻어오는 지연 초기화 방식이 적용된 것을 볼 수 있다.

결과를 보면 `munuList`필드를 처음 호출하면 `loadMenuList()`메서드를 실행하지만 두 번째 호출할 때는 `loadMenuList`를 호출하지 않는다.

코틀린에서는 지연 초기화를 위한 `lazy()`메서드를 제공한다. `lazy()`메서드는 파라미터로 받은 람다식을 이용하여 지연 초기화 방식으로 구현된 `getValue()`메서드를 가진 객체를 생성하여 반환한다.

```kotlin
class Market(val name: String) {
    val menuList by lazy { loadMenuList(this) }
}

fun main() {
    val market = Market("Bang Market")
    println("첫 번째 호출")
    println(market.menuList)

    println("\n두 번째 호출")
    println(market.menuList)
}
```

![image](https://user-images.githubusercontent.com/43977617/127433546-756a5631-1657-4967-a116-576cb0717b75.png)

결과를 보면 기존에 작성했던 코드와 동일하게 동작한 것을 알 수 있다.

`lazy()` 메서드는 다음과 같이 되어있다.

![image](https://user-images.githubusercontent.com/43977617/127433802-3ee2eaa6-8a89-468f-a777-bd405e7f9661.png)

자세히 보니 `SynchronizedLazyImpl`를 사용하는 걸 볼 수 있는데, 이는 동기화를 통해 스레드 세입한 환경을 제공해 주는것 같다.

그리고 반환된 인스턴스는 스스로 동기화를 하기 때문에, 외부 코드에서 동기화할 시 교착 상태가 발생할 수 있으므로 동기화를 하지 말라고 한다.

</br >

### 제약 사항

`lazy()`메서드를 사용하기 위해서는 몇 가지 제약 사항이 있다.

- `var`을 사용할 수 없다.
  - 최초에 한 번만 초기화되므로 변경될 수 없다.
  - 그래서 `setter`를 따로 구현할 수 없다.
- 클래스 생성자에서 사용할 수 없다.

</br >

## observable()

`obesrvable()`메서드는 프로퍼티에 값이 할당될 때 처리할 메서드를 등록할 수 있는 메서드이다.

`obesrvable()`메서드는  람다 식을 파라미터로 전달받아 `setValue()`메서드가 구현된 객체를 반환한다.

~~~kotlin
class Person(val name: String, age: Int) {
    var age: Int by Delegates.observable(age) { property, oldValue, newValue ->
        println("${property.name}: $oldValue -> $newValue")
    }
}

fun main() {
    val person = Person("Bang",  25)
    person.age = 27
}
~~~

![image](https://user-images.githubusercontent.com/43977617/127435709-fe03ef41-fe1e-40aa-abe7-cc3f88bc8c09.png)

람다식을 전달해주는 것으로 프로퍼티가 바뀔 때 수행될 기능을 지정할 수 있다.

`observable()`메서드는 다음과 같이 되어있다.

![image](https://user-images.githubusercontent.com/43977617/127435659-7949eb5c-d325-4e8e-8fc5-be3c5de95ba8.png)

매개 변수로 `initialValue`와 `onChange`람다 식을 받아 `ReadWriteProperty`객체를 반환한다.

