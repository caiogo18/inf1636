package tratadores_de_eventos;

import java.awt.event.*;

import javax.swing.*;

import baralho.Baralho;
import baralho.Carta;
import janela.Janela_Jogador;
public class Pedir_Carta implements ActionListener{
	private Janela_Jogador fr;
	private int x=50,y=50;
	private int LARGURA=73,ALTURA=97;
	public Pedir_Carta(Janela_Jogador fr){
		this.fr=fr;
	}
	public void actionPerformed(ActionEvent e) {
		Carta c=Baralho.get();
		JPanel p=c.get_imagem();
		p.setBounds(x, y, LARGURA, ALTURA);
		x=x+20;
		fr.pont.soma(c.get_valor());
		fr.add(p, 0);
		fr.repaint();
	}

}
