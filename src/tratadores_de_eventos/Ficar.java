package tratadores_de_eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import jogo.Turno;

public class Ficar implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b=(JButton)e.getSource();
		b.setEnabled(false);
		Turno.jogada();
	}

}
