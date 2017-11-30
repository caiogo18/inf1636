package tratadores_de_eventos;

import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import jogo.Controle_do_jogo;

public class Aumentar_listener implements MouseListener{
	private int ndojogador;
	private int valor;
	private static final double CENTER=25;
	private static final double RADIUS=22;
	public Aumentar_listener(int i,int valor){
		ndojogador=i;
		this.valor=valor;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Point ponto=e.getPoint();
		if((Math.pow(ponto.x- CENTER,2) + Math.pow(ponto.y- CENTER,2) )< Math.pow(RADIUS, 2)){
			Controle_do_jogo.Aumentar_Aposta(ndojogador,valor);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
