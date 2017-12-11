package jogador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

import baralho.Baralho;
import baralho.Carta;

public class Jogador_Blackjack extends Observable implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8269448448604476492L;
	private int pont;
	private ArrayList<Carta> lista	;
	public Jogador_Blackjack(){
		lista=new ArrayList<Carta>();
	}
	public int get_pont(){
		return pont;
	}
	public void nova_carta(){
		lista.add(Baralho.get());
		int as=0,total=0,valor;
		for (int i = 0; i < lista.size(); i++) {
			valor=lista.get(i).get_ponto();
			total+=valor;
			if(valor==11){
				as++;
			}
			while(total>21&&as>0){
				total-=10;
				as--;
			}
		}
		pont=total;
		setChanged();
		notifyObservers(this);
	}
	public void limpa(){
		lista.removeAll(lista);
		pont=0;
		setChanged();
		notifyObservers(this);
	}
	public void reload(){
		setChanged();
		notifyObservers(this);
	}
	public  ArrayList<Carta> get_list(){
		return lista;
	}
}
