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
                "damit Goldonia wieder im Glanz des Lichts erstrahlen kann."
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

    return team
}

fun team() {
    val meinTeam = erstelleTeamMitZufaelligenNamen()

    for (held in meinTeam) {
        println("${held.name} - Typ: ${held.heldenTyp},Lebenspunkte: ${held.lebenspunkte} Angriff: ${held.angriff}, Verteidigung: ${held.verteidigung}, Magie: ${held.magie}")
    }
}

