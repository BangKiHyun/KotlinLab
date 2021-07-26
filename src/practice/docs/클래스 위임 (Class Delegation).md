# 클래스 위임 (Class Delegation)

여기서 위임이란 개발자가 구현해야 할 추상 메서드들 또는 추상 프로퍼티들의 정의를 다른 객체엑 떠넘기는걸 뜻한다.

코틀린은 자바와 달리 기본적으로 모든 클래스가 `final`이다. 만약 상속을 원한다면 클래스에 `open`접근자를 명시해줘야 한다.

그래서 상속 기능이 필요할 때 **데코레이터 패턴(Decorator Pattern)**이라는 방식을 사용한다.

>데코레이터 패턴(Decorator Pattern)
>
>객체의 결합을 통해 기능을 동적으로 유연하게 확장할 수 있게 해주는 패턴
>
>기본 기능에 추가할 수 있는 기능의 종류가 많은 경우에 각 추가 기능을 Decorator 클래스로 정의한 후 필요한 Decorator 객체를 조합함으로써 추가 기능의 조합을 설계하는 방식이다.

예를 들어, `MutableList`를 상속받아 리스트의 모든 기능을 사용하면서, 원소의 개수를 카운트하는 기능을 넣고 싶을때, `MutableList`인터페이스를 `CountingList`라는 이름의 새로운 클래스로 구현하고 `MutableList`를 프로퍼티로 가진 뒤 `add()`,와 `addAll()` 메서드를 재정의하면 된다.

하지만 `MutableList`는 인터페이스이기 때문에 `MutableList`에 정의된 메서드 및 프로퍼티들을 모두 재정의 해줘야 한다.

하지만 나는 `add()`와 `addAll()`만 재정의 하고 싶다. 이때, `by`키워드를 이미 구현된 객체에게 위임해주면 된다.

~~~kotlin
class CountingList<T>(val innerList: MutableList<T>) : MutableList<T> by innerList {
    var addedCount = 0
    override fun add(element: T): Boolean {
        addedCount++
        return innerList.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        addedCount += elements.size
        return innerList.addAll(elements)
    }
}
~~~

위와 같이 프로퍼티로 정의한 `innerList`에세 위임을 해주었다.

```kotlin
fun main() {
    val countingList = CountingList<Int>(mutableListOf())
    countingList.addAll(listOf(1, 2, 3))
    println("List: ${countingList.addedCount} objects were added, remain: ${countingList.size}")

    countingList.clear()
    println("List: ${countingList.addedCount} objects were added, remain: ${countingList.size}")
}
```

![image](https://user-images.githubusercontent.com/43977617/126987507-7cfb535f-0165-4660-9a38-8f8500241a10.png)

실행 결과를 보면 원하는 동작들이 잘 동작하는 것을 확인할 수 있다.

`by`키워드를 통해 이미 구현한 클래스에게 위임함으로써 구현을 좀 더 쉽게 해줄 수 있었다.

