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
