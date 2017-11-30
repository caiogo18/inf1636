package janela;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import baralho.Carta;
import jogo.Controle_do_jogo;

@SuppressWarnings("serial")
public class Janela_Banca extends JFrame implements ActionListener{
	private final int LARGURA=600,ALTURA=400;
	private static Janela_Banca fr=null;
	private static JPanel painel=new JPanel();
	private static ArrayList<Carta> lista	;
	public JButton b;
	private Janela_Banca(){
		super("Banca");
		setBounds(300,0,LARGURA,ALTURA);
		JButton b = new JButton("Começar rodada");
		lista=new ArrayList<Carta> ();
		painel.setBounds(175,100, 250, 100);
		painel.setOpaque(false);
		b.setBounds(0,300,100,50);
		b.addActionListener(this);
		JPanel p=new Imagem_Panel("imagens/Banca.png",0,0);
		p.setBounds(0,0,LARGURA,ALTURA);
		this.b=b;
		add(b);
		add(painel);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b=(JButton)e.getSource();
		b.setEnabled(false);
		Controle_do_jogo.iniciar_apostas();
	}
	public static void add_card(Carta card){
		lista.add(card);
		painel.removeAll();
		int pos=0;
		int aux;
		JPanel p;
		if( lista.size()<=1){
			aux=0;
		}
		else{
			aux= (250-73)/(lista.size()-1);
		}
		for (int i = 0; i < lista.size(); i++) {
			Carta temp=lista.get(i);
			if(lista.size()==2&&i==1){
				p=new Imagem_Panel("imagens/deck1.gif",0,0);
			}
			else{
				p=new Imagem_Panel(String.format("imagens/%s%s.gif", temp.get_valor(),temp.get_naipe()),0,0);
			}
			p.setBounds(pos, 0, 73, 97);
			pos+=aux;
			painel.add(p,0);
		}
		painel.repaint();
	}
	public static void revelar(){
		painel.removeAll();
		int pos=0;
		int aux;
		JPanel p;
		if( lista.size()<=1){
			aux=0;
		}
		else{
			aux= (250-73)/(lista.size()-1);
		}
		for (int i = 0; i < lista.size(); i++) {
			Carta temp=lista.get(i);
			p=new Imagem_Panel(String.format("imagens/%s%s.gif", temp.get_valor(),temp.get_naipe()),0,0);
			p.setBounds(pos, 0, 73, 97);
			pos+=aux;
			painel.add(p,0);
		}
		painel.repaint();
	}
	public static void limpar(){
		painel.removeAll();
		lista.removeAll(lista);
		fr.repaint();
	}
	public static void esperar_rodada(){
		Component[] V =fr.getContentPane().getComponents();
		for(int i =0;i<V.length;i++){
			if(V[i] instanceof JButton){
				V[i].setEnabled(true);
			}
		}

	}
}
