package janela;

import javax.swing.*;

@SuppressWarnings("serial")
public class Janela_Banca extends JFrame{
	private final int LARGURA=600,ALTURA=400;
	private static Janela_Banca fr=null;
	private Janela_Banca(){
		super("Banca");
		setBounds(300,0,LARGURA,ALTURA);
		JPanel p=new Imagem_Panel("imagens/Banca.png",0,0);
		p.setBounds(0,0,LARGURA,ALTURA);
		add(p);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static Janela_Banca get_frame(){
		if(fr==null){
			fr=new Janela_Banca();
		}
		return fr;
	}
}
