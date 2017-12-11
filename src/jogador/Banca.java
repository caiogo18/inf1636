package jogador;

import java.io.Serializable;

public class Banca extends Jogador_Blackjack implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2273403132927488261L;
	public Banca(){
		super();
	}
	public void play(){
		nova_carta();
		while(get_pont()<17){
			nova_carta();
		}
		if(get_pont()>21){
			System.out.println("a banca quebrou");
		}
	}
}