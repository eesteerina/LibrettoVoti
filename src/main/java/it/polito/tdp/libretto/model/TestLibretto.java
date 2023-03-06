package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		
		Libretto lib = new Libretto();
		
		lib.add(new Voto("Analisi I", 29, LocalDate.of(2021, 2, 15)));
		lib.add(new Voto("Fisica I", 25, LocalDate.of(2021, 6, 13)));
		
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
		

	}

}
