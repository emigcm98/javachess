package Modelo;

public class Caballo extends Pieza {

	
	public Caballo(int x, int y, boolean is_white, Tablero tablero)
    {
        super(x,y,is_white, tablero); // mirar

        if (is_white)setFilePath("caballo_blanco.png"); 
        else setFilePath("caballo_negro.png");
    }

    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
        
    	setHaComido(false);
    	int posX = Math.abs(destination_x - getX());
    	int posY = Math.abs(destination_y - getY());
    	
    	if ((posX == 2 && posY == 1) || (posX == 1 && posY == 2)) {
    		
    		Pieza aux = tablero.getPiece(destination_x, destination_y);
    		if (aux != null) {
    			if (this.isWhite() && aux.isBlack()) {
    				setHaComido(true);
    				return true;
    			}
    			if (this.isBlack() && aux.isWhite()) {
    				setHaComido(true);
    				return true;
    			}
    		}
    		else return true; // no hay pieza, se puede
    		
    	}
                    
                
        return false;
    }

}
