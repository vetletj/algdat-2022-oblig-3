# Obligatorisk oppgave 3 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende student:
* Vetle Tønsberg Johansen, S341540, s341540@oslomet.no


# Oppgavebeskrivelse

I oppgave 1 så gikk jeg frem ved å kopiere programkode 5.2.3 a) fra kompendiet, og endret hvordan det ble lagt
til ny node når vi er ute av trret. q er da siste noden vi passerte og dette blir satt til forelderen til p.

I oppgave 2 så brukte jeg en while løkke til å søke gjennom treet, anvendete compare funksjon for å sammenlikne
veriden vi søker etter og verdien til noden. Hvis verdien vi søker etter er mindre går vi til venstre i treet,
hvis verdien er større går vi til høyre, og hvis den er lik så inkremerer vi variable antall_verdi med 1 og går
til hæyre i treet. While løkken kjører fram til vi er ute av treet og returnerer deretter antall_verdi.

I oppgave 3 fulgte jeg egentlig bare forklaring av den første og neste til postorden gitt i kompendium.
Metoden toStringPostOrder() er ferdig programmert, så jeg vet vi sjekker for om treet er tomt først,
vet også at vi sender rotnode til metoden førstePostorden(). førstePostorden kjører en while-løkke fram til 
vi kommer til en node uten noen barn. Fram til vi når denne sjekker vi først venstre barn og hvis det finnes peker
vi til venstre node. Hvis det ikke finnes noe venstre barn peker vi til høyre barn.
Til metoden nestePostorden() vet vi at vi sender først inn førstePostorden(rot) derfor trenger vi ikke å sjekke for
om treet er tomt eller sette en node til rotnode i metoden. Sjekker først om forelder til p er null --> p er siste node 
i postorden (rotnode). Anvedner deretter en hjelpenode f som vi setter til forelderen til p. Hvis p er høyre barn til f 
returnerer vi f da dette er neste i postorden, hvis p er venstre barn til sin forelder f og p er enebarn returnerer vi også f.
Hvis p er venstre barn til sin forelder f og p ikke er enebarn så er den neste i postorden førstePostorden til subtreet med 
med høyre barnet til foreldereb til p som rot.

I oppgave 4, iterativ postorden metode sjekket jeg først om treet var tomt med metoden tom() som allerede var programmert.
Deretter setter jeg ny node, p, til første postorden ved bruk av første postorden metoden programmert i oppgave 1, vidre anvender
jeg en while-løkke som kjører fram til p er lik null, som vil si at vi er ute av treet, ettersom inni løkken kjører vi først oppgaven
men også neste postorden metoden som ble programmert i oppgave 2. Den vil ikke bli null før vi er ute av treet. 
