package tratadores_de_eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jogo.Controle_do_jogo;

public class Apostar_listener implements ActionListener {
	private int ndojogador;
	public Apostar_listener(int i){
		ndojogador=i;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Controle_do_jogo.Apostar(ndojogador);
		
	}

}
