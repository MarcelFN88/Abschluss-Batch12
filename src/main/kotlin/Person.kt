open class Person(val name: String, var lebenspunkte: Int, var angriff: Int, var verteidigung: Int) {
    open var blockt: Boolean = false
    fun sprechen() {
        println("HILFE!!")
    }

    open fun erleideSchaden(schaden: Double) {
        val reduzierterSchaden: Int

        if (blockt) {
            reduzierterSchaden = ((schaden - verteidigung) / 2).toInt()
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

}