import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit
import kotlin.random.Random

open class Held(
    val name: String,
    var lebenspunkte: Int,
    val maxLebenspunkte: Int,
    var angriff: Int,
    var magie: Int,
    var verteidigung: Int
) {

    fun trainieren() {
        println(
            """
        |$name, an welchem mystischen Ort möchtest du heute trainieren und deine Fähigkeiten meistern?
        | 1. Tempel der Schwertmeister (Angriff)
        | 2. Verzauberter Wald der Zauberer (Magie)
        | 3. Festung der Schildwächter (Verteidigung)
        |Treffe deine Wahl, oh Held (1/2/3):
    """.trimMargin()
        )

        val erhoehung = Random.nextInt(5, 11)

        when (readln()) {
            "1" -> {
                this.angriff += erhoehung
                println("Im Tempel der Schwertmeister hast du wertvolles Wissen erlangt! Angriff erhöht um \u001B[32m$erhoehung\u001B[0m Punkte.")
            }

            "2" -> {
                this.magie += erhoehung
                println("Im verzauberten Wald hast du mit alten Magiern gesprochen! Magie erhöht um \u001B[32m$erhoehung\u001B[0m Punkte.")
            }

            "3" -> {
                this.verteidigung += erhoehung
                println("In der Festung der Schildwächter hast du gelernt, jeden Schlag abzuwehren! Verteidigung erhöht um \u001B[32m$erhoehung\u001B[0m Punkte.")
            }

            else -> println("Ein unbekannter Pfad... Vielleicht ein andermal.")
        }

        println(
            """
        |----------------------------------
        |$name's aktuelle Statistiken:
        | Angriff: $angriff
        | Magie: $magie
        | Verteidigung: $verteidigung
        | Lebenspunkte: $lebenspunkte / $maxLebenspunkte
        |----------------------------------
    """.trimMargin()
        )
        println()
    }

    open fun angreifenBoesewicht(): Int {
        println(
            """
        |In der Hitze des Gefechts, umgeben von Feinden und Verbündeten, liegt es an dir, deinen nächsten Zug zu wählen.
        | 
        | 1. Entfessle einen wuchtigen Schlag, der die Erde erzittern lässt.
        | 2. Kanalisiere die Mächte der Magie und schleudere einen elektrisierenden Magieblitz gegen deinen Widersacher.
        | 3. Lass dein Schwert durch die Luft sausen und führe einen tödlichen Schwertstreich aus.
        |
        | Held, welchen Pfad wählst du in dieser kritischen Stunde? (1/2/3):
    """.trimMargin()
        )
        val schaden = Random.nextInt(20, 41)

        when (readln()) {
            "1" -> {
                println("Mit einem donnernden Knall und einer Stärke, die Legenden würdig ist, trifft dein Schlag den Gegner unvorbereitet!")
            }

            "2" -> {
                println("Während du alte Sprüche murmelst, sammeln sich um dich herum elektrische Energien, die schließlich in einem blendenden Blitz auf deinen Gegner zusteuern!")
            }

            "3" -> {
                println("Das leise Zischen deines Schwertes ist das letzte, was dein Gegner hört, bevor er die scharfe Klinge zu spüren bekommt!")
            }

            else -> {
                println("Die Schlacht ist chaotisch und in einem Moment der Unsicherheit gelingt es dir nicht, einen effektiven Angriff auszuführen!")
                return 0
            }
        }

        println("Die Macht deines Angriffs hat \u001B[31m$schaden\u001B[0m Schadenspunkte verursacht!")
        return schaden
    }

    fun blocken(): Boolean {
        println(
            """
        |Inmitten des wilden Getümmels der Schlacht spürst du, $name, die drohende Gefahr eines bevorstehenden Angriffs.
        |Entschlossen, dich zu verteidigen, bereitest du dich vor, einen scheinbar tödlichen Schlag abzuwehren.
        |
        | 1. Erhebe deinen Schild und lasse den Angriff daran zerschellen.
        | 2. Nutze deine magische Aura, um dich in einen schützenden Kokon zu hüllen.
        | 3. Weiche mit einer geschmeidigen Bewegung dem Angriff aus.
        |
        | Held, wie wirst du dich schützen, wenn das Unheil herabkommt? (1/2/3):
    """.trimMargin()
        )

        when (readln()) {
            "1" -> {
                println("Mit einem lauten Krachen trifft der feindliche Angriff auf deinen Schild, doch du stehst fest wie ein Fels in der Brandung!")
            }

            "2" -> {
                println("Ein schimmerndes Leuchten umgibt dich, während du von einer schützenden magischen Barriere umhüllt wirst. Der Angriff kann dir nichts anhaben!")
            }

            "3" -> {
                println("Wie ein Schatten verschwindest du aus dem Blickfeld deines Gegners und tauchst an einem sicheren Ort wieder auf. Der Angriff hat dich verfehlt!")
            }

            else -> {
                println("Ein unvorhergesehener Fehler in deiner Verteidigung lässt dich verwundbar zurück. Hoffentlich wird das nicht dein Verhängnis!")
                return false
            }
        }

        println("Durch deine Verteidigung bist du unbeschadet geblieben!")
        return true
    }


    private val scheduler: ScheduledExecutorService = Executors.newScheduledThreadPool(1)

    fun benutzeItem(beutel: Beutel) {
        println(
            """
        |In der hitzigen Schlacht spürst du, $name, dass du vielleicht auf etwas in deinem Beutel zurückgreifen musst.
        |Mit raschen Handgriffen öffnest du den Beutel, um seinen Inhalt zu prüfen.
        |
        | 1. Heiltrank: Heilt die Hälfte deiner verlorenen Lebenspunkte.
        | 2. Vitamine: Steigert einen deiner Werte (Angriff, Magie oder Verteidigung) um 10% für eine Minute.
        |
        | Welches Item möchtest du verwenden? (1/2):
    """.trimMargin()
        )

        when (readln()) {
            "1" -> {
                val anzahl = beutel.items.getOrDefault("Heiltrank", 0)
                if (anzahl > 0) {
                    val geheiltePunkte = (maxLebenspunkte - lebenspunkte) / 2
                    lebenspunkte += geheiltePunkte
                    beutel.items["Heiltrank"] = anzahl - 1
                    println("Ein warmes Gefühl durchströmt dich, während du $geheiltePunkte Lebenspunkte wiederherstellst!")
                } else {
                    println("Leider hast du keinen Heiltrank mehr in deinem Beutel!")
                }
            }

            "2" -> {
                val anzahl = beutel.items.getOrDefault("Vitamine", 0)
                if (anzahl > 0) {
                    println(
                        """
                    |Die Vitamine versprechen, einen deiner Werte zu stärken. Welchen möchtest du steigern?
                    | 1. Angriff
                    | 2. Magie
                    | 3. Verteidigung
                """.trimMargin()
                    )

                    val gewaehlterWert: String
                    val urspruenglicherWert: Int

                    when (readln()) {
                        "1" -> {
                            gewaehlterWert = "Angriff"
                            urspruenglicherWert = angriff
                            angriff = (angriff * 1.10).toInt()
                            println("Deine Muskeln fühlen sich gestärkt an! Dein Angriffswert steigt für eine Minute!")
                        }

                        "2" -> {
                            gewaehlterWert = "Magie"
                            urspruenglicherWert = magie
                            magie = (magie * 1.10).toInt()
                            println("Die magischen Energien in dir wachsen! Dein Magiewert steigt für eine Minute!")
                        }

                        "3" -> {
                            gewaehlterWert = "Verteidigung"
                            urspruenglicherWert = verteidigung
                            verteidigung = (verteidigung * 1.10).toInt()
                            println("Ein Schutzschild umgibt dich! Dein Verteidigungswert steigt für eine Minute!")
                        }

                        else -> {
                            println("Unsicher, welchen Wert du steigern möchtest, nimmst du die Vitamine nicht ein.")
                            return
                        }
                    }
                    beutel.items["Vitamine"] = anzahl - 1


                    var sekundenVerbleibend = 60
                    val countdown = scheduler.scheduleAtFixedRate({
                        print("\rNoch ${sekundenVerbleibend--} Sekunden bis die Wirkung der Vitamine nachlässt.")
                        if (sekundenVerbleibend < 0) {
                            scheduler.shutdown()
                            println()
                        }
                    }, 1, 1, TimeUnit.SECONDS)


                    scheduler.schedule({
                        countdown.cancel(true)
                        when (gewaehlterWert) {
                            "Angriff" -> angriff = urspruenglicherWert
                            "Magie" -> magie = urspruenglicherWert
                            "Verteidigung" -> verteidigung = urspruenglicherWert
                        }
                        println("Die Wirkung der Vitamine lässt nach. Dein $gewaehlterWert kehrt zum ursprünglichen Wert zurück.")
                    }, 60, TimeUnit.SECONDS)
                } else {
                    println("Leider hast du keine Vitamine mehr in deinem Beutel!")
                }
            }
        }
    }
}
