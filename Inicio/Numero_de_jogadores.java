package Inicio;

import java.awt.Container;
import java.awt.event.*;
import java.util.Enumeration;

import javax.swing.*;

import janela.Imagem_Inicio;

public class Numero_de_jogadores implements ActionListener{
	private ButtonGroup bg;
	public Numero_de_jogadores(ButtonGroup bg){
		this.bg=bg;
	}

	public void actionPerformed(ActionEvent e) {
		Container c=TelaInicial.get_frame().getContentPane();
		c.removeAll();
		int numjogadores=1;
		int i=1;
		int x=50,y=480,altura=30,largura=200;
		for (Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements();) {
	           AbstractButton button = buttons.nextElement();
	           if (button.isSelected()) {
	        	   numjogadores=i;
	           }
	           i++;
	    }
		JTextField[] vt=new JTextField[numjogadores];
		for(i=0;i<numjogadores;i++){
			vt[i]=new JTextField();
			vt[i].setText(String.format("Jogador%d", i+1));
			vt[i].setBounds(x, y, largura, altura);
			y=y+50;
			if(i==1){
				y=480;
				x=300;
			}
			c.add(vt[i]);
		}
		JButton bEnter= new JButton("Enter");
		bEnter.setBounds(600,500,100,50);
		bEnter.addActionListener(new IniciarJogo(vt));
		c.add(bEnter);
		Imagem_Inicio p1=Imagem_Inicio.get_Panel();
		p1.setBounds(0, 0,c.getWidth(),c.getHeight());
		c.add(p1);
		TelaInicial.get_frame().repaint();
	}

		
}

