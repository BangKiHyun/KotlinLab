# 제어함수2 (while, for)

## while, do-while

코틀린의 `while` 함수와 `do-while` 함수는 자바와 동일하다.

~~~kotlin
fun main() {
    var number = 0
    println("while test")
    while (number < 10) print("${number++} ")

    println("\n\ndo-while test")
    do {
        print("${number--} ")
    } while (number > 0)
}
~~~

![image](https://user-images.githubusercontent.com/43977617/126297446-63dfa67d-7b75-4fa2-a45a-7db4ab862fd6.png)

Java와 마찬가지로 `while`의 조건문이 true면 while문이 실행된다. 정말 똑같다.

</br >

## in ..

`for` 함수를 알아보기 전에 `in ..`를 먼저 알아야 한다.

우선 `..`연산자는 범위를 만든다.

~~~kotlin
fun main() {
    var oneToTen = 1..10
    println("first number: ${oneToTen.first}")
    println("last number: ${oneToTen.last}")
}
~~~

![image](https://user-images.githubusercontent.com/43977617/126299492-4ce8b787-f33a-4386-ae07-98aabbd07cce.png)

`..`연산자를 통해 1부터 10이라는 범위를 만들었다.

위 결과를 봤을때 `..`연산자는 양끝을 포함하는 구간을 사용한다. 즉, 위 예제에서는 1과 10을 포함하는 구간이 만들어진다.

</br >

`in`연산자는 매개 변수가 범위 안에 들어있는지 확인하는 연산자이다. 그래서 `..`연산자와 함께 사용되는 경우가 많다.

>- specifies the object being iterated in a [for loop](https://kotlinlang.org/docs/control-flow.html#for-loops)
>- is used as an infix operator to check that a value belongs to [a range](https://kotlinlang.org/docs/ranges.html), a collection or another entity that [defines the 'contains' method](https://kotlinlang.org/docs/operator-overloading.html#in-operator)
>- is used in [when expressions](https://kotlinlang.org/docs/control-flow.html#when-expression) for the same purpose
>- marks a type parameter as [contravariant](https://kotlinlang.org/docs/generics.html#declaration-site-variance)

```kotlin
fun isLessThanTen(number: Int) = number in 1..9

fun main() {
    var number = 10
    println(isLessThanTen(number)) //result: false
}
```

</br >

`in`연산자는 컬렉션에도 사용될 수 있다.

~~~kotlin
fun main() {
    val coll = setOf("Hello", "Bang")
    println("Bang" in coll) //result: true
}
~~~

</br >

### for

이제 `for` 함수에 대해 알아보자. 코틀린은 `in`과 `..`연산자를 이용해서 구현할 수 있다.

~~~kotlin
fun main() {
    for(idx in 0..9){
        print("$idx ")
    }
}
~~~

![image](https://user-images.githubusercontent.com/43977617/126304266-59e38d8d-6d7f-4314-b2b7-61b7185faab7.png)

</br >

만약 10부터 1로 거꾸로 세고 싶으면 `downTo`라는 연산자를 사용하면 된다.

~~~kotlin
fun main() {
    for (number in 10 downTo 1) {
        print("$number ")
    }
}
~~~

</br >

특정 값으로 값으로 증가시키거나 감소시키고 싶으면 `step`이라는 연산자를 사용하면 된다.

~~~kotlin
fun main() {
    for (number in 10 downTo 1 step 2) {
        print("$number ")
    }
}
~~~

![image](https://user-images.githubusercontent.com/43977617/126305905-6cb18910-62b5-4b0d-a111-5a0ec17b9c9d.png)

참고로 `downTo`나 `step`은 모두 일반 메서드이고, '중위 호출 방식(Infix Calls)'을 사용하기 때문에 일반 함수 호출과 달리 키워드 처럼 사용할 수 있다.

>중위 호출(Infix Calls)
>
>중위 호출이란 매개 변수가 하나 뿐인 메서드를 호출할 때 간단하게 호출할 수 있게 하기 위한 방법이다.
>
>함수 선언 앞에 "infix"라는 키워드를 붙여 선언하면 사용할 수 있다.

![image](https://user-images.githubusercontent.com/43977617/126307441-fbf72af1-31da-45e2-bce7-6066298b4d25.png)

`downTo`메서드를 보면 앞에 `infix`가 붙어 있는걸 볼 수 있다.(`step`도 마찬가지) 그렇기 때문에 다음과 같이 사용할 수 있다.

~~~kotlin
fun main() {
    for (number in 10.downTo(1).step(2)){
        print("$number ")
    }
}
~~~

</br >

`for`함수를 이용해서 컬렉션의 원소를 Key-Value로 분해하는 것도 가능하다.

~~~kotlin
fun main() {
    var list = arrayListOf("Hello", "Bang", "Bye")
    for ((index, value) in list.withIndex()) {
        println("$index: $value")
    }
}
~~~

![image](https://user-images.githubusercontent.com/43977617/126308869-9744e9d4-9e81-4ca6-aa99-662462de4173.png)

이를 구조 분해라고 하는데, 위에서는 `withIndex()`를 이용하여 `index`와 `value`로 분해하였다.

