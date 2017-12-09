package janela;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class Texto_Aposta extends JPanel implements Observer{
	private int valor=0;
	public Texto_Aposta(){
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2d=(Graphics2D) g;
		super.paintComponent(g);
		g2d.setColor(Color.RED);
		g2d.drawString(String.format("Aposta: $%d", valor), 0, 10);
	}
	public void update(Observable arg0, Object arg1) {
		if(arg1 instanceof Integer){
			valor=(int)arg1;
			repaint();
		}
		
	}
	
}
