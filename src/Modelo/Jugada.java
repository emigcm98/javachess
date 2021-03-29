package Modelo;

// esta clase representa al movimiento que hace un jugador (color)
public class Jugada {

	private boolean white;
	private int x;
	private int y;
	private String notacion;
	private Pieza p;
	private boolean ha_comido;
	private boolean jaque;
	private boolean jaque_mate;
	private boolean enroque_corto = false;
	private boolean enroque_largo = false;
	
	// el movimiento que hace una pieza a una posición, y si ha o no comido
	public Jugada(Pieza p, int x, int y, boolean ha_comido, boolean jaque, boolean jaque_mate) {
		
		this.p = p;
		white = p.isWhite();
		this.x = x; // mirar si sacar de aquí o de la pieza una vez movida
		this.y = y;
		this.ha_comido = ha_comido;
		
		this.jaque=jaque;
		this.jaque_mate=jaque_mate;
		
		calcularNotación();
		
	}
	
	
	private void calcularNotación() {
		
		if (p instanceof Rey && ((Rey) p).getEnroqueCorto()) notacion = "0-0";
		else if (p instanceof Rey && ((Rey) p).getEnroqueLargo()) notacion = "0-0-0";
		else {
			
			if(p instanceof Peon && ha_comido)notacion = Character.toString((char)(8-x+((Peon) p).getLastMove()+96)); // el peon es solo si come			
			if(p instanceof Alfil)notacion = "B"; // Bishop
			if(p instanceof Peon && !ha_comido)notacion = ""; // pawn
			if(p instanceof Caballo)notacion = "N"; // kNight
			if(p instanceof Dama)notacion = "Q"; // Queen
			if(p instanceof Rey)notacion = "K"; // King
			if(p instanceof Torre)notacion = "R"; // Rook
			
			if(ha_comido)notacion+="x";
			
			notacion+=convertirCasillas(x, y);		
		}
		
		if(jaque)notacion+="+";
		else if(jaque_mate)notacion+="#";
		
	}
	
	public boolean is_white() {
		return white;
	}
	
	// al jugar con blancas: MIRAR
	private String convertirCasillas(int x, int y) { // cambiar retorno
		return ""+(char)(8-x+96) + (y+1);
	}
	
	public String getNotacion() {
		return notacion;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return notacion;
	}
}
