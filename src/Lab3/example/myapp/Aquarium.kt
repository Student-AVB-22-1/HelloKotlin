package lab3.example.myapp

open class Aquarium(var length: Int = 100, var width: Int = 20, open var height: Int = 40) {  // помечаем height как open
    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open var shape = "rectangle"
    open var water: Double = 0.0
        get() = volume * 0.9

    init {
        println("aquarium initializing")
    }

    fun printSize() {
        println(shape)
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
        println("Volume: $volume liters Water: $water liters (${water / volume * 100.0}% full)")
    }
}
