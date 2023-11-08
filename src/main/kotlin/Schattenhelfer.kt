class Schattenhelfer {
    fun angreifen(team: List<Held>) {
        val schaden = 10
        for (held in team) {
            held.lebenspunkte -= schaden
            println("Der Schattenhelfer fügt ${held.name} $schaden Schaden zu.\n")
        }
    }
}
