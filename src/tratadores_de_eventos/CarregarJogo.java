package tratadores_de_eventos;

import java.awt.event.*;

import Inicio.TelaInicial;
import jogo.Controle_do_jogo;


public class CarregarJogo implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		TelaInicial.get_frame().dispose();
		Controle_do_jogo.recuperar();
	}
	
}
