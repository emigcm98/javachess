package Modelo;

public class Dama extends Pieza{
	
	public Dama(int x, int y, boolean is_white, Tablero tablero)
    {
        super(x,y,is_white, tablero); // mirar
        
        if (is_white)setFilePath("reina_blanca.png"); 
        else setFilePath("reina_negra.png");
    }
  
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
       
    	setHaComido(false);
    	// modo alfil y modo torre
    	if ((Math.abs(destination_x - this.getX()) != Math.abs(destination_y - this.getY())) && (this.getX() != destination_x && this.getY() != destination_y))
    		return false;
    	else { // cada una de las direcciones
    		
    		 String direccion = "";
    	        if (destination_y > this.getY() && destination_x > this.getX()) direccion = "d_abajo_derecha";
    	        else if (destination_y < this.getY() && destination_x < this.getX()) direccion = "d_arriba_izquierda";
    	        else if (destination_x > this.getX() && destination_y < this.getY()) direccion = "d_arriba_derecha";
    	        else if (destination_x < this.getX() && destination_y > this.getY()) direccion = "d_abajo_izquierda";
    	        else if (destination_y > this.getY() && destination_x == this.getX()) direccion = "sur";
    	        else if (destination_y < this.getY() && destination_x == this.getX()) direccion = "norte";
    	        else if (destination_x > this.getX() && destination_y == this.getY()) direccion = "este";
    	        else if (destination_x < this.getX() && destination_y == this.getY()) direccion = "oeste";
    	        
    	        System.out.println("direccion: "+ direccion);
    	        
    	        // x e y son iguales
    	        int espacio = Math.abs(destination_y - this.getY());  
    	        int espacioX = Math.abs(destination_x - this.getX());
    	        
    	        if (direccion.equals("d_abajo_izquierda")) {

    	        	for (int i = 1; i < espacio; i++) {
    	        		if (tablero.getPiece(this.getX() - i, this.getY() + i)!=null)return false; // hay pieza, no se puede pasar
    	        	}
    	        }
    	        if (direccion.equals("d_arriba_derecha")) {

    	        	for (int i = 1; i < espacio; i++) {
    	        		if (tablero.getPiece(this.getX() + i, this.getY() - i)!=null)return false; // hay pieza, no se puede pasar
    	        	}
    	        }
    	           
    	        if (direccion.equals("d_arriba_izquierda")) {

    	        	for (int i = 1; i < espacio; i++) {
    	        		if (tablero.getPiece(this.getX() - i, this.getY() -i)!=null)return false; // hay pieza, no se puede pasar
    	        	}
    	        }
    	        if (direccion.equals("d_abajo_derecha")) {

    	        	for (int i = 1; i < espacio; i++) {
    	        		if (tablero.getPiece(this.getX() + i, this.getY() + i)!=null)return false; // hay pieza, no se puede pasar
    	        	}
    	        }
    	        if (direccion.equals("sur")) {
    	        	
    	        	for (int i = 1; i < espacio; i++) {
    	        		if (tablero.getPiece(this.getX(), this.getY() + i)!=null)return false; // hay pieza, no se puede pasar
    	        	}
    	        }
    	        if (direccion.equals("norte")) {
    	        	
    
    	        	for (int i = 1; i < espacio; i++) {
    	        		if (tablero.getPiece(this.getX(), this.getY() - i)!=null)return false; // hay pieza, no se puede pasar
    	        	}
    	        }
    	           
    	        if (direccion.equals("este")) {
    	        	
    	        	for (int i = 1; i < espacioX; i++) {
    	        		if (tablero.getPiece(this.getX() + i, this.getY())!=null)return false; // hay pieza, no se puede pasar
    	        	}
    	        }
    	        if (direccion.equals("oeste")) {
    	        	    	        	
    	        	for (int i = 1; i < espacioX; i++) {
    	        		if (tablero.getPiece(this.getX() - i, this.getY())!=null)return false; // hay pieza, no se puede pasar
    	        	}
    	        }
    	        
    	        // comer pieza: no se puede si mismos colores y la casilla destino tiene una pieza
    	        Pieza aux = tablero.getPiece(destination_x, destination_y);
    	        if (aux != null) {

    	        	if (this.isWhite() && aux.isWhite())return false;
    	        	else setHaComido(true);
    	        	
    	        	if (this.isBlack() && aux.isBlack())return false;
    	        	else setHaComido(true);
    	        }
    	        
    	}
    	return true;
    }
}
