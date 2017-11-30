package jogador;

import java.util.ArrayList;

import baralho.Carta;

public class Jogador_Blackjack {
	private int pont;
	private ArrayList<Carta> lista	;
	public Jogador_Blackjack(){
		lista=new ArrayList<Carta> ();
	}
	public int get_pont(){
		return pont;
	}
	public void nova_carta(Carta card){
		lista.add(card);
		int as=0,total=0,valor;
		for (int i = 0; i < lista.size(); i++) {
			valor=lista.get(i).get_ponto();
			total+=valor;
			if(valor==11){
				as++;
			}
			while(total>=21&&as>0){
				total-=10;
				as--;
			}
		}
		pont=total;
	}
	public void limpa(){
		lista.removeAll(lista);
		pont=0;
	}
}
