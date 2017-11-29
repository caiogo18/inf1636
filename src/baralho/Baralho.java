package baralho;

import java.util.*;

public class Baralho {
	private static Carta[] baralho = null;
	public static int corrente = 0;
	final static int NUMDEBARALHOS = 6,NUMDECARTAS=52;

	private Baralho() {
		int i = 0;
		baralho= new Carta[NUMDEBARALHOS*NUMDECARTAS];
		for (int n = 0; n < NUMDEBARALHOS; n++)
			for (Valor valor : Valor.values())
				for (Naipe naipe : Naipe.values()) {
					baralho[i]=new Carta(valor,naipe);
					i++;
				}

	}

	public static void embaralha() {
		if (baralho == null)
			new Baralho();
		corrente = 0;
		List<Carta> list = Arrays.asList(baralho);
		Collections.shuffle(list);
		baralho = (Carta[]) list.toArray();
	}

	public static Carta get() {
		corrente++;
		return baralho[corrente - 1];
	}
}
