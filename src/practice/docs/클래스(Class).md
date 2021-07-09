# 클래스(Class)

## 정의 및 선언

코틀린에서는 자바와 달리 파일명과 클래스명이 동일하지 않아도 되고, 한 파일 내에 몇 개의 클래스가 있어도 상관 없다.

`class`키워드를 붙여 선언하면 된다.

~~~kotlin
class Person() {
    var id: Int = 10
}
~~~

</br >

객체를 생성할 때 `new`키워드를 사용하지 않는다.

~~~kotlin
fun main(args: Array<String>) {
    // 일반 version
    val person: Person = Person()
  
    // 타입 추론 version
    val person = Person()
}
~~~

</br >

## 가시성 변경자 (Visiblity Modifier)

가시성 변경자는 Java에서 접근 제어자라고 생각하면 될거같다.

코틀린에서 변경자를 따로 명시해주지 않으면 자동으로 `pulbic`으로 선언된다.

| 변경자    | 클래스         | 최상위 함수, 변수 |
| --------- | -------------- | ----------------- |
| public    | 모든 곳        | 모든 곳           |
| internal  | 같은 모듈 내   | 같은 모듈 내      |
| protected | 하위 클래스 내 | 사용 불가         |
| private   | 같은 클래스 내 | 같은 파일 내      |

여기서 모듈은 함꼐 컴파일되는 코틀린 파일들을 의미한다.

</br >

## 생성자

### 주 생성자(Primary Constructor)

~~~kotlin
    class User {
        var id: Int = 10
    }
~~~

위 클래스만 보면 생성자가 없는 것으로 보이지만 주 생성자가 생략되어 있는 상태이다.

자바와 마찬가지로, 매개 변수가 없는 생성자만 존재할 경우 생성자는 생략될 수 있다. 생략되기 전의 정의는 아래와 같다.

~~~kotlin
    class User() {
        var id: Int = 10
    }
~~~

차이점으로는 클래스명 뒤에 `()`가 생겼다.

코틀린에서 주 생성자는 클래스명 뒤에 괄호`()`로 정의하며, 생성자 파라미터에 의해 프로퍼티(멤버 변수)를 초기화하기 위한 목적으로 사용된다.

`User`클래스는 매개 변수가 없는 주 생성자를 사용하므르 빈 괄호를 쓸 수 있고, 주 생성자 외에 다른 생성자가 없으므로 주 생성자를 생략할 수 있다.

</br >

### 주 생성자를 통해 매개 변수 초기화

아래와 같이 입력받는 매개 변수를 통해 초기화 시킬 수 있다.

```kotlin
class User(inputId: Int) {
    var id = inputId
}
```

코틀린은 주 생성자의 정의와 프로퍼티 정의를 한번에 할 수 있다.

~~~kotlin
class User(var id: Int)
~~~

</br >

### 부 생성자(Secondary Constructor)

Java에서 여러 개의 생성자를 정의할 수 있듯이, 코틀린에서도 여러 개의 생성자를 정의할 수 있다.

`constructor`키워드를 사용해 정의한다.

~~~kotlin
    class User {
        var id: Int = 10
        var name: String = "bang"

        constructor(id: Int) {
            this.id = id
        }

        constructor(id: Int, name: String) {
            this.id = id
            this.name = name
        }
    }
~~~

`constructor`로 부 생성자를 정의하면 코틀린은 기본 생성자를 따로 만들어주지 않는다. 만약 기본 생성자(매개 변수가 없는 생성자)를 사용하고 싶다면 주 생성자나 부 생성자에 매개 변수가 없는 생성자를 정의해주면 된다.

</br >

### 주 생성자와 부 생성자를 같이 사용할 때 주의할 점

```kotlin
class User(var id: Int) {
    var name: String = "bang"

    constructor(id: Int, name: String) {
        this.id = id
        this.name = name
    }
}
```

위 코드는 Int형 매개 변수 하나를 받는 주 생성자를 정의했다.

하지만 실제로 코드를 실행시면 다음과 같은 에러가 난다.

~~~kotlin
Primary constructor call expected
~~~

해석해보면 주 생성자를 호출해야 한다고 알려준다.

코틀린에서 주 생성자가 정의된 경우, 부 생성자는 반드시 주 생성자를 재호출해야 한다. 필수로 초기화되는 프로퍼티들을 놓지지 않기 위해서다.

부 생성자에서 주 생성자를 재호출하는 방법은 부 생성자 선언부 옆에 `:`명령어를 붙인 후 `this`키워드를 사용하면 된다.

```kotlin
class User(var id: Int) {
    var name: String = "bang"

    constructor(id: Int, name: String) : this(id) {
        this.name = name
    }
}
```

