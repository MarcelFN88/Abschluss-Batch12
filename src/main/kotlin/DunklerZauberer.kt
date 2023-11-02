class DunklerZauberer(
    name: String,
    lebenspunkte: Int,
    maxLebenspunkte: Int,
    angriff: Int,
    verteidigung: Int,
    override var blockt: Boolean = false
) : Boesewicht(name, lebenspunkte, maxLebenspunkte, angriff, verteidigung) {
    var schattenBeschworen = false

    private val attacken = listOf(
        Attacke("\n" +
                ":::::::::  :::    ::: ::::    ::: :::    ::: :::        :::::::::: :::::::::               :::::::::  :::        ::::::::::: ::::::::::: ::::::::: \n" +
                ":+:    :+: :+:    :+: :+:+:   :+: :+:   :+:  :+:        :+:        :+:    :+:              :+:    :+: :+:            :+:         :+:          :+:  \n" +
                "+:+    +:+ +:+    +:+ :+:+:+  +:+ +:+  +:+   +:+        +:+        +:+    +:+              +:+    +:+ +:+            +:+         +:+         +:+   \n" +
                "+#+    +:+ +#+    +:+ +#+ +:+ +#+ +#++:++    +#+        +#++:++#   +#++:++#: +#++:++#++:++ +#++:++#+  +#+            +#+         +#+        +#+    \n" +
                "+#+    +#+ +#+    +#+ +#+  +#+#+# +#+  +#+   +#+        +#+        +#+    +#+              +#+    +#+ +#+            +#+         +#+       +#+     \n" +
                "#+#    #+# #+#    #+# #+#   #+#+# #+#   #+#  #+#        #+#        #+#    #+#              #+#    #+# #+#            #+#         #+#      #+#      \n" +
                "#########   ########  ###    #### ###    ### ########## ########## ###    ###              #########  ########## ###########     ###     #########", 1.2),
        Attacke("\n" +
                ":::::::::: :::       :::    :::  ::::::::  :::    :::      :::::::::  :::::::::: :::::::::       :::     ::: :::::::::: :::::::::  :::       ::: :::::::::: ::::::::  :::    ::: ::::    :::  ::::::::  \n" +
                ":+:        :+:       :+:    :+: :+:    :+: :+:    :+:      :+:    :+: :+:        :+:    :+:      :+:     :+: :+:        :+:    :+: :+:       :+: :+:       :+:    :+: :+:    :+: :+:+:   :+: :+:    :+: \n" +
                "+:+        +:+       +:+    +:+ +:+        +:+    +:+      +:+    +:+ +:+        +:+    +:+      +:+     +:+ +:+        +:+    +:+ +:+       +:+ +:+       +:+        +:+    +:+ :+:+:+  +:+ +:+        \n" +
                ":#::+::#   +#+       +#+    +:+ +#+        +#++:++#++      +#+    +:+ +#++:++#   +#++:++#:       +#+     +:+ +#++:++#   +#++:++#:  +#+  +:+  +#+ +#++:++#  +#++:++#++ +#+    +:+ +#+ +:+ +#+ :#:        \n" +
                "+#+        +#+       +#+    +#+ +#+        +#+    +#+      +#+    +#+ +#+        +#+    +#+       +#+   +#+  +#+        +#+    +#+ +#+ +#+#+ +#+ +#+              +#+ +#+    +#+ +#+  +#+#+# +#+   +#+# \n" +
                "#+#        #+#       #+#    #+# #+#    #+# #+#    #+#      #+#    #+# #+#        #+#    #+#        #+#+#+#   #+#        #+#    #+#  #+#+# #+#+#  #+#       #+#    #+# #+#    #+# #+#   #+#+# #+#    #+# \n" +
                "###        ########## ########   ########  ###    ###      #########  ########## ###    ###          ###     ########## ###    ###   ###   ###   ########## ########   ########  ###    ####  ########  ", 0.8),
        Attacke("\n" +
                " ::::::::   ::::::::  :::    :::     ::: ::::::::::: ::::::::::: :::::::::: ::::    :::                :::::::: ::::::::::: ::::::::   ::::::::   ::::::::  \n" +
                ":+:    :+: :+:    :+: :+:    :+:   :+: :+:   :+:         :+:     :+:        :+:+:   :+:               :+:    :+:    :+:    :+:    :+: :+:    :+: :+:    :+: \n" +
                "+:+        +:+        +:+    +:+  +:+   +:+  +:+         +:+     +:+        :+:+:+  +:+               +:+           +:+    +:+    +:+ +:+        +:+        \n" +
                "+#++:++#++ +#+        +#++:++#++ +#++:++#++: +#+         +#+     +#++:++#   +#+ +:+ +#+ +#++:++#++:++ +#++:++#++    +#+    +#+    +:+ +#++:++#++ +#++:++#++ \n" +
                "       +#+ +#+        +#+    +#+ +#+     +#+ +#+         +#+     +#+        +#+  +#+#+#                      +#+    +#+    +#+    +#+        +#+        +#+ \n" +
                "#+#    #+# #+#    #+# #+#    #+# #+#     #+# #+#         #+#     #+#        #+#   #+#+#               #+#    #+#    #+#    #+#    #+# #+#    #+# #+#    #+# \n" +
                " ########   ########  ###    ### ###     ### ###         ###     ########## ###    ####                ########     ###     ########   ########   ########  ",
            1.5),
        Attacke("\n" +
                ":::::::::: ::::::::::: :::::::: ::::::::::: ::::::::  :::::::::: :::::::::               :::    :::     :::     :::    :::  ::::::::  :::    ::: \n" +
                ":+:            :+:    :+:    :+:    :+:    :+:    :+: :+:        :+:    :+:              :+:    :+:   :+: :+:   :+:    :+: :+:    :+: :+:    :+: \n" +
                "+:+            +:+    +:+           +:+    +:+        +:+        +:+    +:+              +:+    +:+  +:+   +:+  +:+    +:+ +:+        +:+    +:+ \n" +
                "+#++:++#       +#+    +#++:++#++    +#+    :#:        +#++:++#   +#++:++#: +#++:++#++:++ +#++:++#++ +#++:++#++: +#+    +:+ +#+        +#++:++#++ \n" +
                "+#+            +#+           +#+    +#+    +#+   +#+# +#+        +#+    +#+              +#+    +#+ +#+     +#+ +#+    +#+ +#+        +#+    +#+ \n" +
                "#+#            #+#    #+#    #+#    #+#    #+#    #+# #+#        #+#    #+#              #+#    #+# #+#     #+# #+#    #+# #+#    #+# #+#    #+# \n" +
                "########## ########### ######## ########### ########  ########## ###    ###              ###    ### ###     ###  ########   ########  ###    ###", 1.0)
    )

    override fun angreifen(ziel: Person) {
        val zufalligeAttacke = attacken.random()

        var schadenMultiplier = zufalligeAttacke.multiplikator
        if (schattenBeschworen) {
            schadenMultiplier *= 1.5
        }

        val schaden = (angriff * schadenMultiplier).toInt()

        println("$name beschwört die Macht der Dunkelheit und setzt ${zufalligeAttacke.name} gegen ${ziel.name} ein, was Schadenspunkte verursacht!")
        ziel.erleideSchaden(schaden.toDouble())

        schattenAngriff(ziel)
    }

    private fun schattenAngriff(ziel: Person) {
        if (schattenBeschworen) {
            val schaden = (angriff * 0.5).toInt()
            println("Ein dunkler Schatten, heraufbeschworen von $name, schließt sich dem Angriff an und fügt ${ziel.name} weitere ${schaden} Schadenspunkte zu!")
            ziel.erleideSchaden(schaden.toDouble())
        }
    }

    fun spezialAttacke(ziel: List<Person>) {
        if (schattenBeschworen) {
            for (held in ziel) {
                val schaden = (angriff * 1.5).toInt()
                println("$name konzentriert seine düstere Macht und setzt eine vernichtende Spezialattacke gegen ${held.name} ein, die ${schaden} Schadenspunkte verursacht!")
                held.erleideSchaden(schaden.toDouble())
            }
        } else {
            println("$name murmelt etwas unverständlich und es wird klar, dass er seine mächtige Spezialattacke erst nach dem Beschwören des dunklen Schattens einsetzen kann.")
        }
    }

    data class Attacke(val name: String, val multiplikator: Double)

    fun dunklenSchattenRufen() {
        if (lebenspunkte <= 0.3 * maxLebenspunkte && !schattenBeschworen) {
            schattenBeschworen = true
            println("$name wirft seine Arme in die Luft und mit einem dunklen Flüstern ruft er einen schattenhaften Gehilfen herbei!")
        }
    }

    fun blocken() {
        blockt = true
        println("$name schützt sich mit einem finsteren Schutzschild gegen den nächsten Angriff!")
    }

    override fun erleideSchaden(schaden: Double) {
        if (blockt) {
            lebenspunkte -= (schaden / 2).toInt()
            println("$name's Schutzschild absorbiert einen Teil des Schadens!")
            blockt = false
        } else {
            lebenspunkte -= schaden.toInt()
            println("$name fällt mit einem letzten verzweifelten Schrei zu Boden.")
        }
        dunklenSchattenRufen()
    }
}
