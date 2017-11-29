package Inicio;
import tratadores_de_eventos.*;

import java.awt.*;

import javax.swing.*;

import janela.Imagem_Inicio;

@SuppressWarnings("serial")
public class TelaInicial extends JFrame{
	private final int LARGURA=800, ALTURA=600;
	private static JFrame fr=null;
	private TelaInicial(String s){
		super(s);
		setLayout(null);
		Container c=getContentPane();
		Imagem_Inicio p1=Imagem_Inicio.get_Panel();
		p1.setBounds(0, 0,LARGURA,ALTURA);
		JButton bNovo=new JButton("Novo Jogo");
		JButton bCarregar=new JButton("Carregar Jogo");
		bNovo.addActionListener(new NovoJogo());
		bCarregar.addActionListener(new CarregarJogo());
		bNovo.setBounds(100,500,200,50);
		bCarregar.setBounds(500,500,200,50);
		c.add(bNovo);
		c.add(bCarregar);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c.add(p1);
		setBounds(300,50,LARGURA+16,ALTURA+39);
		setVisible(true);
	}
	public static JFrame get_frame(){
		if(fr==null){
			fr=new TelaInicial("BlackJack");
		}
		return fr;
	}
	
}
