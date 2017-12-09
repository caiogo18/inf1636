package jogo;
import Inicio.TelaInicial;
import jogador.Banca;
import jogador.Jogador;

import janela.Janela_Banca;
import janela.Janela_Jogador;

public class Controle_do_jogo {
	private static String[] nomes;
	private static Janela_Jogador[] vfr;
	private static Jogador[] vj;
	private static Banca banca;
	private static Janela_Banca janela_banca;
	public static void main(String[] args) {
		TelaInicial.get_frame();

	}
	public static void Criar_jogo(String[] jogadores) {
		nomes=jogadores;
		int x = (1200 / nomes.length) / 2 - 150, y = 400;
		int parametro = 1200 / nomes.length;
		vj = new Jogador[nomes.length];
		vfr = new Janela_Jogador[nomes.length];
		for (int i = 0; i < nomes.length; i++) {
			vj[i] = new Jogador(5000, nomes[i]);
			vfr[i] = new Janela_Jogador(nomes[i], x, y,i);
			vj[i].addObserver(vfr[i]);
			x += parametro;
		}
		janela_banca=new Janela_Banca();
		banca=new Banca();
		banca.addObserver(janela_banca);
		for(int i=0;i<vfr.length;i++){
			vfr[i].desabilitar();
			vfr[i].mudar_dinheiro(vj[i].get_Cash());
		}
		Turno.iniciar_turno();
		
	}
	public static void finalizar_turno(){
		janela_banca.esperar_rodada();
	}
	public static Jogador[] get_jogadores() {
		return vj;
	}
	public static Banca get_banca() {
		return banca;
	}
	public static void set_Observer(Aposta aposta,int i){
		aposta.addObserver(vfr[i].get_observer());
	}
		
}
