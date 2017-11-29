package tratadores_de_eventos;

import java.awt.event.*;


import baralho.Baralho;
import baralho.Carta;
import janela.Janela_Jogador;
import jogo.Controle_do_jogo;
public class Pedir_Carta implements ActionListener{
	private int ndojogador;
	public Pedir_Carta(int i){
		ndojogador=i;
	}
	public void actionPerformed(ActionEvent e) {
		Controle_do_jogo.add_card(ndojogador);
	}

}
