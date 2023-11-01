class Krieger(name: String) : Held(name, "Krieger") {
    init {
        angriff = 30
    }

    override fun mitSchwertKaempfenLernen() {
        super.mitSchwertKaempfenLernen()
        angriff += 10
    }

    fun kriegerAngriff() {
        println("$name, wähle einen Attacke:")
        println("1. Schwertschlag")
        println("2. Hechtsprung")
        println("3. Rundhieb")

        val auswahl = readln()

        val attacke = when (auswahl) {
            "1" -> "Schwertschlag"
            "2" -> "Hechtsprung"
            "3" -> "Rundhieb"
            else -> {
                println("Ungültige Auswahl. Es wird ein Schwertschlag ausgeführt.")
                "Schwertschlag"
            }
        }

        val schaden: Int = when (attacke) {
            "Schwertschlag" -> 20 + angriff
            "Hechtsprung" -> 25 + angriff
            "Rundhieb" -> 15 + angriff
            else -> 0
        }

        println("$name Attackiert mit einem $attacke und fügt $schaden Schaden zu.")
    }

}

