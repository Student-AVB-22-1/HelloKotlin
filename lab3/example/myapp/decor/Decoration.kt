package example.myapp.decor

data class Decoration(val rocks: String, val wood: String, val diver: String)

fun makeDecorations() {
    val decoration1 = Decoration("granite", "wood", "diver")
    println(decoration1)

    val decoration2 = Decoration("slate", "wood", "diver")
    println(decoration2)

    val decoration3 = Decoration("slate", "wood", "diver")
    println(decoration3)

    println(decoration1.equals(decoration2))
    println(decoration3.equals(decoration2))

    val (rocks, wood, diver) = decoration1
    println(rocks)
    println(wood)
    println(diver)

    val decoration4 = decoration3.copy()
    println(decoration4)

    val decoration5 = Decoration2("crystal", "wood", "diver")
    println(decoration5)

    val decoration6 = Decoration2("pearl", "wood", "diver")
    println(decoration6)

    println(decoration5.equals(decoration6))
}

class Decoration2(val rocks: String, val wood: String, val diver: String)

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
}

enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}
