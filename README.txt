Gheorghisor Ileana-Teodora
323 CA
*******************************************************************************
                   Santa Claus is coming to ACS students

    Desi nu am facut la timp etapa 1, am reusit sa termin proiectul pentru
etapa a 2-a si voi incerca sa punctez ce am facut pentru prima parte a
proiectului, apoi sa detaliez ce am implementat ulterior.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Etapa 1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    Am facut o clasa pentru fiecare element major din lista care se citeste.
Am adaptat ierarhia claselor in functie de cea din fisierele json date, pentru
a fi mai usor sa fac citirea. Am mai facut clasa "ChildOut" pentru afisarea
copiilor in modul cerut, cat si alte clase precum "InitialData", "Input" care
ma ajuta sa parcurg datele initiale.
    Functionalitatea codului este facuta in "Implementare", cu metoda "start"
a carei dimensiune nu am putut sa o reduc sub 150 de linnii, desi am incercat
sa pun codul duplicat in diferite metode mai mici.
    In rest, codul urma structura:

- Fac deep copy-uri pentru toate tipurile de liste.

    Runda 0.
- Sortez lista de copii dupa id-uri pentru a avea calculele corecte.
- Gasesc categoria de varsta a copiluluil si setez ce trebuie.
- Calculez suma scorurilor average de la toti copiii.
- Calculez bugetul unitar.
- Calculez bugetul alocat fiecarui copil.
- Urmeaza distribuirea cadourilor.
- Sortez cadourile dupa pret.

    De la runda 1 in sus:
- Reinitializez variabilele folosite.
- Incrementez varsta copiilor.
- Gasesc categoria de varsta a copiluluil si setez ce trebuie.
- Daca copilul e Young Adult, il scot din output.
- Urmeaza distribuirea cadourilor.
- Setez nice score-ul si updatez lista de preferinte de cadouri.
- Scot duplicatele din lista de preferinte.
- Sortez lista de copii dupa id-uri pentru a avea calculele corecte.
- Gasesc categoria de varsta a copilului si setez ce trebuie.
- Calculez suma scorurilor average de la toti copiii.
- Calculez bugetul unitar si bugetul alocat fiecarui copil.
- Urmeaza distribuirea cadourilor si sortez cadourile dupa pret.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Etapa 2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    Odata ce am terminat cu etapa 1, a fost relativ usor sa adaug noutatile de
la etapa 2. Am adaugat noile instante in clasele existente si am creat
"GiftOut" pentru ca trebuia de data aceasta sa afisez diferit si cadourile
primite de copii. Nu am mai modificat numele claselor din romana in engleza
din lipsa de timp, asa ca in incercarea mea de a elimina toate warning-urile,
nu am reusit sa elimin si erorile de spelling.

~~~~Nice Score Bonus~~~~
    Pentru implementarea acestuia am folosit metoda "avgScoreBonus" in care
ii modificam copilului dat ca parametru nice scorul dupa formula cea noua.

~~~~~~~~~Elves~~~~~~~~~~
    Pentru elful WHITE nu am facut nicio modificare.
    Pentru elfii BLACK si PINK am facut metoda "elfBlackPink" care trece prin
toata lista de copii cu care lucrez data ca parametru, alaturi de unitatea de
buget calculata precedent pentru a modifica cu +/- 30% bugetul alocat copiilor.
    Pentru elful YELLOW de asemenea am creat o metoda "elfYellow", care primind
atat lista de copii cat si lista de cadouri, ii cauta pe cei care nu au primit
niciun cadou si le daruieste cadoul cel mai ieftin din categoria preferata,
conform enuntului.

~~~~~~~Strategy~~~~~~~~~
    Pentru ID nu am facut nimic special, intrucat ordonez crescator copiii in
functie de ID-ul lor de mai multe ori pe parcursul implementarii pentru a ma
asigura ca toate calculele se desfasoara corect.
    Pentru niceScore, am facut un comparator al copiilor in functie de
nice score-ul lor, pe care ulterior l-am simplificat folosind utilitatea
inteliji-ului.
    Pentru niceScoreCity a fost putin mai greut, intrucat a trebuit sa mai
adaug acest element in clasa de copii, sa-l calculez, apoi sa ordonez copiii
in functie de el precum in cazul precedent. Aici insa a mai intervenit si
ordonarea oraselor lexicografic, pentru care am creat un toString in enums-ul
Cities, urmat de alte cateva comparatoare simplificate de inteliji.

~~~~~Design Patterns~~~~~
    Am facut doar doua design pattern-uri, un Singleton pentru "Implementare"
pe care il apelez din main.
    Celalalt este un Builder al clasei "Copii" pe care il folosesc pentru a
copia in lista "eligibil" elementele listei initiale de copii, dar din care
ii sterg pe cei care au peste 18 ani.

*******************************************************************************
