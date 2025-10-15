package lab3.example.myapp.decor

data class Decoration(val rocks: String)

fun makeDecorations() {
    val decoration1 = Decoration("granite")
    println(decoration1)

    val decoration2 = Decoration("slate")
    println(decoration2)

    val decoration3 = Decoration("slate")
    println(decoration3)

    println(decoration1 == decoration2)
    println(decoration3 == decoration2)
}