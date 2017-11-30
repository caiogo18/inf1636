package jogador;

public class Jogador extends Jogador_Blackjack{
	private int cash;
	private String name;
	
	public Jogador(int initial_cash,String name){
		super();
		this.name=name;
		cash=initial_cash;
		
	}
	public String get_Name(){
		return name;
	}
	public int get_Cash(){
		return cash;
	}
}
