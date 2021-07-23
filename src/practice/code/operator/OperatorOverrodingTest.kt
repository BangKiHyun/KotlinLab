package practice.code.operator

data class Point(var x: Int, var y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    operator fun unaryMinus(): Point {
        return Point(-x, -y)
    }

    operator fun inc(): Point {
        return Point(x + 1, y + 1)
    }

    operator fun plusAssign(other: Point): Unit {
        x += other.x
        y += other.y
    }

    override fun equals(other: Any?): Boolean {
        if(other === this) return true
        if(other !is Point) return false
        return other.x == x && other.y == y
    }
}

fun main() {
    val p1 = Point(1, 2)
    val p2 = Point(2, 4)
    println(p1 + p2)
    println(p1.plus(p2))

    p1 += p2
    println(p1)

    val point1 = Point(1, 2)
    val point2 = Point(1, 2)
    println(point1 == point2)

    val p = Point(10, 20)
    println(-p1)
}