package jogo;
import java.io.Serializable;

import baralho.Baralho;
import jogador.Banca;
import jogador.Jogador;

public class Turno implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5536386343306357749L;
	private int vezjogador=-1;
	private  Jogador[] vj;
	private  Aposta[] aposta;
	private  Banca banca=null;
	private  int fase;
	private static Turno turno=null;
	private Turno(){
			vj=Controle_do_jogo.get_jogadores();
			banca=Controle_do_jogo.get_banca();
			fase=0;
			aposta=new Aposta[vj.length];
			for(int i =0;i<aposta.length;i++){
				aposta[i]=new Aposta();
				Controle_do_jogo.set_Observer(aposta[i], i);
			}
	}
	public static void reiniciar(){
		for(int i=0;i<turno.aposta.length;i++){
			Controle_do_jogo.set_Observer(turno.aposta[i], i);
			turno.aposta[i].reload();
		}
		if(turno.fase==1){
			turno.vj[turno.vezjogador].vez_apostar();
		}
		else if(turno.fase==2){
			for(int i=0;i<turno.vj.length;i++){
				turno.vj[i].reload();
			}
			turno.banca.reload();
			turno.vj[turno.vezjogador].vez_jogador();
		}
		else{
			for(int i=0;i<turno.vj.length;i++){
				turno.vj[i].reload();
			}
			turno.banca.reload();
			Controle_do_jogo.finalizar_turno();
		}
	}
	public static void iniciar_turno(){
		if(turno==null){
			turno=new Turno();
		}
		limpar();
		turno.vezjogador=0;
		turno.fase=1;
		for(int i=0;i<turno.vj.length;i++){
			turno.aposta[i].zera();
		}
		turno.aposta[turno.vezjogador].vez_set(true);
		turno.vj[turno.vezjogador].vez_apostar();
	}
	public static void iniciar_jogadas(){
		Baralho.embaralha();
		turno.fase=2;
		for(int j=0;j<2;j++){
			for(int i=0;i<turno.vj.length;i++){
				turno.vj[i].nova_carta();
			}
		}
		turno.banca.nova_carta();
		turno.vezjogador=-1;
		jogada();
	}
	public static void limpar(){
		for(int i=0;i<turno.vj.length;i++){
			turno.vj[i].limpa();
			turno.banca.limpa();
		}
	}
	public static void apostar(){
		if(turno.aposta[turno.vezjogador].get_aposta()==0){
			return;
		}
		turno.aposta[turno.vezjogador].vez_set(false);
		turno.vj[turno.vezjogador].apostar();
		turno.vj[turno.vezjogador].desabilitar();
		turno.vezjogador++;
		if(turno.vezjogador>=turno.vj.length){
			iniciar_jogadas();
		}
		else{
			turno.aposta[turno.vezjogador].vez_set(true);
			turno.vj[turno.vezjogador].vez_apostar();
		}
	}
	public static int get_vez(){
		return turno.vezjogador;
	}

	public static void Aumentar_Aposta(int i, int valor){
		if(turno.aposta[i].vez_aposta()&&(turno.aposta[i].get_aposta()+valor)<=turno.vj[i].get_Cash()){
			turno.aposta[i].aumentar_aposta(valor);
		}
	}
	public static void jogada(){
		turno.vezjogador++;
		if(turno.vezjogador!=0){
			turno.vj[turno.vezjogador-1].desabilitar(); 
		}
		if(turno.vezjogador<turno.vj.length){
			if(Resultado.checa(turno.vj[turno.vezjogador])==true){
				jogada();
			}
			else{
				turno.vj[turno.vezjogador].vez_jogador();	
			}
			
		}
		else{
			turno.banca.play();
			Resultado.definir_rodada(turno.vj, turno.banca);
			turno.fase=0;
			Controle_do_jogo.finalizar_turno();
			checa_falencia();
			
		}
	}
	public static int get_aposta(Jogador jogador) {
		for(int i=0;i<turno.vj.length;i++){
			if(turno.vj[i]==jogador){
				return turno.aposta[i].get_aposta();
			}
		}
		return 0;
	}
	public static void dobrar() {
		turno.aposta[turno.vezjogador].aumentar_aposta(turno.aposta[turno.vezjogador].get_aposta());
		turno.vj[turno.vezjogador].dobrar();
	}
	public static void allin() {
		Aumentar_Aposta(turno.vezjogador,turno.vj[turno.vezjogador].get_Cash());
		apostar();
	}
	public static void add_card(){
		turno.vj[turno.vezjogador].add_card();
	}
	public static Aposta[] get_apostas() {
		return turno.aposta;
		
	}
	public static int get_vezjogador() {
		return turno.vezjogador;
	}
	public static void recuperar(Turno tur) {
		turno=tur;
		reiniciar();
	}
	public static int get_fase() {
		return turno.fase;
	}
	public static void Comprar_credito(int numjogador) {
		if(turno.fase==0){
			if(turno.vj[numjogador].get_creditos()>0){
				Controle_do_jogo.mensagem(numjogador, 2);
			}
			else{
				Controle_do_jogo.mensagem(numjogador, 0);
			}
		}
		else{
			Controle_do_jogo.mensagem(numjogador, 1);
		}
		
	}
	private static void checa_falencia(){
		turno.vj=Controle_do_jogo.get_jogadores();
		if(turno.vj==null){
			return;
		}
		else{
			for(int i=0;i<turno.vj.length;i++){
				if(turno.vj[i].get_Cash()==0&&turno.vj[i].get_creditos()==0){
					turno.vj[i].faliu();
					Controle_do_jogo.atualiza_jogadores(i);
					checa_falencia();
					return;
				}
			}
		}
	}
	public static void atualiza_jogadores(int numjogador){
		Aposta []novo=new Aposta[turno.aposta.length-1];
		int aux=0;
		for(int j=0;j<turno.aposta.length;j++){
			if(numjogador==j){
				novo[aux]=turno.aposta[j];
				aux++;
			}
		}
	}
	public static Turno get_turno() {
		return turno;
	}
}
