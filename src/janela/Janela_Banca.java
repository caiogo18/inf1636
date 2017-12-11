package janela;

import java.awt.Color;
import java.awt.Component;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;
import javax.swing.*;

import baralho.Carta;
import jogador.Jogador_Blackjack;
import tratadores_de_eventos.Salvar_listener;
import tratadores_de_eventos.Turno_listener;

@SuppressWarnings("serial")
public class Janela_Banca extends JFrame implements Observer{
	private final int LARGURA=600,ALTURA=400;
	private ArrayList<JPanel> lista_painel=new ArrayList<JPanel>();
	private Pontuacao pont;
	private JButton salvar;
	public Janela_Banca(){
		super("Banca");
		setLayout(null);
		setBounds(300,0,LARGURA,ALTURA);
		JButton b=new JButton("Nova rodada");
		b.setBounds(0,320,200,50);
		b.addActionListener(new Turno_listener());
		b.setEnabled(false);
		salvar=new JButton("salvar");
		salvar.setBounds(200,320,100,50);
		salvar.addActionListener(new Salvar_listener());
		salvar.setEnabled(true);
		add(salvar);
		pont=new Pontuacao();
		pont.setOpaque(false);
		pont.setForeground(Color.black);
		pont.setBounds(5,5,200,20);
		JPanel p=new Imagem_Panel("imagens/Banca.png",0,0);
		p.setBounds(0,0,LARGURA,ALTURA);
		add(b);
		add(p);
		add(pont,0);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void add_card(){
		int LARGURA=175,ALTURA=100;
		int pos=0;
		int aux;
		if(lista_painel.size()==1){
			aux= (250-73)/(lista_painel.size());
		}
		else{
			aux= (250-73)/(lista_painel.size()-1);
		}
		for (int i = 0; i < lista_painel.size(); i++) {
			JPanel p=lista_painel.get(i);
			p.setBounds(LARGURA+pos, ALTURA, 73, 97);
			pos+=aux;
			add(p,0);
		}
		if(lista_painel.size()==1){
			JPanel p=new Imagem_Panel("imagens/deck1.gif",0,0);
			lista_painel.add(p);
			p.setBounds(LARGURA+pos, ALTURA, 73, 97);
			add(p,0);
		}
		repaint();
	}
	public void limpar(){
		for(int i=0;i<lista_painel.size();i++){
			remove(lista_painel.get(i));
		}
		lista_painel.removeAll(lista_painel);
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
		pont.set(((Jogador_Blackjack)arg1).get_pont());
		List<Carta> lista=((Jogador_Blackjack)arg1).get_list();
		if(lista.isEmpty()){
			limpar();
		}
		else{
			for(int i=0;i<lista_painel.size();i++){
				remove(lista_painel.get(i));
			}
			lista_painel.removeAll(lista_painel);
			for (int i = 0; i < lista.size(); i++) {
				Carta temp=lista.get(i);
				JPanel p=new Imagem_Panel(String.format("imagens/%s%s.gif", temp.get_valor(),temp.get_naipe()),0,0);
				lista_painel.add(p);
			}
			add_card();
		}
		
	}
	public void sem_jogadores() {
		if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(this, "Nao ha mais jogadores na mesa", "Game Over", JOptionPane.DEFAULT_OPTION )){
			dispose();
		}
		
	}
}
