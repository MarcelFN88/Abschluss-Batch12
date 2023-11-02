fun zeigeWillkommensNachricht() {
    println("*************************")
    println("*   Willkommen zum     *")
    println("*  Abenteuerspiel!     *")
    println("*************************")
    println("Du bist ein tapferer Held, der sich dem Dunklen Zauberer und seinen finsteren Kräften stellt.")
}

private fun ermittleHeldenNamen(): String {
    println("Bitte gib deinem Helden einen Namen:")
    return readln()
}

fun starteSpiel() {
    zeigeWillkommensNachricht()
    val heldenName = ermittleHeldenNamen()

    println("Willkommen, edler $heldenName, in einer Welt, in der die Magie lebendig ist und Abenteuer an jeder Ecke lauern.")
    println(
        "Vor Äonen gab es ein einst friedliches Königreich, das den Namen Goldonia trug." +
                "Doch vor unendlicher Zeit tauchte der Dunkle Zauberer auf und stürzte das Land in ein Chaos von unermesslichem Ausmaß und vernichtender Dunkelheit."
    )
    println(
        "Die verzweifelten Stimmen des Volkes rufen nach einem strahlenden Helden," +
                "der mit unbändigem Mut und herausragender Weisheit dem Dunklen Zauberer und seinen finsteren Künsten entgegentritt, um Goldonia vor dem drohenden Untergang zu bewahren."
    )
    println("Und so, $heldenName, wurdest du von den Sternen auserkoren, dieser gefahrvollen Bestimmung gerecht zu werden.")
    println(
        "Du brichst auf zu einer epischen Reise, die dich durch verzauberte Landstriche und düstere Wälder führt," +
                "um die uralten Geheimnisse der Dunklen Magie zu entschlüsseln und den Dunklen Zauberer ein für alle Mal zu besiegen," +
                "damit Goldonia wieder im Glanz des Lichts erstrahlen kann." +
                "\nHier is dein Team $heldenName:"
    )

}

fun erstelleTeamMitZufaelligenNamen(): List<Held> {
    val namenListe = listOf(
        "Aric Stormblade",
        "Lyra Shadowstrike",
        "Thorne Ironfist",
        "Soren Fireheart",
        "Elara Dawnbreaker",
        "Draven Bloodthorn",
        "Kael Stonehammer",
        "Freya Frostbite",
        "Ragnar Blackthorn",
        "Seraphina Nightshade",
        "Torin Steelclad",
        "Astrid Warblade",
        "Garen Stormrider",
        "Azura Silvermoon",
        "Malik Grimhelm",
        "Isolde Swiftarrow",
        "Roderic Battlecry",
        "Anika Thornblade",
        "Leif Frostfang",
        "Keira Dragonflame",
        "Alaric Spellweaver",
        "Elowen Starcaster",
        "Thaddeus Mysticfire",
        "Seraphina Enchantress",
        "Malachi Moonshadow",
        "Isolde Arcanegale",
        "Oberon Spellbound",
        "Evangeline Runeblaze",
        "Sylas Stormbringer",
        "Celestia Frostwind",
        "Dorian Runesong",
        "Isidore Flamecaller",
        "Evelina Spellbinder",
        "Alarina Moonspell",
        "Thalion Windwhisper",
        "Morgana Shadowcaster",
        "Silvanus Starfrost",
        "Calista Dreamweaver",
        "Balthazar Earthshaker",
        "Elara Nightglow"
    )
    val team = mutableListOf<Held>()

    val krieger = Krieger(namenListe.random())
    val zauberer = Zauberer(namenListe.random())
    val manipulator = Manipulator(namenListe.random())

    team.add(krieger)
    team.add(zauberer)
    team.add(manipulator)
    for (held in team) {
        println("${held.name} - Typ: ${held.heldenTyp},Lebenspunkte: ${held.lebenspunkte} Angriff: ${held.angriff}, Verteidigung: ${held.verteidigung}, Magie: ${held.magie}")
    }

    return team
}


