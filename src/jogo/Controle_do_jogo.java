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
		for(int i=0;i<vfr.length;i++){
			vfr[i].desabilitar();
		}
	}
	public static void iniciar_rodada(){
		Baralho.embaralha();
		for(int j=0;j<2;j++){
			for(int i=0;i<vfr.length;i++){
				System.out.println("espera");
				add_card(i);
			}
			add_card(10);
		}
		Janela_Banca.get_frame().b.setEnabled(false);
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
				vfr[ndojogador].habilitar();	
			}
		}
		else{
			Janela_Banca.revelar();
			while(banca.get_pont()<17){
				add_card(10);
			}
			if(banca.get_pont()>21) resultado(true);
			else resultado(false);
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
		
}
