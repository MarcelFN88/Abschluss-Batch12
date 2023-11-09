package BoeseSeite

import GuteSeite.Held
import kotlin.random.Random

class Drache(
    name: String
) : Boesewicht(
    name,
    2500,
    2500,
    100,
    50,
    80
) {

    private var bonusRundenVerteidigung: Int = 0
    private var urspruenglicheVerteidigung: Int = verteidigung

    override var lebenspunkte: Int = maxLebenspunkte
        set(value) {
            field = maxOf(0, value)
        }

    companion object {
        fun erstelleDrache(): Drache {
            return Drache("Smaug der Schreckliche")
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
            val angriffe = listOf("Feueratem" to 100, "Klauenangriff" to 80, "Schwanzschlag" to 90)
            val (angriffName, basisSchaden) = angriffe.random()
            val schaden = berechneSchaden(basisSchaden, this.angriff)
            ziel.lebenspunkte -= schaden
            println("$name greift $ziel mit $angriffName an und verursacht $schaden Schaden.")
        }, {
            spezialAngriff(team)
        })
    }


    private fun spezialAngriff(team: List<Held>) {
        println("$name entfesselt eine mächtige Drachenwut.")
        team.forEach { held ->
            val schaden = berechneSchaden(120, this.angriff)
            held.lebenspunkte -= schaden
            println("Es verursacht $schaden Schaden an $held.")
        }
    }

    override fun verteidigen() {

        if (bonusRundenVerteidigung == 0) {
            val verteidigungsBonus = 30
            urspruenglicheVerteidigung = verteidigung
            verteidigung += verteidigungsBonus
            println("$name hüllt sich in eine dicke Rauchwolke. Verteidigung um $verteidigungsBonus erhöht.\n")
            bonusRundenVerteidigung = 2
        } else {
            println("$name ist bereits von Rauch umgeben und kann die Verteidigung nicht weiter erhöhen.\n")
        }
    }
}
