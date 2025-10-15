package lab3.example.myapp

import lab3.example.myapp.decor.makeDecorations

fun buildAquarium() {
    println()
    val aquarium1 = Aquarium(width = 25, length = 25, height = 40)
    aquarium1.printSize()

    println()
    val shark: AquariumFish = Shark()
    val plecostomus: AquariumFish = Plecostomus()

    println("Shark color: ${shark.color}")
    shark.eat()

    println()
    println("Plecostomus color: ${plecostomus.color}")
    plecostomus.eat()

    println()
    makeDecorations()
}

fun main() {
    buildAquarium()  // Создание аквариума, рыб и декораций
}
