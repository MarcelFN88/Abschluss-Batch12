open class Beutel {
    private val inventar = mutableListOf<String>()

    init {
        for (i in 1..3) {
            inventar.add("Heiltrank")
        }
        for (i in 1..5) {
            inventar.add("Vitamine")
        }
    }

    fun oeffneBeutel(held: Held) {
        println("Du öffnest den Beutel und findest darin:")
        inventar.forEachIndexed { index, gegenstand ->
            println("${index + 1}. $gegenstand")

        }
        println("Was möchtest du verwenden?")

        when (val auswahl = readln().toInt()) {
            in 1..inventar.size -> {
                val ausgewaehlterGegenstand = inventar[auswahl - 1]
                println("Du verwendest $ausgewaehlterGegenstand.")
                when (ausgewaehlterGegenstand) {
                    "Heiltrank" -> held.heileMitHeiltrank()
                    "Vitamine" -> held.nutzeVitamine()
                }
                inventar.removeAt(auswahl - 1)
            }
            else -> {
                println("Ungültige Auswahl.")
            }
        }
    }

}
