package jogo;

import jogador.Jogador;

import baralho.Baralho;
import janela.Janela_Banca;
import janela.Janela_Jogador;

public class Controle_do_jogo {
	private String[] nomes;

	public Controle_do_jogo(String[] jogadores) {
		nomes = jogadores;
	}

	public void Criar_jogadores() {
		int x = (1200 / nomes.length) / 2 - 150, y = 400;
		int parametro = 1200 / nomes.length;
		Jogador[] vj = new Jogador[nomes.length];
		Janela_Jogador[] vfr = new Janela_Jogador[nomes.length];
		for (int i = 0; i < nomes.length; i++) {
			vj[i] = new Jogador(5000, nomes[i]);
			vfr[i] = new Janela_Jogador(vj[i], x, y);
			x += parametro;
		}
		Janela_Banca.get_frame();
		Baralho.embaralha();
	}
}
