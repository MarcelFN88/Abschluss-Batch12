class Manipulator(name: String) : Held(name, "Manipulator") {
    init {
        verteidigung = 30
    }

    override fun verteidigenLernen() {
        super.verteidigenLernen()
        verteidigung += 10
    }

    fun manipulatorAngriff() {
        println("$name, wähle einen Attacke:")
        println("1. Schildbumerang")
        println("2. Umwerfen")
        println("3. Blocken")

        val auswahl = readln()

        val attacke = when (auswahl) {
            "1" -> "Schildbumerang"
            "2" -> "Umwerfen"
            "3" -> "Blocken"
            else -> {
                println("Ungültige Auswahl. Es wird ein Schwertschlag ausgeführt.")
                "Schwertschlag"
            }
        }

        val schaden: Number = when (attacke) {
            "Schildbumerang" -> 20 + verteidigung
            "Umwerfen" -> 25 + verteidigung
            "Blocken" -> 15 + verteidigung
            else -> 0
        }

        println("$name Attackiert mit einem $attacke und fügt $schaden Schaden zu.")
    }

}
