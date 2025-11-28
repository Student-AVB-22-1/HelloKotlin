package example.myapp

import kotlin.math.PI

open class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {

    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open val shape = "square"

    open var water: Double = 0.0
        get() = volume * 0.9

    init {
        println("aquarium initializing")
    }

    constructor(numberOfFish: Int) : this() {
        val tank = numberOfFish * 2000 // 2000 cm^3 per fish
        val minLength = tank / (width * height)
        length = if (minLength > length) minLength else length
    }

    fun printSize() {
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
        println("Volume: $volume liters Water: $water liters (${water/volume*100.0}% full)")
    }
}

class TowerTank (override var height: Int, var diameter: Int) : Aquarium(height = height, width = diameter, length = diameter) {
    override var volume: Int
        get() = (width/2 * length/2 * height / 1000 * PI).toInt()
        set(value) {
            height = (value * 1000) / (width * length)
        }

    override val shape = "cylinder"
}

// Функции-расширения (Extension Functions)
fun Aquarium.isRed() = color == "red"

fun Aquarium.isGreen() = color == "green"

fun Aquarium.isBlue() = color == "blue"
