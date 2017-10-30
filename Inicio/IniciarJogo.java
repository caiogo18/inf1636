package Inicio;
import jogo.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class IniciarJogo implements ActionListener{
	private JTextField[] vt;
	public IniciarJogo(JTextField[] vt){
		this.vt=vt;
	}
	public void actionPerformed(ActionEvent e) {
		TelaInicial.get_frame().dispose();
		String[] nomes=new String[vt.length];
		for(int i=0;i<nomes.length;i++){
			nomes[i]=vt[i].getText();
		}
		Controle_do_jogo jogo=new Controle_do_jogo(nomes);
		jogo.Criar_jogadores();
	}

}
