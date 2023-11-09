package Items

import GuteSeite.Held

class Beutel {
    private var heiltraenke = 3
    private var vitamine = 7

    private fun benutzeHeiltrank(held: Held) {
        if (heiltraenke > 0) {
            val heilung = (held.maxLebenspunkte * 0.3).toInt()
            held.lebenspunkte = minOf(held.lebenspunkte + heilung, held.maxLebenspunkte)
            heiltraenke--
            println("Der GuteSeite.Held hat einen Heiltrank benutzt und $heilung Lebenspunkte wiederhergestellt.")
        } else {
            println("Du hast keine Heiltränke mehr!")
        }
    }

    private fun benutzeVitamine(held: Held) {
        if (vitamine > 0) {
            held.temporaereVerteidigungErhoehen(3)
            vitamine--
            println("Der GuteSeite.Held hat Vitamine benutzt und die Verteidigung wird für die nächsten 3 Runden um 20% erhöht.\n")
        } else {
            println("Du hast keine Vitamine mehr!")
        }
    }

    fun zeigeInventar() {
        println("Items.Beutel-Inventar:\n ")
        println("Heiltränke: $heiltraenke")
        println("Vitamine: $vitamine\n")
    }

    fun waehleUndBenutze(held: Held) {
        println("Wähle einen Gegenstand aus deinem Items.Beutel:\n")
        println("1. Heiltrank (Heilt 30% deiner max. LP)")
        println("2. Vitamine (Steigert Verteidigung um 20% für 3 Runden)\n")
        println("Deine Wahl: \n")
        when (readln()) {
            "1" -> benutzeHeiltrank(held)
            "2" -> benutzeVitamine(held)
            else -> println("Ungültige Auswahl. Du verlierst deine Aktion.")
        }
    }

    fun fuegeHinzu(gegenstand: String) {
        when (gegenstand) {
            "Heiltrank" -> heiltraenke++
            "Vitamine" -> vitamine++
            else -> println("Gegenstand nicht bekannt. Kein Gegenstand hinzugefügt.")
        }
    }

}
