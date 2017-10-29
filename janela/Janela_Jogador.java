package janela;
import java.awt.*;

import javax.swing.*;

import jogador.Jogador;
import tratadores_de_eventos.Pedir_Carta;
public class Janela_Jogador extends JFrame{
	private final int ALTURA=350,LARGURA=300;
	Jogador jog;
	public Janela_Jogador(Jogador jog,int x,int y){
		super(jog.get_Name());
		setLayout(null);
		this.jog=jog;
		Container c=getContentPane();
		JButton b1=new JButton("Pedir");
		b1.setBounds(0,200,100,50);
		b1.addActionListener(new Pedir_Carta(this));
		c.add(b1);
		JPanel p=new Imagem_Panel("imagens/Jogador_Mesa.jpg",0,0);
		p.setBounds(0,0,LARGURA,ALTURA);
		add(p);
		setBounds(x, y, LARGURA, ALTURA);
		setVisible(true);
	}
}
