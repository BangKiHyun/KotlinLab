package practice.code.second.inheritance

class InheritanceTest {

    open class Animal(val name: String, val sound: String) {
        open fun printInfo() {
            println("Name: $name, Sound: $sound")
        }
    }

    class Dog1(name: String, sound: String) : Animal(name, sound) {
        override fun printInfo() {
            println("Name: $name, Sound: $sound")
        }
    }

    class Dog2 : Animal {
        constructor(name: String, sound: String) : super(name, sound)
    }
}