package janela;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import baralho.Carta;
import jogador.Jogador;
import jogador.Situation;
import jogo.Controle_do_jogo;
import tratadores_de_eventos.Allin_listener;
import tratadores_de_eventos.Apostar_listener;
import tratadores_de_eventos.Aumentar_listener;
import tratadores_de_eventos.Comprar_listener;
import tratadores_de_eventos.Dobrar_listener;
import tratadores_de_eventos.Ficar;
import tratadores_de_eventos.Pedir_Carta;
import tratadores_de_eventos.Sair_listener;
@SuppressWarnings("serial")
public class Janela_Jogador extends JFrame implements Observer{
	private final int ALTURA=350,LARGURA=300;
	private JPanel painel=new JPanel();
	private Pontuacao pont;
	private ArrayList<JPanel> lista_painel=new ArrayList<JPanel>();
	private JPanel painel_resultado;
	private Texto_Aposta aposta;
	private Dinheiro_View dinheiro;
	private JButton bAposta;
	private JButton bPedir;
	private JButton bFicar;
	private JButton bDobrar;
	private JButton bAllin;
	private JPanel pComprar_credito;
	public Janela_Jogador(String nome,int x,int y,int i){
		super(nome);
		setLayout(null);
		Container c=getContentPane();
		painel.setBounds(25,70, 250, 100);
		bPedir=new JButton("Pedir");
		bPedir.setBounds(0,220,100,50);
		bFicar=new JButton("Ficar");
		bFicar.setBounds(100,220,100,50);
		ActionListener ficarlistener=new Ficar();
		bFicar.addActionListener(ficarlistener);
		c.add(bFicar);
		ActionListener listener=new Pedir_Carta();
		bPedir.addActionListener(listener);
		c.add(bPedir);
		bAposta=new JButton("Apostar");
		bAposta.setBounds(0,270,100,50);
		bAposta.addActionListener(new Apostar_listener());
		c.add(bAposta);
		aposta=new Texto_Aposta();
		aposta.setBounds(5,20,80,50);
		aposta.setOpaque(false);
		bDobrar=new JButton("Dobrar");
		bDobrar.setBounds(200,220,100,50);
		bDobrar.addActionListener(new Dobrar_listener());
		c.add(bDobrar);
		bAllin=new JButton("All-in");
		bAllin.setBounds(100,270,100,50);
		bAllin.addActionListener(new Allin_listener());
		c.add(bAllin);
		add_fichas(i);
		pComprar_credito=new Imagem_Panel("imagens/BuyMore.png",0,0);
		pComprar_credito.setBounds(100,0, 200, 50);
		pComprar_credito.addMouseListener(new Comprar_listener(i));
		pComprar_credito.setOpaque(false);
		add(pComprar_credito);
		Pontuacao pont=new Pontuacao();
		JPanel p=new Imagem_Panel("imagens/Jogador_Mesa.jpg",0,0);
		p.setBounds(0,0,LARGURA,ALTURA);
		painel.setOpaque(false);
		add(painel);
		add(p);
		dinheiro=new Dinheiro_View();
		dinheiro.setBounds(5,5,100,50);
		dinheiro.setOpaque(false);
		add(dinheiro,0);
		pont.setOpaque(false);
		pont.setForeground(Color.black);
		pont.setBounds(5,35,220,20);
		this.pont=pont;
		c.add(pont,0);
		add(aposta,0);
		setResizable(false);
		setBounds(x, y, LARGURA, ALTURA);
		setVisible(true);
		this.addWindowListener(new Sair_listener(i));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	private void add_card(){
		int LARGURA=25,ALTURA=70;
		int pos=0;
		int aux;
		if( lista_painel.size()<=1){
			aux=0;
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
		repaint();
	}
	public void win(){
		JPanel p=new Imagem_Panel("imagens/win.png",0,0);
		p.setBounds(25, 30, 250, 200);
		p.setOpaque(false);
		add(p,0);
		painel_resultado=p;
		repaint();
	}
	public void lose(){
		JPanel p=new Imagem_Panel("imagens/lose.png",0,0);
		p.setBounds(25, 30, 250, 200);
		p.setOpaque(false);
		add(p,0);
		painel_resultado=p;
		repaint();
	}
	public void draw(){
		JPanel p=new Imagem_Panel("imagens/draw.png",0,0);
		p.setBounds(25, 30, 250, 200);
		p.setOpaque(false);
		add(p,0);
		painel_resultado=p;
		repaint();
	}
	public void limpar(){
		if(painel_resultado!= null)remove(painel_resultado);
		for(int i=0;i<lista_painel.size();i++){
			remove(lista_painel.get(i));
		}
		lista_painel.removeAll(lista_painel);
		repaint();
	}
	private void add_fichas(int i){
		int aux=0,largura=50,altura=170;
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
				List<Carta> lista=((Jogador)arg1).get_list();
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
			else if(arg1 instanceof Situation){
				change_situation((Situation)(arg1));
			}
			else if(arg1 instanceof Integer){
				dinheiro.mudar_valor((int)arg1);
			}
		}
	}
	private void change_situation(Situation situation) {
		switch(situation){
			case APOSTAR:
				bAposta.setEnabled(true);
				bAllin.setEnabled(true);
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
			case SAIU:
				if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(this, "Voce nao possui mais fichas", "Sair", JOptionPane.DEFAULT_OPTION )){
					dispose();
				}
				break;
			case NDOBRA:
				habilitar();
				bDobrar.setEnabled(false);
				break;
			default:
				habilitar();
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
	public void habilitar(){
		bDobrar.setEnabled(true);
		bPedir.setEnabled(true);
		bFicar.setEnabled(true);
	}
	public Texto_Aposta get_observer(){
		return aposta;
	}
	
	public void criar_dialogo(int i,int opcoes){
		switch(opcoes){
			case(0):
				JOptionPane.showMessageDialog(this, "Voce nao possui mais credito");
				break;
			case(1):
				JOptionPane.showMessageDialog(this, "Voce nao pode efetuar compras durante a rodada");
				break;
			case(2):
				if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(this, "Temm certeza que gostaria de comprar mais credito?")){
					Controle_do_jogo.comprar_credito(i);
				}
				break;
			default:
				
		}
		
	}

}
