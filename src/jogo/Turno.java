package jogo;

import java.util.Observable;

import baralho.Baralho;
import jogador.Banca;
import jogador.Jogador;

public class Turno{
	private static int vezjogador;
	private static Jogador[] vj;
	private static Aposta[] aposta;
	private static Banca banca=null;
	private Turno(){
		vezjogador=0;
		vj=Controle_do_jogo.get_jogadores();
		aposta=new Aposta[vj.length];
		for(int i =0;i<aposta.length;i++){
			aposta[i]=new Aposta();
			Controle_do_jogo.set_Observer(aposta[i], i);
		}
		banca=Controle_do_jogo.get_banca();
	}
	public static void iniciar_turno(){
		if(banca==null){
			new Turno();
		}
		limpar();
		vezjogador=0;
		for(int i=0;i<vj.length;i++){
			aposta[i].zera();
		}
		aposta[vezjogador].vez_set(true);
		vj[vezjogador].vez_apostar();
	}
	public static void iniciar_rodada(){
		Baralho.embaralha();
		for(int j=0;j<2;j++){
			for(int i=0;i<vj.length;i++){
				vj[i].nova_carta();
			}
		}
		banca.nova_carta();
		vezjogador=-1;
		jogada();
	}
	public static void limpar(){
		for(int i=0;i<vj.length;i++){
			vj[i].limpa();
			banca.limpa();
		}
	}
	public static void Apostar(int i){
		if(vezjogador==i){
			aposta[vezjogador].vez_set(false);
			vj[vezjogador].desabilitar();
			vezjogador++;
		}
		if(vezjogador>=vj.length){
			iniciar_rodada();
		}
		else{
			aposta[vezjogador].vez_set(true);
			vj[vezjogador].vez_apostar();
		}
	}
	public static int get_vez(){
		return vezjogador;
	}

	public static void Aumentar_Aposta(int i,int valor){
		if(aposta[i].vez_aposta()){
			aposta[i].aumentar_aposta(valor);
		}
	}
	public static void jogada(){
		vezjogador++;
		if(vezjogador!=0){
			vj[vezjogador-1].desabilitar();
		}
		if(vezjogador<vj.length){
			if(Resultado.checa(vj[vezjogador])==true){
				vezjogador++;
				jogada();
			}
			else if(banca.get_pont()<11){
				vj[vezjogador].vez_jogador(Situation.NORMAL);	
			}
			else{
				vj[vezjogador].vez_jogador(Situation.SEGURO);
			}
		}
		else{
			banca.play();
			Resultado.definir_rodada(vj, banca);
			Controle_do_jogo.finalizar_turno();
			
		}
	}
}
