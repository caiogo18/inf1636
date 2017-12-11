package jogo;
import java.io.Serializable;

import javax.swing.JOptionPane;

import Inicio.TelaInicial;
import baralho.Baralho;
import jogador.Banca;
import jogador.Jogador;
import salvamento.BackUp;
import salvamento.RestaurarObjeto;
import salvamento.SalvarObjeto;
import janela.Janela_Banca;
import janela.Janela_Jogador;

public class Controle_do_jogo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7682553932845421155L;
	private String[] nomes;
	private Janela_Jogador[] vfr;
	private Jogador[] vj;
	public Banca banca;
	private Janela_Banca janela_banca;
	private static Controle_do_jogo controle=null;
	public static void main(String[] args) {
		TelaInicial.get_frame();

	}
	private Controle_do_jogo(String [] jogadores){
		nomes=jogadores;
		int x = (1200 / nomes.length) / 2 - 150, y = 400;
		int parametro = 1200 / nomes.length;
		vfr = new Janela_Jogador[nomes.length];
		janela_banca=new Janela_Banca();
		vj = new Jogador[nomes.length];
		for (int i = 0; i < vj.length; i++) {
			vj[i] = new Jogador(5000, nomes[i]);
			vfr[i] = new Janela_Jogador(nomes[i], x, y,i);
			vj[i].addObserver(vfr[i]);
			x += parametro;
		}
		banca=new Banca();
		banca.addObserver(janela_banca);
		for(int i=0;i<vfr.length;i++){
			vfr[i].desabilitar();
			vfr[i].mudar_dinheiro(vj[i].get_Cash());
		}
	}
	public static void Criar_jogo(String[] jogadores) {
		if(controle==null){
			controle=new Controle_do_jogo(jogadores);
		}
		Turno.iniciar_turno();
		
	}
	public static void Reiniciar_jogo(){
		int x = (1200 / controle.nomes.length) / 2 - 150, y = 400;
		int parametro = 1200 / controle.nomes.length;
		controle.vfr = new Janela_Jogador[controle.vj.length];
		controle.janela_banca=new Janela_Banca();
		for (int i = 0; i < controle.vj.length; i++) {
			if(controle.vfr[i]==null){
				System.out.println("ola");
				controle.vfr[i] = new Janela_Jogador(controle.nomes[i], x, y,i);
			}
			controle.vj[i].addObserver(controle.vfr[i]);
			x += parametro;
			controle.vfr[i].desabilitar();
			controle.vfr[i].mudar_dinheiro(controle.vj[i].get_Cash());
				
		}
		controle.banca.addObserver(controle.janela_banca);
	}
	public static void finalizar_turno(){
		controle.janela_banca.esperar_rodada();
	}
	public static Jogador[] get_jogadores() {
		return controle.vj;
	}
	public static Banca get_banca() {
		return controle.banca;
	}
	public static void set_Observer(Aposta aposta,int i){
		aposta.addObserver(controle.vfr[i].get_observer());
	}
	public static void save(){
		SalvarObjeto.salvar(new BackUp());
		
	}
	public static void recuperar(){
		BackUp backup=(BackUp)RestaurarObjeto.restaurar();
		controle=backup.get_controle();
		Reiniciar_jogo();
		Baralho.recupera(backup.get_baralho());
		Turno.recuperar(backup.get_turno());
		
	}
	public static Controle_do_jogo get_controle() {
		return controle;
	}
	public static void mensagem(int i,int opcao){
		controle.vfr[i].criar_dialogo(i,opcao);
	}
	public static void comprar_credito(int i) {
		controle.vj[i].usar_credito();
		
	}
	public static void atualiza_jogadores(int numjogador) {
		System.out.println("o jogador saiu");
		if(controle.vj.length-1>0){
			String[] atualizado=new String[controle.vj.length-1];
			Jogador[] novo=new Jogador[controle.vj.length-1];
			int aux=0;
			for(int i=0;i<controle.vj.length;i++){
				if(i!=numjogador){
					atualizado[aux]=controle.nomes[i];
					novo[aux]=controle.vj[i];
					aux++;
				}
						
			}
			controle.vj=novo;
			controle.nomes=atualizado;
			Turno.atualiza_jogadores(numjogador);
		}
		else{
			controle.vj=null;
			controle.janela_banca.sem_jogadores();
		}
		
	}
	public static boolean sair(){
		if(Turno.get_fase()==0){
			return true;
		}
		else{
			return false;
		}
	}
}
