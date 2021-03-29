package Modelo;

public class Peon extends Pieza {

    //private boolean has_moved;
    private boolean mover_doble;
    private int last_move;
    
    public Peon(int x, int y, boolean is_white, Tablero tablero)
    {
        super(x,y,is_white, tablero); // mirar
        //has_moved = false; // para el primer movimiento
        mover_doble = false;
        
        if (is_white)setFilePath("peon_blanco.png"); 
        else setFilePath("peon_negro.png");
    }   
    
    public boolean getMoverDoble() {
    	return mover_doble;
    }
    
    public int getLastMove() {
		return last_move;
	}
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
    	last_move = 0;
    	// si eres blancas, va hacia arriba
    	Pieza aux = tablero.getPiece(destination_x, destination_y);
    	mover_doble = false;
    	setHaComido(false);
    	
    	Pieza peon_paso = tablero.getPiece(this.getX()+1, this.getY()); // por la derecha para las blancas
		Pieza peon_paso2 = tablero.getPiece(this.getX()-1, this.getY()); // por la izquierda
    	
		// YA NO VALE COMPROBACIÓN POR COLOR por el hecho de haber cambiado las piezas
    	if (this.isWhite()) {

    		if ((destination_y - this.getY() == 2) && destination_x == this.getX() && !getHasMoved()) { // primer movimiento

    			int espacio = Math.abs(destination_y - this.getY()); // no hay pieza en medio
    			for (int i = 1; i < espacio; i++) {
    				if (tablero.getPiece(this.getX(), this.getY()+i)!=null)return false; // hay pieza, no se puede pasar
    			}	
    			mover_doble = true;
    			return true;
    		}

    
    		if ((destination_y - this.getY() == 1) && destination_x == this.getX() && aux== null) { // uno hacia delante y no hay pieza
    			return true;
    		}
    		
    		if (destination_y - this.getY() == 1 && Math.abs(destination_x - this.getX()) == 1 && aux != null && aux.isBlack()) {
    			setHaComido(true);
    			last_move = destination_x - this.getX();
    			return true;
    		}
    		
    		// comer al paso
    		
    		
    		//if (!(peon_paso instanceof Peon || peon_paso2 instanceof Peon))return false; // no es un peón
    	
    		if (peon_paso != null && peon_paso.isBlack() && peon_paso instanceof Peon && ((Peon)peon_paso).getMoverDoble()) {
    			
    			if (destination_x - this.getX() == 1 && destination_y - this.getY() == 1) {
    				tablero.Black_Pieces.remove(peon_paso);
    				setHaComido(true);
    				return true;
    			}
    			
    		}
    		if (peon_paso2 != null && peon_paso2.isBlack() && peon_paso2 instanceof Peon && ((Peon)peon_paso2).getMoverDoble()) {
    			
    			if (destination_x - this.getX() == -1 && destination_y - this.getY() == 1) {
    				tablero.Black_Pieces.remove(peon_paso2);
    				setHaComido(true);
    				return true;
    			}
    			
    		}
    		
    	}

    	// si eres negras, va hacia abajo
    	
    	if (this.isBlack()) {

    		if ((destination_y - this.getY() == -2) && destination_x == this.getX() && !getHasMoved()) { // primer movimiento

    			int espacio = Math.abs(destination_y - this.getY()); // no hay pieza en medio
    			for (int i = 1; i < espacio; i++) {
    				if (tablero.getPiece(this.getX(), this.getY()-i)!=null)return false; // hay pieza, no se puede pasar
    			}	
    			mover_doble = true;
    			return true;
    		}

    		if ((destination_y - this.getY() == -1) && destination_x == this.getX() && aux== null) { // uno hacia delante
    			
    			
    			return true;
    		}

    		if (destination_y - this.getY() == -1 && Math.abs(destination_x - this.getX()) == 1 && aux != null && aux.isWhite()) {
    			
    			setHaComido(true);
    			last_move = destination_x - this.getX();
    			return true;
    		}
    		
    		// comer al paso
    		
    		if (peon_paso != null && peon_paso.isWhite() && peon_paso instanceof Peon && ((Peon)peon_paso).getMoverDoble()) {
    			
    			if (destination_x - this.getX() == 1 && destination_y - this.getY() == -1) {
    				tablero.White_Pieces.remove(peon_paso);
    				setHaComido(true);
    				return true;
    			}
    			
    		}
    		if (peon_paso2 != null && peon_paso2.isWhite() && peon_paso2 instanceof Peon && ((Peon)peon_paso2).getMoverDoble()) {
    			
    			if (destination_x - this.getX() == -1 && destination_y - this.getY() == -1) {
    				tablero.White_Pieces.remove(peon_paso2);
    				setHaComido(true);
    				return true;
    			}
    			
    		}
    	}
   	              
        return false;
    }


}