# 인라인 함수(Inline Functions)



고차 함수에서 람다를 사용할 경우 각 함수는 객체로 변환되어 추가적인 메모리 할당과 함수 호출이 발생하게 된다. 이는 런타임 오버헤드를 초래한다.

코틀린에서는 람다를 매개 변수로 사용하는 고차 함수를 인라인 함수(Inline Functions)으로 정의하여 오버 헤드를 줄일 수 있는 방법을 제공하고 있다.

먼저 고차 함수를 사용할 때 어떤 과정이 이뤄지는 알아보자.

~~~kotlin
fun calculator(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

fun main() {
    println(calculator(1, 2) { a: Int, b: Int -> a + b })
}
~~~

위 코드는 `calculator`의 매개 변수로 `operation`이라는 람다 식을 정의했다.

위 코드를 자바로 변환하면 다음과 같다.

~~~kotlin
public final class InlineTestKt {
   public static final int calculator(int a, int b, @NotNull Function2 operation) {
      Intrinsics.checkParameterIsNotNull(operation, "operation");
      return ((Number)operation.invoke(a, b)).intValue();
   }

   public static final void main() {
      int var0 = calculator(1, 2, (Function2)null.INSTANCE);
      boolean var1 = false;
      System.out.println(var0);
   }
}
~~~

`main()`함수를 자세히 보면 `calculator()`함수의 세 번째 매개변수가 람다 식이 아니라 `Function2`타입의 객체로 받고 있다.

즉, `main()`에서 매개 변수로 전달한 `{ a: Int, b: Int -> a + b }`람다 식은 `Function2`객체로 생성되어 전달되고 있다.

> FunctionN
>
> 코틀린에서 컴파일 단계에서 람다를 `FunctionN`인터페이스를 구현한 객체로 저장한다.
>
> 해당 인터페이스는 매개 변수 개수에 맞는 `invoke()`메서드가 하나씩 선언되어 있고, `FunctionN`인터페이스의 `invoke()`메서드 내에 람다 식을 구현하고, 해당 객체를 파라미터로 사용한다.

만약에 `calculator()`함수를 람다 식을 통해 여러번 실행할 경우 람다 식마다의 각각의 객체가 생성되게 되어 메모리에 저장되고, 해당 객체의 `invoke()`함수가 각각 호출되기 때문에, 메모리 할당과 호출에 의한 런타임 오버헤드가 발생되게 된다.

</br >

## 인라인 함수

인라인 함수는 함수 앞에 `inline`키워드를 붙이면 된다.

인라인 함수로 정의된 함수는 컴파일 단계에서 호출하는 방식이 아니라 코드 자체가 복제되는 방식으로 컴파일 된다. 다음 예제를 봐보자.

~~~kotlin
inline fun calculator(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

fun main() {
    println(calculator(1, 2) { a: Int, b: Int -> a + b })
}
~~~

첫 번째 예제 코드에서 `calculator`함수 앞에 `inline`키워드만 붙였다.

이 코드를 자바로 변환하면 다음과 같다.

```kotlin
public final class InlineTestKt {
   public static final int calculator(int a, int b, @NotNull Function2 operation) {
      int $i$f$calculator = 0;
      Intrinsics.checkParameterIsNotNull(operation, "operation");
      return ((Number)operation.invoke(a, b)).intValue();
   }

   public static final void main() {
      byte a$iv = 1;
      int b$iv = 2;
      int $i$f$calculator = false;
      int var5 = false;
      int var6 = a$iv + b$iv;
      boolean var7 = false;
      System.out.println(var6);
   }
}
```

`main()`함수를 보면 `calculator()`의 본문이 복사되어, `Function2`객체를 생성하지도 않는다. `Function2`객체를 생성하지 않기 때문에 호출할 필요도 없게 된다.

이렇게 인라인 함수를 사용하게 된다면 람다 사용 시 발생하는 오버헤드를 줄일 수 있다.

</br >

## noinline 키워드

인라인 함수에 전달된 람다 중 모든 인자를 `inline`으로 처리하고 싶지 않을 때, `noinline`키워드를 사용하여 `inline`에서 제외시킬 수 있다.

```kotlin
inline fun newCalculator(a: Int, b: Int, operation: (Int, Int) -> Int, noinline func: () -> Unit): Int {
    func()
    return operation(a, b)
}

fun main() {
    println(newCalculator(1, 2, { a: Int, b: Int -> a + b }, { println("noinline function") }))
}
```

`func`앞에 `noinline`키워드르 붙여 인라인 함수에서 제외시켰다.

이 코드를 자바로 변환한 코드를 봐보자.

```kotlin
public final class InlineTestKt {
   public static final int newCalculator(int a, int b, @NotNull Function2 operation, @NotNull Function0 func) {
      int $i$f$newCalculator = 0;
      Intrinsics.checkParameterIsNotNull(operation, "operation");
      Intrinsics.checkParameterIsNotNull(func, "func");
      func.invoke();
      return ((Number)operation.invoke(a, b)).intValue();
   }

   public static final void main() {
      a$iv = 1;
      b$iv = 2;
      Function0 func$iv = (Function0)null.INSTANCE; // Function0 생성
      int $i$f$newCalculator = false;
      func$iv.invoke(); // Function0 호출
      int var6 = false;
      var7 = a$iv + b$iv;
      var8 = false;
      System.out.println(var7);
   }
}
```

`noinline`으로 선언한 함수는 `Fucntion0`로 생성하고, 호출하는 모습을 볼 수 있다.



