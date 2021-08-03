# 람다에서 Return 방식

## Non-local Return

코틀린의 람다 식에서는 `return`을 사용할 수 없다. `return`은 명명된 메서드나 익명 함수에만 사용할 수 있다.

아래 코드를 보자.

```kotlin
data class Person (val name: String, val age: Int)

fun findPerson(operation: () -> Unit) {
    println("Start find")
    operation()
    println("Finish")
}

fun main() {
    val people = listOf(Person("Bang", 25), Person("Ki", 25))
    findPerson {
        for(person in people) {
            if(person.name == "Bang") {
                println("Find ${person.name}!!")
                return
            }
        }
    }
}
```

`findPerson()`메서드는 람다식을 입력받는다. 여기서는 `for`문을 통해 "Bang"인 `Person`객체를 찾는다.

하지만 위 코드는 컴파일 에러가 발생한다. 전달할 람다식에서 `return`을 사용할 때 `return`을 사용할 수 없다는 메시지를 보여준다,

![image](https://user-images.githubusercontent.com/43977617/127994175-8f4ef429-2d17-4c86-92d5-7a9dcf4e5f52.png)

위 코드에서  `fun findPerson`앞에 `inline`키워드를 붙여주면 에러 메시지가 사라지고, 결과는 다음과 같다.

```kotlin
inline fun findPerson(operation: () -> Unit) {
    // ...
}
```

![image](https://user-images.githubusercontent.com/43977617/127995313-47e07136-dcc3-447e-8c16-f5f520b7184d.png)

람다 식은 `findPerson()`의 매개변수로 전달되어 `operation()`구문으로 호출된다.

그리고 `operation()`메서드에서 `return`이 이뤄지니까 다시 `findPerson()`으로 돌아와서 ` println("Finish")`구문을 실행해야 했어야 하는데, 그렇지 않고 끝이났다.

인라인 함수에 사용된 람다 식의 `return`은 람다를 인자로 받는 인라인 함수도 함꼐 종료한다. 이것은 'Non-local return'이라 한다.

</br >

## Local Return

인라인 함수에서 람다 식의 `return`으로 람다 식만 종료하고 싶을 때 'Local return'을 사용하면 된다.

`return`으로 종료하고 싶은 람다 식 앞에 레이블을 붙이고, `return`시 해당 레이블을 함꼐 써주면 된다.

```kotlin
fun main() {
    val people = listOf(Person("Bang", 25), Person("Ki", 25))
    findPerson label@{ // 레이블 선언
        for(person in people) {
            if(person.name == "Bang") {
                println("Find ${person.name}!!")
                return@label //레이블 종료
            }
        }
    }
}
```

`label@`를 통해 레이블을 선언하고 `@label` 를 통해 닫았다.

참고로 `return`과 `@`는 붙어있어야 한다. 띄워쓰기가 있으면 안된다.

이제 `fun findPerson()` 메서드에 Inline을 붙이지 않아도 에러가 나지 않고, 'Local return'또한 할 수 있다.

```kotlin
fun findPerson(operation: () -> Unit) {
    println("Start find")
    operation()
    println("Finish")
}
```

![image-20210803190237073](/Users/bang/Library/Application Support/typora-user-images/image-20210803190237073.png)

**참고로 레이블 명은 원하는 아무거나 사용할 수 있다. 쌍을 이루는 두 개가 같기만 하면 된다.**

~~~kotlin
fun main() {
    val people = listOf(Person("Bang", 25), Person("Ki", 25))
    findPerson {
        for (person in people) {
            if (person.name == "Bang") {
                println("Find ${person.name}!!")
                return@findPerson //함수명 사용
            }
        }
    }
}
~~~

</br >

## Local Return 익명 함수 사용

익명 함수에서는 `return`을 사용할 수 있다. 그래서 레이블을 사용하기 곤란하거나 람다 식에서 `return`을 여러 곳에서 해야 한다면 **익명 함수**로 바꿔 사용하면 된다.

익명 함수는 함수명 없이 `fun`키워드와 매개 변수만으로 선언된 함수를 말한다.

~~~kotlin
fun main() {
    val people = listOf(Person("Bang", 25), Person("Ki", 25))
    findPerson(fun() {
        for (person in people) {
            if (person.name == "Bang") {
                println("Find ${person.name}!!")
                return
            }
        }
    })
}
~~~

![image](https://user-images.githubusercontent.com/43977617/127998636-a82ad526-6bfc-4430-a036-9a099f9518fc.png)

