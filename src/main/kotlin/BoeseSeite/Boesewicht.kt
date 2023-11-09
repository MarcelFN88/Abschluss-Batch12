package BoeseSeite

import GuteSeite.Held
import kotlin.random.Random

open class Boesewicht(
    val name: String,
    lebenspunkte: Int,
    var maxLebenspunkte: Int,
    var angriff: Int,
    val magie: Int,
    var verteidigung: Int
) {
    private var bonusRundenVerteidigung: Int = 0
    private var urspruenglicheVerteidigung: Int = verteidigung
    var laehmung: Boolean = false



    open var lebenspunkte: Int = lebenspunkte
        set(value) {
            field = maxOf(0, value)
        }

    companion object {

        const val resetColor = "\u001B[0m"
        const val nameColor = "\u001B[33m"
        private const val labelColor = "\u001B[34m"
        private const val valueColor = "\u001B[32m"

        fun erzeugeBoesewicht(): Boesewicht {
            val namenListe = mapOf(
                "Zantor" to "der Verderber",
                "Morgath" to "der Grausame",
                "Korvax" to "der Vernichter",
                "Sindar" to "der Schatten",
                "Guldan" to "der Schwarzmagier"
            )

            val (vorname, titel) = namenListe.entries.shuffled().first()
            val vollerName = "$vorname $titel"

            val boesewicht = Boesewicht(vollerName, 2000, 2000, 70, 70, 70)

            boesewicht.druckeEigenschaften()

            return boesewicht
        }

        fun lebenspunkteFarbe(lebenspunkte: Int, maxLebenspunkte: Int): String {
            val prozent = lebenspunkte.toDouble() / maxLebenspunkte
            return when {
                prozent > 0.5 -> Held.greenColor
                prozent > 0.3 -> Held.yellowColor
                else -> Held.redColor
            }
        }
    }

    fun druckeEigenschaften() {
        println("$nameColor$name$resetColor")
        println("${labelColor}Lebenspunkte:$resetColor $valueColor$lebenspunkte/$maxLebenspunkte$resetColor")
        println("${labelColor}Angriff:$resetColor $valueColor$angriff$resetColor")
        println("${labelColor}Magie:$resetColor $valueColor$magie$resetColor")
        println("${labelColor}Verteidigung:$resetColor $valueColor$verteidigung$resetColor\n")
        println("Der Bösewicht $nameColor$name$resetColor steht bereit, um Unheil über die Welt zu bringen!\n")
    }
    fun angreifen(gegner: Held) {
        val aktion = Random.nextInt(1, 4)

        when (aktion) {
            1 -> {
                val schaden = berechneSchaden(50, angriff)
                gegner.lebenspunkte -= schaden
                println("$name hat $schaden Schaden mit Schwertstreich verursacht.\n")
            }
            2 -> {
                val schaden = berechneSchaden(40, magie)
                gegner.lebenspunkte -= schaden
                println("$name hat $schaden Schaden mit Feuerball verursacht.\n")
            }
            3 -> {
                val schaden = berechneSchaden(60, angriff)
                gegner.lebenspunkte -= schaden
                println("$name hat $schaden Schaden mit Donnerschlag verursacht.\n")
            }
        }
    }

    fun berechneSchaden(basisSchaden: Int, wert: Int): Int {
        return basisSchaden + wert
    }

    open fun erleideSchaden(schaden: Int) {
        lebenspunkte -= schaden
        println("$name erleidet $schaden Schaden.")
    }
    open fun verteidigen() {
        if (bonusRundenVerteidigung == 0) {
            val verteidigungsBonus = 20
            urspruenglicheVerteidigung = verteidigung
            verteidigung += verteidigungsBonus
            println("$name erhöht die Verteidigung um $verteidigungsBonus.\n")
            bonusRundenVerteidigung = 2
        }
    }

    fun rundenUpdate() {
        if (bonusRundenVerteidigung > 0) {
            bonusRundenVerteidigung--
            if (bonusRundenVerteidigung == 0) {
                verteidigung = urspruenglicheVerteidigung
                println("Der Verteidigungsbonus von $name ist ausgelaufen.\n")
            }
        }
    }
}
