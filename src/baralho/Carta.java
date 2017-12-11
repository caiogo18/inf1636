package baralho;

import java.io.Serializable;

public class Carta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5589310594971720467L;
	private Naipe naipe;
	private Valor valor;
	public Carta(Valor valor,Naipe naipe){
		this.valor=valor;
		this.naipe=naipe;
	}
	public Valor get_valor(){
		return valor;
	}
	public Naipe get_naipe(){
		return naipe;
	}
	public int get_ponto(){
		return valor.getPont();
	}
}
