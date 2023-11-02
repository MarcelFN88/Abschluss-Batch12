class Zauberer(name: String) : Held(name, "Zauberer") {
    init {
        magie = 30
    }

    override fun zaubernLernen() {
        super.zaubernLernen()
        magie += 10
    }

    override fun trainieren() {
        super.trainieren()
    }

    fun zaubererAngriff() {
        println("$name, im flackernden Licht, fragt sich selbst: 'Welchen Zauberspruch soll ich wirken?'")
        println("1. Feuerball - Ein Ball aus Flammen stürmt auf den Feind zu.")
        println("2. Blitzschlag - Ein heftiger Blitz trifft den Gegner.")
        println("3. Eisstrahl - Ein eisiger Strahl friert alles auf seinem Weg ein.")

        val auswahl = readln()

        val zauberspruch = when (auswahl) {
            "1" -> "Feuerball"
            "2" -> "Blitzschlag"
            "3" -> "Eisstrahl"
            else -> {
                println("In seiner Unsicherheit entscheidet sich $name für einen Feuerball.")
                "Feuerball"
            }
        }

        val schaden: Int = when (zauberspruch) {
            "Feuerball" -> 20 + magie
            "Blitzschlag" -> 25 + magie
            "Eisstrahl" -> 15 + magie
            else -> 0
        }

        println("Mit einem kraftvollen Schwenk seines Zauberstabs entfesselt $name einen mächtigen $zauberspruch und verursacht dabei $schaden Schaden an seinem Gegner.")
    }
}
