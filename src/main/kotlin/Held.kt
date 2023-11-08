import java.io.IOException
import java.io.File


open class Held(
    var name: String,
    var lebenspunkte: Int,
    var maxLebenspunkte: Int,
    var angriff: Int,
    var magie: Int,
    var verteidigung: Int
) {

    open var urspruenglicheVerteidigung = verteidigung
    open var bonusRundenVerteidigung = 0


    open fun temporaereVerteidigungErhoehen(runden: Int) {
        if (bonusRundenVerteidigung == 0) {
            urspruenglicheVerteidigung = verteidigung
            verteidigung = (verteidigung * 1.2).toInt()
            println("Der Effekt der Vitamine beginnt! Verteidigung um 20% erhöht.")
        }
        bonusRundenVerteidigung = runden
    }

    open fun aktualisiereVerteidigung() {
        if (bonusRundenVerteidigung > 0) {
            bonusRundenVerteidigung--
            if (bonusRundenVerteidigung == 0) {
                verteidigung = urspruenglicheVerteidigung
                println("Der Effekt der Vitamine ist vorbei. Verteidigung wird zurückgesetzt.")
            }
        }
    }

    fun speichern() {
        println("Speichern des Spielstands. Drücken Sie Enter, um als '$name.txt' zu speichern oder geben Sie einen neuen Namen ein:")
        val eingabe = readln().trim()
        val dateiName = if (eingabe.isBlank()) "$name.txt" else "$eingabe.txt"

        try {
            val daten = "$name,$lebenspunkte,$maxLebenspunkte,$angriff,$magie,$verteidigung"
            File(dateiName).writeText(daten)
            println("Speichern erfolgreich: Daten wurden in '$dateiName' gespeichert.")
        } catch (e: IOException) {
            println("Ein Fehler ist aufgetreten beim Speichern der Datei '$dateiName': ${e.message}")
        }
    }

    companion object {
        val nameColor = "\u001B[34m"
        val valueColor = "\u001B[32m"
        val labelColor = "\u001B[35m"
        val resetColor = "\u001B[0m"
        const val greenColor = "\u001B[32m"
        const val yellowColor = "\u001B[33m"
        const val redColor = "\u001B[31m"
        var siege = 0
        var niederlagen = 0

        fun laden(): Held? {
            val spielstandOrdner = File(".")
            val spielstaende = spielstandOrdner.listFiles { file -> file.isFile && file.name.endsWith(".txt") }
            if (spielstaende == null || spielstaende.isEmpty()) {
                println("Keine Spielstände gefunden.")
                return null
            }

            println("Verfügbare Spielstände:")
            spielstaende.forEachIndexed { index, file ->
                println("${index + 1}. ${file.name}")
            }

            println("Bitte wählen Sie die Nummer des zu ladenden Spielstands:")
            val eingabe = readln().toIntOrNull() ?: return null
            if (eingabe in 1..spielstaende.size) {
                val daten = File(spielstaende[eingabe - 1].name).readText().split(",")
                if (daten.size < 6) return null
                return Held(
                    daten[0],
                    daten[1].toInt(),
                    daten[2].toInt(),
                    daten[3].toInt(),
                    daten[4].toInt(),
                    daten[5].toInt()
                )
            } else {
                println("Ungültige Auswahl.")
                return null
            }
        }

        fun spielstaendeLoeschen() {
            val spielstandOrdner = File(".")
            val spielstaende = spielstandOrdner.listFiles { file -> file.isFile && file.name.endsWith(".txt") }
            if (spielstaende.isNullOrEmpty()) {
                println("Keine Spielstände zum Löschen gefunden.")
                return
            }

            println("Verfügbare Spielstände zum Löschen:")
            spielstaende.forEachIndexed { index, file ->
                println("${index + 1}. ${file.name}")
            }

            println("Bitte geben Sie die Nummer des zu löschenden Spielstands ein oder '0', um abzubrechen:")
            val eingabe = readln().toIntOrNull() ?: return
            if (eingabe == 0) {
                println("Löschvorgang abgebrochen.")
                return
            }
            if (eingabe in 1..spielstaende.size) {
                val zuLoeschendeDatei = spielstaende[eingabe - 1]
                if (zuLoeschendeDatei.delete()) {
                    println("Spielstand '${zuLoeschendeDatei.name}' wurde gelöscht.")
                } else {
                    println("Spielstand '${zuLoeschendeDatei.name}' konnte nicht gelöscht werden.")
                }
            } else {
                println("Ungültige Auswahl.")
            }

        }

        fun erzeugeUndInitialisiereHelden(): Held {
            playSound("sunrise.wav")
            val held = Held("Unbekannt", 0, 1500, 0, 0, 0)
            held.heldenErstellen()
            return held
        }

        fun lebenspunkteFarbe(lebenspunkte: Int, maxLebenspunkte: Int): String {
            val prozent = lebenspunkte.toDouble() / maxLebenspunkte
            return when {
                prozent > 0.5 -> greenColor
                prozent > 0.3 -> yellowColor
                else -> redColor
            }
        }
    }

    open fun heldenErstellen() {
        val namenMap = mapOf(
            "Myrion" to listOf("der Weise", "Hüter von Verlorener Hafen", "Magier von Mythria"),
            "Lyrana" to listOf("Sternentänzerin", "Priesterin von Silberwald", "Botin der Sterne"),
            "Tharion" to listOf("Klingenmeister", "Wächter der Dunkelheit", "Krieger der Tiefe"),
            "Elara" to listOf("Mondjägerin", "Waldgeister-Hüterin", "Bogenschützin von Elmswood"),
            "Draken" to listOf("Feuerseele", "Drachentöter", "Beschützer der Berge"),
            "Seraphel" to listOf("Windflüsterin", "Hohepriesterin der Wolken", "Göttin der Lüfte"),
            "Varok" to listOf("Eisenfaust", "König der Unterwelt", "Krieger des Abgrunds"),
            "Illyria" to listOf("Wasserwächterin", "Meeresprinzessin", "Herrin der Wellen"),
            "Orynn" to listOf("Steinhaut", "Bergbewahrer", "Zerstörer von Fels"),
            "Azura" to listOf("Himmelsbotin", "Göttin des Zwielichts", "Wächterin des Morgenrots"),
            "Keldorn" to listOf("Sturmbringer", "Held von Mythria's Grenzen", "Vagabund des Westens"),
            "Nylara" to listOf("Schattenweberin", "Herrin der Nacht", "Mondpriesterin")
        )

        val (vorname, nachnamen) = namenMap.entries.shuffled().first()
        val nachname = nachnamen.shuffled().first()
        this.name = "$vorname $nachname"
        val geschichte = """
In den alten Zeiten von Zamnesia, einer Welt voller Magie und uralter Mysterien,
erhob sich ein Held aus dem Schatten der Legenden, um das Schicksal der Reiche zu formen.
Dieser Held, bekannt unter vielen Namen und Titeln durch die Ären, sollte bald sein eigenes Vermächtnis erschaffen.

$nameColor${name.split(" ").first()}$resetColor, dessen wahre Herkunft in den Sternen geschrieben steht,
ist bestimmt, durch große Taten in die Annalen von Zamnesia einzugehen. Vor ihm liegt ein Weg
voller Prüfungen und Triumphe, von dunklen Höhlen bis zu den Gipfeln der unberührten Berge.

Das Schicksal hat ihn zu diesem Punkt geführt, und nun ist es an der Zeit, dass sein Name
mit Taten gefüllt wird, die so lebendig und unvergänglich sind wie das Land selbst.

Seine Reise beginnt hier, in diesem Moment, während er seine Kräfte sammelt und sich auf die
bevorstehenden Abenteuer vorbereitet.
""".trimIndent()

        for (char in geschichte) {
            print(char)
            Thread.sleep(11)
            if (char == '\n') {
                Thread.sleep(55)
            }
        }

        println("\n")

        this.lebenspunkte = 1500
        this.angriff = 50
        this.magie = 50
        this.verteidigung = 50

        println(
            "$nameColor$name$resetColor\n" +
                    "$labelColor${"Lebenspunkte:"}$resetColor $valueColor$lebenspunkte$resetColor/$valueColor$maxLebenspunkte$resetColor\n" +
                    "$labelColor${"Angriff:"}$resetColor $valueColor$angriff$resetColor\n" +
                    "$labelColor${"Magie:"}$resetColor $valueColor$magie$resetColor\n" +
                    "$labelColor${"Verteidigung:"}$resetColor $valueColor$verteidigung$resetColor\n"
        )
    }

    open fun training() {
        var weiterTraining = true

        while (weiterTraining) {
            println("Wähle eine Fähigkeit zum Trainieren:\n")
            println("1. Angriff")
            println("2. Magie")
            println("3. Verteidigung\n")
            print("Deine Wahl: \n")

            when (readln()) {
                "1" -> {
                    angriff = erhoeheWert(angriff)
                    println("$nameColor$name$resetColor - Dein Angriff ist jetzt $valueColor$angriff$resetColor\n")
                }

                "2" -> {
                    magie = erhoeheWert(magie)
                    println("$nameColor$name$resetColor - Deine Magie ist jetzt $valueColor$magie$resetColor\n")
                }

                "3" -> {
                    verteidigung = erhoeheWert(verteidigung)
                    println("$nameColor$name$resetColor - Deine Verteidigung ist jetzt $valueColor$verteidigung$resetColor\n")
                }

                else -> println("Das ist keine gültige Auswahl.")
            }

            println("Möchtest du weiter trainieren? (ja/nein)\n")
            weiterTraining = readln() == "ja"
        }

        zeigeStatus()
    }

    open fun zeigeStatus() {
        println("Training abgeschlossen für $nameColor$name$resetColor.")
        println(
            "Hier sind die aktuellen Werte:\n" +
                    "$labelColor${"Lebenspunkte:"}$resetColor $valueColor$lebenspunkte/$maxLebenspunkte$resetColor\n" +
                    "$labelColor${"Angriff:"}$resetColor $valueColor$angriff$resetColor\n" +
                    "$labelColor${"Magie:"}$resetColor $valueColor$magie$resetColor\n" +
                    "$labelColor${"Verteidigung:"}$resetColor $valueColor$verteidigung$resetColor\n"
        )
    }

    fun erhoeheWert(wert: Int): Int {
        return (wert * 1.1).toInt()
    }

    open fun angreifen(gegner: Boesewicht) {
        println("Wähle eine Attacke:\n")
        println("1. Schwertstreich (Angriffs basierend)")
        println("2. Feuerball (Magie basierend)")
        println("3. Donnerschlag (Angriffs basierend)\n")
        print("Deine Wahl: ")

        when (readln()) {
            "1" -> {
                val schaden = berechneSchaden(50, angriff)
                gegner.lebenspunkte -= schaden
                println("$name hat $schaden Schaden mit Schwertstreich verursacht.\n")
            }

            "2" -> {
                val schaden = berechneSchaden(40, magie)
                gegner.lebenspunkte -= schaden
                println("$name hat $schaden Schaden mit Feuerball verursacht.\n")
            }

            "3" -> {
                val schaden = berechneSchaden(60, angriff)
                gegner.lebenspunkte -= schaden
                println("$name hat $schaden Schaden mit Donnerschlag verursacht.\n")
            }

            else -> println("Das ist keine gültige Auswahl.")
        }
    }

    open fun berechneSchaden(basisSchaden: Int, wert: Int): Int {
        return basisSchaden + wert
    }

    open fun verteidigen() {
        if (bonusRundenVerteidigung == 0) {
            val verteidigungsBonus = 20
            urspruenglicheVerteidigung = verteidigung
            verteidigung += verteidigungsBonus
            println("$nameColor$name$resetColor erhöht die Verteidigung um $verteidigungsBonus.")
        }
        bonusRundenVerteidigung = 2
    }

    open fun rundenUpdate() {
        if (bonusRundenVerteidigung > 0) {
            bonusRundenVerteidigung--
            if (bonusRundenVerteidigung == 0) {
                verteidigung = urspruenglicheVerteidigung
                println("$nameColor$name$resetColor Verteidigungsbonus ist ausgelaufen.")
            }
        }
    }

}
