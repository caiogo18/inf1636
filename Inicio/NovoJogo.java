package Inicio;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import janela.Imagem_Inicio;

public class NovoJogo implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		Container c=TelaInicial.get_frame().getContentPane();
		c.removeAll();
		JRadioButton b1=new JRadioButton("1 jogador",true);
		JRadioButton b2=new JRadioButton("2 jogadores");
		JRadioButton b3=new JRadioButton("3 jogadores");
		JRadioButton b4=new JRadioButton("4 jogadores");
		JButton bEnter= new JButton("Enter");
		ButtonGroup bg = new ButtonGroup();
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);
		bg.add(b4);
		b1.setBounds(50,480,100,30);
		b2.setBounds(50,550,100,30);
		b3.setBounds(250,480,100,30);
		b4.setBounds(250,550,100,30);
		bEnter.setBounds(600,500,100,50);
		bEnter.addActionListener(new Numero_de_jogadores(bg));
		c.add(b1);
		c.add(b2);
		c.add(b3);
		c.add(b4);
		c.add(bEnter);
		Imagem_Inicio p1=Imagem_Inicio.get_Panel();
		p1.setBounds(0, 0,c.getWidth(),c.getHeight());
		c.add(p1);
		TelaInicial.get_frame().repaint();
	}

}
