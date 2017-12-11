package salvamento;

import java.io.Serializable;

import baralho.Baralho;
import jogo.Controle_do_jogo;
import jogo.Turno;

public class BackUp implements Serializable{
	private static final long serialVersionUID = -3846858020058576755L;
	private Turno turno;
	private Baralho baralho;
	private Controle_do_jogo controle;
	public BackUp(){
		
		baralho=Baralho.get_baralho();
		controle=Controle_do_jogo.get_controle();
		turno=Turno.get_turno();
	}
	public Baralho get_baralho() {
		return baralho;
	}
	public Controle_do_jogo get_controle() {
		return controle;
	}
	public Turno get_turno() {
		return turno;
	}
	
}
