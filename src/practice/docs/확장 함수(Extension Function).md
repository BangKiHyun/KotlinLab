# 확장 함수(Extension Function)

## 확장 함수란?

확장 함수는 어떤 클래스 밖에서, 마치 그 클래스의 멤버인 것처럼 선언된 메서드를 뜻한다.

클래스 내부에 있지 않지만 그 클래스 내부 멤버에 접근할 수 있고, 클래스 멤버 메서드와 동일한 방식으로 호출할 수 있다.

~~~kotlin
class Calculator {
    fun sum(a: Int, b: Int) = a + b
    fun minus(a: Int, b: Int) = a - b
}

fun main() {
    val calc = Calculator()
    println("1 + 2 = ${calc.sum(1, 2)}")
    println("2 - 1 = ${calc.minus(2, 1)}")
}
~~~

위 코드를 실행시켜보면 `Calculator`클래스에 정의한 `sum()`, `minus()`를 호출한 반환 값이 출력된다.

이제 `Calculator`클래스에 바로 접근할 수 없다는 가정을 두고 `sum()`, `minus()` 메서드를 확장해보자.

~~~kotlin
class Calculator {
    fun sum(a: Int, b: Int) = a + b
    fun minus(a: Int, b: Int) = a - b
}

fun Calculator.sum(a: Int, b: Int, c: Int) = sum(a, b) + c
fun Calculator.minus(a: Int, b: Int, c: Int) = minus(a, b) - c

fun main() {
    val calc = Calculator()
    println("1 + 2 + 3 = ${calc.sum(1, 2, 3)}")
    println("3 - 2 - 1 = ${calc.minus(3, 2, 1)}")
}
~~~

위 코드에서 `sum(a, b, c)`와 `minus(a, b, c)`메서드는 `Calculator`클래스 밖에 정의됐지만, `Calculator`내부 메서드에 바로 접근할 수 있다.

</br >

## 주의할 점

### 1. 확장 함수는 `private`이나 `protected`로 선언된 멤버에는 접근할 수 없다.

위 에제는 따로 선언해주지 않았기 때문에 `public`으로 선언되어 메서드나 프로퍼티에 바로 접근할 수 있지만, `private`이나 `protected`로 선언된 멤버에는 접근할 수 없다.

</br >

### 2. 확장 함수로 오버라이드할 수 없다.

클래스 내부의 멤버 메서드와 동일한 함수명, 동일한 매개 변수를 가진 확장 함수는 정의할 수 없다. 즉, 기존 메서드를 재정의할 수 없다.

만약 동일한 함수명과 매개 변수를 가진 확장 함수를 정의한다면 **컴파일 에러가 발생하지는 않지만 확장 함수는 동작하지 않고 기존 클래스 멤버 메서드가 호출된다.**

그렇기 때문에 확장 함수를 정의할 때, 함수명과 매개 변수에 유의해야 한다.

</br >

### 3. 확장 프로퍼티는 '필드'를 가질 수 없다.

코틀린에서 함수뿐만 아니라 프로퍼티도 확장해서 사용할 수 있다. 하지만 확장 프로퍼티는 '필드'를 가질 수 없기 때문에 값 지정이 불가능하다.

필드가 없기 때문에 getter를 제공할 수 없으므로 반드지 getter를 정의해 줘야 한다.

~~~kotlin
class Calculator {
    val result: Int = 0
    fun sum(a: Int, b: Int) = a + b
    fun minus(a: Int, b: Int) = a - b
}

val Calculator.sign: Char
    get() {
        if (result < 0)
            return '-'
        else return '+'
    }
~~~

