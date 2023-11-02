class Manipulator(name: String) : Held(name, "Manipulator") {
    init {
        verteidigung = 30
    }

    override fun verteidigenLernen() {
        super.verteidigenLernen()
        verteidigung += 10
    }
    override fun trainieren() {
        super.trainieren()
    }
    fun manipulatorAngriff() {
        println("$name, tief in der Schlacht, musst du dich entscheiden, welche Technik du nutzen möchtest:")
        println("1. Schildbumerang")
        println("2. Umwerfen")
        println("3. Blocken")

        val auswahl = readln()

        val attacke = when (auswahl) {
            "1" -> "Schildbumerang"
            "2" -> "Umwerfen"
            "3" -> "Blocken"
            else -> {
                println("In der Hitze des Gefechts zögert $name einen Moment, entscheidet sich aber letztlich für den Schildbumerang.")
                "Schildbumerang"
            }
        }

        val schaden: Number = when (attacke) {
            "Schildbumerang" -> 20 + verteidigung
            "Umwerfen" -> 25 + verteidigung
            "Blocken" -> 15 + verteidigung
            else -> 0
        }

        println("Mit einer geschickten Bewegung attackiert $name mit einem $attacke. Die Gegner werden von der Kraft des Angriffs überrascht und erleiden $schaden Schaden.")
    }
}
