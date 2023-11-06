import kotlin.random.Random

class Krieger(
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
    angriff, magie,
    verteidigung
) {
    init {
        val ocker = "\u001B[33m"
        val reset = "\u001B[0m"
        println(
            """
        |${ocker}$name, Nachfahre der legendären Krieger von Mythria, deren Tapferkeit und Stärke in alten Liedern besungen wird.
        |Deine Vorfahren führten die Armeen von König Alderon in der Schlacht auf den Ebenen von Agador zum Sieg.
        |Dein Schwert, geschmiedet in den Feuern des Vulkanes Dranor, birgt die Essenz dieser alten Kriege.${reset}
        """.trimMargin()
        )
        println()
        Thread.sleep(5000)
    }


    override fun angreifenBoesewicht(): Int {
        println(
            """
            |Krieger $name, deine Feinde zittern bereits, wenn sie nur deinen Namen hören. Wie wirst du den Bösewicht bezwingen?
            | 1. Wilder Schwertstreich - Ein Erbe der Schlacht von Agador, mächtig und furchteinflößend.
            | 2. Unerbittlicher Schildstoß - Eine Technik, die von den Schildwächtern von Mythria gelehrt wurde.
            | 3. Kriegsbrüllen - Ein Schrei, der den Mut deiner Verbündeten stärkt und Feinde zurückschrecken lässt.
            |
            | Wähle deinen Angriff (1/2/3):
        """.trimMargin()
        )

        val auswahl = readln().toIntOrNull()
        return when (auswahl) {
            1 -> {
                println("Du schwingst dein Schwert in einem mächtigen Bogen und entfesselst die Wut deiner Ahnen.")
                angriff + Random.nextInt(0, 10)
            }
            2 -> {
                println("Mit einem kraftvollen Stoß deines Schildes wirfst du den Gegner zurück und zeigst die Wehrhaftigkeit Mythrias.")
                angriff + Random.nextInt(0, 5)
            }
            3 -> {
                println("Dein Brüllen hallt über das Schlachtfeld, und Freund wie Feind spüren die Macht deiner Stimme.")
                angriff
            }
            else -> {
                println("$name, selbst ein Krieger von Mythria muss sich auf seine Stärken besinnen. Kein Angriff erfolgt.")
                0
            }
        }
    }
}