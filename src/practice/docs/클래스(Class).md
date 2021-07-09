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



