# Antworten zu den Übungsblättern

## Blatt 1
### Aufgabe 1.1

Als Entwurfsmuster für diese Aufgabe eignet sich das "Abstract Factory"-Pattern am besten.
Denn durch das Translator-Interface können die Vorgaben an einen Translator vorgegeben werden, die tatsächliche
Implementierung kann jedoch bei jedem Translator einzel bestimmt werden. Dieser Ansatz ermöglicht die
Erstellung weiterer Translator (z.B. French-, English-, etc) mit den vorgeschriebenen Methoden des Interfaces.
Die tatsächliche Implementierung muss aber natürlich bei jedem Translator für die jeweilige Sprache geschehen.

Man könnte den Source Code des Interfaces durch das Werfen einer Exception bei den Methoden erweitern, was
potenziell eine übersichtlichere und einfache Fehlerbehandlung ermöglicht.

### Aufgabe 1.3

Die Vorteile einer separaten Testklasse sind zum einen eine bessere Lesbarkeit und Übersicht, zum anderen
lassen sich die Tests schnell und einfach anpassen oder ergänzen. Des Weiteren beeinflussen Fehler in der
Testklasse nicht den eigentlichen Source Code und die Dokumentation des Tests ist einfacher.

Äquivalenzklassen fassen die zahlreichen Eingabemöglichkeiten/-werte in Gruppen zusammen, sodass aus
jeder Gruppe meist nur ein Repräsentant getestet werden muss und dessen Ergebnis dann für alle anderen
Gruppen Elemente gilt. Eine Ausnahme hier sind Grenzwerte, diese Werte können öfters in einer Äquivalenzklasse
vorkommen, müssen aber explizit getestet werden. Außerdem können durch Klassen gültige Eingaben und ungültigen klar 
getrennt werden.   

Die Client-Klasse erzeugt den GermanTranslator nicht direkt, sondern greift nur über das Translator Interface
auf die Translator-Implementierungen zu. Bedeutet die Client-Klasse ist abhängig von externen Objekten die erst
zur Laufzeit bereitgestellt werden. Da ist es sinnvoller, den Translator direkt zu testen.~~


## Blatt 2 
### Aufgabe 2 FA3
Der frei wählbare String als Fehlerbehandlung eignet sich nur bedingt. Zum einen kann der Fehler leichter ignoriert
werden, zum anderen wird so keine eindeutige Fehlerbehandlung garantiert. Würde stattdessen eine Exception geworfen
werden, kann eine feste Fehlerbehandlung implementiert werden, die mit diesem Fall umgeht und den Nutzer im Zweifel
konsequent über den Fehler informiert.

