package jogo;
import Inicio.TelaInicial;
import jogador.Banca;
import jogador.Jogador;


import baralho.Baralho;
import baralho.Carta;
import janela.Janela_Banca;
import janela.Janela_Jogador;

public class Controle_do_jogo {
	private static String[] nomes;
	private static Janela_Jogador[] vfr;
	private static Jogador[] vj;
	private static Banca banca;
	private static int[] sit;
	private static int vezjogador;
	private static int[] aposta;
	public static void main(String[] args) {
		TelaInicial.get_frame();

	}
	public static void Criar_jogadores(String[] jogadores) {
		nomes=jogadores;
		int x = (1200 / nomes.length) / 2 - 150, y = 400;
		int parametro = 1200 / nomes.length;
		vj = new Jogador[nomes.length];
		vfr = new Janela_Jogador[nomes.length];
		for (int i = 0; i < nomes.length; i++) {
			vj[i] = new Jogador(5000, nomes[i]);
			vfr[i] = new Janela_Jogador(nomes[i], x, y,i);
			x += parametro;
		}
		sit=new int[nomes.length];
		Janela_Banca.get_frame();
		banca=new Banca();
		aposta=new int[nomes.length];
		for(int i=0;i<vfr.length;i++){
			vfr[i].desabilitar();
			vfr[i].mudar_dinheiro(vj[i].get_Cash());
		}
		
	}
	public static void iniciar_apostas(){
		limpar();
		vezjogador=0;
		for(int i=0;i<vj.length;i++){
			aposta[i]=0;
		}
		vfr[0].habilitar(1);
	}
	public static void iniciar_rodada(){
		Baralho.embaralha();
		for(int j=0;j<2;j++){
			for(int i=0;i<vfr.length;i++){
				add_card(i);
			}
			add_card(10);
		}
		Janela_Banca.get_frame().b.setEnabled(false);
		vezjogador=0;
		Controle_do_jogo.jogada(0);
	}
	public static void jogada(int ndojogador){
		if(ndojogador!=0){
			vfr[ndojogador-1].desabilitar();
		}
		if(ndojogador<vfr.length){
			if(vj[ndojogador].get_pont()==21){
				ganhar(ndojogador);
				jogada(ndojogador+1);
			}
			else{
				sit[ndojogador]=0;
				vfr[ndojogador].habilitar(0);	
			}
		}
		else{
			Janela_Banca.revelar();
			while(banca.get_pont()<17){
				add_card(10);
			}
			if(banca.get_pont()>21) resultado(true);
			else resultado(false);
			finalizar_turno();
			
		}
	}
	public static void add_card(int i){
		Carta card=Baralho.get();
		if(i==10){
			banca.nova_carta(card);
			Janela_Banca.add_card(card);
			if(banca.get_pont()>21){
				System.out.println("a banca quebrou");
			}
		}
		else{
			vj[i].nova_carta(card);
			vfr[i].add_card(card,vj[i].get_pont());
			if(vj[i].get_pont()>21){
				perder(i);
				jogada(i+1);
			}
		}
	}
	private static void resultado(boolean quebrou){
		for(int i=0;i<vj.length;i++){
			if(sit[i]==0){
				if(quebrou==true||vj[i].get_pont()>banca.get_pont()){
					ganhar(i);
				}
				else if(vj[i].get_pont()==banca.get_pont()){
					empatou(i);
				}
				else{
					perder(i);
				}
			}
		}
	}
	private static void ganhar(int i){
		vfr[i].win();
		sit[i]=1;
	}
	private static void perder(int i){
		vfr[i].lose();
		sit[i]=-1;
	}
	private static void empatou(int i){
		vfr[i].draw();
	}
	public static void Aumentar_Aposta(int i,int valor){
		if(vezjogador==i){
			aposta[i]+=valor;
			vfr[i].mudar_valor(aposta[i]);
			System.out.printf("O jogador %d apostou mais %d\n",i,valor);
		}
	}
	public static void Apostar(int i){
		if(vezjogador==i){
			vezjogador++;
			vfr[i].desabilitar();
		}
		if(vezjogador>=vj.length){
			iniciar_rodada();
		}
		else{
			vfr[vezjogador].habilitar(1);
		}
	}
	public static void finalizar_turno(){
		Janela_Banca.esperar_rodada();
	}
	public static void limpar(){
		for(int i=0;i<vj.length;i++){
			vfr[i].limpar();
			vj[i].limpa();
			banca.limpa();
			Janela_Banca.limpar();
		}
	}
		
}
