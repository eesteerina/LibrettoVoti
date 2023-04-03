package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		
		Libretto lib = new Libretto();
		
		lib.add(new Voto("Analisi I", 29, LocalDate.of(2021, 2, 15)));
		lib.add(new Voto("Fisica I", 21, LocalDate.of(2021, 6, 13)));
		lib.add(new Voto("Fisica III", 23, LocalDate.of(2021, 7, 12)));
		
		lib.stampa();
		lib.stampaPuntiUguali(25);
		Voto v = lib.cercaVotoPerNome("Analisi I");
		Voto a1bis = new Voto("Analisi I", 29, LocalDate.of(2021, 2, 15));
		Voto a1ter = new Voto("Analisi I", 30, LocalDate.of(2021, 2, 15));
		System.out.println(v);
		if(lib.esisteVoto(v) == true) {
			System.out.println("Il voto esiste già");
		}
		else {
			System.out.println("Voto non ancora inserito");
		}
		
		Voto votoConflitto = new Voto("Analisi I", 22, LocalDate.of(2021, 2, 15));
		
		System.out.println("C'è conflitto tra due voti? " + lib.conflittoConAltroVoto(votoConflitto));
		lib.add(new Voto("Informatica", 25, LocalDate.of(2023, 7, 10)));
		try {
			lib.add(new Voto("Informatica", 25, LocalDate.of(2023, 7, 10)));
		} catch(IllegalArgumentException e) {
			System.out.println("Errore nell'inserimento voto.");
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nLIBRETTO ORIGINARIO");
		lib.stampa();
		
		//lib.cancellaVotiInferiori(24);
		
		Libretto migliore = lib.librettoMigliorato();
		System.out.println("\nLIBRETTO MIGLIORATO");
		migliore.stampa();
		
		System.out.println("\nLIBRETTO ORDINATO ALFABETICAMENTE");
		lib.librettoOrdinatoAlfabeticamente().stampa();
		
		System.out.println("\nLIBRETTO ORDINATO PER VOTO");
		lib.librettoOrdinatoPerVoto().stampa();

	}

}
