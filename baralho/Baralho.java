package baralho;

import java.util.*;

public class Baralho {
	private static Carta[] baralho = null;
	public static int corrente = 0;
	final static int NUMDEBARALHOS = 6, NUMDECARTAS = 52;

	private Baralho() {
		int valor = 2;
		Carta temp;
		baralho = new Carta[NUMDECARTAS * NUMDEBARALHOS];
		for (int i = 0; i < NUMDECARTAS / 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < NUMDEBARALHOS; k++) {
					temp = new Carta(valor, String.format(
							"imagens/Carta%d.gif", j + 4 * i));
					baralho[k + NUMDEBARALHOS * (4 * i + j)] = temp;
				}
			}
			valor++;
			if (valor > 10) {
				valor = 10;
			}
			if (i == 11) {
				valor = 11;
			}

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
