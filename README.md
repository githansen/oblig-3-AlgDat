# Obligatorisk oppgave 3 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende student:
Johan Hustoft Hansen, S349880, s349880@oslomet.no


# Oppgavebeskrivelse

I oppgave 1 så gikk jeg frem ved å kopiere inn programkode 5.2.3 a) slik oppgaven foreslo. Den eneste endringen som måtte gjøres var å bruke konstruktøren som setter foreldrenoden samtidig. Endringen fra programkoden er gjort på linje 98.

I oppgave 2: 
Inneholder(): Allerede ferdig laget, men prinsippet i den metoden kan brukes for antall();  her brukes det at det er et binært søketre, hvor høyrenoden må være større eller lik forelderen, og venstrenoden må være mindre enn forelderen. Gjør derfor tester hvor nåværende verdi sammenlignes med verdien det søkes etter, og vi flytter nåværende node etter hva resultatet av sammenligningen blir. Dersom verdien finnes returneres true, om ikke returneres false. 
antall(T verdi) som oppgaven ber meg om  å lage, benytter seg av samme prinsippet som inneholder(). Forskjellen her er at jeg istedenfor å returnere true/false oppretter en tellevariabel hvor jeg legger til 1 hver gang jeg finner en verdi som er lik den jeg søker etter. Dersom jeg finner verdien som søkes etter, fortsetter jeg å gå gjennom treet, altså videre til høyrebarnet til jeg er ute av treet.


Oppgave 3: 
førstePostOrden(); 
Her følges prinsippet fra programkode 5.1.7 h). Den første noden i post orden er noden hvor det ikke går an å gå til venstre eller høyre. Jeg starter i roten og sjekker først om noden har et venstre-barn. Dersom den har det, går jeg dit. Dersom den ikke har et venstrebarn, sjekker jeg om den har et høyrebarn og går dit hvis den har det. Når det ikke finnes et høyre eller et venstrebarn har jeg funnet noden.

nestePostOrden();
Følger instruks som står i kap. 5.1.7. i kompendiet: 
Hvis p ikke har en forelder (p er rotnoden), så er p den siste i postorden.
Hvis p er høyre barn til sin forelder f, er forelderen f den neste.
          Hvis p er venstre barn til sin forelder f, gjelder:
Hvis p er enebarn (f.høyre er null), er forelderen f den neste.
Hvis p ikke er enebarn (dvs. f.høyre er ikke null), så er den neste den noden som kommer først i postorden i subtreet med f.høyre som rot.


Oppgave 4: 
    postorden(Oppgave<?superT>oppgave): 
Her har oppgaveteksten gitt en relativt god instruks for hvordan den skal implementeres. Jeg starter med å bruke førstepostorden() fra forrige oppgave. 
Lager så en loop som kjører mens nåværende node er ulik null. Oppgaven utføres først, og deretter settes noden til neste i postorden. Det gjøres ved hjelp av den andre metoden fra forrige oppgave, nestePostOrden.

Oppgave 5: 
Serialize(): 
I videoforelesning fra uke 42, ble det gjennomgått hvordan man kan skrive ut et tre i nivå-orden ved å bruke en kø. Metoden serialize bruker det samme prinsippet. Men istedenfor å skrive ut verdier i slutten av loopen, legges nodeverdien inn i en ArrayList som returneres etter at hele treet er gått gjennom. Loopen starter ved å ta ut første node fra køen, og legge til venstrebarnet først og deretter høyrebarnet i køen dersom de eksisterer. På slutten legger vi til verdien i tabellisten. 

Deserialize(): 
Denne metoden er enkel å implementere. Jeg starter med å opprette et tomt binærtre, for så å legge til verdier i det treet. Starter fra indeks 0 til jeg har gått gjennom hele arrayet. 

Oppgave 6: 
public boolean fjern(T verdi): 
Slik oppgaven foreslo, har jeg kopiert programkode 5.2.8 d) med noen endringer.
Endringene som er gjort er at jeg har satt forelder-noden riktig i tilfellene hvor noden som skal fjernes er venstre eller høyrebarnet. Ellers blir foreldrenoder satt korrekt. Endringene er gjort i linje 138-139 og 144-145.  

public int fjernalle(): 
Bruker en whileløkke og kjører metoden over inntil verdien ikke finnes i treet lenger (returnerer false). Har samtidig en tellevariabel som teller hvor mange ganger metoden kjøres med true som resultat.

public void nullstill():
Bruker samme prinsipp som de rekursive traverseringsmetodene vi har sett på i kompendiet og forelesninger. Men istedenfor å utføre en oppgave, som f.eks å skrive ut verdier, setter vi nodenes pekere og verdier lik null. 
