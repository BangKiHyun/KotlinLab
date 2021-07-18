# Null Check를 위한 연산자

Null Check를 할 수 있는 간단한 방법과 관련 연산자들을 알아보자

</br >

## `?.`연산자

`?.`연산자는 우선 왼쪽의 매개 변수가 `null`인지 확인한다. 만약 `null`이라면 `null`을 반환하며 구문을 종료하고, 아니라면 해당 변수를 Non-Null 타입으로 반환하여 프로퍼티에 접근할 수 있도록 한다.

~~~kotlin
class Map(val width: Int, val height: Int) {
    val size: Int
        get() = width * height
}

fun CreateMap(width: Int, height: Int): Map? {
    if (width > 0 && height > 0) return Map(width, height)
    else return null
}

fun main() {
    val map: Map? = CreateMap(10, 0)
    if (map != null) println(map.size)
}
~~~

위 코드는 Nullable 타입은 Map 객체의 `size`에 접근하기 위해 if문을 사용해 null check를 한다.

위 코드를 `?.`연산자를 사용하여 간단하게 바꿔보자.

~~~kotlin
fun main() {
    val map: Map? = CreateMap(10, 0)
    println(map?.size)
}
~~~

위 코드의 `println(map?.size)`구문은 `if (map != null) println(map.size) else null`과 동일한 의미이다. 훨씬 쉽고 간단하게 코드를 구현할 수 있다. 참고로 `?.`의 연산자는 체인 방식을 허용한다는 장점이 있다.

</br >

## `?:`연산자

`?:`연산자는 해당 값이 `null`일 경우 디폴트 값을 설정할 수 있도록 하는 연산자이다.

`?:`연산자의 왼쪽에 있는 값이 `null`일 경우 오른쪽에 있는 값(디폴트 값)을 대입한다.

~~~kotlin
fun User.cityName(): String {
    val city = this.addr?.city
    return city?: "Unknown"
}
~~~

위 코드를 보면 `?:`연산자를 통해 `Address`에 정의한`city`값이 `null`값일 경우 'Unknown'이라는 값을 대입한다.

```kotlin
class Address(val city: String, val detail: String?)
class User(val name: String, val addr: Address?)

fun User.detailName(): String {
    val detail = this.addr?.detail
    return detail?: "Unknown"
}

fun main() {
    val addr = Address("도시이름", null)
    val user = User("bang", addr)
    println("?: 연산자 테스트 실행 결과")
    println(user.detailName())
}
```

![image](https://user-images.githubusercontent.com/43977617/125825073-bd9cc39d-8148-4daf-9845-130e30af95e2.png)

실형 결과로 디폴트 값을 설정한 'Unknown'이 잘 출력되는걸 확인할 수 있다.

</br >

## `!!`연산자

`!!`연산자는 절대 `null`값이 올 수 없는 상황에서 nullable 타입의 변수를 사용해야 할 때 Null check가 없으면 컴파일할 수 없는 번거로움을 막기 위해 만들어진 연산자이다. 

그렇기 때문에 값이 만에 하나  `null`일 경우 `NullPointerException`을 방지할 수 없기 때문에 주의해야 한다.

```kotlin
fun main() {
    val map: Map? = CreateMap(10, 1)
    println(map!!.size)
}
```

만약 위 코드에서 `map`이 `null`이라면 `NullPointerException`이 터질것이다.

</br >

## let 함수

`let` 함수는 **함수를 호출하는 객체를 이어지는 블록의 인자로 넘기고, 해당 블록의 결과 값을 반환하는 코틀린 함수이다.**

`?.`연산자와 함꼐 사용하여 Nullable 타입을 사용할 수 없는 곳에 Nullable 타입의 변수를 사용할 수 있다.

~~~kotlin
fun DrawMap(map: Map) {
    println("draw map!")
}

fun main() {
    val nullableMap: Map? = CreateMap(10, 10)
    DrawMap(nullableMap)
}
~~~

![image](https://user-images.githubusercontent.com/43977617/126068342-8e795f56-eb05-48c6-9968-3aababaf9c19.png)

위 코드를 보면 `DrawMap`에 필요한 변수는 `Map`이지만 입력하는 값은 `Map?`이다. 

이때 `let`함수를 사용하면 에러없이 코드를 처리할 수 있다.

~~~kotlin
fun main() {
    val nullableMap: Map? = CreateMap(10, 10)
    nullableMap?.let {
        DrawMap(nullableMap)
    }
}
~~~

`?.`연산자를 사용해서 해당 객체가 `null`인지 확인한 후 null이 아닐 경우에는 'Non Null' 타입의 객체가 되어 `let`힘수를 실행한다.

그러므로 `let`함수가 넘긴 객체는 'Not Null' 타입으로 변환된 변수가 인자로 넘어와 `DrawMap`에 사용될 수 있다.

