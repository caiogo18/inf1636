package jogo;

import java.io.Serializable;
import java.util.Observable;

public class Aposta extends Observable implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7237474801947103145L;
	private int aposta=0;
	private boolean vez=false;
	void aumentar_aposta(int valor){
		aposta+=valor;
		setChanged();
		notifyObservers(aposta);
	}
	void zera(){
		aposta=0;
		setChanged();
		notifyObservers(aposta);
	}
	void reload(){
		setChanged();
		notifyObservers(aposta);
	}
	public int get_aposta(){
		return aposta;
	}
	public void vez_set(boolean vez){
		this.vez=vez;
	}
	public boolean vez_aposta() {
		return vez;
	}
}
