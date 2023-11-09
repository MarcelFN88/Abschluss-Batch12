package BoeseSeite

import GuteSeite.Held
import kotlin.random.Random

class DunklerMagier(
    name: String
) : Boesewicht(
    name,
    1800,
    1800,
    60,
    120,
    60
) {
    var magieSchild: Int = 0
    private var bonusRundenVerteidigung: Int = 0
    private var urspruenglicheVerteidigung: Int = verteidigung

    override var lebenspunkte: Int = maxLebenspunkte
        set(value) {
            field = maxOf(0, value)
        }

    companion object {
        fun erstelleDunklerMagier(): DunklerMagier {
            return DunklerMagier("Gandar der Dunkelheit")
        }
    }

    fun entscheideAktion(normalerAngriff: () -> Unit, spezialAngriff: () -> Unit) {
        if (Random.nextInt(100) < 80) {
            normalerAngriff()
        } else {
            spezialAngriff()
        }
    }

    fun angreifen(team: List<Held>) {
        entscheideAktion({
            val ziel = team.random()
            val angriffe = listOf("Schwarzfeuer" to 90, "Seelenfresser" to 110, "Dunkle Kugel" to 100)
            val (angriffName, basisSchaden) = angriffe.random()
            val schaden = berechneSchaden(basisSchaden, this.magie)
            ziel.lebenspunkte -= schaden
            println("$name greift $ziel mit $angriffName an und verursacht $schaden Schaden.")
        }, {
            spezialAngriff(team)
        })
    }

    private fun spezialAngriff(team: List<Held>) {
        println("$name entfesselt die Kräfte der Dunkelheit über das gesamte Team.")
        team.forEach { held ->
            val schaden = berechneSchaden(130, this.magie)
            held.lebenspunkte -= schaden
            println("Es verursacht $schaden Schaden an $held.")
        }
    }


    override fun verteidigen() {
        if (bonusRundenVerteidigung == 0) {
            val verteidigungsBonus = 25
            urspruenglicheVerteidigung = verteidigung
            verteidigung += verteidigungsBonus
            magieSchild = 50
            println("$name erschafft einen magischen Schild. Verteidigung um $verteidigungsBonus erhöht, Schild absorbiert bis zu $magieSchild Schaden.\n")
            bonusRundenVerteidigung = 3
        } else {
            println("$name hat bereits einen magischen Schild und kann die Verteidigung nicht weiter erhöhen.\n")
        }
    }
}
