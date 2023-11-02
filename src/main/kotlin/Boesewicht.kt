open class Boesewicht(
    name: String,
    lebenspunkte: Int,
    angriff: Int,
    verteidigung: Int,
    open val maxLebenspunkte: Int = 200
) : Person(name, lebenspunkte, angriff, verteidigung) {

    fun zufalligerAusdruck() {
        val ausdrucke = listOf("1. Schmiedet Pläne", "2. Zettelt Unruhe", "3. Bereitet sich auf einen Angriff vor")
        val zufalligerAusdruck = ausdrucke.random()
        println(zufalligerAusdruck)
    }

    open fun angreifen(ziel: Person) {

    }
}
