# 제어 함수1 (if, when)

## if

if 함수는 자바와 형식이 거의 같고, if 함수의 조건으로 쓰티는 조건문 역시 동일하다.

```kotlin
fun getMax(a: Int, b: Int): Int {
    val max: Int
    if (a < b) max = b
    else max = a
    return max
}
```

위 같이 자바와 동일한 방식으로 사용할 수 있다.

하지만 코틀린은 '**함수형 프로그래밍**'을 지원한다.

함수형 프로그래밍이란 함수를 일반 값처럼 다룰 수 있도록 한 것이다. 그렇기 떄문에 함수를 변수에 저장할 수 있고, 함수를 매개 변수로 전달할 수도 있다.

그래서 다음과 같이 바꿀 수 있다.

~~~kotlin
fun getMax(a: Int, b: Int): Int {
    val max = if (a < b) b else a
    return max
}
~~~

좀 더 짧게 바꾸면 다음과 같이 바꿀 수 있다.

~~~kotlin
fun getMax(a: Int, b: Int) = if(a < b) b else a
~~~

</br >

if 함수 뒤에는 당연히 블럭({})이 올 수 있다. 블럭에서는 구문 뿐 아니라 값을 반환할 수 있다.

~~~kotlin
fun getMax(a: Int, b: Int): Int {
    return if (a < b) {
        println("b bigger than a")
        b
    } else {
        println("a bigger than b")
        a
    }
}
~~~

블럭에서 마지막에 선언한 값이 반환 값이 된다.

참고로 if 함수를 통해 값을 반환할 수 있기 때문에 코틀린에서는 따로 삼항 연산자(`a < b ? b : a`)가 없다.

</br >

## when

when 함수는 자바의 switch 함수를 대체하는 함수이며, 더 많은 기능을 수행할 수 있다.

~~~kotlin
fun calculate(a: Int, b: Int, operation: String): Int {
    when (operation) {
        "+" -> return a + b
        "-" -> return a - b
        "*" -> return a * b
        else -> return a / b
    }
}
~~~

when 함수는 `case:` 대신 `->`를 사용하고, `default:`대신 `else ->`를 사용한다.

위 코드만 보았을 때는 Java와 크게 다를게 없어 보인다. 다음 코드를 봐보자.

```kotlin
fun printValue(number: Int, str: String) {
    when (number) {
        str.toInt() -> println("str is number")
        else -> println("str is not number")
    }
}
    printValue(10, "10")
    printValue(10, "20")
}
```

![image](https://user-images.githubusercontent.com/43977617/126155102-d8728fbb-f1ae-4982-9163-bc87e69f12cf.png)

위 코드에서 `String.toInt()` 함수를 사용했다. 앞에서 언근했듯이 코틀린은 함수형 프로그램을 지원하기 때문에 함수가 값 대신 사용될 수 있다.

</br >

when 함수에는 `is`연산자를 이용한 '스마트 캐스트'기능이 사용될 수 있다.

~~~kotlin
fun isStartPrefix(x: Any) = when (x) {
    is String -> x.startsWith("prefix")
    else -> false
}

fun main() {
    println(isStartPrefix("prefixTrue"))
    println(isStartPrefix(10))
}
~~~

![image](https://user-images.githubusercontent.com/43977617/126155867-b8da3495-d8f3-466c-8772-f250c7b92e63.png)

`Any`타입으로 받은 `x`가 String 타입을 경우 해당 문자열이 "prefix"로 시작하는지 검사한 결과 값을 반환하고, String 타입이 아닐 경우 `false`를 반환한다.

</br >

when 함수는 매개 변수 없이도 사용할 수 있다.

~~~kotlin
fun checkValue(text: String) {
    when {
        text.startsWith("hi") -> println("$text is start hi")
        text.startsWith("bye") -> println("$text is start bye")
        else -> println("text is $text")
    }
}

fun main() {
    checkValue("hi man")
    checkValue("bye man")
    checkValue("good man")
}
~~~

![image](https://user-images.githubusercontent.com/43977617/126156535-4977ccb4-bbd9-475b-9b93-d488b923ad59.png)

위 코드의 경우 조건문이 `true` 일때 해당 구문을 실행한다.

Java의 `switch`문 보다 훨씬 더 많은 기능을 제공하는 것을 알 수 있다.

