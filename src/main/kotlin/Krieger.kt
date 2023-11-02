class Krieger(name: String) : Held(name, "Krieger") {
    init {
        angriff = 30
    }

    override fun mitSchwertKaempfenLernen() {
        super.mitSchwertKaempfenLernen()
        angriff += 10
    }

    override fun trainieren() {
        super.trainieren()
    }

    fun kriegerAngriff() {
        println("$name, tapferer Krieger, wähle deine Kampftechnik:")
        println("1. Schwertstreich des Drachen")
        println("2. Sprung des Löwen")
        println("3. Wirbelwind des Falken")

        val auswahl = readln()

        val attacke = when (auswahl) {
            "1" -> "Schwertstreich des Drachen"
            "2" -> "Sprung des Löwen"
            "3" -> "Wirbelwind des Falken"
            else -> {
                println("Ungewisse Entscheidung. Der Schwertstreich des Drachen wird gewählt.")
                "Schwertstreich des Drachen"
            }
        }

        val schaden: Int = when (attacke) {
            "Schwertstreich des Drachen" -> 20 + angriff
            "Sprung des Löwen" -> 25 + angriff
            "Wirbelwind des Falken" -> 15 + angriff
            else -> 0
        }

        println("$name setzt den $attacke ein und fügt beeindruckende $schaden Schadenspunkte zu.")
    }

}