fun darstelleLebenspunkte(character: Any) {
    val (name, lebenspunkte, maxLebenspunkte) = when (character) {
        is Held -> Triple(character.name, character.lebenspunkte, character.maxLebenspunkte)
        is DunklerZauberer -> Triple(character.name, character.lebenspunkte, character.maxLebenspunkte)
        else -> throw IllegalArgumentException("Unbekannter Charaktertyp")
    }

    val prozent = (lebenspunkte.toDouble() / maxLebenspunkte) * 100
    val farbe = when {
        prozent <= 20 -> "\u001B[31m"
        prozent <= 50 -> "\u001B[33m"
        else -> "\u001B[32m"
    }
    println("$farbe$name hat $lebenspunkte Lebenspunkte.\u001B[0m")
}


fun rundenbasierterKampf(helden: List<Held>, gegner: DunklerZauberer) {
    var runde = 1
    val beutel = Beutel()
    while (gegner.lebenspunkte > 0 && helden.any { it.lebenspunkte > 0 }) {
        println("----- Runde $runde -----")

        for (held in helden) {
            darstelleLebenspunkte(held)
        }
        darstelleLebenspunkte(gegner)


        runde++

        for (held in helden) {
            if (held.lebenspunkte > 0) {
                println("${held.name}, es ist dein Zug!")
                println("Wähle eine Aktion:")
                println("1. Angreifen")
                println("2. Beutel öffnen")
                println("3. Blocken")
                when (readln()) {
                    "1" -> {
                        when (held) {
                            is Krieger -> {
                                held.kriegerAngriff()
                                gegner.erleideSchaden(held.angriff.toDouble())
                            }
                            is Zauberer -> {
                                held.zaubererAngriff()
                                gegner.erleideSchaden(held.magie.toDouble())
                            }
                            is Manipulator -> {
                                held.manipulatorAngriff()
                                gegner.erleideSchaden(held.verteidigung.toDouble())
                            }
                        }
                        gegner.erleideSchaden(held.angriff.toDouble())
                    }

                    "2" -> {
                        beutel.oeffneBeutel(held)
                    }

                    "3" -> {
                        held.blocken()
                        println("${held.name} bereitet sich darauf vor, zu blocken!")
                    }

                    else -> {
                        println("Ungültige Eingabe. Überspringe Zug.")
                    }
                }
            }
        }

        if (gegner.lebenspunkte > 0) {
            val zufall = (1..100).random()


            if (!gegner.schattenBeschworen && gegner.lebenspunkte <= 150) {
                gegner.dunklenSchattenRufen()
            } else if (zufall <= 70) {
                println("Der Dunkle Zauberer greift an!")
                if (gegner.schattenBeschworen) {
                    gegner.spezialAttacke(helden)
                } else {
                    val ziel = helden.filter { it.lebenspunkte > 0 }.random()
                    gegner.angreifen(ziel)
                }
            } else {
                gegner.blocken()
                println("Der Dunkle Zauberer hat geblockt!")
            }
        }


        runde++
    }

    if (gegner.lebenspunkte <= 0) {
        println("Gratulation! Der Dunkle Zauberer wurde besiegt!")
    } else {
        println("Das Team wurde besiegt. Das Böse regiert weiterhin...")
    }

}

private fun Menue(team: List<Held>) {
    var auswahl: String
    do {
        println("Hauptmenü:")
        println("1. Trainieren")
        println("2. Kampf gegen den Dunklen Zauberer starten")
        println("3. Spiel beenden")
        auswahl = readln()

        when (auswahl) {
            "1" -> {
                do {
                    println("Trainingsmenü:")
                    for ((index, held) in team.withIndex()) {
                        println("${index + 1}. Lass ${held.name} trainieren")
                    }
                    println("${team.size + 1}. Zurück zum Hauptmenü")
                    val trainingsAuswahl = readln().toIntOrNull()
                    if (trainingsAuswahl != null && trainingsAuswahl in 1..team.size) {
                        team[trainingsAuswahl - 1].trainieren()
                    } else if (trainingsAuswahl == team.size + 1) {
                        break
                    } else {
                        println("Ungültige Auswahl. Bitte wähle erneut.")
                    }
                } while (true)
            }

            "2" -> {
                val dunklerZauberer = DunklerZauberer("Dunkler Zauberer", 500, 50, 30)
                rundenbasierterKampf(team, dunklerZauberer)
            }

            "3" -> {
                println("Spiel beendet. Bis zum nächsten Mal!")
                break
            }

            else -> println("Ungültige Eingabe. Bitte wähle erneut.")
        }
    } while (auswahl != "3")
}
