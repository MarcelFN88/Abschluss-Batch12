                Charakter
            /         |        \
          Held    Gegner     Beutel
        /  |  \     /  |  \ 
     Magier Krieger ...  Endgegner  Unterboss

Charakter:
- name: String
- hp: int
- aktionen: Liste<Aktion>

Aktion:
- name: String
- beschreibung: String
- ausführen(): void

Beutel:
- gegenstände: Liste<Gegenstand>
- verwendeGegenstand(gegenstand: Gegenstand): void

Gegenstand:
- name: String
- effekt: void

Held:
- spezifischeHeldEigenschaft1
- spezifischeHeldEigenschaft2

Magier:
- spezifischeMagierEigenschaft

Krieger:
- spezifischeKriegerEigenschaft

...

Gegner:
- spezifischeGegnerEigenschaft1
- spezifischeGegnerEigenschaft2

Endgegner:
- spezifischeEndgegnerEigenschaft

Unterboss:
- spezifischeUnterbossEigenschaft
