import kotlin.random.Random

open class Held(
    name: String,
    val heldenTyp: String,
    lebenspunkte: Int = 200,
    angriff: Int = 10,
    verteidigung: Int = 10,
    var magie: Int = 10,
    var maxLebenspunkte: Int = 200
) :
    Person(name, lebenspunkte, angriff, verteidigung) {


    fun blocken() {
        blockt = true
    }

    override fun erleideSchaden(schaden: Double) {
        val reduzierterSchaden: Int

        if (blockt) {
            reduzierterSchaden = (schaden / 2).toInt()
            blockt = false
        } else {
            reduzierterSchaden = (schaden - verteidigung).toInt()
        }

        if (reduzierterSchaden > 0) {
            lebenspunkte -= reduzierterSchaden
            if (lebenspunkte < 0) {
                lebenspunkte = 0
            }
            println("$name erleidet $reduzierterSchaden Schaden und hat nun $lebenspunkte Lebenspunkte.")
        } else {
            println("$name blockt den Angriff und erleidet keinen Schaden.")
        }
    }


    open fun mitSchwertKaempfenLernen() {
        angriff += 20
        lebenspunkte += (10..20).random()
        println("Trainiert mit seinem Schwert")
    }

    open fun zaubernLernen() {
        magie += 20
        lebenspunkte += (10..20).random()
        println("Studiert die alte Kunst der Magie")
    }

    open fun verteidigenLernen() {
        verteidigung += 20
        lebenspunkte += (10..20).random()
        println("Trainiert mit dem Schild sich zu verteidigen")
    }

    open fun trainieren() {
        println(
            "Möchtest Du mit dem Schwert trainieren,\n" +
                    " zaubern lernen oder mit dem Schild deine verteidigung stärken?"
        )
        println("1. Mit dem Schwert trainieren")
        println("2. Zaubern lernen")
        println("3. Verteidigung stärken")

        val auswahl = readln()

        when (auswahl) {
            "1" -> {
                mitSchwertKaempfenLernen()
            }

            "2" -> {
                zaubernLernen()
            }

            "3" -> {
                verteidigenLernen()
            }

            else -> {
                println("Ungültige Auswahl. Bitte wählen Sie 1 oder 2 oder 3.")
            }
        }
    }

    fun heileMitHeiltrank() {
        val heilung = maxLebenspunkte / 2
        lebenspunkte += heilung
        if (lebenspunkte > maxLebenspunkte) {
            lebenspunkte = maxLebenspunkte
        }
        println("$name hat einen Heiltrank verwendet und $heilung Lebenspunkte wurden geheilt. $name hat jetzt $lebenspunkte Lebenspunkte.")
    }

    fun nutzeVitamine() {
        val chance = Random.nextDouble()
        if (chance < 0.5) {

            angriff = (angriff * 1.10).toInt()
            println("$name hat Vitamine genommen und sein Angriff wurde um 10% erhöht.")
        } else {

            magie = (magie * 1.10).toInt()
            println("$name hat Vitamine genommen und seine Magie wurde um 10% erhöht.")
        }
    }

}