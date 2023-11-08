## Übersicht

Dieses textbasierte Rollenspiel, entwickelt in Kotlin, lässt Spieler in ein Abenteuer eintauchen, in dem sie zwischen verschiedenen Modi wählen, einen Helden aufbauen und in Kämpfen antreten können. Das Spiel läuft in IntelliJ IDEA und bietet eine einfache Benutzeroberfläche mit textbasierten Befehlen.

## Hauptfunktionen

- **Spielstart**: Wählen Sie zwischen Einzel- und Teammodus zu Beginn des Spiels.
- **Hauptmenü**: Starten Sie ein neues Spiel, laden Sie einen Spielstand oder löschen Sie einen vorhandenen.
- **Helden-Management**: Erstellen und verwalten Sie Ihren Helden mit verschiedenen Fähigkeiten.
- **Training und Kämpfe**: Trainieren Sie Ihren Helden oder ziehen Sie gegen Bösewichte in die Schlacht.
- **Sound-Wiedergabe**: Für ein immersives Erlebnis können Sie Soundeffekte abspielen lassen.
- **Rundenbasierter Kampf**: Treffen Sie strategische Entscheidungen im Kampf gegen Ihre Gegner.


## Spielablauf

1. Das Spiel beginnt im Hauptmenü, wo die Spieler die Option haben, ein neues Spiel zu starten, einen Spielstand zu laden oder einen Spielstand zu löschen.
2. Nachdem ein neues Spiel gestartet oder ein Spielstand geladen wurde, gelangen die Spieler ins Teammenü, wo sie ihr Team trainieren, in den Kampf ziehen oder das Spiel speichern und beenden können.
3. Während des Trainings können Spieler einen Helden aus ihrem Team auswählen, um seine Fähigkeiten zu verbessern.
4. Beim Start eines Kampfes wird ein Bösewicht zufällig erstellt, und der Kampf findet rundenbasiert statt.
5. Die Spieler können ihren Helden wählen, um anzugreifen, sich zu verteidigen oder Gegenstände aus ihrem Beutel zu verwenden.
6. Der Kampf endet, wenn entweder alle Helden besiegt sind oder der Bösewicht besiegt wurde.

## Hinweise

- Vor dem Start des Spiels stellen Sie sicher, dass die Sounddatei `sunrise.wav` im gleichen Verzeichnis vorhanden ist.
- Die Konsolenausgabe verwendet ANSI-Farbcodes, um Textfarben für verschiedene Elemente des Spiels zu ändern.
- Die Spielstanddateien werden im aktuellen Verzeichnis gespeichert und haben die Endung `.txt`.

Viel Spaß beim Spielen!

## Funktionen

### `erstelleBoesewicht()`
Erstellt einen neuen Bösewicht für das Spiel. Es wird zufällig entschieden, ob es sich um einen Drachen oder einen dunklen Magier handelt.

### `starteSpielUndTeamMenu(team: List<Held>? = null)`
Startet das Spiel und zeigt das Teammenü an. Benutzer können ein neues Team erstellen oder ein vorhandenes Team nutzen.

### `teamTraining(team: List<Held>)`
Ermöglicht einem Held aus dem Team, durch Training stärker zu werden.

### `speichern(team: List<Held>)`
Speichert den aktuellen Spielstand in einer Textdatei.

### `laden(): List<Held>?`
Lädt einen Spielstand aus einer Textdatei.

### `spielstaendeLoeschen()`
Löscht einen vorhandenen Spielstand.

### `hauptMenuTeam()`
Zeigt das Hauptmenü des Spiels an und ermöglicht dem Benutzer, ein neues Spiel zu starten, einen Spielstand zu laden oder einen Spielstand zu löschen.

### `starteRundenbasiertenKampf(team: List<Held>, boesewicht: Boesewicht, beutel: Beutel)`
Beginnt einen rundenbasierten Kampf zwischen dem Team des Spielers und einem Bösewicht.

