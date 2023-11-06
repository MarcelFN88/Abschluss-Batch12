import kotlin.random.Random

class Manipulator(
    name: String,
    lebenspunkte: Int,
    maxLebenspunkte: Int,
    angriff: Int,
    magie: Int,
    verteidigung: Int
) : Held(
    name,
    lebenspunkte,
    maxLebenspunkte,
    angriff, magie,
    verteidigung
) {
    init {
        val cyan = "\u001B[33m"
        val reset = "\u001B[0m"
        println(
            """
        |${cyan}$name, geheimnisvoller Manipulator aus den dunklen Ecken Mythrias.
        |Dein Ruf geht voraus, als Meister der verbotenen Künste, jemand, der die Grenzen des Möglichen ständig neu definiert.
        |Deine Macht zieht Neider und Bewunderer gleichermaßen an, da du Dinge tust, die andere nur in ihren schlimmsten Alpträumen sehen.${reset}
        """.trimMargin()
        )
        println()
        Thread.sleep(3000)
    }


    override fun angreifenBoesewicht(): Int {
        println(
            """
            |Manipulator $name, Bewahrer der dunklen Geheimnisse, mit welcher Kraft wirst du die Realität heute verbiegen?
            | 1. Gedankenkontrolle - Die Fähigkeit, das Bewusstsein deines Gegners zu infiltrieren und seine Handlungen zu deinem Vorteil zu lenken.
            | 2. Schattenmanipulation - Ruf die Dunkelheit herbei, um deinen Feind in einem Netz aus Angst und Unsicherheit zu verstricken.
            | 3. Zeitverzerrung - Spiele mit dem Stoff der Zeit selbst, um deinem Gegner immer einen Schritt voraus zu sein.
            |
            | Wähle deinen Angriff (1/2/3):
        """.trimMargin()
        )

        val auswahl = readln()
        return when (auswahl) {
            "1" -> {
                println("Die Augen des Gegners werden trüb, als du seinen Geist erfasst und seinen Willen brichst.")
                magie + Random.nextInt(0, 10)  // Der Schaden sollte sich hier eher auf Magie als auf Angriff beziehen, da es eine Form der geistigen Kontrolle ist.
            }
            "2" -> {
                println("Die Schatten verdichten sich um deinen Gegner, binden ihn und säen Zweifel in seinem Herzen.")
                magie + Random.nextInt(0, 5)  // Hier auch Magieschaden.
            }
            "3" -> {
                println("Mit einem flüchtigen Gestus verzerrst du die Zeit, und der Raum um dich herum scheint sich zu verbiegen.")
                magie  // Hier könnte man auch einen zusätzlichen Effekt hinzufügen, z.B. eine Chance, den Gegner für einen Zug zu immobilisieren.
            }
            else -> {
                println("$name, als Manipulator weißt du, dass Zurückhaltung manchmal der mächtigste Angriff ist.")
                0
            }
        }
    }
}