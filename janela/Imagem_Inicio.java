package janela;

public class Imagem_Inicio extends Imagem_Panel{
	private static Imagem_Inicio panel=null;
	private Imagem_Inicio(){
		super("imagens/BlackJack.png",0,0);
	}
	public static Imagem_Inicio get_Panel(){
		if(panel==null){
			panel=new Imagem_Inicio();
		}
		return panel;
	}
}
