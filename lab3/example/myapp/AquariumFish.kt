package example.myapp

interface FishAction  {
    fun eat()
}

abstract class FishColor(val color: String) : FishAction {
    override fun eat() = println("eats a lot")
}

class Shark: FishColor("gray"), FishAction {
    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus: FishColor("gold"), FishAction {
    override fun eat() {
        println("eat algae")
    }
}

// ИСПРАВЛЕНО: Функции-расширения добавлены здесь и применены к FishColor
fun FishColor.isRed() = color == "red"

fun FishColor.isGreen() = color == "green"

fun FishColor.isBlue() = color == "blue"
