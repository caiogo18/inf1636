package baralho;

import java.io.Serializable;
import java.util.*;

public class Baralho implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2381203491898824125L;
	private Carta[] cartas = null;
	private  int corrente = 0;
	private static Baralho baralho;
	final static int NUMDEBARALHOS = 6,NUMDECARTAS=52;

	private Baralho() {
		int i = 0;
		cartas= new Carta[NUMDEBARALHOS*NUMDECARTAS];
		for (int n = 0; n < NUMDEBARALHOS; n++)
			for (Valor valor : Valor.values())
				for (Naipe naipe : Naipe.values()) {
					cartas[i]=new Carta(valor,naipe);
					i++;
				}

	}

	public static void embaralha() {
		if (baralho == null)
			baralho=new Baralho();
		baralho.corrente = 0;
		List<Carta> list = Arrays.asList(baralho.cartas);
		Collections.shuffle(list);
		baralho.cartas = (Carta[]) list.toArray();
	}

	public static Carta get() {
		baralho.corrente++;
		return baralho.cartas[baralho.corrente - 1];
	}
	public static void recupera(Baralho b){
		if (baralho == null)
			baralho=b;
	}
	public static Baralho get_baralho(){
		return baralho;
	}
}
