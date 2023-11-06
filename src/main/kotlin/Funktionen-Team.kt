import java.io.IOException
import java.nio.file.Paths
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.LineUnavailableException

fun playMusic(path: String) {
    try {
        val audioIn = AudioSystem.getAudioInputStream(Paths.get(path).toFile())
        val clip = AudioSystem.getClip()
        clip.open(audioIn)
        clip.start()
    } catch (ex: LineUnavailableException) {
        ex.printStackTrace()
    } catch (ex: IOException) {
        ex.printStackTrace()
    } catch (ex: javax.sound.sampled.UnsupportedAudioFileException) {
        ex.printStackTrace()
    }
}

fun erstelleTeam(): List<Held> {
    val namenMap = mapOf(
        "Thorin" to listOf("Oakenshield", "Mountain's Son", "Axemaster"),
        "Aragorn" to listOf("Strider", "King of Gondor", "Elessar"),
        "Frodo" to listOf("Baggins", "Ringbearer", "Master of the Shire"),
        "Gandalf" to listOf("the Grey", "White Wizard", "Firebearer"),
        "Legolas" to listOf("Greenleaf", "Prince of the Wood Elves", "Archer"),
        "Galadriel" to listOf("Light Queen", "Lady of the Wood", "Star Maiden"),
        "Boromir" to listOf("Son of Denethor", "Hornblower", "Defender of Gondor"),
        "Gimli" to listOf("Axe-Wielder", "Dwarf Warrior", "Son of Glóin"),
        "Eowyn" to listOf("Shieldmaiden", "Lady of Rohan", "White Lady"),
        "Merlin" to listOf("the Magician", "Enchanter", "Druid Sage"),
        "Lancelot" to listOf("Knight of the Lake", "Bravest of Knights", "Court Champion"),
        "Morgana" to listOf("the Enchantress", "Mistress of Magic", "Sorceress")
    )

    val team = mutableListOf<Held>()

    val kriegerName = namenMap.keys.random()
    val kriegerNachname = namenMap[kriegerName]?.random() ?: "Unknown"
    val krieger = Krieger("$kriegerName $kriegerNachname", 1100, 1100, 30, 25, 30)
    team.add(krieger)

    val magierName = namenMap.keys.minus(kriegerName).random()
    val magierNachname = namenMap[magierName]?.random() ?: "Unknown"
    val magier = Magier("$magierName $magierNachname", 1000, 1000, 25, 40, 25)
    team.add(magier)

    val manipulatorName = namenMap.keys.minus(listOf(kriegerName, magierName)).random()
    val manipulatorNachname = namenMap[manipulatorName]?.random() ?: "Unknown"
    val manipulator = Manipulator("$manipulatorName $manipulatorNachname", 1050, 1050, 28, 35, 28)
    team.add(manipulator)

    println(
        """
        |In der alten Taverne von Mythria, einst das Zentrum der magischen Welt, wo Helden aus allen Ländern kamen,
        |um Ruhm und Reichtum zu suchen, formt sich ein besonderes Team.
        |
        |Zwischen dem Klang von Bechern und dem Flüstern alter Geschichten, die von Thorin, dem letzten Überlebenden von 
        |Mythria's Bergvolk, und Gandalf, einem der alten Wächter von Mythria's heiligen Tempeln, erzählt werden, 
        |erwacht ein Team von Helden, von dem Legenden bereits zu flüstern wagen.
        |
        |Erhebt das Haupt und begrüßt:
        |  - Krieger: $kriegerName $kriegerNachname
        |  - Magier: $magierName $magierNachname
        |  - Manipulator: $manipulatorName $manipulatorNachname
        |bestimmt, einen unauslöschlichen Abdruck in den Chroniken von Mythria zu hinterlassen!
    """.trimMargin()
    )

    return team
}

fun lebensbalkenAnzeigen(lebenspunkte: Int, maxLebenspunkte: Int): String {
    val balkenLaenge = 20
    val lebenspunkteProzent = lebenspunkte.toDouble() / maxLebenspunkte.toDouble()
    val gefuellt = (balkenLaenge * lebenspunkteProzent).toInt()
    val ungefuellt = balkenLaenge - gefuellt

    return "█".repeat(gefuellt) + "░".repeat(ungefuellt)
}

