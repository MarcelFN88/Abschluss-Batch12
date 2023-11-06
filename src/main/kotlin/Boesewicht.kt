import kotlin.random.Random

open class Boesewicht(
    val name: String,
    var lebenspunkte: Int = 2000,
    val maxLebenspunkte: Int = 2000,
    var angriff: Int = 30,
    var magie: Int = 30,
    var verteidigung: Int = 30
) {
    open val schatten = Schatten()

    init {
        println("\nEin finsteres Wesen ist aus den Schatten von Mythria hervorgetreten. Es ist $name, ein Bösewicht, der es sich zur Aufgabe gemacht hat, die friedlichen Bewohner des Landes zu terrorisieren.")
        Thread.sleep(2000)
        println("$name hat einen finsteren Blick und eine Aura, die von seiner dunklen Macht zeugt.")
        Thread.sleep(1500)
    }

    fun rufeSchatten() {
        if (lebenspunkte <= maxLebenspunkte * 0.5 && !schatten.aktiv) {
            println("$name ruft den Schatten herbei!")
            schatten.aktivieren()
        }
    }
    fun angreifen(): Pair<String, Int> {
        println("\n$name sammelt seine düsteren Kräfte für einen Angriff...")
        return when (Random.nextInt(1, 4)) {
            1 -> {
                val schaden = Random.nextInt(20, 40)
                println("${name} führt mit unvorstellbarer Dunkelheit einen dämonischen Schlag aus und verursacht \u001B[31m$schaden\u001B[0m Schaden!")
                Pair("Dämonischer Schlag", schaden)
            }

            2 -> {
                val schaden = Random.nextInt(20, 40)
                println("${name} beschwört aus der Tiefe seines Herzens einen finsteren Magieblitz und verursacht \u001B[31m$schaden\u001B[0m Schaden!")
                Pair("Finsterer Magieblitz", schaden)
            }

            else -> {
                val schaden = Random.nextInt(20, 40)
                println("${name}, mit dem Zorn der verbotenen Mächte, schwingt sein dunkles Schwert und verursacht \u001B[31m$schaden\u001B[0m Schaden!")
                Pair("Dunkler Schwertstreich", schaden)
            }
        }
    }

    fun blocken(): Boolean {
        val chanceZuBlocken = Random.nextInt(1, 101)
        return if (chanceZuBlocken <= 50) {
            println("$name umgibt sich mit einer schützenden dunklen Aura und blockt deinen Angriff!")
            true
        } else {
            false
        }
    }

    fun erhalteSchaden(schaden: Int) {
        lebenspunkte -= schaden
        if (lebenspunkte < 0) {
            lebenspunkte = 0
        }
        println("$name ächzt vor Schmerz und hat jetzt noch $lebenspunkte Lebenspunkte!")
    }

    open fun angreifenHeld(): Int {
        println("$name bündelt seine dunklen Energien, um den Helden anzugreifen!")
        return angriff
    }

    override fun toString(): String {
        return "Name: $name, Lebenspunkte: $lebenspunkte, Angriff: $angriff, Magie: $magie, Verteidigung: $verteidigung"
    }

    open fun angreifenHeld(team: List<Held>): Int {
        TODO("Not yet implemented")
    }
}
