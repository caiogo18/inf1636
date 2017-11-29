package janela;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Pontuacao extends JLabel {
	private int pont;
	public Pontuacao(int pont){
		this.pont=pont;
		setText(String.format("Pontua��o: %d", this.pont));
	}
	public void set(int num){
		pont=num;
		setText(String.format("Pontua��o: %d", pont));
	}
	public void zera(){
		pont=0;
		setText(String.format("Pontua��o: %d", pont));
	}

}
