class Zauberer(name: String) : Held(name, "Zauberer") {
    init {
        magie = 30
    }

    override fun zaubernLernen() {
        super.zaubernLernen()
        magie += 10
    }

    fun zaubererAngriff() {
        println("$name, wähle einen Zauberspruch:")
        println("1. Feuerball")
        println("2. Blitzschlag")
        println("3. Eisstrahl")

        val auswahl = readln()

        val zauberspruch = when (auswahl) {
            "1" -> "Feuerball"
            "2" -> "Blitzschlag"
            "3" -> "Eisstrahl"
            else -> {
                println("Ungültige Auswahl. Es wird ein Feuerball ausgeführt.")
                "Feuerball"
            }
        }

        val schaden: Int = when (zauberspruch) {
            "Feuerball" -> 20 + magie
            "Blitzschlag" -> 25 + magie
            "Eisstrahl" -> 15 + magie
            else -> 0
        }

        println("$name zaubert $zauberspruch und fügt $schaden Schaden zu.")
    }



}

