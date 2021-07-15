# Nullable vs Non-Null

## Non-Null 타입

자바는 모든 참조 변수가 Null값을 가질 수 있지만 코틀린의 참조 변수는 기본적으로 Null을 가질 수 없다.

만약 'Non-Null'타입의 변수에 `null`을 입력하면 컴파일 에러가 발생한다.

![image](https://user-images.githubusercontent.com/43977617/125754079-2601f10a-0ebe-4456-a04b-835a013e14f9.png)

이렇게 하면 모든 참조 변수는 `null`을 가질 수 없게 되므로, `NullPointerException`을 방지 할 수 있다.

</br >

## Nullable 타입

코틀린에서 `Nullable`한 타입을 사용하려면 `?`키워드를 사용하면 된다.

`?`키워드는 코틀린의 모든 타입에 사용 가능하다. 단, 해당 변수의 필드에 'Null Check'없이 바로 접근할 수 없다.

![image](https://user-images.githubusercontent.com/43977617/125756066-f75a260c-9a7f-4648-9379-ac79a8c10bd4.png)

위 코드에서 `value`를 보면 `String`옆에 `?`를 붙여줌으로써 Nullable하다는 것을 명시해줬다.

그래서 `value` 값이 `null`을 넣어줘도 에러가 발생하지 않는것을 확인할 수 있다. 하지만 `value.length`에서 에러가 발생했다. 에러가 발생한 이유는 Null Check를 해주지 않았기 때문이다.

```kotlin
class NullableText(private val value: String?) {
    fun length(): Int {
        if (value != null) return value.length
        else return 0
    }
}
```

위와 같이 Null Check를 하면 에러없이 잘 돌아간다.

이렇게 코틀린에서는 Null이 될 수 있는 모든 경우에 대한 예외 처리를 컴파일러에서 강제하고 있기 때문에 `NullPointerException`를 방지할 수 있게 된다.

