package lab2

fun greet(name: String = "World") {
    println("Hello, $name!")
}

fun filterDecorations(decorations: List<String>, filter: (String) -> Boolean): List<String> {
    return decorations.filter(filter)
}

fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        greet(args[0])
    } else {
        greet()
    }

    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    val filteredDecorations = filterDecorations(decorations) { it[0] == 'p' }

    println("Filtered Decorations: $filteredDecorations")  // Выводит: [pagoda, plastic plant]

    val shortDecorations = filterDecorations(decorations) { it.length < 6 }
    println("Short Decorations: $shortDecorations")
}