package practice.code.second.inheritance

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable")
}

interface NotClickable {
    fun newClick()
    fun showOff() = println("I'm not clickable")
}

class Button : NotClickable, Clickable {
    override fun click() {
        println("inheritance clickable interface!")
    }

    override fun newClick() {
        println("inheritance not clickable interface!")
    }

    // 구현체가 있는 메서드는 재정의 안해도 무방
    override fun showOff() {
        println("implement clickable showOff method!")
    }
}

class Button2 : NotClickable, Clickable {
    override fun click() {
        println("inheritance clickable interface!")
    }

    override fun newClick() {
        println("inheritance not clickable interface!")
    }

    override fun showOff() {
        super<Clickable>.showOff()
        super<NotClickable>.showOff()
    }
}

interface Animal {
    val name: String
}

class Dog(val sound: String) : Animal {
    override val name = "dog"
}

class Cat(override val name: String, val sound: String) : Animal {
}

fun main(array: Array<String>) {
    val button = Button()
    button.click()
    button.showOff()
}