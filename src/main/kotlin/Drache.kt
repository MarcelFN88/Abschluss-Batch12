import kotlin.random.Random

class Drache(
    name: String
) : Boesewicht(
    name = name,
    lebenspunkte = 4000,
    maxLebenspunkte = 4000,
    angriff = 45,
    magie = 45,
    verteidigung = 45
) {
    override val schatten = Schatten()

    init {
        println("\nEin mächtiges Brüllen ertönt aus der Ferne, und der Himmel verdunkelt sich. Ein gewaltiger Drache namens $name erhebt sich am Horizont.")
        Thread.sleep(2000)
        println("$name, der von vielen in Mythria gefürchtet wird, hat Jahrhunderte in der Dunkelheit verbracht und ist nun bereit, die Welt erneut in Schatten zu hüllen.")
        Thread.sleep(1500)
    }

    override fun angreifenHeld(): Int {
        if (lebenspunkte <= maxLebenspunkte * 0.5) {
            println("$name fühlt sich geschwächt und ruft die Kräfte des Schattens zu Hilfe!")
            schatten.aktivieren()
        }

        val schattenBonus = schatten.bonusAngriff()

        return when (Random.nextInt(1, 4)) {
            1 -> {
                println("Drache $name entfesselt einen vernichtenden Feueratem!")
                angriff + 10 + schattenBonus
            }

            2 -> {
                println("Mit einem gewaltigen Schwung setzt $name einen zerstörerischen Schwanzschlag ein!")
                angriff + schattenBonus
            }

            else -> {
                println("Der mächtige Flügelschlag von $name erzeugt einen Sturm, der alles in seiner Nähe wegfegt!")
                angriff - 5 + schattenBonus
            }
        }
    }

    override fun toString(): String {
        return "Drache - ${super.toString()}"
    }
}
