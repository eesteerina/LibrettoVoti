package it.polito.tdp.libretto.model;

import java.util.*;

public class Libretto {
	
	private List<Voto> voti;

	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}
	
	/**
	 * Aggiungi un nuovo voto al libretto
	 * per ora non fa nessun controllo
	 * @param v il voto da aggiungere
	 * @return true
	 */
	public boolean add(Voto v) {
		return this.voti.add(v);
	}
	
	public void stampa() {
		for(Voto v : this.voti) {
			System.out.println(v.toString());
		}
	}
	
	public void stampaPuntiUguali(int valore) {
		for(Voto v : this.voti) {
			if(v.getPunti() == valore) {
				System.out.println(v);
			}
		}
	}
	
	public Voto cercaVotoPerNome(String corso) {
		for(Voto v : this.voti) {
			if(v.getCorso().equals(corso)) {
				return v;
			}
		}
		return null;
		//throw new RuntimeException("Voto non trovato");  In questo caso meglio ritornare null, lasciare 
			// l'eccezione per casi in cui è più insolito non trovare ciò che cerco
	}
	
	public boolean esisteVoto(Voto nuovo) {
		
		for(Voto v : this.voti) {
			if(v.equals(nuovo)){
				return true;
			}
		}
		return false;
	}
	
	public boolean conflittoConAltroVoto(Voto v) {
		for(Voto vv : this.voti) {
			if(vv.getCorso().compareTo(v.getCorso()) == 0) {
				if(vv.getPunti() != v.getPunti()) {
					return true;
				}
			}
		}
		return false;
	}
	

}
