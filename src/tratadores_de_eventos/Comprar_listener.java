package tratadores_de_eventos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import jogo.Turno;

public class Comprar_listener implements MouseListener{
	private int numjogador;
	public Comprar_listener(int i){
		numjogador=i;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Turno.Comprar_credito(numjogador);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
