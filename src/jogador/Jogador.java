package jogador;

import jogo.Controle_do_jogo;
import jogo.Resultado;
import jogo.Situation;
import jogo.Turno;

public class Jogador extends Jogador_Blackjack{
	private int cash;
	private String name;
	private Situation situation;
	
	public Jogador(int initial_cash,String name){
		super();
		this.name=name;
		cash=initial_cash;
		situation=Situation.DESABILITADO;
		
	}
	public String get_Name(){
		return name;
	}
	public int get_Cash(){
		return cash;
	}
	public Situation get_Situation(){
		return situation;
	}
	public void vez_apostar(){
		situation=Situation.APOSTAR;
		setChanged();
		notifyObservers(situation);
	}
	public void vez_jogador(Situation situation){
		this.situation=situation;
		setChanged();
		notifyObservers(situation);
	}
	public void desabilitar(){
		if(situation==Situation.NORMAL){
			situation=Situation.DESABILITADO;
			setChanged();
			notifyObservers(situation);
		}
	}
	public void add_card(){
		nova_carta();
		if(Resultado.checa(this)==true){
			estouro();
			Turno.jogada();
		}
	}
	public void estouro() {
		situation=Situation.ESTOUROU;
		setChanged();
		notifyObservers(situation);
		
	}
	public void blackjack() {
		situation=Situation.BLACKJACK;
		setChanged();
		notifyObservers(situation);
		
	}
	public void ganhar() {
		situation=Situation.GANHOU;
		setChanged();
		notifyObservers(situation);
		
	}
	public void empatar() {
		situation=Situation.EMPATOU;
		setChanged();
		notifyObservers(situation);
	}
	public void perder() {
		situation=Situation.PERDEU;
		setChanged();
		notifyObservers(situation);
	}
}
