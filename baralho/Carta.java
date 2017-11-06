package baralho;

import janela.Imagem_Panel;

public class Carta {
	private int valor;
	private Imagem_Panel imagem;
	public Carta(int valor,String file_name){
		this.valor=valor;
		imagem=new Imagem_Panel(file_name,0,0);
	}
	public int get_valor(){
		return valor;
	}
	public Imagem_Panel get_imagem(){
		return imagem;
	}
}
