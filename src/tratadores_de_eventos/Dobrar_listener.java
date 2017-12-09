package tratadores_de_eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jogo.Turno;

public class Dobrar_listener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Turno.dobrar();
		
	}
	
	
}
