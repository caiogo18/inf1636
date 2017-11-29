package janela;

import javax.swing.*;

import java.awt.*;
import java.io.*;

import javax.imageio.*;

@SuppressWarnings("serial")
public class Imagem_Panel extends JPanel {
	private String str;
	int x, y;

	public Imagem_Panel(String args, int x, int y) {
		str = args;
		this.x = x;
		this.y = y;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image i = null;

		try {
			i = ImageIO.read(new File(str));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		g.drawImage(i, x, y, null);
	}
}
