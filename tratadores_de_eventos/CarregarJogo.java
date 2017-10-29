package tratadores_de_eventos;

import java.awt.event.*;

import javax.swing.*;

import janela.TelaInicial;

public class CarregarJogo implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		TelaInicial.get_frame().dispose();
	}
	
}
