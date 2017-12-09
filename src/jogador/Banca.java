package jogador;

public class Banca extends Jogador_Blackjack{
	public Banca(){
		super();
	}
	public void play(){
		nova_carta();
		while(get_pont()<17){
			nova_carta();
		}
		if(get_pont()>21){
			System.out.println("a banca quebrou");
		}
	}
}