package GuteSeite

import BoeseSeite.Boesewicht
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
            "Myrion" to listOf("der Weise", "Hüter von Verlorener Hafen", "GuteSeite.Magier von Mythria"),
            "Lyrana" to listOf("Sternentänzerin", "Priesterin von Silberwald", "Botin der Sterne"),
            "Tharion" to listOf("Klingenmeister", "Wächter der Dunkelheit", "GuteSeite.Krieger der Tiefe"),
            "Elara" to listOf("Mondjägerin", "Waldgeister-Hüterin", "Bogenschützin von Elmswood"),
            "Draken" to listOf("Feuerseele", "Drachentöter", "Beschützer der Berge"),
            "Seraphel" to listOf("Windflüsterin", "Hohepriesterin der Wolken", "Göttin der Lüfte"),
            "Varok" to listOf("Eisenfaust", "König der Unterwelt", "GuteSeite.Krieger des Abgrunds"),
            "Illyria" to listOf("Wasserwächterin", "Meeresprinzessin", "Herrin der Wellen"),
            "Orynn" to listOf("Steinhaut", "Bergbewahrer", "Zerstörer von Fels"),
            "Azura" to listOf("Himmelsbotin", "Göttin des Zwielichts", "Wächterin des Morgenrots"),
            "Keldorn" to listOf("Sturmbringer", "GuteSeite.Held von Mythria's Grenzen", "Vagabund des Westens"),
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

        println(
            "Siehe, ein neuer Adept betritt die Hallen von Zamnesia:\n" +
                    "Edler ${Held.nameColor}$name${Held.resetColor}, bereit deine Weisheit und Macht zum Wohle der Lande einzusetzen.\n" +
                    "Deine Lebensessenz beläuft sich auf ${Held.valueColor}$lebenspunkte${Held.resetColor} von maximalen ${Held.valueColor}$maxLebenspunkte${Held.resetColor} Punkten.\n" +
                    "Deine Angriffskraft ist ehrenwert, sie beträgt ${Held.valueColor}$angriff${Held.resetColor}.\n" +
                    "Dein magisches Geschick, oh weiser ${Held.nameColor}$name${Held.resetColor}, ist unübertroffen mit einem Werte von ${Held.valueColor}$magie${Held.resetColor}.\n" +
                    "Die Stärke deiner Verteidigung wird in den Annalen verzeichnet als ${Held.valueColor}$verteidigung${Held.resetColor}.\n"
        )

        println(
                    "Du ${Held.nameColor}$name${Held.resetColor} trettest dem Team bei:\n" +
                    "${Held.labelColor}${"Lebenspunkte:"}${Held.resetColor} ${Held.valueColor}$lebenspunkte/$maxLebenspunkte${Held.resetColor}\n" +
                    "${Held.labelColor}${"Angriff:"}${Held.resetColor} ${Held.valueColor}$angriff${Held.resetColor}\n" +
                    "${Held.labelColor}${"Magie:"}${Held.resetColor} ${Held.valueColor}$magie${Held.resetColor}\n" +
                    "${Held.labelColor}${"Verteidigung:"}${Held.resetColor} ${Held.valueColor}$verteidigung${Held.resetColor}\n"
        )
    }
    override fun angreifen(gegner: Boesewicht) {
        println("Erhebt euch, ihr mystischen Kräfte, und wählet einen Zauber:\n")
        println("1. Feuerball – Ein Geschoss geformt aus den Flammen der alten Welt.")
        println("2. Eissturm – Ein tobender Sturm, geboren aus dem Atem des Frostes.")
        println("3. Blitzschlag – Ein zorniger Fingerzeig der Himmelsgötter.\n")
        print("Welcher Pfad soll beschritten werden? Eure Entscheidung, GuteSeite.Magier: ")

        when (readln()) {
            "1" -> {
                val schaden = berechneSchaden(magie, 30)
                gegner.lebenspunkte -= schaden
                println("$name, du hast einen Feuerball beschworen, der $schaden Schaden verursacht hat. Die Feinde zittern vor Furcht.\n")
            }

            "2" -> {
                val schaden = berechneSchaden(magie, 50)
                gegner.lebenspunkte -= schaden
                println("$name hat mit einem mächtigen Eissturm $schaden Schaden angerichtet. Doch ach, die Kräfte des Frostes sind tückisch!\n")
                if (Random.nextInt(100) < 10) {
                    val selbstschaden = schaden * 10 / 100
                    this.lebenspunkte -= selbstschaden
                    println("Durch die Unberechenbarkeit des Eises hast du $selbstschaden Schaden an dir selbst verursacht. Vorsicht ist geboten, auch im Siegesrausch.\n")
                }
            }

            "3" -> {
                val schaden = berechneSchaden(magie, 40)
                gegner.lebenspunkte -= schaden
                println("$name, durch deine Hand wurde ein Blitzschlag herabgerufen, der $schaden Schaden verursachte. Deine Feinde weichen zurück vor dem donnernden Zorn.\n")

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
            println("$name hat die Verteidigung um $verteidigungsBonus erhöht. Die Schutzzauber weben sich fester um deine Gestalt.\n")
        }
        bonusRundenVerteidigung = 2
    }

    override fun rundenUpdate() {
        if (bonusRundenVerteidigung > 0) {
            bonusRundenVerteidigung--
            if (bonusRundenVerteidigung == 0) {
                verteidigung = urspruenglicheVerteidigung
                println("Die verstärkten Schutzzauber, die $name umhüllten, beginnen zu schwinden. Bereite dich vor auf kommende Prüfungen.\n")
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
