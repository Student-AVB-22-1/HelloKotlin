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
