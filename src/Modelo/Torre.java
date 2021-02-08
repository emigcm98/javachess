package Modelo;

public class Torre extends Pieza {
	
	public Torre(int x, int y, boolean is_white, Tablero tablero)
    {
        super(x,y,is_white, tablero); // mirar

        if (is_white)setFilePath("torre_blanca.png"); 
        else setFilePath("torre_negra.png");
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
        
    	Pieza aux = tablero.getPiece(destination_x, destination_y);
    	setHaComido(false);
    	
        if (aux != null) {
        	// hay una pieza
        	
        	if (aux.isWhite() && this.isWhite())return false;
        	else setHaComido(true);
        	if (aux.isBlack() && this.isBlack())return false;
        	else setHaComido(true);
        }
        
        if (this.getX() != destination_x && this.getY() != destination_y) return false;// solo linea recta
        
        String direccion = "";
        if (destination_y > this.getY()) direccion = "sur";
        if (destination_y < this.getY()) direccion = "norte";
        if (destination_x > this.getX()) direccion = "este";
        if (destination_x < this.getX()) direccion = "oeste";
        
        if (direccion.equals("sur")) {
        	
        	int espacio = Math.abs(destination_y - this.getY());
        	for (int i = 1; i < espacio; i++) {
        		if (tablero.getPiece(this.getX(), this.getY() + i)!=null)return false; // hay pieza, no se puede pasar
        	}
        }
        if (direccion.equals("norte")) {
        	
        	int espacio = Math.abs(destination_y - this.getY());
        	for (int i = 1; i < espacio; i++) {
        		if (tablero.getPiece(this.getX(), this.getY() - i)!=null)return false; // hay pieza, no se puede pasar
        	}
        }
           
        if (direccion.equals("este")) {
        	
        	int espacio = Math.abs(destination_x - this.getX());
        	for (int i = 1; i < espacio; i++) {
        		if (tablero.getPiece(this.getX() + i, this.getY())!=null)return false; // hay pieza, no se puede pasar
        	}
        }
        if (direccion.equals("oeste")) {
        	
        	int espacio = Math.abs(destination_x - this.getX());
        	for (int i = 1; i < espacio; i++) {
        		if (tablero.getPiece(this.getX() - i, this.getY())!=null)return false; // hay pieza, no se puede pasar
        	}
        }
        
        return true;
    }

}
