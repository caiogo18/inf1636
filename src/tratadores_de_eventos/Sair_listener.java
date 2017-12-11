package tratadores_de_eventos;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import jogo.Controle_do_jogo;

public class Sair_listener implements WindowListener {
	private int numjogador;
	public Sair_listener(int numjogador){
		
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		JFrame fr=(JFrame) arg0.getSource();
		if(Controle_do_jogo.sair()==true){
			if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(fr, "tem certeza que deseja sair", "sair", JOptionPane.OK_OPTION)){
				Controle_do_jogo.atualiza_jogadores(numjogador);
				fr.dispose();
			}
		}
		else{
			JOptionPane.showMessageDialog(fr,"So e possivel sair no final da rodada");
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
