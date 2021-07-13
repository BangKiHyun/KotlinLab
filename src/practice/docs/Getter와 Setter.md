# Getter와 Setter

코틀린은 멤버 변수 선언 시 getter와 setter가 자동으로 만들어진다. 필요에 따라 사용자가 직접 구현할 수도 있다.

</br >

## 프로퍼티 (Property)

멤버 변수의 필드와, getter, setter를 묶어 프로퍼티(Property)라고 한다. 프로퍼티는 getter와 setter라는 접근자를 가지며, 사용자가 직접 구현하지 않을 경우 컴파일러가 자동으로 접근자를 만들어준다.

~~~kotlin
class Rectangle {
    var height: Int = 0
    var width: Int = 0
}
~~~

위와 같이 멤버 변수를 선언해 줬을때 컴파일러는 다음과 같이 자동으로 getter와 setter를 만들어준다.

~~~kotlin
class Rectangle {
    var height: Int = 0
        get() = field
        set(value) {
            field = value
        }
    var width: Int = 0
        get() = field
        set(value) {
            field = value
        }
}
~~~

코틀린은 멤버 변수 선언 시, 바로 뒤에 각 멤버에 대한 getter와 setter가 구현된다. 사용자가 직접 구현할 때도 바로 뒤에 붙여서 구현해야 한다.

프로퍼티에 접근하기 위해 `get(`)과 `set()`을 써야 하지만, 프로퍼티의 이름을 써주기만 해도 코틀린 컴파일러가 알아서 getter와 setter를 호출해준다.

참고로 퍼로퍼티 타입이 `val`타입 이라면, 컴파일러는 getter만 만들고 setter는 만들지 않는다.

</br >

## 접근자 구현

getter와 setter를 직접 작성할 수 있다.

`Rectangle` 클래스에 `val`타입의  `isSquare`라는 멤버 변수를 추가했다. 만약 getter와 setter를 따로 만들어주지 않는다면 컴파일러가 자동으로 생성해 주겠지만 이번에는 직접 구현해보자.

### getter를 통한 초기화

~~~kotlin
// 커스텀 접근자
class Rectangle2(var height: Int, var width: Int) {
    val isSquare: Boolean
        get() = height == width
}
~~~

### 초기화 블록을 통한 초기화

~~~kotlin
class Rectangle3(var height: Int, var width: Int) {
    val isSquare: Boolean

    init {
        isSquare = height == width
    }
}
~~~

첫 번째는 `getter`를 이용하여 `isSquare`값을 초기화 시켜 줬고, 두 번째는 초기화 블록을 통해 값을 초기화 시켜줬다.

만약 `isSquare`를 호출할 때 `heigth`값이 바뀌게 된다면 `isSquare`값도 바뀔까? 결론은 둘 다 초기값을 호출한다.

~~~kotlin
fun main() {
    val rectangle2 = Rectangle2(10, 10)
    rectangle2.height = 2
    println(rectangle2.isSquare)

    val rectangle3 = Rectangle3(10, 10)
    rectangle2.height = 2
    println(rectangle2.isSquare)
}
~~~

![image](https://user-images.githubusercontent.com/43977617/125462328-8aa272f8-262e-48e1-af13-205ac3679a41.png)

setter를 직접 구현하기 위해서는 필드 값에 접근할 때는 `field`키워드를 사용한다. **참고로 getter에서는 필드 값을 읽어올 수만 있고, setter에서는 읽거나 쓰기 둘 다 가능하다.**

</br >

## 접근자의 가시성 변경자

접근자의 가시성은 기본적으로 프로퍼티의 가시성과 동일하지만, 변경해서 사용할 수 있다.

~~~kotlin
class Rectangle4 {
    var height: Int = 0
        private set(value) {
            field = value
        }

    fun addHeight() {
        this.height++;
    }
}
~~~

위 코드에서 `height`의 setter를 `private`으로 설정했다. 이렇게 되면 `height`를 외부에서 변경할 수 없게 된다.

![image](https://user-images.githubusercontent.com/43977617/125463779-b52b8c48-c205-4a4e-bf69-d60aac469313.png)

`height`를 외부에서 변경하려 할 때 위와 같은 에러가 발생한다.

