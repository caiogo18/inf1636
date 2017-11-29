package baralho;

public enum Valor {
	DOIS(2), TRES(3), QUATRO(4), CINCO(5), SEIS(6), SETE(7), OITO(8), NOVE(9), DEZ(10), REI(10), VALETE(10), DAMA(10), AS(11) ;
	private int pont;
	 
	private Valor(int pont){
		this.pont = pont;
	}
 
	public int getPont(){
		return pont;
	}
}
