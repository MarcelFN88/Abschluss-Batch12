import kotlin.random.Random

class DunklerMagier(
    name: String
) : Boesewicht(
    name = name,
    lebenspunkte = 3000,
    maxLebenspunkte = 3000,
    angriff = 40,
    magie = 40,
    verteidigung = 40
) {
    override val schatten = Schatten()

    init {
        println("\nEin kalter Wind weht durch die Gegend, gefolgt von einem dunklen Flüstern. Aus dem Nichts erscheint $name, ein Dunkler Magier, bekannt in Mythria für seine grausamen und dunklen Zauber.")
        Thread.sleep(2000)
        println("$name hat viele Jahre in den verbotenen Künsten der dunklen Magie verbracht und sucht nun nach der ultimativen Macht, um Mythria zu beherrschen.")
        Thread.sleep(1500)
    }

    override fun angreifenHeld(): Int {
        if (lebenspunkte <= maxLebenspunkte * 0.5) {
            println("$name spürt seine Schwäche und ruft die dunklen Mächte des Schattens an seine Seite!")
            schatten.aktivieren()
        }

        val schattenBonus = schatten.bonusAngriff()

        return when (Random.nextInt(1, 4)) {
            1 -> {
                println("Dunkler Magier $name sammelt die Kräfte der Finsternis und entfesselt eine Dunkle Energiekugel!")
                angriff + magie + schattenBonus
            }

            2 -> {
                println("$name murmelt eine finstere Beschwörung und setzt Seelensauger ein, um die Lebensenergie seiner Gegner zu stehlen!")
                angriff + (magie / 2) + schattenBonus
            }

            else -> {
                println("Mit dunklen Worten öffnet $name ein Schattenportal, um Wesen aus den Tiefen der Dunkelheit herbeizurufen!")
                angriff - 10 + schattenBonus
            }
        }
    }

    override fun toString(): String {
        return "Dunkler Magier - ${super.toString()}"
    }
}
