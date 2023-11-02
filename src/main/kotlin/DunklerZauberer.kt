class DunklerZauberer(
    name: String,
    lebenspunkte: Int,
    angriff: Int,
    verteidigung: Int,
    override var blockt: Boolean = false
) : Boesewicht(name, lebenspunkte, angriff, verteidigung) {
    var schattenBeschworen = false

    private val attacken = listOf(
        Attacke("Dunkler Blitz", 1.2),
        Attacke("Fluch der Verwundung", 0.8),
        Attacke("Schattenstoß", 1.5),
        Attacke("Eisiger Hauch", 1.0)
    )

    override fun angreifen(ziel: Person) {
        val zufalligeAttacke = attacken.random()

        var schadenMultiplier = zufalligeAttacke.multiplikator
        if (schattenBeschworen) {
            schadenMultiplier *= 1.5
        }

        val schaden = (angriff * schadenMultiplier).toInt()

        println("$name greift ${ziel.name} mit ${zufalligeAttacke.name} an und fügt ${schaden} Schaden zu!")
        ziel.erleideSchaden(schaden.toDouble())
    }

    fun spezialAttacke(ziel: List<Person>) {
        if (schattenBeschworen) {
            for (held in ziel) {
                val schaden = (angriff * 1.5).toInt()
                println("$name führt eine mächtige Spezialattacke gegen ${held.name} aus und fügt ${schaden} Schaden zu!")
                held.erleideSchaden(schaden.toDouble())
            }
        } else {
            println("$name kann die Spezialattacke erst nach dem Beschwören des dunklen Schattens verwenden.")
        }
    }


    data class Attacke(val name: String, val multiplikator: Double)

    fun dunklenSchattenRufen() {
        if (lebenspunkte <= 0.3 * maxLebenspunkte && !schattenBeschworen) {
            schattenBeschworen = true
            println("$name ruft einen dunklen Schatten herbei, um ihm im Kampf zu helfen!")
        }
    }

    fun blocken() {
        blockt = true
    }

    override fun erleideSchaden(schaden: Double) {
        if (blockt) {
            lebenspunkte -= (schaden / 2).toInt()
            blockt = false
        } else {
            lebenspunkte -= schaden.toInt()
        }
    }
}