fun gemeinsameHeldenFarbe(name: String): String {
    return when (name.split(" ")[0]) {
        "Myrion", "Thorin" -> "\u001B[31m"
        "Lyrana", "Aragorn" -> "\u001B[32m"
        "Tharion", "Frodo" -> "\u001B[33m"
        "Elara", "Gandalf" -> "\u001B[34m"
        "Draken", "Legolas" -> "\u001B[35m"
        "Seraphel", "Galadriel" -> "\u001B[36m"
        "Varok", "Boromir" -> "\u001B[37m"
        "Illyria", "Gimli" -> "\u001B[91m"
        "Orynn", "Eowyn" -> "\u001B[92m"
        "Azura", "Merlin" -> "\u001B[93m"
        "Keldorn", "Lancelot" -> "\u001B[94m"
        "Nylara", "Morgana" -> "\u001B[95m"
        else -> "\u001B[0m"
    }
}

fun Held.statusTeamFarbig() {
    fun farbig(value: Int, max: Int): String {
        val percentage = value.toDouble() / max.toDouble()
        return when {
            percentage > 0.6 -> "\u001B[32m$value\u001B[0m"
            percentage > 0.3 -> "\u001B[33m$value\u001B[0m"
            else -> "\u001B[31m$value\u001B[0m"
        }
    }

    val farbigerName = "${gemeinsameHeldenFarbe(name)}$name\u001B[0m"

    println(
        """
    |${farbigerName}'s Status:
    | Lebenspunkte: ${farbig(lebenspunkte, maxLebenspunkte)}/$maxLebenspunkte
    | Angriff: $angriff
    | Magie: $magie
    | Verteidigung: $verteidigung
    """.trimMargin()
    )
}


