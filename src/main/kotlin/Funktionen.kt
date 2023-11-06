fun erstelleHeld(): Held {
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
    val vorname = namenMap.keys.random()
    val nachname = namenMap[vorname]?.random() ?: "Unknown"

    println(
        """
        |In Mythria, einem Land von mystischen Wäldern und kristallklaren Seen, 
        |steigt ein neuer Held auf, dessen Schicksal in den Sternen geschrieben steht.
        |Willkommen, $vorname $nachname!
        |Deine Reise beginnt jetzt, und die Einwohner von Mythria setzen ihre Hoffnungen in dich.
    """.trimMargin()
    )
    return Held("$vorname $nachname", 999, 999, 20, 20, 20)
}

fun heldenFarbe(name: String): String {
    return when (name.split(" ")[0]) {
        "Myrion" -> "\u001B[31m"
        "Lyrana" -> "\u001B[32m"
        "Tharion" -> "\u001B[33m"
        "Elara" -> "\u001B[34m"
        "Draken" -> "\u001B[35m"
        "Seraphel" -> "\u001B[36m"
        "Varok" -> "\u001B[37m"
        "Illyria" -> "\u001B[91m"
        "Orynn" -> "\u001B[92m"
        "Azura" -> "\u001B[93m"
        "Keldorn" -> "\u001B[94m"
        "Nylara" -> "\u001B[95m"
        else -> "\u001B[0m"
    }
}

fun rollenspielSimulation(held: Held) {
    val beutel = Beutel()
    val boesewicht = Boesewicht("Dunkler Fürst")

    println("\n${held.name}, du stehst vor einer uralten Ruine in Mythria und siehst den ${boesewicht.name} auf einem Thron sitzen!")
    println("Du spürst, dass das Schicksal dieses Landes in deinen Händen liegt. Es ist Zeit zu kämpfen!")

    var runde = 1
    while (held.lebenspunkte > 0 && boesewicht.lebenspunkte > 0) {
        Thread.sleep(1000)
        println("\nRunde $runde")
        held.statusAnzeigenFarbig()
        boesewicht.statusAnzeigenFarbig()

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

        println("\n${boesewicht.name}s Zug!")
        val schaden = boesewicht.angreifen().second
        if (aktion != "blocken" || !held.blocken()) {
            held.lebenspunkte -= schaden
        }


        if (held.lebenspunkte <= 0) {
            println("\nLeider hat ${boesewicht.name} gewonnen. Versuche es erneut, ${held.name}!")
            break
        }

        runde++
    }

    if (boesewicht.lebenspunkte <= 0) {
        println("\nMit dem Fall des Bösewichts erstrahlt Mythria wieder in seinem alten Glanz!")
        println("\nHerzlichen Glückwunsch, ${held.name}! Du hast das Land von der Dunkelheit befreit!")
        val itemHinzugefuegt = beutel.fuegeItemHinzu("Heiltrank", 1)
        if (itemHinzugefuegt) {
            println("Heiltrank wurde zum Beutel hinzugefügt!")
        } else {
            println("Heiltrank konnte nicht hinzugefügt werden!")
        }
        when ((1..3).random()) {
            1 -> {
                held.angriff += 5
                println("Dein Angriff wurde um 5 Punkte erhöht!")
            }

            2 -> {
                held.magie += 5
                println("Deine Magie wurde um 5 Punkte erhöht!")
            }

            3 -> {
                held.verteidigung += 5
                println("Deine Verteidigung wurde um 5 Punkte erhöht!")
            }
        }
    }
}

fun soloKampf() {
    println("Willkommen im Land von Mythria, einem Ort voller Abenteuer und Magie!")
    println("Bist du bereit, das Schicksal dieses Landes zu verändern?")
    var option: String
    val held = erstelleHeld()
    do {
        println("\nHauptmenü:")
        println("1. Trainiere deinen Helden")
        println("2. Tritt in den Kampf")
        println("3. Beenden")
        print("Wähle eine Option: ")
        option = readLine() ?: ""

        when (option) {
            "1" -> {
                do {
                    held.trainieren()
                    println("Möchtest du weiter trainieren? (ja/nein)")
                } while (readln() == "ja")
            }

            "2" -> {
                rollenspielSimulation(held)
                held.lebenspunkte = held.maxLebenspunkte
                println("Möchtest du zum Hauptmenü zurückkehren? (ja/nein)")
                if (readln() != "ja") {
                    option = "3"
                }
            }

            "3" -> {
                println("Danke fürs Spielen! Auf Wiedersehen!")
            }

            else -> {
                println("Ungültige Option!")
            }
        }
    } while (option != "3")
}


fun Held.statusAnzeigenFarbig() {
    fun farbig(value: Int, max: Int): String {
        val percentage = value.toDouble() / max.toDouble()
        return when {
            percentage > 0.6 -> "\u001B[32m$value\u001B[0m"  // Grün
            percentage > 0.3 -> "\u001B[33m$value\u001B[0m"  // Gelb
            else -> "\u001B[31m$value\u001B[0m"  // Dunkelrot
        }
    }

    println(
        """
        |${heldenFarbe(name)}${name}'s Status:\u001B[0m
        | Lebenspunkte: ${farbig(lebenspunkte, maxLebenspunkte)}/$maxLebenspunkte
        | Angriff: $angriff
        | Magie: $magie
        | Verteidigung: $verteidigung
        """.trimMargin()
    )
}

fun Boesewicht.statusAnzeigenFarbig() {
    fun farbig(value: Int, max: Int): String {
        val percentage = value.toDouble() / max.toDouble()
        return when {
            percentage > 0.6 -> "\u001B[32m$value\u001B[0m"  // Grün
            percentage > 0.3 -> "\u001B[33m$value\u001B[0m"  // Gelb
            else -> "\u001B[31m$value\u001B[0m"  // Dunkelrot
        }
    }

    println(
        """
        |${name}'s Status:
        | Lebenspunkte: ${farbig(lebenspunkte, maxLebenspunkte)}/$maxLebenspunkte
        | Angriff: $angriff
        | Magie: $magie
        | Verteidigung: $verteidigung
        """.trimMargin()
    )
}
