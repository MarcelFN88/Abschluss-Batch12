Beutel-Klasse
Die Beutel-Klasse repräsentiert einen Beutel, der von einem Helden verwendet wird, um verschiedene Gegenstände zu speichern und zu benutzen.
Eigenschaften
heiltraenke: Die Anzahl der Heiltränke im Beutel.
vitamine: Die Anzahl der Vitamine im Beutel.
Methoden
benutzeHeiltrank(held: Held)
Diese Methode ermöglicht es dem Helden, einen Heiltrank aus dem Beutel zu benutzen. Wenn noch Heiltränke im Beutel vorhanden sind, wird der Held um 30% seiner maximalen Lebenspunkte geheilt. Die Anzahl der Heiltränke im Beutel wird um eins verringert.
benutzeVitamine(held: Held)
Diese Methode ermöglicht es dem Helden, Vitamine aus dem Beutel zu benutzen. Wenn noch Vitamine im Beutel vorhanden sind, wird die Verteidigung des Helden für die nächsten 3 Runden um 20% erhöht. Die Anzahl der Vitamine im Beutel wird um eins verringert.
zeigeInventar()
Diese Methode zeigt den Inhalt des Beutels an. Sie gibt die Anzahl der Heiltränke und Vitamine im Beutel aus.
waehleUndBenutze(held: Held)
Diese Methode ermöglicht es dem Helden, einen Gegenstand aus dem Beutel auszuwählen und zu benutzen. Der Benutzer wird aufgefordert, eine Auswahl zu treffen, indem er die entsprechende Zahl eingibt. Wenn der Benutzer "1" eingibt, wird die Methode benutzeHeiltrank aufgerufen, wenn der Benutzer "2" eingibt, wird die Methode benutzeVitamine aufgerufen. Bei einer ungültigen Auswahl wird eine entsprechende Fehlermeldung ausgegeben.
fuegeHinzu(gegenstand: String)
Diese Methode ermöglicht es, einen Gegenstand zum Beutel hinzuzufügen. Der Methode wird der Name des Gegenstands als Parameter übergeben. Wenn der Gegenstand "Heiltrank" ist, wird die Anzahl der Heiltränke im Beutel erhöht. Wenn der Gegenstand "Vitamine" ist, wird die Anzahl der Vitamine im Beutel erhöht. Bei einem unbekannten Gegenstand wird eine entsprechende Fehlermeldung ausgegeben.