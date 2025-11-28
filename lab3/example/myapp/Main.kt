package example.myapp

import example.myapp.decor.makeDecorations
import example.myapp.* // ИСПРАВЛЕНО: Используем wildcard-импорт для функций-расширений

fun main() {
    buildAquarium()
    makeDecorations()
    makeFish()
    testPairs()
    testExtensionFunctions()
}

fun buildAquarium() {
    val myAquarium = Aquarium()
    myAquarium.printSize()
    myAquarium.volume = 70
    myAquarium.printSize()

    val towerTank = TowerTank(height = 40, diameter = 25)
    towerTank.printSize()
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}

fun testPairs() {
    val equipment = "fish net" to "catching fish"
    println("${equipment.first} used for ${equipment.second}")

    val numbers = Triple(6, 9, 42)
    println(numbers.toString())
    println(numbers.toList())
}

fun testExtensionFunctions() {
    val shark = Shark()
    println("Is shark red? ${shark.isRed()}")
}
