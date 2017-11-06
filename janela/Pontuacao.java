package janela;

import java.awt.Graphics;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Pontuacao extends JLabel {
	private int pont;
	public Pontuacao(int pont){
		this.pont=pont;
		setText(String.format("Pontuação: %d", this.pont));
	}
	public void soma(int adciona){
		pont+=adciona;
		setText(String.format("Pontuação: %d", pont));
	}
	public void zera(){
		pont=0;
		setText(String.format("Pontuação: %d", pont));
	}

}
