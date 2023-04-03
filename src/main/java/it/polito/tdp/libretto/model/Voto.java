package it.polito.tdp.libretto.model;

import java.time.LocalDate;
import java.util.Objects;

public class Voto {
	
	private String corso;
	private int punti;  // da 18 a 31
	private LocalDate dataEsame;
	
	public Voto(String corso, int punti, LocalDate dataEsame) {
		super();
		this.corso = corso;
		this.punti = punti;
		this.dataEsame = dataEsame;
	}
	public Voto(Voto v) {
		this.corso = v.corso;
		this.punti = v.punti;
		this.dataEsame = v.dataEsame;
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

	public int getPunti() {
		return punti;
	}

	public void setPunti(int punti) {
		this.punti = punti;
	}

	public LocalDate getDataEsame() {
		return dataEsame;
	}

	public void setDataEsame(LocalDate dataEsame) {
		this.dataEsame = dataEsame;
	}
	
	public boolean isDuplicato(Voto altro) {
		return this.getCorso().equals(altro.getCorso()) && this.getPunti() == altro.getPunti();
	}
	
	public boolean isConflitto(Voto altro) {
		return this.getCorso().equals(altro.getCorso()) && this.getPunti() != this.getPunti();
	}
	
	public Voto clone() {
		return new Voto(corso, punti, dataEsame);
	}

	@Override
	public String toString() {
		return corso + " (" + punti + " pt) il " + dataEsame;
	}

	@Override
	public int hashCode() {
		return Objects.hash(corso, dataEsame, punti);
	}

	@Override
	public boolean equals(Object obj) {
		Voto v = (Voto)obj;
		if(this.corso.compareTo(v.getCorso()) == 0 && this.punti == v.getPunti()) {
			return true;
		}
		else {
			return false;
		}
	}


}
