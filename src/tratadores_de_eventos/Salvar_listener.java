package tratadores_de_eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jogo.Controle_do_jogo;

public class Salvar_listener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Controle_do_jogo.save();

	}

}
