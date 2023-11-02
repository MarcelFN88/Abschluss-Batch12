open class Person(val name: String,
                  var lebenspunkte: Int,
                  open val maxLebenspunkte: Int,
                  var angriff: Int,
                  var verteidigung: Int
) {
    open var blockt: Boolean = false

    fun sprechen() {
        println("$name ruft verzweifelt: 'HILFE!! Wer wird mir in meiner Not zur Seite stehen?'")
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
            println("Ein mächtiger Schlag trifft $name! Er verliert $reduzierterSchaden Lebenspunkte und ist nun nur noch bei $lebenspunkte Lebenspunkten.")
        } else {
            println("Mit einer unglaublichen Reaktionsfähigkeit blockt $name den Angriff und bleibt unverletzt!")
        }
    }

}
