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
        println("Während deiner Reise durch das neblige Tal entscheidest du, eine kurze Rast zu machen.")
        println("Du setzt dich unter einen großen, alten Baum und öffnest deinen Beutel.")
        println("Ein sanfter Duft steigt dir in die Nase und du erblickst:")

        inventar.forEachIndexed { index, gegenstand ->
            when (gegenstand) {
                "Heiltrank" -> println("${index + 1}. Ein glitzernder ${gegenstand}, der in der Sonne funkelt.")
                "Vitamine" -> println("${index + 1}. Eine Dose voller ${gegenstand}, die vor Energie zu strotzen scheint.")
            }
        }

        println("In diesen gefährlichen Zeiten könnten dir diese Gegenstände von Nutzen sein.")
        println("Welchen möchtest du verwenden?")

        when (val auswahl = readln().toInt()) {
            in 1..inventar.size -> {
                val ausgewaehlterGegenstand = inventar[auswahl - 1]
                when (ausgewaehlterGegenstand) {
                    "Heiltrank" -> {
                        println("Du nimmst den Heiltrank und fühlst, wie seine Energie durch deine Adern fließt.")
                        held.heileMitHeiltrank()
                    }
                    "Vitamine" -> {
                        println("Du öffnest die Dose Vitamine und fühlst dich sofort stärker und wacher.")
                        held.nutzeVitamine()
                    }
                }
                inventar.removeAt(auswahl - 1)
            }

            else -> {
                println("Vielleicht ist es besser, nichts zu verwenden und einfach weiterzuziehen.")
            }
        }
    }
}
