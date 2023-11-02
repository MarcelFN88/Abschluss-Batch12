import kotlin.random.Random

open class Held(
    name: String,
    val heldenTyp: String,
    lebenspunkte: Int = 350,
    override var maxLebenspunkte: Int = lebenspunkte,
    angriff: Int = 10,
    verteidigung: Int = 10,
    var magie: Int = 10
) :
    Person(name, lebenspunkte,maxLebenspunkte, angriff, verteidigung) {

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
            println("$name, der $heldenTyp, erlitt einen schweren Schlag und verlor $reduzierterSchaden Lebenspunkte. Er hat jetzt nur noch $lebenspunkte Lebenspunkte.")
        } else {
            println("$name, mit seiner Rüstung und Geschick, konnte den Angriff gekonnt abwehren!")
        }
    }

    open fun mitSchwertKaempfenLernen() {
        angriff += 20
        lebenspunkte += (10..20).random()
        println("$name verbringt den Tag auf dem Übungsplatz und perfektioniert seine Schwertkunst.")
        println("""
 ________  ________  ___       __   _______   ________                 ___  ___  ________   
|\   __  \|\   __  \|\  \     |\  \|\  ___ \ |\   __  \               |\  \|\  \|\   __  \  
\ \  \|\  \ \  \|\  \ \  \    \ \  \ \   __/|\ \  \|\  \  ____________\ \  \\\  \ \  \|\  \ 
 \ \   ____\ \  \\\  \ \  \  __\ \  \ \  \_|/_\ \   _  _\|\____________\ \  \\\  \ \   ____\
  \ \  \___|\ \  \\\  \ \  \|\__\_\  \ \  \_|\ \ \  \\  \\|____________|\ \  \\\  \ \  \___|
   \ \__\    \ \_______\ \____________\ \_______\ \__\\ _\               \ \_______\ \__\   
    \|__|     \|_______|\|____________|\|_______|\|__|\|__|               \|_______|\|__| 
    """.trimIndent())
    }

    open fun zaubernLernen() {
        magie += 20
        lebenspunkte += (10..20).random()
        println("$name studiert bei den alten Magiern und erlernt geheimnisvolle Zauber.")
        println("""
 ________  ________  ___       __   _______   ________                 ___  ___  ________   
|\   __  \|\   __  \|\  \     |\  \|\  ___ \ |\   __  \               |\  \|\  \|\   __  \  
\ \  \|\  \ \  \|\  \ \  \    \ \  \ \   __/|\ \  \|\  \  ____________\ \  \\\  \ \  \|\  \ 
 \ \   ____\ \  \\\  \ \  \  __\ \  \ \  \_|/_\ \   _  _\|\____________\ \  \\\  \ \   ____\
  \ \  \___|\ \  \\\  \ \  \|\__\_\  \ \  \_|\ \ \  \\  \\|____________|\ \  \\\  \ \  \___|
   \ \__\    \ \_______\ \____________\ \_______\ \__\\ _\               \ \_______\ \__\   
    \|__|     \|_______|\|____________|\|_______|\|__|\|__|               \|_______|\|__| 
    """.trimIndent())
    }

    open fun verteidigenLernen() {
        verteidigung += 20
        lebenspunkte += (10..20).random()
        println("$name trainiert mit den Meistern der Verteidigung und lernt, Angriffe besser abzuwehren.")
        println("""
 ________  ________  ___       __   _______   ________                 ___  ___  ________   
|\   __  \|\   __  \|\  \     |\  \|\  ___ \ |\   __  \               |\  \|\  \|\   __  \  
\ \  \|\  \ \  \|\  \ \  \    \ \  \ \   __/|\ \  \|\  \  ____________\ \  \\\  \ \  \|\  \ 
 \ \   ____\ \  \\\  \ \  \  __\ \  \ \  \_|/_\ \   _  _\|\____________\ \  \\\  \ \   ____\
  \ \  \___|\ \  \\\  \ \  \|\__\_\  \ \  \_|\ \ \  \\  \\|____________|\ \  \\\  \ \  \___|
   \ \__\    \ \_______\ \____________\ \_______\ \__\\ _\               \ \_______\ \__\   
    \|__|     \|_______|\|____________|\|_______|\|__|\|__|               \|_______|\|__| 
    """.trimIndent())
    }

    open fun trainieren() {
        println(
            "Wie möchtest du heute, edler Held, deine Fähigkeiten stärken?\n" +
                    "1. Die Kunst des Schwertkampfes vertiefen\n" +
                    "2. Die Mysterien der Magie erkunden\n" +
                    "3. Die Techniken der Verteidigung meistern"
        )
        val auswahl = readln()

        when (auswahl) {
            "1" -> mitSchwertKaempfenLernen()
            "2" -> zaubernLernen()
            "3" -> verteidigenLernen()
            else -> println("Ungültige Auswahl. Ehrenwerter Held, bitte wähle zwischen 1, 2 oder 3.")
        }
    }

    fun heileMitHeiltrank() {
        val heilung = maxLebenspunkte / 2
        lebenspunkte += heilung
        if (lebenspunkte > maxLebenspunkte) {
            lebenspunkte = maxLebenspunkte
        }
        println("$name verwendet einen seltenen Heiltrank aus den Tiefen des alten Waldes und regeneriert $heilung Lebenspunkte.")
    }

    fun nutzeVitamine() {
        val chance = Random.nextDouble()
        if (chance < 0.5) {
            angriff = (angriff * 1.10).toInt()
            println("$name verzehrt seltene Früchte aus fernen Ländern, welche seine Kampfkraft um 10% steigern.")
        } else {
            magie = (magie * 1.10).toInt()
            println("$name meditiert mit geheimnisvollen Kräutern, die seine magischen Fähigkeiten um 10% erhöhen.")
        }
    }

}
