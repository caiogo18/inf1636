package jogador;

import java.io.Serializable;

import jogo.Resultado;
import jogo.Turno;

public class Jogador extends Jogador_Blackjack implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7751027695593275429L;
	private int cash;
	private String name;
	private Situation situation;
	private int creditos;
	public Jogador(int initial_cash,String name){
		super();
		this.name=name;
		cash=initial_cash;
		situation=Situation.DESABILITADO;
		creditos=0;
		
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
	public void vez_jogador(){
		if(cash<Turno.get_aposta(this)){
			situation=Situation.NDOBRA;
		}
		else{
			situation=Situation.NORMAL;
		}
		setChanged();
		notifyObservers(situation);
	}
	public void desabilitar(){
		if(situation==Situation.NORMAL||situation==Situation.APOSTAR||situation==Situation.NDOBRA){
			situation=Situation.DESABILITADO;
			setChanged();
			notifyObservers(situation);
		}
		
	}
	public void add_card(){
		nova_carta();
		if(Resultado.checa(this)==true){
			Turno.jogada();
		}
		if(situation==Situation.NORMAL){
			situation=Situation.NDOBRA;
			setChanged();
			notifyObservers(situation);
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
		int aposta=Turno.get_aposta(this);
		alterar_dinheiro(aposta+(3*aposta/2));
		
	}
	public void ganhar() {
		situation=Situation.GANHOU;
		setChanged();
		notifyObservers(situation);
		int aposta=Turno.get_aposta(this);
		alterar_dinheiro(2*aposta);
		
	}
	public void empatar() {
		situation=Situation.EMPATOU;
		setChanged();
		notifyObservers(situation);
		int aposta=Turno.get_aposta(this);
		alterar_dinheiro(aposta);
	}
	public void perder() {
		situation=Situation.PERDEU;
		setChanged();
		notifyObservers(situation);
	}
	private void alterar_dinheiro(int valor){
		cash+=valor;
		setChanged();
		notifyObservers(cash);
	}
	public void apostar(){
		int aposta=Turno.get_aposta(this);
		alterar_dinheiro(-aposta);
	}
	public void dobrar() {
		int aposta=Turno.get_aposta(this);
		alterar_dinheiro(-(aposta/2));
		add_card();
		if(situation!=Situation.ESTOUROU)Turno.jogada();
	}
	public void reload(){
		setChanged();
		notifyObservers(this);
		setChanged();
		notifyObservers(cash);
		setChanged();
		notifyObservers(situation);
	}
	public int get_creditos(){
		return creditos;
	}
	public void usar_credito(){
		creditos--;
		alterar_dinheiro(2500);
	}
	public void faliu() {
		situation=Situation.SAIU;
		setChanged();
		notifyObservers(situation);
	}
	
}
