import kotlin.random.Random

class Schatten {
    var aktiv: Boolean = false
    private var runden: Int = 0

    init {
        println(
            """
            |Ein uraltes Dunkelheitsrelikt aus den versteckten Ecken Mythrias, der Schatten, ist ein Wesen, das sowohl gefürchtet als auch verehrt wird.
            |Seine Anwesenheit ist flüchtig, aber wenn er gerufen wird, verleiht er seinem Meister unglaubliche Macht.
            |Viele haben versucht, diese Kraft zu beherrschen, aber nur wenige sind erfolgreich gewesen, während andere von der Dunkelheit verzehrt wurden.
            """.trimMargin()
        )
    }

    fun aktivieren() {
        if (!aktiv) {
            println("Die Luft wird kälter, während der Schatten sich materialisiert und dich mit seiner dunklen Essenz umhüllt.")
            aktiv = true
            runden = 10
        } else {
            println("Der Schatten ist bereits aktiv. Seine Dunkelheit ist überwältigend.")
        }
    }

    fun bonusAngriff(): Int {
        return if (aktiv) {
            println("Durch die dunkle Energie des Schattens fühlst du dich mächtiger und gewinnst einen Angriffsbonus.")
            runden--
            if (runden == 0) {
                println("Die Energie des Schattens beginnt zu schwinden und zieht sich zurück in die Dunkelheit.")
                aktiv = false
            }
            10
        } else {
            println("Der Schatten ist nicht aktiv. Die Dunkelheit antwortet nicht auf deinen Ruf.")
            0
        }
    }


    fun schattenAngriff(team: List<Held>): Int {
        if (!aktiv) return 0

        val schaden = when (Random.nextInt(1, 5)) {
            1 -> {
                println("Schatten führt 'Dunkle Peitsche' aus!")
                10
            }
            2 -> {
                println("Schatten entfesselt 'Nachtliche Klauen'!")
                15
            }
            3 -> {
                println("Schatten wirkt 'Mondstrahl Durchdringung'!")
                8
            }
            4 -> {
                println("Schatten setzt 'Sternenfall' ein!")
                12
            }
            else -> 0
        }

        for (held in team) {
            held.lebenspunkte -= schaden
            println("${held.name} erleidet $schaden Schaden durch den Schatten!")
        }

        return schaden
    }
}
