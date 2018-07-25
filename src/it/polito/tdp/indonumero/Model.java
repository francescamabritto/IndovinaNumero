package it.polito.tdp.indonumero;

import java.security.*;

import javafx.beans.value.ObservableValue;

public class Model {
	
	private int NMAX = 100;
	private int TMAX = 7;
	
	private int segreto;
	private int tentativi;
	
	private boolean inGame = false;
	public ObservableValue<? extends String> tentativiProperty;
	
	public Model() {
		this.inGame = false;
	}
	
	// avvia una nuova partita generando un nuovo numero segreto
	public void newGame() {
		this.segreto = (int)(Math.random()*NMAX)+1 ;
		
		this.tentativi = 0 ;
		this.inGame = true ;
	}
	
	/**
	 * Fai un tentativo per indovinare
	 * @param t valore numerico del tentativo
	 * @return 0 se è indovinato, +1 se è troppo grande, -1 se è troppo piccolo
	 */	
	public int tentativo(int t) {
		if(!inGame) {
			throw new IllegalStateException("Partita non attiva");
		}
		if (!valoreValido(t)) {
			throw new InvalidParameterException("Tentativo fuori range");
		}
		
		if(this.tentativi>=this.TMAX) 
			this.inGame = false;
		
			
		this.tentativi++;
		if(t==this.segreto) {
			this.inGame= false;
			return 0;
		}
		if(t>this.segreto)
			return 1;
		else
			return -1;
		
		
	}
	// controlla se il tentativo fornito rispetta le regole formali
	public boolean valoreValido(int tentativo) {
		return tentativo >= 1 && tentativo <= this.NMAX;
	}

	public int getSegreto() {
		return segreto;
	}

	public void setSegreto(int segreto) {
		this.segreto = segreto;
	}

	public int getTentativi() {
		return tentativi;
	}

	public void setTentativi(int tentativi) {
		this.tentativi = tentativi;
	}

	public int getNMAX() {
		return NMAX;
	}

	public void setNMAX(int nMAX) {
		NMAX = nMAX;
	}

	public int getTMAX() {
		return TMAX;
	}

	public void setTMAX(int tMAX) {
		TMAX = tMAX;
	}

	public boolean isInGame() {
		return inGame;
	}

	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}
	
	
	
}
