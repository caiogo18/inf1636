package tratadores_de_eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jogo.Turno;

public class Apostar_listener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Turno.apostar();
	}

}
