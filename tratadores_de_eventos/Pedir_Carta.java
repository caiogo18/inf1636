package tratadores_de_eventos;

import java.awt.event.*;

import javax.swing.*;

import baralho.Baralho;
import baralho.Carta;
import janela.Imagem_Panel;

public class Pedir_Carta implements ActionListener{
	private JFrame fr;
	private int x=50,y=50;
	private int LARGURA=73,ALTURA=97;
	public Pedir_Carta(JFrame fr){
		this.fr=fr;
	}
	public void actionPerformed(ActionEvent e) {
		Carta c=Baralho.get();
		Imagem_Panel p=c.get_imagem();
		p.setBounds(x, y, LARGURA, ALTURA);
		x=x+20;
		fr.add(p, 0);
		fr.repaint();
	}

}
