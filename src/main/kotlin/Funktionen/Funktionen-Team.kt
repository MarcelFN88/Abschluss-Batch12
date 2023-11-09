package Funktionen

import BoeseSeite.Boesewicht
import BoeseSeite.Drache
import BoeseSeite.DunklerMagier
import BoeseSeite.Schattenhelfer
import GuteSeite.Held
import GuteSeite.Krieger
import GuteSeite.Magier
import GuteSeite.Manipulator
import Items.Beutel
import java.io.File
import java.io.IOException
import kotlin.random.Random

fun erstelleBoesewicht(): Boesewicht {
    return if (Random.nextBoolean()) {
        Drache.erstelleDrache()

    } else {
        DunklerMagier.erstelleDunklerMagier()
    }
}

fun starteSpielUndTeamMenu(team: List<Held>? = null) {
    playSound("sunrise.wav")
    val meinTeam = team ?: listOf(
        Krieger().apply { heldenErstellen() },
        Magier().apply { heldenErstellen() },
        Manipulator().apply { heldenErstellen() }
    )
    val boesewicht = erstelleBoesewicht()
    val beutel = Beutel()

    var laufen = true
    val tuerkis = "\u001B[96m"
    while (laufen) {
        println(
            """
            |Willkommen im Hauptmenü des Teams.
            |${tuerkis}[1] Trainieren${Held.resetColor}
            |${tuerkis}[2] In den Kampf ziehen${Held.resetColor}
            |${tuerkis}[3] Spiel beenden und speichern${Held.resetColor}
            |Bitte wähle eine Option:
            """.trimMargin()
        )

        when (readln()) {
            "1" -> {
                teamTraining(meinTeam)
            }

            "2" -> {
                starteRundenbasiertenKampf(meinTeam, boesewicht, beutel)
            }

            "3" -> {
                println("Spiel wird gespeichert und beendet...")
                speichern(meinTeam)
                laufen = false
            }

            else -> println("Ungültige Eingabe, bitte versuchen Sie es erneut.")
        }
    }
}

fun teamTraining(team: List<Held>) {
    val blau = "\u001B[34m"
    val reset = "\u001B[0m"

    println("Wen möchtest du trainieren?")
    team.forEachIndexed { index, held ->
        val heldenRolle = when (held) {
            is Krieger -> "GuteSeite.Krieger"
            is Magier -> "GuteSeite.Magier"
            is Manipulator -> "GuteSeite.Manipulator"
            else -> "Unbekannt"
        }
        println("$blau${index + 1}. ${held.name} $reset($heldenRolle)")
    }
    println("Gib die Nummer des Helden ein, den du trainieren möchtest:")

    val auswahl = readln().toIntOrNull()
    if (auswahl == null || auswahl !in 1..team.size) {
        println("Ungültige Auswahl. Bitte gib eine Zahl zwischen 1 und ${team.size} ein.")
        return
    }

    val zuTrainierenderHeld = team[auswahl - 1]
    zuTrainierenderHeld.training()
}

fun speichern(team: List<Held>) {
    val teamNamen = team.joinToString("_") { it.name.filter { char -> char.isLetterOrDigit() } }
    println("Speichern des Spielstands. Drücken Sie Enter, um als '${teamNamen}.txt' zu speichern oder geben Sie einen neuen Namen ein:")
    val eingabe = readln().trim()
    val dateiName = if (eingabe.isBlank()) "${teamNamen}.txt" else "$eingabe.txt"

    try {
        File(dateiName).bufferedWriter().use { out ->
            team.forEach { held ->
                val typ = when (held) {
                    is Krieger -> "GuteSeite.Krieger"
                    is Magier -> "GuteSeite.Magier"
                    is Manipulator -> "GuteSeite.Manipulator"
                    else -> throw IllegalArgumentException("Unbekannter Heldentyp")
                }
                val daten =
                    "$typ,${held.name},${held.lebenspunkte},${held.maxLebenspunkte},${held.angriff},${held.magie},${held.verteidigung}"
                out.write(daten)
                out.newLine()
            }
        }
        println("Speichern erfolgreich: Daten wurden in '$dateiName' gespeichert.")
    } catch (e: IOException) {
        println("Ein Fehler ist aufgetreten beim Speichern der Datei '$dateiName': ${e.message}")
    }
}


