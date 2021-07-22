# Collections(1) - List, Set, Map

Collections이란 자바에서 데이터를 저장하는 기본 자료 구조들을 한 곳에 모아 관리와 사용을 편하게 하기 위해 제공하는 프레임 워크를 의미한다.

코틀린의 컬렉션은 변경 가능(Mutalbe)한 컬렉션과 변경 불가능(Immutable)한 컬렉션을 구분해서 사용한다.

</br >

## List

코틀린의 `List`는 기본적으로 변경 불가능한 방식이다. 생성자에 리스트의 길이와 초기화를 위한 람다 식을 넣어주는 것으로 객체를 생성하거나, `listOf`함수를 사용해 생성할 수 있다.

```kotlin
fun main() {
    val list: List<Int> = List(5) { i -> i }
    println(list)

    val listOf: List<Int> = listOf(1, 2, 3, 4, 5)
    println("\n$listOf")
}
```

![image](https://user-images.githubusercontent.com/43977617/126636524-68abcd65-d0b3-4aa5-a2ad-d8b0ac52aef4.png)

</br >

List 불변 타입이기 때문에 값을 바꾸는 건 불가능하다.

![image](https://user-images.githubusercontent.com/43977617/126637621-16ac0e32-44b9-4fc9-950f-4a9e985ad671.png)

값을 바꾸려 하면 위와 같은 에러가 뜬다. 배열에 접근할 수 있도록 설정한 방법이 없다는 것 같다.

변경 가능한(Mutable)한 리스트를 만들기 위해서는 `MutableList`또는 `ArrayList`를 사용하면 된다. `MutableList`는 `List`와 같은 방법으로 생성자에 리스트의 길이와 초기화를 위한 람다 식을 넣어주는 것으로 객체를 생성하거나, `mutableListOf()`함수를 사용해서 생성할 수 있다.

코틀린의  `ArrayList` 는 자바의 `ArrayList`에 기반하여 만들어지는 것 같다. 그래서 생성자에서 길이 초기화는 가능하지만 람다 식을 넣을 순 없다. 대신 `arrayListOf()`를 통해 생성할 수 있다.

![image](https://user-images.githubusercontent.com/43977617/126639756-0f7b1c22-e819-49d4-8bcb-facf81337dd0.png)

~~~kotlin
fun main() {
    println("mutable list 실행 결과")
    val mutableList: MutableList<Int> = MutableList(5) { i -> i }
    println(mutableList)

    val mutableListOf = mutableListOf(1, 2, 3, 4, 5)
    println(mutableListOf)

    println("\narray list 실행 결과")
    val arrayList: ArrayList<Int> = ArrayList(5)
    println(arrayList)

    val arrayListOf = arrayListOf(1,2,3,4,5)
    println(arrayListOf)
}
~~~

![image](https://user-images.githubusercontent.com/43977617/126640180-8fad4771-5c72-438a-9635-0df0a1fbd67e.png)

</br >

## Set

`Set`은 중복을 허용하지 않는다. `List`와 마찬가지로 Mutable과 Immutable 타입이 있다.

```kotlin
fun main() {
    val set: Set<Int> = setOf(1, 1, 4, 3)
    println(set) // result: [1, 4, 3]
}
```

출력 결과는 `[1, 4, 3]`으로 '1'이 중복 제거된 것을 확인할 수 있다.

</br >

변경 가능한 `Set`을 만들기 위해 `mutableSetOf`, `hashSetOf`, `linkedSetOf` 등의 함수를 사용해 생성할 수 있다.

~~~kotlin
fun main() {
    val mutableSet = mutableSetOf(1, 1, 4, 3)
    mutableSet.add(5)
    println(mutableSet)

    val hashSet = hashSetOf(1, 4, 2, 2)
    hashSet.add(5)
    println(hashSet)
}
~~~

![image](https://user-images.githubusercontent.com/43977617/126649744-2e2f194d-9e5b-447d-9ff5-e8a0b87a8cec.png)

`HashSet`의 출력 순서를 보면 오른차순으로 되어있는걸 확인할 수 있다. `HashSet`클래스는 'Key'값의 해시 코드(hash code)순으로 검색된다.

 </br >

## Map

`Map`은 Key-Value 쌍으로 이루어진 집합이다. 순차작이지 않으며, Key는 중복될 수 없고, Value는 중복될 수 있다.

Immutable 타입이며, `mapOf()` 함수로 생성할 수 있다.

```kotlin
fun main() {
    val map: Map<String, Int> = mapOf("One" to 1, "Two" to 2, "Three" to 3)
    println(map)

    val mapPair: Map<String, Int> = mapOf(Pair("One", 1), Pair("Two", 2), Pair("Three", 3))
    println(mapPair)
}
```

![image-20210722225428689](/Users/bang/Library/Application Support/typora-user-images/image-20210722225428689.png)

</br >

변경 가능한 `Map`을 만들기 위해 `mutalbeMapOf`, `hashMapOf`등의 함수를 사용해 생성할 수 있다.

새로운 값을 주입하는 방법은 `put()`과 `[]`가 있다.

~~~kotlin
fun main() {
    val mutableMap = mutableMapOf("One" to 1, "Two" to 2, "Three" to 3)
    mutableMap.put("Four", 4)
    println(mutableMap)

    val mutableHashMap = hashMapOf(Pair("One", 1), Pair("Two", 2), Pair("Three", 3))
    mutableHashMap["Four"] = 4
    println(mutableHashMap)
}
~~~

![image-20210722230730612](/Users/bang/Library/Application Support/typora-user-images/image-20210722230730612.png)

</br >

만약, 중복된 Key값이 들어왔을 때는 기존의 Key-Value쌍은 사라지고, 새로 주입한 값이 들어가게 된다.

```kotlin
fun main() {
    val mutableMap = mutableMapOf("One" to 1, "Two" to 2, "Three" to 3)
    mutableMap.put("Two", 22)
    println(mutableMap)
}
```

![image](https://user-images.githubusercontent.com/43977617/126653534-b9b491b8-5bae-488c-9653-d02f968de126.png)