### `rundenbasierterKampfTeam(team: List<Held>, boesewicht: Boesewicht, beutel: Beutel)`
Verwaltet den Ablauf eines rundenbasierten Kampfes, wobei das Team und der Bösewicht abwechselnd Aktionen ausführen.






- **Start**: Initialisieren Sie das Spiel mit der `Start()`-Funktion.
- **Navigation**: Benutzen Sie die Konsole zur Navigation im Menü.
- **Kampf**: Folgen Sie den Anweisungen auf dem Bildschirm während der Kampfszenen.

## Funktionen im Detail

### `Start()`
- Startpunkt des Spiels mit der Auswahl des Spielmodus.
- Bei ungültiger Eingabe wird der Benutzer erneut zur Eingabe aufgefordert.

### `hauptMenu()`
- Hauptmenüführung mit Optionen zum Spielstart, Laden und Löschen eines Spielstandes.
- Erstellung oder Laden eines Helden basierend auf der Nutzereingabe.

### `menu(held: Held)`
- Das Hauptmenü für verschiedene Aktivitäten wie Training oder Kampf.
- Der Kampf wird durch einen generierten Bösewicht initiiert.

### `playSound(soundFileName: String)`
- Spielt eine Sounddatei ab. Fehler werden auf der Konsole ausgegeben.

### `rundenbasierterKampf(held: Held, boesewicht: Boesewicht, beutel: Beutel)`
- Ein rundenbasierter Kampfmechanismus, bei dem der Spieler verschiedene Aktionen auswählen kann.
- Lebenspunkte werden nach jeder Runde aktualisiert und der Fortschritt des Kampfes wird angezeigt.

## Hinweise

- Nutzen Sie die einfache Texteingabe zur Spielsteuerung.
- Der Erfolg im Spiel hängt vom strategischen Einsatz von Heldenattributen und Beutelinhalt ab.
- Fortschritte können gespeichert werden, um bei der nächsten Sitzung fortzufahren.

Viel Spaß beim Spielen!





## Klasse `Held`

Die `Held` Klasse ist das Herzstück des Spiels. Sie definiert die Eigenschaften und Fähigkeiten eines Helden.

### Eigenschaften

- `name`: Der Name des Helden.
- `lebenspunkte`: Die aktuellen Lebenspunkte des Helden.
- `maxLebenspunkte`: Die maximalen Lebenspunkte des Helden.
- `angriff`: Die Angriffskraft des Helden.
- `magie`: Die magischen Fähigkeiten des Helden.
- `verteidigung`: Die Verteidigungskraft des Helden.

### Methoden

- `temporaereVerteidigungErhoehen(runden)`: Erhöht die Verteidigung des Helden temporär für eine bestimmte Anzahl an Runden.
- `aktualisiereVerteidigung()`: Aktualisiert die Verteidigung des Helden, wenn der temporäre Bonus ausläuft.
- `speichern()`: Speichert den aktuellen Zustand des Helden in einer Datei.
- `laden()`: Lädt einen Helden aus einer Datei.
- `spielstaendeLoeschen()`: Löscht gespeicherte Spielstände.
- `erzeugeUndInitialisiereHelden()`: Erzeugt einen neuen Helden und führt die initiale Konfiguration durch.
- `heldenErstellen()`: Startet den Prozess des Heldenerschaffens und lässt den Spieler einen Namen wählen.
- `training()`: Ermöglicht es dem Helden, seine Fähigkeiten zu verbessern.
- `zeigeStatus()`: Zeigt den aktuellen Status des Helden an.
- `angreifen(gegner)`: Führt einen Angriff gegen einen Gegner aus.







# Krieger Klasse

Die `Krieger` Klasse ist ein Teil des Abenteuerspiels und repräsentiert einen Helden mit speziellen Fähigkeiten und Attributen. Als Unterklasse von `Held`, besitzt `Krieger` zusätzliche Methoden und Eigenschaften, die das Kämpfen und Verteidigen innerhalb des Spiels ermöglichen.

## Features

