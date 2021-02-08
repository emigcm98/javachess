package Modelo;

public class Alfil extends Pieza {

	
	public Alfil(int x, int y, boolean is_white, Tablero tablero)
    {
        super(x,y,is_white, tablero); // mirar

        if (is_white)setFilePath("alfil_blanco.png"); 
        else setFilePath("alfil_negro.png");
    }

    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
        
    	setHaComido(false);
    	
    	if (destination_x == this.getX() || destination_y == this.getY() || (Math.abs(destination_x - this.getX()) != Math.abs(destination_y - this.getY())))
    		return false;
    	else { // cada una de las direcciones
    		
    		 String direccion = "";
    	        if (destination_y > this.getY() && destination_x > this.getX()) direccion = "d_abajo_derecha";
    	        if (destination_y < this.getY() && destination_x < this.getX()) direccion = "d_arriba_izquierda";
    	        if (destination_x > this.getX() && destination_y < this.getY()) direccion = "d_arriba_derecha";
    	        if (destination_x < this.getX() && destination_y > this.getY()) direccion = "d_abajo_izquierda";
    	        
    	        // x e y son iguales
    	        int espacio = Math.abs(destination_y - this.getY());  
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
    	        
    	        // comer pieza: no se puede si mismos colores y la casilla destino tiene una pieza
    	        Pieza aux = tablero.getPiece(destination_x, destination_y);
    	        if (this.isWhite() && aux != null) {
    	        	if(aux.isWhite())return false;
    	        	else setHaComido(true);
    	        }
    	        if (this.isBlack() && aux!= null) {
    	        	if (aux.isBlack())return false;
    	        	else setHaComido(true);
    	        }
    	}
    	return true;
    }
    	
}
