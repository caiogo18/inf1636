package janela;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import baralho.Carta;
import jogador.Banca;
import jogador.Jogador;
import jogo.Controle_do_jogo;
import tratadores_de_eventos.Turno_listener;

@SuppressWarnings("serial")
public class Janela_Banca extends JFrame implements Observer{
	private final int LARGURA=600,ALTURA=400;
	private JPanel painel=new JPanel();
	private ArrayList<Carta> lista	;
	private Pontuacao pont;
	public JButton b;
	public Janela_Banca(){
		super("Banca");
		setBounds(300,0,LARGURA,ALTURA);
		JButton b = new JButton("Começar rodada");
		painel.setBounds(175,100, 250, 100);
		painel.setOpaque(false);
		b.setBounds(0,300,100,50);
		b.addActionListener(new Turno_listener());
		b.setEnabled(false);
		pont=new Pontuacao();
		pont.setOpaque(false);
		pont.setForeground(Color.black);
		pont.setBounds(5,5,200,20);
		JPanel p=new Imagem_Panel("imagens/Banca.png",0,0);
		p.setBounds(0,0,LARGURA,ALTURA);
		this.b=b;
		add(b);
		add(painel);
		add(p);
		add(pont,0);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void add_card(){
		painel.removeAll();
		int pos=0;
		int aux;
		if(lista.size()==1){
			aux= (250-73)/(lista.size());
		}
		else{
			aux= (250-73)/(lista.size()-1);
		}
		for (int i = 0; i < lista.size(); i++) {
			Carta temp=lista.get(i);
			JPanel p=new Imagem_Panel(String.format("imagens/%s%s.gif", temp.get_valor(),temp.get_naipe()),0,0);
			p.setBounds(pos, 0, 73, 97);
			pos+=aux;
			painel.add(p,0);
		}
		if(lista.size()==1){
			JPanel p=new Imagem_Panel("imagens/deck1.gif",0,0);
			p.setBounds(pos, 0, 73, 97);
			painel.add(p,0);
		}
		repaint();
	}
	public void limpar(){
		painel.removeAll();
		lista.removeAll(lista);
		repaint();
	}
	public void esperar_rodada(){
		Component[] V =getContentPane().getComponents();
		for(int i =0;i<V.length;i++){
			if(V[i] instanceof JButton){
				V[i].setEnabled(true);
			}
		}

	}
	@Override
	public void update(Observable arg0, Object arg1) {
		pont.set(((Banca)arg1).get_pont());
		lista=((Banca)arg1).get_list();
		if(lista.isEmpty()){
			limpar();
		}
		else{
			add_card();
		}
		
	}
}
