package janela;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Pontuacao extends JPanel {

	private int pont=0;
	public void paintComponent(Graphics g) {
		Graphics2D g2d=(Graphics2D) g;
		super.paintComponent(g);
		g2d.setColor(Color.RED);
		g2d.drawString(String.format("Pontuacao: %d", pont), 0, 10);
	}
	public void set(int num){
		pont=num;
		repaint();
	}

}