- **Helden Erstellung:** Generiert einen Krieger mit einem zufälligen Namen und spezifischen Attributen.
- **Angriffsmethoden:** Ermöglicht dem Krieger verschiedene Angriffsarten gegen Bösewichte zu verwenden.
- **Verteidigung:** Die Fähigkeit, sich zu verteidigen und temporär die Verteidigung zu erhöhen.
- **Runden Update:** Aktualisiert den Status des Kriegers nach jeder Runde.

## Nutzung der Krieger Klasse

Die `Krieger` Klasse wird automatisch durch die Spiellogik verwendet, wenn ein neuer Held erstellt wird. Die Interaktion erfolgt über die Konsole, in der Sie unterschiedliche Aktionen während Ihres Zuges auswählen können.

## Beitrag

Fühlen Sie sich frei, zu diesem Projekt beizu



## Klasse `Magier`

Die `Magier`-Klasse ist eine Erweiterung der `Held`-Klasse und repräsentiert einen magischen Charakter mit spezifischen Fähigkeiten und Attributen. Zu diesen Attributen gehören Lebenspunkte, Angriff, Magie und Verteidigung. Ein `Magier` kann Angriffe ausführen, sich verteidigen und hat zusätzliche magiebezogene Methoden.

### Funktionen

- `heldenErstellen()`: Initialisiert den Magier mit einem einzigartigen Namen und setzt die Grundwerte für Lebenspunkte, Angriff, Magie und Verteidigung.
- `angreifen(gegner: Boesewicht)`: Erlaubt dem Magier, einen von mehreren Zaubersprüchen auszuwählen, um den Gegner anzugreifen.
- `verteidigen()`: Erhöht die Verteidigung des Magiers temporär, wenn sie nicht bereits erhöht wurde.
- `rundenUpdate()`: Aktualisiert den Status der Verteidigung nach jeder Runde.
- `temporaereVerteidigungErhoehen(runden: Int)`: Erhöht die Verteidigung des Magiers temporär für eine bestimmte Anzahl von Runden.
- `aktualisiereVerteidigung()`: Aktualisiert die Verteidigung des Magiers, wenn die temporäre Erhöhung abgelaufen ist.



Manipulator

Überblick

Die Klasse Manipulator ist eine Erweiterung der Basisklasse Held und implementiert spezielle Funktionen für einen Charakter im Spielkontext, der manipulative Fähigkeiten besitzt. Diese Klasse bietet Methoden zur Erstellung eines Helden, zum Angreifen von Gegnern mit verschiedenen manipulativen Fähigkeiten, zur Verteidigung und zur Aktualisierung der Heldenattribute mit jeder Runde.

Funktionen

heldenErstellen(): Initialisiert einen neuen Helden mit einem einzigartigen Namen und festgelegten Attributen.
angreifen(gegner: Boesewicht): Bietet dem Spieler eine Auswahl an manipulativen Fähigkeiten, um gegen den Bösewicht zu kämpfen.
berechneSchaden(basisSchaden: Int, wert: Int): Berechnet den verursachten Schaden basierend auf dem magischen Wert und zusätzlichen Boni.
verteidigen(): Erhöht die Verteidigung des Helden temporär.
rundenUpdate(): Aktualisiert die Runden-basierten Effekte auf den Helden.
temporaereVerteidigungErhoehen(runden: Int): Erhöht die Verteidigung des Helden für eine bestimmte Anzahl von Runden.
aktualisiereVerteidigung(): Aktualisiert den Verteidigungsstatus nach Ablauf temporärer Boni.



# Beutel-Klasse

Die `Beutel`-Klasse ist ein wesentlicher Bestandteil des Inventar-Systems im Rollenspiel. Sie verwaltet die Gegenstände, die ein Spielercharakter bei sich tragen kann, speziell Heiltränke und Vitamine.

## Funktionen

- `zeigeInventar()`: Gibt eine Übersicht über die aktuell im Beutel vorhandenen Gegenstände aus.
- `waehleUndBenutze(held: Held)`: Ermöglicht dem Spieler, einen Gegenstand aus dem Beutel auszuwählen und zu benutzen.
- `fuegeHinzu(gegenstand: String)`: Fügt einen Gegenstand zum Beutel hinzu, sofern dieser bekannt ist.

