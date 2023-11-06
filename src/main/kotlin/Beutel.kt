class Beutel {

    private val kapazitaet = 10
    val items: MutableMap<String, Int> = mutableMapOf(
        "Heiltrank" to 3,
        "Vitamine" to 5
    )

    fun zeigeInhalt() {
        println("\nWährend deiner Reisen durch Mythria hast du einige wertvolle Gegenstände in deinem Beutel gesammelt.")
        Thread.sleep(1500)
        println("Dein Beutel enthält:")
        items.forEach { (item, anzahl) ->
            println("- $item: $anzahl Stück")
        }
        println("\nJeder freie Platz in deinem Beutel könnte in zukünftigen Kämpfen von entscheidender Bedeutung sein. Freier Platz: ${kapazitaet - items.values.sum()}")
    }

    fun fuegeItemHinzu(item: String, anzahl: Int): Boolean {
        println("\nDu versuchst, $anzahl $item zu deinem Beutel hinzuzufügen...")
        Thread.sleep(1000)
        val aktuelleAnzahl = items.getOrDefault(item, 0)
        return if (aktuelleAnzahl + anzahl <= kapazitaet) {
            items[item] = aktuelleAnzahl + anzahl
            println("Erfolg! Du hast $anzahl $item zu deinem Beutel hinzugefügt.")
            true
        } else {
            println("Dein Beutel ist zu voll! Die Gegenstände von Mythria sind wertvoll, aber du musst sicherstellen, dass du nicht zu viel mit dir herumträgst. Du kannst keine weiteren Items hinzufügen.")
            false
        }
    }

    override fun toString(): String {
        return buildString {
            append("Beutelinhalt:\n")
            items.forEach { (item, anzahl) ->
                append(" - $item: $anzahl Stück\n")
            }
        }
    }
}
