package practice.code.first

class FunctionTest {

    // 기본적인 함수 선언 방법
    fun sum1(a: Int, b: Int): Int {
        return a + b
    }

    // default값 세팅 가능
    fun sum2(a: Int, b: Int = 10): Int {
        return a + b
    }

    // return 타입 생략 가능
    fun sum3(a: Int, b: Int) = a + b
}