import java.util.*
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Clip

object SoundPlayer {
    fun playKeyPressSound() {
        try {
            val clip: Clip = AudioSystem.getClip()
            val audioInputStream = AudioSystem.getAudioInputStream(
                resources::class.java.getResource("key_press.wav")
            )
            clip.open(audioInputStream)
            clip.start()
            while (clip.isRunning) {
                Thread.sleep(10)
            }
            clip.close()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}

object resources {

}

fun simuliereGetipptenText(text: String, wartezeit: Long = 50) {
    for (char in text) {
        print(char)
        SoundPlayer.playKeyPressSound()
        Thread.sleep(wartezeit)
    }
    println()
}



fun zeigeWillkommensNachricht() {
    val ANSI_RESET = "\u001B[0m"
    val ANSI_RED = "\u001B[31m"
    val ANSI_BG_BLACK = "\u001B[40m"

    println(ANSI_BG_BLACK + ANSI_RED + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          \n" +
            " :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:  \n" +
            "   +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+    \n" +
            "+#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ \n" +
            "   +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+    \n" +
            " #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#  ")
    println(ANSI_BG_BLACK + ANSI_RED + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          \n" +
            "                                                                          :::       ::: ::::::::::: :::        :::        :::    ::: ::::::::  ::::    ::::  ::::    ::::  :::::::::: ::::    :::          ::::::::::: :::     :::::::::  :::::::::: :::::::::: :::::::::  :::::::::: :::::::::       :::       :::     :::     ::::    ::: :::::::::  :::::::::: :::::::::  :::::::::: :::::::::  :::                                                                                                    \n" +
            " :+:     :+:                                                              :+:       :+:     :+:     :+:        :+:        :+:   :+: :+:    :+: +:+:+: :+:+:+ +:+:+: :+:+:+ :+:        :+:+:   :+:              :+:   :+: :+:   :+:    :+: :+:        :+:        :+:    :+: :+:        :+:    :+:      :+:       :+:   :+: :+:   :+:+:   :+: :+:    :+: :+:        :+:    :+: :+:        :+:    :+: :+:                                                                                       :+:     :+:  \n" +
            "   +:+ +:+                                                                +:+       +:+     +:+     +:+        +:+        +:+  +:+  +:+    +:+ +:+ +:+:+ +:+ +:+ +:+:+ +:+ +:+        :+:+:+  +:+              +:+  +:+   +:+  +:+    +:+ +:+        +:+        +:+    +:+ +:+        +:+    +:+      +:+       +:+  +:+   +:+  :+:+:+  +:+ +:+    +:+ +:+        +:+    +:+ +:+        +:+    +:+ +:+                                                                                         +:+ +:+    \n" +
            "+#++:++#++:++                                                             +#+  +:+  +#+     +#+     +#+        +#+        +#++:++   +#+    +:+ +#+  +:+  +#+ +#+  +:+  +#+ +#++:++#   +#+ +:+ +#+              +#+ +#++:++#++: +#++:++#+  :#::+::#   +#++:++#   +#++:++#:  +#++:++#   +#++:++#:       +#+  +:+  +#+ +#++:++#++: +#+ +:+ +#+ +#+    +:+ +#++:++#   +#++:++#:  +#++:++#   +#++:++#:  +#+                                                                                      +#++:++#++:++ \n" +
            "   +#+ +#+                                                                +#+ +#+#+ +#+     +#+     +#+        +#+        +#+  +#+  +#+    +#+ +#+       +#+ +#+       +#+ +#+        +#+  +#+#+#              +#+ +#+     +#+ +#+        +#+        +#+        +#+    +#+ +#+        +#+    +#+      +#+ +#+#+ +#+ +#+     +#+ +#+  +#+#+# +#+    +#+ +#+        +#+    +#+ +#+        +#+    +#+ +#+                                                                                         +#+ +#+    \n" +
            " #+#     #+#                                                               #+#+# #+#+#      #+#     #+#        #+#        #+#   #+# #+#    #+# #+#       #+# #+#       #+# #+#        #+#   #+#+# #+#          #+# #+#     #+# #+#        #+#        #+#        #+#    #+# #+#        #+#    #+#       #+#+# #+#+#  #+#     #+# #+#   #+#+# #+#    #+# #+#        #+#    #+# #+#        #+#    #+#                                                                                           #+#     #+#  \n" +
            "                                                                            ###   ###   ########### ########## ########## ###    ### ########  ###       ### ###       ### ########## ###    #### ##           ### ###     ### ###        ###        ########## ###    ### ########## ###    ###        ###   ###   ###     ### ###    #### #########  ########## ###    ### ########## ###    ### ###                                                                                                    ")
    println(ANSI_BG_BLACK + ANSI_RED + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          \n" +
            " :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:   :+:     :+:  \n" +
            "   +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+       +:+ +:+    \n" +
            "+#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ +#++:++#++:++ \n" +
            "   +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+       +#+ +#+    \n" +
            " #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#   #+#     #+#  \n" +
            "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          " + ANSI_RESET)
    val nachrichten = listOf(
        "In einem Zeitalter, in dem die Sterne alt werden und leise flüstern,",
        "und das dunkle Schicksal ständig an der Ecke lauert, hat dich das Schicksal ausgewählt.",
        "In einer Welt, die von Schatten und finsteren Mächten heimgesucht wird,",
        "bist du der letzte Strahl der Hoffnung, ein leuchtender Stern am dunklen Himmel.",
        "Rüste dich aus, sammle deine Kräfte und stelle dich der Dunkelheit, die das Land verschlingt.",
        "Mögen die Götter dir beistehen, mutiger Held, auf deiner epischen Reise ins Unbekannte!"
    )

    for (nachricht in nachrichten) {
        simuliereGetipptenText(ANSI_BG_BLACK + ANSI_RED + nachricht + ANSI_RESET)
        Thread.sleep(500)
    }
}


private fun ermittleHeldenNamen(): String {
    println("In dieser gefährlichen Welt benötigt jeder Held einen Namen. Wie sollen die Barden dich besingen?")
    return readln()
}

fun starteSpiel() {
    zeigeWillkommensNachricht()
    val heldenName = ermittleHeldenNamen()
    println()
    println("Ah, $heldenName, ein Name, der bereits durch die Hallen des Schicksals hallt!")
    println("In einer Zeit, in der Goldonia, ein einst stolzes Königreich, von Schatten bedroht wird, wurdest du auserkoren, das Licht zurückzubringen.")
    println("Doch du bist nicht allein in dieser gefährlichen Reise...")
    println("Hier ist dein tapferes Team:")
    println()
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
    println()
    println("Ein mächtiger Wind zieht auf und die Erde bebt... Der Dunkle Zauberer steht vor dir!")
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
        println("Mit einem lauten Schrei zerfällt der Dunkle Zauberer zu Staub und die Dunkelheit weicht dem Licht. Gratulation! Dein Team hat das Böse besiegt!")
    } else {
        println("Die Dunkelheit ist mächtig und unerbittlich. Dein Team wurde besiegt, aber das bedeutet nicht das Ende. Die Sterne flüstern von einer zweiten Chance...")
    }

    println("\nMöchtest du weitermachen? (Ja/Nein)")
    val antwort = readln().trim().lowercase(Locale.getDefault())
    when (antwort) {
        "ja" -> {
            println("Mit erneuerter Entschlossenheit machst du dich auf den Weg. Dein Abenteuer geht weiter!")
        }
        "nein" -> {
            println("Du entscheidest dich, eine Pause einzulegen und dich von deinen Abenteuern zu erholen. Aber das Schicksal wartet immer...")
            return
        }
        else -> {
            println("Ich verstehe diese Antwort nicht. Trotzdem führt dich dein Weg zurück zum Hauptmenü.")
        }
    }
}

fun Menue(team: List<Held>) {
    println("Am Scheideweg deines Schicksals angelangt, stehst du vor einer Entscheidung...")
    var auswahl: String
    val ANSI_RESET = "\u001B[0m"
    val ANSI_BLACK = "\u001B[30m"
    val ANSI_RED = "\u001B[31m"
    val ANSI_GREEN = "\u001B[32m"
    val ANSI_YELLOW = "\u001B[33m"
    val ANSI_BLUE = "\u001B[34m"
    val ANSI_PURPLE = "\u001B[35m"
    val ANSI_CYAN = "\u001B[36m"
    val ANSI_WHITE = "\u001B[37m"

    val ANSI_BG_RED = "\u001B[41m"
    val ANSI_BG_GREEN = "\u001B[42m"
    val ANSI_BG_YELLOW = "\u001B[43m"
    val ANSI_BG_BLUE = "\u001B[44m"
    val ANSI_BG_PURPLE = "\u001B[45m"
    val ANSI_BG_CYAN = "\u001B[46m"
    val ANSI_BG_WHITE = "\u001B[47m"
    val ANSI_BG_BLACK = "\u001B[40m"
    do {
        println(ANSI_BG_BLACK + ANSI_RED + "======================")
        println(ANSI_BG_BLACK + ANSI_RED + "||" + "                  " + "||")
        println(ANSI_BG_BLACK + ANSI_RED + "||" + "   HAUPTMENÜ      " + "||")
        println(ANSI_BG_BLACK + ANSI_RED + "||" + "                  " + "||")
        println(ANSI_BG_BLACK + ANSI_RED + "======================" + ANSI_RESET)
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
                val dunklerZauberer = DunklerZauberer("Dunkler Zauberer", 1000, 1000, 45, 20)
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
