package tratadores_de_eventos;

import java.awt.event.*;

import Inicio.TelaInicial;

public class CarregarJogo implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		TelaInicial.get_frame().dispose();
	}
	
}