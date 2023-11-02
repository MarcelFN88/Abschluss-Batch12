open class Boesewicht(
    name: String,
    lebenspunkte: Int,
    maxLebenspunkte: Int = lebenspunkte,
    angriff: Int,
    verteidigung: Int
) : Person(name, lebenspunkte, maxLebenspunkte, angriff, verteidigung) {

    fun zufalligerAusdruck() {
        val ausdrucke = listOf(
            "murmelnd beschwört $name dunkle Magie.",
            "läuft umher und zettelt Unruhe an.",
            "verzieht sein Gesicht und bereitet sich finster auf einen Angriff vor."
        )
        val zufaelligerAusdruck = ausdrucke.random()
        println(zufaelligerAusdruck)
    }

    open fun angreifen(ziel: Person) {
        zufalligerAusdruck()
        val schaden = angriff - ziel.verteidigung
        if (schaden > 0) {
            ziel.lebenspunkte -= schaden
            println("Mit einer raschen Bewegung fegt $name über das Schlachtfeld und trifft ${ziel.name}, wobei er $schaden Schadenspunkte verursacht!")
        } else {
            println("${ziel.name} weicht geschickt dem wütenden Angriff von $name aus und bleibt unverletzt!")
        }
    }
}