## Gegenstände

### Heiltränke

- Beim Verwenden eines Heiltranks wird der Lebenspunktestand des Helden um 30% seiner maximalen Lebenspunkte erhöht.
- Die Anzahl der Heiltränke wird im Beutel verfolgt und bei Benutzung verringert.
- Wenn keine Heiltränke mehr vorhanden sind, wird eine entsprechende Nachricht ausgegeben.

### Vitamine

- Vitamine erhöhen temporär die Verteidigung des Helden um 20% für die nächsten 3 Runden.
- Ähnlich wie Heiltränke wird ihre Anzahl im Beutel geführt und bei Gebrauch dekrementiert.
- Ist kein Vitamin mehr vorrätig, wird der Spieler darüber informiert.

## Nutzung

Die `waehleUndBenutze` Funktion erlaubt es dem Spieler, über eine einfache Texteingabe (1 für Heiltränke, 2 für Vitamine) einen Gegenstand zu nutzen. Eine unpassende Eingabe führt dazu, dass der Spieler seine Aktion für die Runde verliert.

## Hinweise zur Implementierung

- Die Funktionen `benutzeHeiltrank` und `benutzeVitamine` sind als private deklariert, da sie ausschließlich intern von der `waehleUndBenutze` Funktion aufgerufen werden sollten.
- Es wird empfohlen, die Klassen `Held` und `Beutel` weiter zu modularisieren, um die Wartbarkeit und Erweiterbarkeit des Codes zu verbessern.

Bitte beachten Sie, dass die `Held`-Klasse entsprechende Funktionen bereitstellen muss, um die Heilung und Verteidigungsverstärkung korrekt zu verarbeiten.

## Zukünftige Erweiterungen

- Erweiterung der Gegenstandsliste um weitere Items wie Zaubertränke, Buff-Food etc.
- Implementierung eines Systems zur Dauerhaftigkeit von Gegenständen.
- Möglichkeit zur Interaktion mit anderen Inventar-Systemen oder Händlern im Spiel.



# Boesewicht-Klasse

Die `Boesewicht`-Klasse repräsentiert einen Gegner im Spiel, mit dem der Held konfrontiert werden kann. Die Klasse enthält Informationen über Lebenspunkte, Angriffsstärke, Magie, Verteidigung und Zustände wie Lähmung und temporäre Verteidigungserhöhungen.

## Eigenschaften

- `name`: Der Name des Bösewichts, inklusive eines Titels.
- `lebenspunkte`: Die aktuellen Lebenspunkte des Bösewichts.
- `maxLebenspunkte`: Die maximalen Lebenspunkte des Bösewichts.
- `angriff`: Der Angriffswert des Bösewichts.
- `magie`: Der Magiewert des Bösewichts.
- `verteidigung`: Der Verteidigungswert des Bösewichts.
- `laehmung`: Ein Zustand, der anzeigt, ob der Bösewicht gelähmt ist oder nicht.

## Methoden

- `druckeEigenschaften()`: Gibt die Eigenschaften des Bösewichts formatiert in der Konsole aus.
- `angreifen(gegner: Held)`: Wählt eine Angriffsart aus und verursacht entsprechenden Schaden am Helden.
- `berechneSchaden(basisSchaden: Int, wert: Int)`: Berechnet den Schaden, der einem Held zugefügt wird.
- `erleideSchaden(schaden: Int)`: Verringert die Lebenspunkte des Bösewichts, wenn er Schaden erleidet.
- `verteidigen()`: Erhöht temporär die Verteidigung des Bösewichts.
- `rundenUpdate()`: Aktualisiert den Status des Bösewichts am Ende jeder Runde, z.B. die Reduzierung der Bonusverteidigung.

## Statik- und Companion-Objekte