fun rollenspielSimulation(team: List<Held>, gegnerName: String) {
    val beutel = Beutel()
    val boesewicht = when (gegnerName) {
        "Dunkler Magier" -> DunklerMagier("Dunkler Magier von Mythria, einst ein Schüler der größten Magierschule, der vom Pfad des Lichts abkam")
        "Drache" -> Drache("Feuerspeiender Drache aus den Tiefen von Mythria's Bergen")
        else -> Boesewicht("Unbekannter Feind")
    }

    println(
        """
        |Auf einem vergessenen Schlachtfeld von Mythria, wo einst der endgültige Krieg zwischen Gut und Böse tobte, 
        |trifft unser Team von Helden auf einen mächtigen Gegner.
        |
        |Das Team wurde in dieses alte Reich gezogen und steht nun dem ${boesewicht.name} gegenüber!
        |Der Wind weht kalt über die Ruinen, und die Luft ist mit der Magie und Spannung von Mythria geladen.
        |Es ist Zeit zu kämpfen!
    """.trimMargin()
    )

    var runde = 1
    var heldenLebendig = true
    while (team.any { it.lebenspunkte > 0 } && boesewicht.lebenspunkte > 0) {
        Thread.sleep(1000)
        println("\nRunde $runde")

        for (held in team) {
            held.statusTeamFarbig()
        }

        boesewicht.statusAnzeigenFarbig()

        for (held in team.filter { it.lebenspunkte > 0 }) {
            println("\nDein Zug, ${held.name}. Wähle deine Aktion: (angreifen/blocken/beutel)")
            val aktion = readln()

            when (aktion) {
                "angreifen" -> {
                    val schaden = held.angreifenBoesewicht()
                    if (!boesewicht.blocken()) {
                        boesewicht.erhalteSchaden(schaden)
                    }
                }

                "blocken" -> {
                    println("${held.name} bereitet sich darauf vor, den nächsten Angriff zu blocken!")
                }

                "beutel" -> {
                    beutel.zeigeInhalt()
                    held.benutzeItem(beutel)
                }

                else -> {
                    println("Ungültige Wahl!")
                }
            }

            if (boesewicht.lebenspunkte <= 0) break
        }

        if (boesewicht.lebenspunkte <= 0) {
            println("\nDie Legenden von Mythria werden von eurem Mut sprechen, Helden von Mythria!")
            println("\nJede Erzählung in der Taverne wird eure Geschichte feiern!")

            for (held in team) {
                val itemHinzugefuegt = beutel.fuegeItemHinzu("Heiltrank", 1)
                if (itemHinzugefuegt) {
                    println("${held.name} hat einen Heiltrank zum Beutel hinzugefügt!")
                } else {
                    println("${held.name} konnte keinen Heiltrank hinzufügen!")
                }
            }

            for (held in team.filter { it.lebenspunkte > 0 }) {
                when ((1..3).random()) {
                    1 -> {
                        held.angriff += 5
                        println("${held.name}s Angriff wurde um 5 Punkte erhöht!")
                    }

                    2 -> {
                        held.magie += 5
                        println("${held.name}s Magie wurde um 5 Punkte erhöht!")
                    }

                    3 -> {
                        held.verteidigung += 5
                        println("${held.name}s Verteidigung wurde um 5 Punkte erhöht!")
                    }
                }
            }
        } else {
            println("\nDas Schicksal von Mythria bleibt ungewiss, aber euer Mut und Entschlossenheit wird nicht vergessen werden. Ihr habt den Grundstein für zukünftige Helden gelegt.")
        }


        println("\n${boesewicht.name}s Zug!")
        val schaden = boesewicht.angreifen().second

        if (boesewicht is DunklerMagier || boesewicht is Drache) {
            boesewicht.rufeSchatten()
            if (boesewicht.schatten.aktiv) {
                boesewicht.schatten.schattenAngriff(team)
            }
        }

        for (held in team) {
            if (!held.blocken()) {
                held.lebenspunkte -= schaden
                if (held.lebenspunkte <= 0) {
                    println("\n${held.name} ist gefallen!")
                }
            }
        }

        heldenLebendig = team.any { it.lebenspunkte > 0 }
        if (!heldenLebendig) {
            println("\nLeider hat der ${boesewicht.name} gewonnen. Versucht es erneut, Team!")
            break
        }

        runde++

        while (team.any { it.lebenspunkte > 0 } && boesewicht.lebenspunkte > 0) {
            Thread.sleep(1000)
            println("\nRunde $runde")

            for (held in team) {
                println(
                    "${held.name}: ${
                        lebensbalkenAnzeigen(
                            held.lebenspunkte,
                            held.maxLebenspunkte
                        )
                    } ${held.lebenspunkte}/${held.maxLebenspunkte}"
                )
            }

            println(
                "${boesewicht.name}: ${
                    lebensbalkenAnzeigen(
                        boesewicht.lebenspunkte,
                        boesewicht.maxLebenspunkte
                    )
                } ${boesewicht.lebenspunkte}/${boesewicht.maxLebenspunkte}"
            )

        }

    }
}

    fun teamKampf() {
        println("\u001B[95m\nWillkommen Helden von Mythria!\u001B[0m")
        println("\u001B[96m\nSeid ihr bereit, euer Schicksal zu erfüllen?\u001B[0m\n")
        var option: String
        val team = erstelleTeam()
        do {
            println("\nHauptmenü:")
            println("1. Trainiere dein Team")
            println("2. Tritt in den Kampf")
            println("3. Beenden")
            print("Wähle eine Option: ")
            option = readln()

            when (option) {
                "1" -> {
                    do {
                        for (held in team) {
                            println("\n${held.name} trainiert jetzt.")
                            held.trainieren()
                        }
                        println("Möchtest du weiter trainieren? (ja/nein)")
                    } while (readln() == "ja")
                }

                "2" -> {
                    println("\nGegen welchen Gegner möchtest du kämpfen? (Dunkler Magier/Drache)")
                    val gegnerName = readln() ?: ""
                    rollenspielSimulation(team, gegnerName)
                    for (held in team) {
                        held.lebenspunkte = held.maxLebenspunkte
                    }
                    println("Möchtest du zum Hauptmenü zurückkehren? (ja/nein)")
                    if (readln() != "ja") {
                        option = "3"
                    }
                }

                "3" -> {
                    println("Danke für eure Tapferkeit, Helden von Mythria. Bis zum nächsten Abenteuer!")
                }

                else -> {
                    println("Ungültige Option!")
                }
            }
        } while (option != "3")
    }


    fun typePrint(message: String, delay: Long = 5) {
        for (char in message) {
            print(char)
            Thread.sleep(delay)
        }
    }

    fun auswahlMenu() {
        playMusic("resources/sunrise.wav")
        typePrint("\u001B[34m\n****************************************")
        typePrint("\nWillkommen in der Welt von Mythria!")
        typePrint("\n****************************************\u001B[0m")
        Thread.sleep(600)

        typePrint("\u001B[94m\nVor langer Zeit war Mythria ein blühendes und friedliches Königreich, behütet von den mächtigen Magiern des Ordens des Lichts.\u001B[0m")
        Thread.sleep(600)
        typePrint(
            "\u001B[95m\nDoch in den dunkelsten Ecken der Welt wurden Pläne geschmiedet.\n" +
                    "Dunkle Mächte, die einst im Schatten verborgen waren, haben ihre Kräfte gesammelt und sind nun bereit,\n" +
                    "ihre finstere Präsenz zu offenbaren.\u001B[0m"
        )
        Thread.sleep(700)

        typePrint(
            "\u001B[96m\nEin dunkler Schatten hat sich über das Land gelegt.\n" +
                    "Böse Kreaturen sind aus den Tiefen aufgestiegen und bedrohen die friedlichen Bewohner von Mythria.\n" +
                    "Dörfer brennen, und die Schreie der Verzweifelten hallen durch die Nacht.\u001B[0m"
        )
        Thread.sleep(700)

        typePrint(
            "\u001B[34m\nIn dieser Zeit der Not wurde eine Prophezeiung offenbart.\n" +
                    "Sie sprach von einem Helden, der aus der Dunkelheit auftauchen und das Licht zurück nach Mythria bringen würde.\u001B[0m"
        )
        Thread.sleep(800)

        typePrint(
            "\u001B[94m\nAls mutiger Held von Mythria steht es dir nun zur Wahl, alleine in das Abenteuer zu ziehen oder ein Team mutiger Krieger zusammenzustellen, um gegen das Böse zu kämpfen.\n" +
                    "Die Hoffnung vieler liegt in deinen Händen.\u001B[0m"
        )
        Thread.sleep(700)

        typePrint("\u001B[95m\nWas wird deine Entscheidung sein?\u001B[0m")
        Thread.sleep(800)
        typePrint("\u001B[33m\n1. Alleine in den Kampf ziehen und das Böse als einsamer Held bekämpfen.\u001B[0m")
        typePrint("\u001B[33m\n2. Ein Team von Helden zusammenstellen und gemeinsam gegen die Dunkelheit antreten.\u001B[0m")
        typePrint("\u001B[33m\n3. Die Welt von Mythria verlassen und ihr Schicksal den Schatten überlassen.\u001B[0m")
        print("\u001B[33m\nDeine Wahl:\u001B[0m")
        val auswahl = readln()

        when (auswahl) {
            "1", "alleine" -> {
                typePrint("\u001B[36m\nDu hast beschlossen, alleine in den Kampf zu ziehen. Möge das Licht von Mythria dich leiten!\u001B[0m")
                Thread.sleep(2000)
                soloKampf()
            }

            "2", "team" -> {
                typePrint("\u001B[34m\nGemeinsam seid ihr stark. Baue ein Team auf und stelle dich den dunklen Mächten!\u001B[0m")
                Thread.sleep(2000)
                teamKampf()
            }

            "3" -> {
                typePrint("\u001B[36m\nMöge dein Weg dich dorthin führen, wo das Licht von Mythria am hellsten scheint. Auf Wiedersehen!\u001B[0m")
                System.exit(0)
            }

            else -> {
                typePrint("\u001B[35m\nUngültige Option! Bitte triff eine gültige Entscheidung.\u001B[0m")
                Thread.sleep(1500)
                auswahlMenu()
            }
        }
    }

