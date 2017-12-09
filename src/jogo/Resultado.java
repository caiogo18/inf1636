package jogo;

import jogador.Banca;
import jogador.Jogador;

public class Resultado{
	public static boolean checa(Jogador j){
		if(j.get_pont()==21&&j.get_list().size()==2){
			j.blackjack();
			return true;
		}
		else if(j.get_pont()>21){
			j.estouro();
			return true;
		}
		return false;
	}
	public static void definir_rodada(Jogador[] vj,Banca banca){
		for(int i=0;i<vj.length;i++){
			if(vj[i].get_Situation()==Situation.DESABILITADO){
				if(banca.get_pont()>21||banca.get_pont()<vj[i].get_pont()){
					vj[i].ganhar();
				}
				else if(banca.get_pont()==vj[i].get_pont()){
					vj[i].empatar();
				}
				else{
					vj[i].perder();
				}
			}
		}
	}
}
