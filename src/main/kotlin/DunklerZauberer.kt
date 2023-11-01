

class DunklerZauberer(name: String, lebenspunkte: Int, angriff: Int, verteidigung: Int) : Boesewicht(name, lebenspunkte, angriff, verteidigung) {
    private var schattenBeschworen = false

    override fun angreifen(ziel: Person) {
        if (schattenBeschworen) {
            super.angreifen(ziel)
        } else {
            println("$name greift $ziel an.")
        }
    }

    fun dunklenSchattenRufen() {
        if (lebenspunkte <= 0.3 * maxLebenspunkte && !schattenBeschworen) {
            schattenBeschworen = true
            println("$name ruft einen dunklen Schatten herbei, um ihm im Kampf zu helfen!")
        }
    }

    fun spezialAttacke(ziel: List<Person>) {
        if (schattenBeschworen) {

            for (held in ziel) {
                val schaden = angriff * 1.5
                held.erleideSchaden(schaden)
                println("$name führt eine mächtige Spezialattacke gegen ${held.name} aus!")
            }
        } else {
            println("$name kann die Spezialattacke erst nach dem Beschwören des dunklen Schattens verwenden.")
        }
    }
}


