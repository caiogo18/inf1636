package janela;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Dinheiro_View extends JPanel{
	private int valor=0;
	public Dinheiro_View(){
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2d=(Graphics2D) g;
		super.paintComponent(g);
		g2d.setColor(Color.RED);
		g2d.drawString(String.format("Dinheiro: $%d", valor), 0, 10);
	}
	public void mudar_valor(int valor){
		this.valor=valor;
		repaint();
	}
}
