import kotlin.random.Random


class Magier(
    name: String,
    lebenspunkte: Int,
    maxLebenspunkte: Int,
    angriff: Int,
    magie: Int,
    verteidigung: Int
) : Held(
    name,
    lebenspunkte,
    maxLebenspunkte,
    angriff,
    magie,
    verteidigung
) {
    init {
        val magenta = "\u001B[33m"
        val reset = "\u001B[0m"
        println(
            """
        |${magenta}$name, Adept der uralten Magieschule von Mythria, berühmt für das Binden der Elemente an deinen Willen.
        |In deinen Adern fließt das Blut der Magierlinie von Elenoir, welche einst die Nordwinde bändigte.
        |Dein Zauberstab, geschnitzt aus dem heiligen Baum Yggdranor, pulsiert mit den Energien längst vergangener Zeiten.${reset}
        """.trimMargin()
        )
        println()
        Thread.sleep(5000)
    }


    override fun angreifenBoesewicht(): Int {
        println(
            """
            |Magier $name, Erbe von Elenoirs Weisheit, mit welchem Zauber wirst du deine Feinde heute herausfordern?
            | 1. Feuerball - Eine wild entfesselte Flamme, gewoben mit der Wärme von Mythrias ewiger Sonne.
            | 2. Eiskette - Ketten aus dem Herzen des nördlichsten Gletschers, so kalt, dass sie die Zeit selbst einfrieren.
            | 3. Elektrische Schockwelle - Ein Echo des legendären Sturms, der Mythria vor Jahrhunderten heimsuchte.
            |
            | Wähle deinen Zauber (1/2/3):
        """.trimMargin()
        )

        val auswahl = readln()
        return when (auswahl) {
            "1" -> {
                println("Du beschwörst einen mächtigen Feuerball, der die Luft erzittern lässt, bevor er auf dein Ziel zurast.")
                magie + Random.nextInt(0, 10)  // Zufälliger Schaden zwischen 0 und 10, sollte sich auf Magie stattdessen von Angriff beziehen
            }
            "2" -> {
                println("Mit einer Bewegung deiner Hand rufen deine Zauber frostige Ketten herbei, die deinen Feind lähmen.")
                magie + Random.nextInt(0, 5)   // Zufälliger Schaden zwischen 0 und 5, sollte sich auf Magie stattdessen von Angriff beziehen
            }
            "3" -> {
                println("Deine Zauber entfesseln eine schockierende Welle elektrischer Energie, die in der Luft knistert.")
                magie  // Hier könnte man auch einen zusätzlichen Effekt hinzufügen, z.B. eine Chance, den Gegner zu betäuben
            }
            else -> {
                println("$name, ein Meister der Elemente steht immer mit bedachtvoller Kraft. Kein Zauber wird gewirkt.")
                0
            }
        }
    }
}

