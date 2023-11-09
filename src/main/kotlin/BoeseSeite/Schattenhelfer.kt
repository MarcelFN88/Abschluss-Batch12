package BoeseSeite

import GuteSeite.Held

class Schattenhelfer {
    fun angreifen(team: List<Held>) {
        val schaden = 10
        for (held in team) {
            held.lebenspunkte -= schaden
            println("Der BoeseSeite.Schattenhelfer fügt ${held.name} $schaden Schaden zu.\n")
        }
    }
}
