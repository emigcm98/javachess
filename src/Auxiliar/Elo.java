package Auxiliar;


public class Elo {

	public enum Resultado
	{
	    BLANCAS, NEGRAS, TABLAS;
		
		@Override
		public String toString() {
			switch(this) {
				case BLANCAS: return "1-0";
				case NEGRAS: return "0-1";
				case TABLAS: return "1/2-1/2";
				default: return null;
			}
		}
	}
	
	public static ResultadoElo cambioElo(int eloBlancas, int eloNegras, Resultado r, int k) {
		
		double r1,r2;
		double e1,e2;
		double s1,s2;
		
		if (r == Resultado.BLANCAS) {
			s1=1;
			s2=0;
		} 
		else if (r == Resultado.TABLAS) {
			s1=0.5;
			s2=0.5;
		}
		else if (r == Resultado.NEGRAS) {
			s1=0;
			s2=1;
		}
		else { // es null
			return null;
		}
		
		r1 = Math.pow(10, (double)eloBlancas/400);
		r2 = Math.pow(10, (double)eloNegras/400);
		
		e1 = r1 / (r1 + r2);
		e2 = r2 / (r1 + r2);
		
		r1 = eloBlancas + k * (s1 - e1);
		r2 = eloNegras + k * (s2 - e2);

		
		return new ResultadoElo((int)Math.round(r1),(int)Math.round(r2));
	}
	
	// DEBUG
	/*public static void main(String[] args) {
		
		int elo1 = 2400;
		int elo2 = 2000;
		
		ResultadoElo res = Elo.cambioElo(2403, 1997, Resultado.NEGRAS, 32);
		System.out.println("Se queda " + res.getEloBlancas() + " y " + res.getEloNegras());

	}*/
	
}

class ResultadoElo {
	
	private int eloBlancas;
	private int eloNegras;
	
	public ResultadoElo(int eloBlancas, int eloNegras) {
		// TODO Auto-generated constructor stub
		this.eloBlancas=eloBlancas;
		this.eloNegras=eloNegras;
	}
	
	public int getEloBlancas() {
		return eloBlancas;
	}
	
	public int getEloNegras() {
		return eloNegras;
	}
}