- Farbcodes werden zur Formatierung der Ausgabe in der Konsole verwendet.
- Die `erzeugeBoesewicht()`-Methode erzeugt zufällig einen neuen Bösewicht mit vordefinierten Namen und Eigenschaften.
- `lebenspunkteFarbe()` wird verwendet, um die Lebenspunkte visuell in Abhängigkeit von ihrem Verhältnis zu den maximalen Lebenspunkten darzustellen.

## Gameplay-Mechaniken

Der Bösewicht kann verschiedene Angriffe ausführen und sich verteidigen, was das Kampfsystem dynamisch und unvorhersehbar macht. Die Methoden zur Schadensberechnung und Verteidigung ermöglichen eine tiefe Integration in das Kampfsystem des Spiels.

## Erweiterungsmöglichkeiten

- Neue Angriffs- und Verteidigungsmechanismen können hinzugefügt werden, um die Vielfalt der Bösewichte zu erhöhen.
- Die Klasse kann erweitert werden, um spezielle Fähigkeiten oder Zaubersprüche für bestimmte Bösewichte zu implementieren.
- Interaktionen mit Umgebungselementen oder Ereignissen im Spiel könnten weitere strategische Tiefe ins Spiel bringen.

## Hinweise zur Implementierung

- Die `Held`-Klasse muss so gestaltet sein, dass sie mit der `Boesewicht`-Klasse interagieren kann, insbesondere im Hinblick auf Angriffs- und Verteidigungsmethoden.
- Anpassungen an der Lebenspunkte-Logik sollten bedacht werden, um mit speziellen Zuständen wie Lähmungen oder Buffs/Debuffs umzugehen.

Die `Boesewicht`-Klasse bildet das Rückgrat der Gegnerlogik in diesem Rollenspiel und soll für eine herausfordernde Spielerfahrung sorgen.


# Drachen-Modul

Das Drachen-Modul bietet eine Implementierung eines Drachen-Gegners für ein textbasiertes Rollenspiel.

## Klasse: Drache

Die Klasse `Drache` erbt von der Basisklasse `Boesewicht` und implementiert einen Drachen mit individuellen Fähigkeiten und Angriffsverhalten.

### Eigenschaften

- `name`: Der Name des Drachens.
- `maxLebenspunkte`: Die maximalen Lebenspunkte des Drachens, initialisiert mit 2500.
- `lebenspunkte`: Die aktuellen Lebenspunkte des Drachens, die nicht unter 0 fallen können.
- `angriff`: Der Angriffswert des Drachens, festgelegt auf 100.
- `verteidigung`: Die Verteidigung des Drachens, initialisiert mit 50.
- `geschwindigkeit`: Die Geschwindigkeit des Drachens, festgelegt auf 80.

### Methoden

- `erstelleDrache()`: Eine Begleiter-Funktion, die eine neue Instanz des Drachens erstellt.
- `entscheideAktion()`: Entscheidet zufällig, ob ein normaler oder spezieller Angriff durchgeführt wird.
- `angreifen()`: Führt einen Angriff gegen ein Team von Helden aus, indem es zwischen verschiedenen Angriffen wählt.
- `spezialAngriff()`: Ein starker Angriff, der auf alle Mitglieder des gegnerischen Teams angewendet wird.
- `verteidigen()`: Erhöht die Verteidigung des Drachens für die nächsten zwei Runden, falls diese nicht bereits erhöht wurde.

### Spezialverhalten

- Der Drache entscheidet bei jedem Angriff zufällig, ob ein normaler Angriff (`80%` Chance) oder ein spezieller Angriff (`20%` Chance) durchgeführt wird.
- Der spezielle Angriff, die "Drachenwut", fügt jedem Helden im gegnerischen Team Schaden zu.
- Die Verteidigung des Drachens kann temporär erhöht werden, was für zwei Runden anhält.

## Integration

Um den Drachen in dein Spiel zu integrieren, kannst du die Methode `erstelleDrache()` verwenden, um eine neue Instanz zu erstellen und diese dann in deinem Kampfsystem zu verwenden.
