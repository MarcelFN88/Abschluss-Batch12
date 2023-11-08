import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Clip
import java.io.File
import java.nio.file.Paths
import kotlin.random.Random

fun Start() {
    println("Willkommen zum Spiel!")
    println("Möchtest du im Einzelmodus oder im Teammodus kämpfen?")
    println("[1] Einzelmodus")
    println("[2] Teammodus")
    print("Bitte wähle eine Option (1 oder 2): ")

    val modus = readln()

    when (modus) {
        "1" -> hauptMenu()
        "2" -> hauptMenuTeam()
        else -> {
            println("Ungültige Eingabe. Bitte wähle 1 für Einzelmodus oder 2 für Teammodus.")
            Start()
        }
    }
}
fun hauptMenu() {
    var held: Held?

    println("Willkommen im Abenteuerspiel!")
    println("Möchtest Du ein neues Spiel starten? dann tippe “start“")
    println("Ein gespeichertes Spiel laden? Dann tippe “laden“")
    println("Einen Spielstand löschen? Dann tippe “löschen“")

    when (readln().trim().lowercase()) {
        "start" -> {
            held = Held.erzeugeUndInitialisiereHelden()
        }

        "laden" -> {
            held = Held.laden()
        }

        "löschen" -> {
            Held.spielstaendeLoeschen()
            hauptMenu()
            return
        }

        else -> {
            println("Ungültige Eingabe. Bitte versuche es erneut.")
            hauptMenu()
            return
        }
    }

    held = held ?: Held.erzeugeUndInitialisiereHelden()
    menu(held)
}


fun menu(held: Held) {
    var laufen = true
    val beutel = Beutel()
    while (laufen) {
        val tuerkis = "\u001B[96m"
        println(
            """
    |Willkommen im Hauptmenü, ${Held.nameColor}${held.name.split(" ").first()}${Held.resetColor}.
    |${tuerkis}[1] Trainieren${Held.resetColor}
    |${tuerkis}[2] In den Kampf ziehen${Held.resetColor}
    |${tuerkis}[3] Spiel beenden und speichern${Held.resetColor}
    |Bitte wähle eine Option:
    """.trimMargin()
        )

        when (readln()) {
            "1" -> {
                println("Held ${Held.nameColor}${held.name}${Held.resetColor} geht ins Training...\n")
                held.training()
            }

            "2" -> {
                println("Held ${Held.nameColor}${held.name}${Held.resetColor} bereitet sich auf den Kampf vor...\n")
                println("Dein Gegner ist:\n")
                val boesewicht = Boesewicht.erzeugeBoesewicht()
                rundenbasierterKampf(held, boesewicht, beutel)
            }

            "3" -> {
                println("Spiel wird gespeichert und beendet...")
                held.speichern()
                laufen = false
            }

            else -> println("Ungültige Eingabe, bitte versuchen Sie es erneut.")
        }
    }
}

fun playSound(soundFileName: String) {
    try {
        val soundFilePath = Paths.get(soundFileName).toAbsolutePath().normalize().toString()
        val soundFile = File(soundFilePath)
        val audioInputStream = AudioSystem.getAudioInputStream(soundFile)
        val clip: Clip = AudioSystem.getClip()
        clip.open(audioInputStream)
        clip.start()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun rundenbasierterKampf(held: Held, boesewicht: Boesewicht, beutel: Beutel) {
    println("Der Held hat bisher ${Held.siege} mal gewonnen und ${Held.niederlagen} mal verloren.\n")
    var runde = 1

    while (held.lebenspunkte > 0 && boesewicht.lebenspunkte > 0) {
        held.aktualisiereVerteidigung()
        held.rundenUpdate()
        boesewicht.rundenUpdate()
        println("Runde $runde!\n")
        val heldLebenspunkteFarbe = Held.lebenspunkteFarbe(held.lebenspunkte, held.maxLebenspunkte)
        println("${Held.nameColor}${held.name}${Held.resetColor} - Lebenspunkte: $heldLebenspunkteFarbe${held.lebenspunkte}/${held.maxLebenspunkte}${Held.resetColor}")

        val boesewichtLebenspunkteFarbe =
            Boesewicht.lebenspunkteFarbe(boesewicht.lebenspunkte, boesewicht.maxLebenspunkte)
        println("${Boesewicht.nameColor}${boesewicht.name}${Boesewicht.resetColor} - Lebenspunkte: $boesewichtLebenspunkteFarbe${boesewicht.lebenspunkte}/${boesewicht.maxLebenspunkte}${Boesewicht.resetColor}\n")

        println("Was willst du tun?")
        println("1. Angreifen")
        println("2. Verteidigen")
        println("3. Beutel benutzen\n")
        print("Deine Wahl: \n")
        val aktion = readln()

        when (aktion) {
            "1" -> {
                held.angreifen(boesewicht)
            }

            "2" -> {
                held.verteidigen()
            }

            "3" -> {
                beutel.zeigeInventar()
                beutel.waehleUndBenutze(held)
            }

            else -> println("Das ist keine gültige Auswahl.")
        }

        if (boesewicht.lebenspunkte > 0) {
            val boesewichtAktion = Random.nextInt(5)
            if (boesewichtAktion in 0..3) {
                boesewicht.angreifen(held)
            } else {
                boesewicht.verteidigen()
            }
        }

        if (boesewicht.lebenspunkte <= 0) {
            println("${Boesewicht.nameColor}${boesewicht.name}${Boesewicht.resetColor} wurde besiegt!\n")
            Held.siege++
            if (Random.nextBoolean()) {
                println("Als Belohnung für deinen Sieg erhältst du einen Heiltrank!\n")
                beutel.fuegeHinzu("Heiltrank")
            } else {
                println("Als Belohnung für deinen Sieg erhältst du Vitamine!\n")
                beutel.fuegeHinzu("Vitamine")
            }
            break
        }

        if (held.lebenspunkte <= 0) {
            println("${Held.nameColor}${held.name}${Held.resetColor} hat den Kampf verloren. Versuche es noch einmal!")
            Held.niederlagen++
            break
        }

        runde++
    }

    held.lebenspunkte = held.maxLebenspunkte

    if (boesewicht.lebenspunkte <= 0) {
        println("Der Kampf ist vorbei.\n" +
                "${Held.nameColor}${held.name}${Held.resetColor} hat gewonnen und seine Lebenspunkte wurden vollständig wiederhergestellt.\n")
    } else if (held.lebenspunkte == held.maxLebenspunkte) {
        println("Der Kampf ist vorbei.\n" +
                "${Held.nameColor}${held.name}${Held.resetColor} hat verloren, aber seine Lebenspunkte wurden für das nächste Abenteuer vollständig wiederhergestellt.\n")
    }
}

