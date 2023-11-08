class Krieger(
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
        this.angriff = 75
        this.magie = 60
        this.verteidigung = 60

        println(
            "Siehe, ein neuer Adept betritt die Hallen von Zamnesia:\n" +
                    "Edler $nameColor$name$resetColor, bereit deine Weisheit und Macht zum Wohle der Lande einzusetzen.\n" +
                    "Deine Lebensessenz beläuft sich auf $valueColor$lebenspunkte$resetColor von maximalen $valueColor$maxLebenspunkte$resetColor Punkten.\n" +
                    "Deine Angriffskraft ist ehrenwert, sie beträgt $valueColor$angriff$resetColor.\n" +
                    "Dein magisches Geschick, oh weiser $nameColor$name$resetColor, ist unübertroffen mit einem Werte von $valueColor$magie$resetColor.\n" +
                    "Die Stärke deiner Verteidigung wird in den Annalen verzeichnet als $valueColor$verteidigung$resetColor.\n"
        )

        println(
            "Du$nameColor$name$resetColor trettest dem Team bei:\n" +
                    "$labelColor${"Lebenspunkte:"}$resetColor $valueColor$lebenspunkte/$maxLebenspunkte$resetColor\n" +
                    "$labelColor${"Angriff:"}$resetColor $valueColor$angriff$resetColor\n" +
                    "$labelColor${"Magie:"}$resetColor $valueColor$magie$resetColor\n" +
                    "$labelColor${"Verteidigung:"}$resetColor $valueColor$verteidigung$resetColor\n"
        )
    }

    override fun angreifen(gegner: Boesewicht) {
        println("Wähle deine Kampfhandlung:\n")
        println("1. Schwertwirbel (Angriffsbasiert)")
        println("2. Berserkerschlag (Erhöhter Angriff, geringere Genauigkeit)")
        println("3. Schildhieb (Nutzt den Verteidigungswert)\n")
        print("Deine Entscheidung: ")

        when (readln()) {
            "1" -> {
                val schaden = berechneSchaden(30, angriff)
                gegner.lebenspunkte -= schaden
                println("$name hat $schaden Schaden mit Klingenschwung verursacht.\n")
            }

            "2" -> {
                val schaden = berechneSchaden(20, angriff * 2)
                gegner.lebenspunkte -= schaden
                println("$name hat $schaden Schaden mit Berserkerstoß verursacht.\n")
            }

            "3" -> {
                val schaden = berechneSchaden(verteidigung, angriff / 2)
                gegner.lebenspunkte -= schaden
                println("$name hat $schaden Schaden mit Schildschlag verursacht.\n")
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
            println("Wie durch einen geheimnisvollen Zaubertrank, fühlt sich $name plötzlich widerstandsfähiger. Die Verteidigung steigt um 20%!")
        }
        bonusRundenVerteidigung = runden
    }

    override fun aktualisiereVerteidigung() {
        if (bonusRundenVerteidigung > 0) {
            bonusRundenVerteidigung--
            if (bonusRundenVerteidigung == 0) {
                verteidigung = urspruenglicheVerteidigung
                println("Der Zauber der Verteidigung schwindet, und $name fühlt, wie die alte Stärke zurückkehrt.")
            }
        }
    }
}