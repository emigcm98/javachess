package Modelo;

public class Rey extends Pieza{

	
	// indica si ha enrocado este turno
	private boolean enroque_corto;
	private boolean enroque_largo;	
	
	public Rey(int x, int y, boolean is_white, Tablero tablero)
    {
        super(x,y,is_white, tablero); // mirar
      
        if (is_white)setFilePath("rey_blanco.png"); 
        else setFilePath("rey_negro.png");
    }
    
    
    public boolean getEnroqueCorto() {
    	
    	return enroque_corto;
    }
    
    public boolean getEnroqueLargo() {
    	
    	return enroque_largo;
    }
    
    private boolean ilegalMovement(int destination_x, int destination_y) {
    	
    	return false;
    }
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
        setHaComido(false);
    	int distanciaX = Math.abs(destination_x - this.getX());
    	int distanciaY = Math.abs(destination_y - this.getY());
    	enroque_corto = false;
    	enroque_largo = false;
    	
    	Pieza aux = tablero.getPiece(destination_x, destination_y);
    	if (distanciaX <= 1 && distanciaY <= 1) {
    		
    		if (aux != null) { // hay pieza
    			
    			if (this.isWhite() && aux.isBlack()) {
    				if (ilegalMovement(destination_x, destination_y)) { // no puede mover, le dan jaque
    					return false;
    				}
    				setHaComido(true);
    				return true;
    			}
    			if (this.isBlack() && aux.isWhite()) {
    				if (ilegalMovement(destination_x, destination_y)) { // no puede mover, le dan jaque
    					return false;
    				}
    				setHaComido(true);
    				return true;
    			}
    		}
    		else {
    			
    			if (ilegalMovement(destination_x, destination_y)) { // no puede mover, le dan jaque
					return false;
				}
    			return true;
    		}
    	}
    	 	
    	// enroque corto
    	
    	if (destination_x - this.getX() == -2 && destination_y == this.getY()) {
    		
    		if (tablero.getPiece(this.getX()-1, this.getY())== null && tablero.getPiece(this.getX()-2, this.getY())== null) {
    			
    			Pieza torre = tablero.getPiece(this.getX()-3, this.getY());

    			if (!this.getHasMoved() && torre != null && torre instanceof Torre && !((Torre) torre).getHasMoved()) {

    				torre.setX(this.getX()-1);
    				enroque_corto = true;
    				return true;
    			}
    		}
    	}
    	
    	// enroque largo
    	
    	if (destination_x - this.getX() == + 2 && destination_y == this.getY()) {
    		if (tablero.getPiece(this.getX()+1, this.getY())== null && tablero.getPiece(this.getX()+2, this.getY())== null && tablero.getPiece(this.getX()+3, this.getY())==null) {
    			
    			Pieza torre = tablero.getPiece(this.getX()+4, this.getY());

    			if (!this.getHasMoved() && torre != null && torre instanceof Torre && !((Torre) torre).getHasMoved()) {

    				torre.setX(this.getX()+1);
    				enroque_largo = true;
    				return true;
    			}
    		}
    	}
        
    	// comprobación movimiento jaque
    	

    	
        return false;
    }

}
