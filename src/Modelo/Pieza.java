package Modelo;

public abstract class Pieza {


	private int x;
	private int y;
	final private boolean is_white;
	private String file_path;
	public Tablero tablero; // Mirar esto

	private boolean has_moved;
	private boolean ha_comido;
	
	public Pieza(int x, int y, boolean is_white, Tablero tablero)
	{
		this.is_white = is_white;
		this.x = x;
		this.y = y;
		this.tablero = tablero;
		
		has_moved = false;
		ha_comido = false;
	}

	public boolean getHasMoved() {
		return has_moved;
	}
	
	public void setHas_moved(boolean has_moved) {
		this.has_moved = has_moved;
	}
	
	public boolean getHaComido() {
		return ha_comido;
	}
	
	public void setHaComido(boolean ha_comido) {
		this.ha_comido = ha_comido;
	}
	
	public String getFilePath()
	{
		return file_path;
	}

	public void setFilePath(String path)
	{
		this.file_path = path;
	}

	public boolean isWhite()
	{
		return is_white;
	}

	public boolean isBlack()
	{
		return !is_white;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
	
	public boolean isJaque() {
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j <7; j++) {
				Pieza aux = tablero.getPiece(j, i);
				if (canMove(j, i) && aux != null && aux instanceof Rey && aux.isWhite() != this.isWhite()) return true;
			}
		}
		return false;
	}
	
	// para ver si le da jaque al rey el bando opuesto en esa posición que quiere mover (x, y)
	
	public abstract boolean canMove(int destination_x, int destination_y);


}
