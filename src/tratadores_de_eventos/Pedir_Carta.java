package tratadores_de_eventos;

import java.awt.event.*;

import jogo.Controle_do_jogo;
import jogo.Turno;
public class Pedir_Carta implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		Turno.add_card();
	}

}
