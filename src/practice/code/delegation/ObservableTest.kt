package practice.code.delegation

import kotlin.properties.Delegates

class Person(val name: String, age: Int) {
    var age: Int by Delegates.observable(age) { property, oldValue, newValue ->
        println("${property.name}: $oldValue -> $newValue")
    }
}

fun main() {
    val person = Person("Bang",  25)
    person.age = 27
}