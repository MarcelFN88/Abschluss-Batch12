import kotlin.random.Random

class Magier(
    name: String = "",
    lebenspunkte: Int = 0,
    maxLebenspunkte: Int = 0,
    angriff: Int = 0,
    magie: Int = 0,
    verteidigung: Int = 0
) : Held(
    name,
    lebenspunkte,
    maxLebenspunkte,
    angriff,
    magie,
    verteidigung
) {
    override var bonusRundenVerteidigung = 0
    override var urspruenglicheVerteidigung = verteidigung

    override fun heldenErstellen() {
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
            "Nylara" to listOf("Schattenweberin", "Herrin der Nacht", "Mondpriesterin"),
            "Aleris" to listOf("der Wächter", "Geist des Waldes", "Meister des Bogens"),
            "Brenna" to listOf("die Flammenweberin", "Beschwörerin des Feuers", "Hüterin der Asche"),
            "Caden" to listOf("der Furchtlose", "Streiter der Königin", "Schild der Schwachen"),
            "Darius" to listOf("der Unbezwingbare", "Zerstörer der Ketten", "Rebell des Nordens"),
            "Elowen" to listOf("die Grüne", "Sängerin der Zweige", "Freundin der Natur"),
            "Fenris" to listOf("der Einsame Wolf", "Streifer der Wildnis", "Bezwinger der Nacht"),
            "Galen" to listOf("der Heiler", "Weiser des Lichts", "Freund der Lebenden"),
            "Horus" to listOf("der Scharfsichtige", "Wächter des Himmels", "Sohn des Lichts"),
            "Irena" to listOf("die Sanfte", "Flüsterin der Hoffnung", "Malerin der Träume"),
            "Jorvik" to listOf("der Unnachgiebige", "Beschützer der Grenzen", "Wächter der Tore"),
            "Kyra" to listOf("die Schnelle", "Jägerin der Schatten", "Tochter des Windes"),
            "Lorcan" to listOf("der Stille", "Meister der Geheimnisse", "Herrscher des Verborgenen"),
            "Mirelle" to listOf("die Barmherzige", "Heilerin der Kranken", "Licht der Hoffnung"),
            "Niven" to listOf("der Geschickte", "Meister der Klingen", "Schatten der Wahrheit"),
            "Orion" to listOf("der Sternengänger", "Sucher der Weiten", "Wanderer des Firmaments"),
            "Perrin" to listOf("der Beständige", "Beherrscher des Sturms", "Freund der Meere"),
            "Quintus" to listOf("der Gelehrte", "Sucher des Wissens", "Wächter der Schrift"),
            "Riona" to listOf("die Strahlende", "Tänzerin des Lichts", "Hüterin des Morgens"),
            "Sorin" to listOf("der Erleuchtete", "Sucher der Sonne", "Wanderer der Tage"),
            "Tyra" to listOf("die Mutige", "Kämpferin der Freiheit", "Tochter der Berge")

        )

        val (vorname, nachnamen) = namenMap.entries.shuffled().first()
        val nachname = nachnamen.shuffled().first()
        this.name = "$vorname $nachname"

        this.lebenspunkte = 2000
        this.maxLebenspunkte = 2000
        this.angriff = 60
        this.magie = 75
        this.verteidigung = 60

        println(    "Du Magier, trettest dem Team bei:\n" +
                    "$nameColor$name$resetColor\n" +
                    "$labelColor${"Lebenspunkte:"}$resetColor $valueColor$lebenspunkte/$maxLebenspunkte$resetColor\n" +
                    "$labelColor${"Angriff:"}$resetColor $valueColor$angriff$resetColor\n" +
                    "$labelColor${"Magie:"}$resetColor $valueColor$magie$resetColor\n" +
                    "$labelColor${"Verteidigung:"}$resetColor $valueColor$verteidigung$resetColor\n"
        )
    }
    override fun angreifen(gegner: Boesewicht) {
        println("Wähle einen magischen Angriff:\n")
        println("1. Feuerball (Magie-basiert)")
        println("2. Eissturm (Höherer Schaden, kann sich selbst verletzen)")
        println("3. Blitzschlag (Magie-basiert)\n")
        print("Deine Wahl: ")

        when (readln()) {
            "1" -> {
                val schaden = berechneSchaden(magie, 30)
                gegner.lebenspunkte -= schaden
                println("$name verursacht $schaden Schaden mit einem Feuerball.\n")
            }

            "2" -> {
                val schaden = berechneSchaden(magie, 50)
                gegner.lebenspunkte -= schaden
                println("$name entfesselt einen Eissturm und verursacht $schaden Schaden.\n")
                if (Random.nextInt(100) < 10) {
                    val selbstschaden = schaden * 10 / 100
                    this.lebenspunkte -= selbstschaden
                    println("$name hat sich selbst mit $selbstschaden Schaden verletzt.\n")
                }
            }

            "3" -> {
                val schaden = berechneSchaden(magie, 40)
                gegner.lebenspunkte -= schaden
                println("$name trifft mit einem Blitzschlag und verursacht $schaden Schaden.\n")

            }

            else -> println("Das ist keine gültige Auswahl.")
        }
    }

    override fun berechneSchaden(basisSchaden: Int, wert: Int): Int {
        return basisSchaden + wert
    }

    override fun verteidigen() {
        if (bonusRundenVerteidigung == 0) {
            val verteidigungsBonus = 20
            urspruenglicheVerteidigung = verteidigung
            verteidigung += verteidigungsBonus
            println("$nameColor$name$resetColor erhöht die Verteidigung um $verteidigungsBonus.")
        }
        bonusRundenVerteidigung = 2
    }

    override fun rundenUpdate() {
        if (bonusRundenVerteidigung > 0) {
            bonusRundenVerteidigung--
            if (bonusRundenVerteidigung == 0) {
                verteidigung = urspruenglicheVerteidigung
                println("$nameColor$name$resetColor Verteidigungsbonus ist ausgelaufen.")
            }
        }
    }
    override fun temporaereVerteidigungErhoehen(runden: Int) {
        if (bonusRundenVerteidigung == 0) {
            urspruenglicheVerteidigung = verteidigung
            verteidigung = (verteidigung * 1.2).toInt()
            println("Der Effekt der Vitamine beginnt! Verteidigung um 20% erhöht.")
        }
        bonusRundenVerteidigung = runden
    }

    override fun aktualisiereVerteidigung() {
        if (bonusRundenVerteidigung > 0) {
            bonusRundenVerteidigung--
            if (bonusRundenVerteidigung == 0) {
                verteidigung = urspruenglicheVerteidigung
                println("Der Effekt der Vitamine ist vorbei. Verteidigung wird zurückgesetzt.")
            }
        }
    }
}