package janela;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import baralho.Carta;
import jogador.Jogador;
import jogo.Aposta;
import jogo.Situation;
import jogo.Turno;
import tratadores_de_eventos.Apostar_listener;
import tratadores_de_eventos.Aumentar_listener;
import tratadores_de_eventos.Ficar;
import tratadores_de_eventos.Pedir_Carta;
@SuppressWarnings("serial")
public class Janela_Jogador extends JFrame implements Observer{
	private final int ALTURA=350,LARGURA=300;
	private JPanel painel=new JPanel();
	private Pontuacao pont;
	private ArrayList<Carta> lista	;
	private JPanel painel_resultado;
	private Texto_Aposta aposta;
	private Dinheiro_View dinheiro;
	private JButton bAposta;
	private JButton bPedir;
	private JButton bFicar;
	public Janela_Jogador(String nome,int x,int y,int i){
		super(nome);
		setLayout(null);
		Container c=getContentPane();
		lista=new ArrayList<Carta> ();
		painel.setBounds(25,50, 250, 100);
		bPedir=new JButton("Pedir");
		bPedir.setBounds(0,200,100,50);
		bFicar=new JButton("Ficar");
		bFicar.setBounds(100,200,100,50);
		ActionListener ficarlistener=new Ficar();
		bFicar.addActionListener(ficarlistener);
		c.add(bFicar);
		ActionListener listener=new Pedir_Carta(i);
		bPedir.addActionListener(listener);
		c.add(bPedir);
		bAposta=new JButton("Apostar");
		bAposta.setBounds(200,200,100,50);
		bAposta.addActionListener(new Apostar_listener(i));
		c.add(bAposta);
		aposta=new Texto_Aposta();
		aposta.setBounds(5,20,80,50);
		aposta.setOpaque(false);
		painel_resultado=new JPanel();
		painel_resultado.setBounds(25, 0, 250, 200);
		painel_resultado.setOpaque(false);
		add(painel_resultado);
		add_fichas(i);
		Pontuacao pont=new Pontuacao();
		JPanel p=new Imagem_Panel("imagens/Jogador_Mesa.jpg",0,0);
		p.setBounds(0,0,LARGURA,ALTURA);
		painel.setOpaque(false);
		add(painel);
		add(p);
		dinheiro=new Dinheiro_View();
		dinheiro.setBounds(100,5,120,50);
		dinheiro.setOpaque(false);
		add(dinheiro,0);
		pont.setOpaque(false);
		pont.setForeground(Color.black);
		pont.setBounds(5,5,200,20);
		this.pont=pont;
		c.add(pont,0);
		add(aposta,0);
		setResizable(false);
		setBounds(x, y, LARGURA, ALTURA);
		setVisible(true);
	}
	private void add_card(){
		
		painel.removeAll();
		int pos=0;
		int aux;
		if( lista.size()<=1){
			aux=0;
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
		repaint();
	}
	public void win(){
		JPanel p=new Imagem_Panel("imagens/win.png",0,0);
		p.setBounds(0, 0, 250, 200);
		p.setOpaque(false);
		painel_resultado.add(p);
		painel_resultado.repaint();
	}
	public void lose(){
		JPanel p=new Imagem_Panel("imagens/lose.png",0,0);
		p.setBounds(0, 0, 250, 200);
		p.setOpaque(false);
		painel_resultado.add(p);
		painel_resultado.repaint();
	}
	public void draw(){
		JPanel p=new Imagem_Panel("imagens/draw.png",0,0);
		p.setBounds(0, 0, 250, 200);
		p.setOpaque(false);
		painel_resultado.add(p);
		painel_resultado.repaint();
	}
	public void limpar(){
		painel_resultado.removeAll();
		painel.removeAll();
		lista.removeAll(lista);
		repaint();
	}
	private void add_fichas(int i){
		int aux=0,largura=50,altura=150;
		JPanel p=new Imagem_Panel("imagens/ficha1.png",0,0);
		p.setBounds(aux, altura, largura, largura);
		p.addMouseListener(new Aumentar_listener(i,1));
		add(p);
		aux+=largura;
		p=new Imagem_Panel("imagens/ficha5.png",0,0);
		p.setBounds(aux, altura, largura, largura);
		p.addMouseListener(new Aumentar_listener(i,5));
		add(p);
		aux+=largura;
		p=new Imagem_Panel("imagens/ficha10.png",0,0);
		p.setBounds(aux, altura, largura, largura);
		p.addMouseListener(new Aumentar_listener(i,10));
		add(p);
		aux+=largura;
		p=new Imagem_Panel("imagens/ficha20.png",0,0);
		p.setBounds(aux, altura, largura, largura);
		p.addMouseListener(new Aumentar_listener(i,20));
		add(p);
		aux+=largura;
		p=new Imagem_Panel("imagens/ficha50.png",0,0);
		p.setBounds(aux, altura, largura, largura);
		p.addMouseListener(new Aumentar_listener(i,50));
		add(p);
		aux+=largura;
		p=new Imagem_Panel("imagens/ficha100.png",0,0);
		p.setBounds(aux, altura, largura, largura);
		p.addMouseListener(new Aumentar_listener(i,100));
		add(p);
		aux+=largura;
		
	}
	public void mudar_dinheiro(int  valor){
		dinheiro.mudar_valor(valor);
	}
	public void update(Observable arg0, Object arg1) {
		if(arg0 instanceof Jogador){
			if(arg1 instanceof Jogador){
				pont.set(((Jogador)arg1).get_pont());
				lista=((Jogador)arg1).get_list();
				if(lista.isEmpty()){
					limpar();
				}
				else{
					add_card();
				}
			}
			else if(arg1 instanceof Situation){
				change_situation((Situation)(arg1));
			}
		}
	}
	private void change_situation(Situation situation) {
		String aux;
		Container c=getContentPane();
		Component[] V =c.getComponents();
		switch(situation){
			case APOSTAR:
				bAposta.setEnabled(true);
				break;
			case DESABILITADO:
				desabilitar();
				break;
			case BLACKJACK:
				win();
				desabilitar();
				break;
			case ESTOUROU:
				lose();
				desabilitar();
				break;
			case GANHOU:
				win();
				break;
			case PERDEU:
				lose();
				desabilitar();
				break;
			case EMPATOU:
				draw();
				break;
			default:
				habilitar(situation);
		}
		
	}

	public void desabilitar(){
		Container c=getContentPane();
		Component[] V =c.getComponents();
		for(int i =0;i<V.length;i++){
			if(V[i] instanceof JButton){
				V[i].setEnabled(false);
			}
		}
	}
	public void habilitar(Situation situation){
		if(situation==Situation.SEGURO){
			
		}
		bPedir.setEnabled(true);
		bFicar.setEnabled(true);
	}
	public Texto_Aposta get_observer(){
		return aposta;
	}

}