fun laden(): List<Held>? {
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
        val team = mutableListOf<Held>()
        val lines = File(spielstaende[eingabe - 1].name).readLines()
        lines.forEach { line ->
            val daten = line.split(",")
            if (daten.size >= 7) {
                val held = when (val typ = daten[0]) {
                    "GuteSeite.Krieger" -> Krieger()
                    "GuteSeite.Magier" -> Magier()
                    "GuteSeite.Manipulator" -> Manipulator()
                    else -> throw IllegalArgumentException("Unbekannter Heldentyp: $typ")
                }
                held.name = daten[1]
                held.lebenspunkte = daten[2].toInt()
                held.maxLebenspunkte = daten[3].toInt()
                held.angriff = daten[4].toInt()
                held.magie = daten[5].toInt()
                held.verteidigung = daten[6].toInt()
                team.add(held)
            }
        }
        if (team.isNotEmpty()) {
            return team
        }
        println("Spielstand ist leer oder beschädigt.")
        return null
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

fun hauptMenuTeam() {

    println("Willkommen im Abenteuerspiel!")
    println("Möchtest Du ein neues Spiel starten? dann tippe “start“")
    println("Ein gespeichertes Spiel laden? Dann tippe “laden“")
    println("Einen Spielstand löschen? Dann tippe “löschen“")

    when (readln().trim().lowercase()) {
        "start" -> {
            starteSpielUndTeamMenu()
        }

        "laden" -> {
            val geladenesTeam = laden()
            if (geladenesTeam != null) {
                starteSpielUndTeamMenu(geladenesTeam)
            } else {
                println("Das Laden des Spielstands ist fehlgeschlagen.")
                hauptMenuTeam()
            }
        }

        "löschen" -> {
            spielstaendeLoeschen()
            hauptMenuTeam()
            return
        }

        else -> {
            println("Ungültige Eingabe. Bitte versuche es erneut.")
            hauptMenuTeam()
            return
        }
    }
}

fun starteRundenbasiertenKampf(team: List<Held>, boesewicht: Boesewicht, beutel: Beutel) {
    println("Initialisiere Kampf...")

    team.forEach { held -> held.lebenspunkte = held.maxLebenspunkte }
    boesewicht.lebenspunkte = boesewicht.maxLebenspunkte

    println("Teamlebenspunkte: ${team.sumOf { it.lebenspunkte }}")
    println("Boesewichtlebenspunkte: ${boesewicht.lebenspunkte}")

    val gegner = if (Random.nextBoolean()) Drache("Eragon") else DunklerMagier("Varok")
    rundenbasierterKampfTeam(team, gegner, beutel)
}

fun rundenbasierterKampfTeam(team: List<Held>, boesewicht: Boesewicht, beutel: Beutel) {
    println("Das Team hat bisher ${Held.siege} mal gewonnen und ${Held.niederlagen} mal verloren.\n")
//    println("Debug: Teamlebenspunkte zu Beginn des Kampfes: ${team.sumOf { it.lebenspunkte }}")
//    println("Debug: Bösewichtlebenspunkte zu Beginn des Kampfes: ${boesewicht.lebenspunkte}")

    var runde = 1
    var schattenhelferAktiv = false
    var schattenhelferRundenZaehler = 0
    val schattenhelfer = Schattenhelfer()


    while (team.any { it.lebenspunkte > 0 } && boesewicht.lebenspunkte > 0) {
        team.forEach { it.aktualisiereVerteidigung(); it.rundenUpdate() }
        boesewicht.rundenUpdate()

        println("Runde $runde!\n")

        team.forEach { held ->
            val lebenspunkteFarbe = Boesewicht.lebenspunkteFarbe(held.lebenspunkte, held.maxLebenspunkte)
            println("${Held.nameColor}${held.name}${Held.resetColor} - Lebenspunkte: $lebenspunkteFarbe${held.lebenspunkte}/${held.maxLebenspunkte}${Held.resetColor}")
        }

        val boesewichtLebenspunkteFarbe =
            Boesewicht.lebenspunkteFarbe(boesewicht.lebenspunkte, boesewicht.maxLebenspunkte)
        println("${Boesewicht.nameColor}${boesewicht.name}${Boesewicht.resetColor} - Lebenspunkte: $boesewichtLebenspunkteFarbe${boesewicht.lebenspunkte}/${boesewicht.maxLebenspunkte}${Boesewicht.resetColor}\n")

        for (held in team) {
            if (held.lebenspunkte > 0) {
                println("Was soll ${held.name} tun?")
                println("1. Angreifen")
                println("2. Verteidigen")
                println("3. Items.Beutel benutzen\n")
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
            }
        }

        if (boesewicht.lebenspunkte > 0) {
            if (boesewicht.laehmung) {
                println("${boesewicht.name} ist gelähmt und kann diesen Zug nicht agieren!")
                boesewicht.laehmung = false
            } else {
                if (boesewicht.lebenspunkte.toDouble() / boesewicht.maxLebenspunkte <= 0.4 && !schattenhelferAktiv) {
                    println("${boesewicht.name} ruft einen BoeseSeite.Schattenhelfer zur Hilfe!")
                    schattenhelferAktiv = true
                    schattenhelferRundenZaehler = 3
                }

            if (boesewicht.laehmung) {
                println("${boesewicht.name} ist gelähmt und kann diesen Zug nicht agieren!")
                boesewicht.laehmung = false
            }

                if (schattenhelferAktiv) {
                    schattenhelfer.angreifen(team)

                    schattenhelferRundenZaehler--
                    if (schattenhelferRundenZaehler <= 0) {
                        schattenhelferAktiv = false
                    }
                }

                val boesewichtAktion = Random.nextInt(5)
                if (boesewichtAktion in 0..3) {
                    boesewicht.angreifen(team.random())
                } else {
                    boesewicht.verteidigen()
                }
            }
        }

        if (boesewicht.lebenspunkte <= 0) {
            Held.siege++
            println("${Boesewicht.nameColor}${boesewicht.name}${Boesewicht.resetColor} wurde besiegt!")
            for (held in team) {
                if (Random.nextBoolean()) {
                    println("Als Belohnung für den Sieg erhält ${held.name} einen Heiltrank!")
                    beutel.fuegeHinzu("Heiltrank")
                } else {
                    println("Als Belohnung für den Sieg erhält ${held.name} Vitamine!")
                    beutel.fuegeHinzu("Vitamine")
                }
                held.lebenspunkte = held.maxLebenspunkte
            }

        } else if (team.all { it.lebenspunkte <= 0 }) {
            Held.niederlagen++
            println("Das Team wurde besiegt!")
            team.forEach { it.lebenspunkte = it.maxLebenspunkte }
        }



    if (boesewicht.lebenspunkte <= 0 || team.all { it.lebenspunkte <= 0 }) {
            break
        }

        runde++
    }

    team.forEach { it.lebenspunkte = it.maxLebenspunkte }
    println("Der Kampf ist vorbei. Das Team hat jetzt ${Held.siege} Siege und ${Held.niederlagen} Niederlagen.\n\n\n")
    boesewicht.maxLebenspunkte = (boesewicht.maxLebenspunkte * 1.1).toInt()
    boesewicht.angriff = (boesewicht.angriff * 1.1).toInt()
    boesewicht.verteidigung = (boesewicht.verteidigung * 1.1).toInt()

    println("${Boesewicht.nameColor}${boesewicht.name}${Boesewicht.resetColor} wird stärker und kommt zurück für eine Revanche!")

}

