# Roll-the-dice - Gra w kości

Kosta w projekcie zakłada użycie kostki z ilością oczek od 1 do 100.
Kod takiej kostki wygląda następująco:

xDy+z

gdzie:

y – rodzaj kostek, których należy użyć (np. D6 - Dice with 6 eyelets, D10)<br>
x – liczba rzutów kośćmi (jeśli rzucamy raz, ten parametr jest pomijalny),<br>
z – (opcjonalnie) liczba, którą należy dodać (lub odjąć) do wyniku rzutów.<br>

Przykłady:<br>
2D10+10 – 2 rzuty D10, do wyniku dodaj 10,<br>
D6 – zwykły rzut kostką sześcienną,<br>
2D3 – rzut dwiema kostkami trójściennymi,<br>
D12-1 – rzut kością D12, od wyniku odejmij 1.<br>

## Jak uruchomić 
Należy uruchomić będąc w katalogu ./src polecenia w terminalu:

```
 javac pl/game/DiceGame.java 
 java pl.game.DiceGame
```
