# Colletions(2) 함수

Collections 함수에 대해 몇가지 알아보자.

공통으로 사용할 코드는 다음과 같다.

```kotlin
val list = listOf("One", "Two", "Three", "Four", "Five")
```

</br >

### val size: Int

size는 컬렉션의 크기를 의미한다.

```kotlin
println(list.size) // result: 5
```

</br >

### fun isEmpty(): Boolean

컬렉션이 비어있으면 `true`를 반환하고, 아니면 `false`를 반환한다.

~~~kotlin
println(list.isEmpty()) // result: false
~~~

</br >

### fun contains(element: E): Boolean

해당 항목이 컬렉션에 포함되어 있는지 반환한다.

```kotlin
println(list.contains("Two")) // result: true
```

</br >

### fun containsAll(elements: Collection< E>): Boolean

지정된 컬렉션의 모든 요소가 리스트 내에 있는지 반환한다.

```kotlin
println(list.containsAll(listOf("One", "Three", "Four"))) // result: true
```

</br >

### public fun get(index: Int): E

지정된 인덱스의 값을 반환한다.

~~~kotlin
println(list.get(1)) // result: Two
~~~

</br >

### public fun indexOf(element:  E): Int

지정된 값의 index를 를 반환합니다. 중복된 값이 있을 경우 맨 처음에 찾은 인덱스 값을 반환한다.

~~~kotlin
println(list.indexOf("One")) // result: 0
~~~

</br >

### public fun subList(fromIndex: Int, toIndex: Int): List< E>

fromIndex(포함)부터 toIndex(포함 안함)까지의 범위의 리스트를 반환한다.

반환되는 리스트는 원본 리스트를 참조하기 때문에 반환된 리스트를 변경하며 원본 리스트도 변경된다.

```kotlin
println(list.subList(0, 3)) // result: [One, Two, Three]
```

</br >

### fun < T> Iterable< T>.all(predicate: (T) -> Boolean): Boolean

지정된 조건에 모든 항목이 만족할 경우 true 반환한다.

~~~kotlin
println(list.all { s -> s.startsWith("T") }) // result: false
~~~

</br >

### fun < T> Iterable< T>.any(predicate: (T) -> Boolean): Boolean

지정된 조건에 하나 이상의 항목이 만족할 경우 true 반환한다.

```kotlin
println(list.any { s -> s.startsWith("T") }) // result: false
```

</br >

### fun < T> Iterable< T>.drop(n: Int): List< T>

앞에서부터 n개의 항목을 제외한 리스트를 반환한다.

~~~kotlin
println(list.drop(2)) // resutl: [Three, Four, Five]
~~~

</br >

### fun < T> Iterable< T>.minus(element: T): List< T>

지정된 항목을 제외한 리스트를 반환하다. 중복된 값이 있을 경우 맨 처음에 찾은 값만 제외한다.

```kotlin
val list2 = listOf("One", "Two", "Three", "Two", "Four", "Five")
println(list2.minus("Two")) // result: [One, Three, Two, Four, Five]
```

`remove`와 차이점으로는 `remove`는 해당 값을 제외하고 return 값이 `Boolean`인 반면 `minus`는 `List`를 반환한다는 점이다.

</br >

### fun < T> Collection< T>.plus(element: T): List< T> 

지정된 항목을 추가한 리스트를 반환한다.

~~~kotlin
println(list.plus("Fix")) // result: [One, Two, Three, Four, Five, Fix]
~~~

</br >

### fun < T> Iterable< T>.shuffled(): List< T>

순서를 랜덤으로 섞은 새로운 리스트를 반환한다.

```kotlin
println(list.shuffled()) // result: [Four, Five, Two, Three, One]
```

</br >

### fun < T> Iterable< T>.take(n: Int): List< T>

앞에서부터 n개의 항목을 반환한다.

~~~kotlin
println(list.take(2)) // result: [One, Two]
~~~

