

open class Person(val name: String, var lebenspunkte: Int, var angriff: Int, var verteidigung: Int) {

    fun sprechen() {
        println("HILFE!!")
    }

    fun erleideSchaden(schaden: Double) {
        val reduzierterSchaden = (schaden - verteidigung).toInt() // Konvertiere zu Int
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
