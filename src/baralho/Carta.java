package baralho;


public class Carta {
	private Naipe naipe;
	private Valor valor;
	public Carta(Valor valor,Naipe naipe){
		this.valor=valor;
		this.naipe=naipe;
	}
	public Valor get_valor(){
		return valor;
	}
	public Naipe get_naipe(){
		return naipe;
	}
	public int get_ponto(){
		return valor.getPont();
	}
}
