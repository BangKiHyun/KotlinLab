package practice.code.lambdas.returntype

data class Person(val name: String, val age: Int)

fun findPerson(operation: () -> Unit) {
    println("Start find")
    operation()
    println("Finish")
}

fun main() {
    val people = listOf(Person("Bang", 25), Person("Ki", 25))
//    findPerson {
//        for(person in people) {
//            if(person.name == "Bang") {
//                println("Find ${person.name}!!")
//                return
//            }
//        }
//    }

    findPerson {
        for (person in people) {
            if (person.name == "Bang") {
                println("Find ${person.name}!!")
                return@findPerson
            }
        }
    }

    findPerson(fun() {
        for (person in people) {
            if (person.name == "Bang") {
                println("Find ${person.name}!!")
                return
            }
        }
    })
}