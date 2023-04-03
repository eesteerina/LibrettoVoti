package it.polito.tdp.libretto.model;

import java.util.*;

import it.polito.tdp.libretto.db.VotoDAO;

public class Libretto {
	
	private List<Voto> voti;

	public Libretto() {
		this.voti = new ArrayList<Voto>();
		VotoDAO dao = new VotoDAO();
		this.voti = dao.listaVoti();
	}
	
	/**
	 * Aggiungi un nuovo voto al libretto
	 * per ora non fa nessun controllo
	 * @param v il voto da aggiungere
	 * @return true
	 */
	public boolean add(Voto v) {
		if(this.esisteVoto(v) || this.conflittoConAltroVoto(v)) {
			// non aggiungere voto
			System.out.print("Voto errato\n");
			throw new IllegalArgumentException("Voto errato: " + v);
		}
		VotoDAO dao = new VotoDAO();
		dao.createVoto(v);
		return this.voti.add(v);
	}
	
	public void stampa() {
		for(Voto v : this.voti) {
			System.out.println(v.toString());
		}
	}
	
	public String toString() {
		
		String txt = "";
		
		for(Voto v : voti) {
			txt = txt + v.toString() + "\n";
		}
		return txt;
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
			if(v.isDuplicato(nuovo)){
				return true;
			}
		}
		return false;
	}
	
	public boolean conflittoConAltroVoto(Voto v) {
		for(Voto vv : this.voti) {
			if(v.isConflitto(v)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo 'factory' per creare un nuovo libretto con i voti migliorati
	 * @param 
	 * @return
	 */
	public Libretto librettoMigliorato() {
		
		Libretto migliore = new Libretto();
		migliore.voti = new ArrayList<>();
		
		for(Voto v : this.voti) {
			//migliore.voti.add(new Voto(v.clone()));
			migliore.voti.add(new Voto(v));
		}
		
		
		for (Voto v : migliore.voti) {
			v.setPunti(v.getPunti() + 2);
		}
		
		return migliore;
	}
	
	public void cancellaVotiInferiori(int punti) {
		
		List<Voto> daCancellare = new ArrayList<Voto>();
		
		// mai rimuovere oggetti dentro il ciclo
		
		for(Voto v : this.voti) {
			if(v.getPunti() < punti) {
				daCancellare.add(v);
			}
		}
		voti.removeAll(daCancellare);
		
//		for(int i = 0; i < this.voti.size(); i++) {
//			if(this.voti.get(i).getPunti() < punti) {
//				this.voti.remove(i);
//				i--;
//			}
//		}
	}
		
		public Libretto librettoOrdinatoAlfabeticamente() {
			
			Libretto ordinato = new Libretto();
			ordinato.voti = new ArrayList<>(this.voti);
			
			ordinato.voti.sort(new ComparatorByName());
			Collections.sort(ordinato.voti, new ComparatorByName());
			
			return ordinato;
		}
		
		public Libretto librettoOrdinatoPerVoto() {
			Libretto ordinato = new Libretto();
			ordinato.voti = new ArrayList<>(this.voti);
			
			ordinato.voti.sort(new Comparator<Voto>() {

				@Override
				public int compare(Voto o1, Voto o2) {
					return o2.getPunti() - o1.getPunti();
				}
				});
			
			return ordinato;
		}
	}
	


