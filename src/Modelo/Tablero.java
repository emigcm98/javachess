package Modelo;

//import chessgui.pieces.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;

import Auxiliar.Elo.Resultado;
import Controlador.ControladorUsuario;
import Vista.BoardFrame;

@SuppressWarnings("serial")
public class Tablero extends JComponent {


	public int turnCounter = 0;
	private static Image NULL_IMAGE = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);

	private final int Square_Width = 65;
	public ArrayList<Pieza> White_Pieces;
	public ArrayList<Pieza> Black_Pieces;

	public ArrayList<DrawingShape> Static_Shapes;
	public ArrayList<DrawingShape> Piece_Graphics;

	public Pieza Active_Piece;

	private final int rows = 8;
	private final int cols = 8;
	private Integer[][] BoardGrid;
	private String board_file_path = "images" + File.separator + "board.png";
	private String active_square_file_path = "images" + File.separator + "active_square.png";
	
	private boolean main_color;
	
	private boolean fin; // indica si se ha acabado la partida

	// como publics de prueba
	public boolean blancas_en_jaque;
	public boolean negras_en_jaque;
	
	
	private Partida partida; // la partida que se juega en el tablero
	
	public Partida getPartida() {
		return partida;
	}
	
	public void initGrid()
	{
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				BoardGrid[i][j] = 0;
			}
		}

		//Image white_piece = loadImage("images/white_pieces/" + piece_name + ".png");
		//Image black_piece = loadImage("images/black_pieces/" + piece_name + ".png");  

		/*if (main_color) { // blancas			
			poner_blancas();
		}
		else { // negras
			poner_negras();
		}*/
		
		// se asume negras de principio para el jugador
		////////////////// PRUEBA ////////////////////
		Usuario negras = ControladorUsuario.getUnicaInstancia().getUsuarioActual();
		Usuario blancas = new Usuario("stockfish nv 0", "");
		blancas.setElo(1200);
		
		partida = new Partida(blancas, negras);
		
		poner_negras();
	}
	
	/*private void poner_blancas() {
		
		Black_Pieces.add(new Rey(4,0,false,this));
		Black_Pieces.add(new Dama(3,0,false,this));
		Black_Pieces.add(new Alfil(2,0,false,this));
		Black_Pieces.add(new Alfil(5,0,false,this));
		Black_Pieces.add(new Caballo(1,0,false,this));
		Black_Pieces.add(new Caballo(6,0,false,this));
		Black_Pieces.add(new Torre(0,0,false,this));
		Black_Pieces.add(new Torre(7,0,false,this));
		Black_Pieces.add(new Peon(0,1,false,this));
		Black_Pieces.add(new Peon(1,1,false,this));
		Black_Pieces.add(new Peon(2,1,false,this));
		Black_Pieces.add(new Peon(3,1,false,this));
		Black_Pieces.add(new Peon(4,1,false,this));
		Black_Pieces.add(new Peon(5,1,false,this));
		Black_Pieces.add(new Peon(6,1,false,this));
		Black_Pieces.add(new Peon(7,1,false,this));

		White_Pieces.add(new Rey(4,7,true,this));
		White_Pieces.add(new Dama(3,7,true,this));
		White_Pieces.add(new Alfil(2,7,true,this));
		White_Pieces.add(new Alfil(5,7,true,this));
		White_Pieces.add(new Caballo(1,7,true,this));
		White_Pieces.add(new Caballo(6,7,true,this));
		White_Pieces.add(new Torre(0,7,true,this));
		White_Pieces.add(new Torre(7,7,true,this));
		White_Pieces.add(new Peon(0,6,true,this));
		White_Pieces.add(new Peon(1,6,true,this));
		White_Pieces.add(new Peon(2,6,true,this));
		White_Pieces.add(new Peon(3,6,true,this));
		White_Pieces.add(new Peon(4,6,true,this));
		White_Pieces.add(new Peon(5,6,true,this));
		White_Pieces.add(new Peon(6,6,true,this));
		White_Pieces.add(new Peon(7,6,true,this));
		
	}*/
	
	private void poner_negras() {
		
		White_Pieces.add(new Rey(3,0,true,this));
		White_Pieces.add(new Dama(4,0,true,this));
		White_Pieces.add(new Alfil(2,0,true,this));
		White_Pieces.add(new Alfil(5,0,true,this));
		White_Pieces.add(new Caballo(1,0,true,this));
		White_Pieces.add(new Caballo(6,0,true,this));
		White_Pieces.add(new Torre(0,0,true,this));
		White_Pieces.add(new Torre(7,0,true,this));
		White_Pieces.add(new Peon(0,1,true,this));
		White_Pieces.add(new Peon(1,1,true,this));
		White_Pieces.add(new Peon(2,1,true,this));
		White_Pieces.add(new Peon(3,1,true,this));
		White_Pieces.add(new Peon(4,1,true,this));
		White_Pieces.add(new Peon(5,1,true,this));
		White_Pieces.add(new Peon(6,1,true,this));
		White_Pieces.add(new Peon(7,1,true,this));

		Black_Pieces.add(new Rey(3,7,false,this));
		Black_Pieces.add(new Dama(4,7,false,this));
		Black_Pieces.add(new Alfil(2,7,false,this));
		Black_Pieces.add(new Alfil(5,7,false,this));
		Black_Pieces.add(new Caballo(1,7,false,this));
		Black_Pieces.add(new Caballo(6,7,false,this));
		Black_Pieces.add(new Torre(0,7,false,this));
		Black_Pieces.add(new Torre(7,7,false,this));
		Black_Pieces.add(new Peon(0,6,false,this));
		Black_Pieces.add(new Peon(1,6,false,this));
		Black_Pieces.add(new Peon(2,6,false,this));
		Black_Pieces.add(new Peon(3,6,false,this));
		Black_Pieces.add(new Peon(4,6,false,this));
		Black_Pieces.add(new Peon(5,6,false,this));
		Black_Pieces.add(new Peon(6,6,false,this));
		Black_Pieces.add(new Peon(7,6,false,this));
	}

	// true = blancas, false = negras
	public Tablero(boolean color) {

		BoardGrid = new Integer[rows][cols];
		Static_Shapes = new ArrayList<>();
		Piece_Graphics = new ArrayList<>();
		White_Pieces = new ArrayList<>();
		Black_Pieces = new ArrayList<>();

		main_color = color;
		initGrid();

		this.setBackground(new Color(37,13,84));
		this.setPreferredSize(new Dimension(520, 520));
		this.setMinimumSize(new Dimension(100, 100));
		this.setMaximumSize(new Dimension(1000, 1000));

		this.addMouseListener(mouseAdapter);
		this.addComponentListener(componentAdapter);
		this.addKeyListener(keyAdapter);

		blancas_en_jaque = false;
		negras_en_jaque = false;
		fin = false;

		this.setVisible(true);
		this.requestFocus();
		
		drawBoard();
	}

	// falta implementar
	private boolean isJaque() {
		
		return false;
	}
	
	// falta implementar
	private boolean isJaqueMate() {
		
		return false;
	}
	
	private Resultado es_fin() {
		
		boolean blancas_ok = false;
		boolean negras_ok = false;
		
		for (Pieza p : White_Pieces) {
			if (p instanceof Rey)blancas_ok = true;
		}
		
		for (Pieza p : Black_Pieces) {
			if (p instanceof Rey)negras_ok = true;
		}
		
		Resultado r;
		
		if (blancas_ok && negras_ok)return null;
		else if (!blancas_ok) {
			r = Resultado.NEGRAS;
			partida.setResultado(r);
			BoardFrame.getBoardFrame().addExportButton();
			return r;
		}
		else if (!negras_ok) {
			r = Resultado.BLANCAS;
			partida.setResultado(r);
			BoardFrame.getBoardFrame().addExportButton();
			return r;
		}
		else return null;
	}
	

	private void drawBoard()
	{
		Piece_Graphics.clear();
		Static_Shapes.clear();
		//initGrid();
		
		Image board = loadImage(board_file_path);	
		
		
		// mirar cómo rotar
		Rectangle2D rect = new Rectangle2D.Double(0, 0, board.getWidth(null), board.getHeight(null));

		
		Static_Shapes.add(new DrawingImage(board, rect));
		if (Active_Piece != null)
		{
			Image active_square = loadImage("images" + File.separator + "active_square.png");
			Static_Shapes.add(new DrawingImage(active_square, new Rectangle2D.Double(Square_Width*Active_Piece.getX(),Square_Width*Active_Piece.getY(), active_square.getWidth(null), active_square.getHeight(null))));
		}
		for (int i = 0; i < White_Pieces.size(); i++)
		{
			int COL = White_Pieces.get(i).getX();
			int ROW = White_Pieces.get(i).getY();
			Image piece = loadImage("images" + File.separator + "white_pieces" + File.separator + White_Pieces.get(i).getFilePath());  
			Piece_Graphics.add(new DrawingImage(piece, new Rectangle2D.Double(Square_Width*COL,Square_Width*ROW, piece.getWidth(null), piece.getHeight(null))));
		}
		for (int i = 0; i < Black_Pieces.size(); i++)
		{
			int COL = Black_Pieces.get(i).getX();
			int ROW = Black_Pieces.get(i).getY();
			Image piece = loadImage("images" + File.separator + "black_pieces" + File.separator + Black_Pieces.get(i).getFilePath());  
			Piece_Graphics.add(new DrawingImage(piece, new Rectangle2D.Double(Square_Width*COL,Square_Width*ROW, piece.getWidth(null), piece.getHeight(null))));
		}
		this.repaint();
	}


	public Pieza getPiece(int x, int y) {
		for (Pieza p : White_Pieces)
		{
			if (p.getX() == x && p.getY() == y)
			{
				return p;
			}
		}
		for (Pieza p : Black_Pieces)
		{
			if (p.getX() == x && p.getY() == y)
			{
				return p;
			}
		}
		return null;
	}

	private MouseAdapter mouseAdapter = new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {
			int d_X = e.getX();
			int d_Y = e.getY();  
			int Clicked_Row = d_Y / Square_Width;
			int Clicked_Column = d_X / Square_Width;
			boolean is_whites_turn = true;
			if (turnCounter%2 == 1)
			{
				is_whites_turn = false;
			}

			Pieza clicked_piece = getPiece(Clicked_Column, Clicked_Row);

			if (Active_Piece == null && clicked_piece != null && 
					((is_whites_turn && clicked_piece.isWhite()) || (!is_whites_turn && clicked_piece.isBlack())))
			{
				Active_Piece = clicked_piece;
			}
			else if (Active_Piece != null && Active_Piece.getX() == Clicked_Column && Active_Piece.getY() == Clicked_Row)
			{
				Active_Piece = null;
			}
			else if (Active_Piece != null && Active_Piece.canMove(Clicked_Column, Clicked_Row) 
					&& ((is_whites_turn && Active_Piece.isWhite()) || (!is_whites_turn && Active_Piece.isBlack())))
			{
				// if piece is there, remove it so we can be there
				if (clicked_piece != null)
				{
					if (clicked_piece.isWhite())
					{
						White_Pieces.remove(clicked_piece);
					}
					else
					{
						Black_Pieces.remove(clicked_piece);
					}
				}
				// do move

				Active_Piece.setX(Clicked_Column);
				Active_Piece.setY(Clicked_Row);

				// if piece is a Peon set has_moved to true
				/*if (Active_Piece.getClass().equals(Peon.class))
				{
					Peon castedPeon = (Peon)(Active_Piece);
					castedPeon.setHasMoved(true);
				}*/
				
				Active_Piece.setHas_moved(true);
				
				if (turnCounter%2 == 0) {
					BoardFrame.getBoardFrame().addDato(String.valueOf(turnCounter/2+1), turnCounter/2, 0);
				}
				
				
				Jugada j = new Jugada(Active_Piece, Clicked_Column, Clicked_Row, Active_Piece.getHaComido(), Active_Piece.isJaque(), false);
				partida.addJugada(j);
				
				
				BoardFrame.getBoardFrame().addDato(j.toString(), turnCounter/2, turnCounter%2+1);
				// meter número de jugada
				
				
				Active_Piece = null;
				turnCounter++;
			}
			
			//convertirCasillas(Clicked_Column, Clicked_Row);
			drawBoard();
			
			// Calcular resultado
			Resultado res;
			if ((res = es_fin())!= null) {
				System.out.println("Han ganado " + res.name());
				return;
			}
		}

		@Override
		public void mouseDragged(MouseEvent e) {		
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) 
		{
		}	


	};

	/*// crear clase casilla ??
	private void convertirCasillas(int x, int y) { // cambiar retorno
		System.out.println("Casilla: [" + (char)(8-x+96) + ", " + (y+1)+"]");
	}
	
	private void adjustShapePositions(double dx, double dy) {

		Static_Shapes.get(0).adjustPosition(dx, dy);
		this.repaint();

	} */

	private Image loadImage(String imageFile) {
		try {
			return ImageIO.read(new File(imageFile));
		}
		catch (IOException e) {
			return NULL_IMAGE;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;
		//AffineTransform old = g2.getTransform();
        //g2.rotate(Math.PI);
        //draw shape/image (will be rotated)
		drawBackground(g2);        
        drawShapes(g2);
       
        //g2.setTransform(old);


	}

	private void drawBackground(Graphics2D g2) {
		g2.setColor(getBackground());
		g2.fillRect(0,  0, getWidth(), getHeight());
	}


	private void drawShapes(Graphics2D g2) {
		for (DrawingShape shape : Static_Shapes) {
			shape.draw(g2);
			//shape.drawRotated(g2);
		}	
		for (DrawingShape shape : Piece_Graphics) {
			//shape.draw(g2);
			shape.drawRotated(g2);
		}
	}

	private ComponentAdapter componentAdapter = new ComponentAdapter() {

		@Override
		public void componentHidden(ComponentEvent e) {

		}

		@Override
		public void componentMoved(ComponentEvent e) {

		}

		@Override
		public void componentResized(ComponentEvent e) {

		}

		@Override
		public void componentShown(ComponentEvent e) {

		}	
	};

	private KeyAdapter keyAdapter = new KeyAdapter() {

		@Override
		public void keyPressed(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {

		}

		@Override
		public void keyTyped(KeyEvent e) {

		}	
	};

}

interface DrawingShape {
	boolean contains(Graphics2D g2, double x, double y);
	void adjustPosition(double dx, double dy);
	void draw(Graphics2D g2);
	void drawRotated(Graphics2D g2);
}

class DrawingImage implements DrawingShape {

	public Image image;
	public Rectangle2D rect;

	public DrawingImage(Image image, Rectangle2D rect) {
		this.image = image;
		this.rect = rect;
	}

	@Override
	public boolean contains(Graphics2D g2, double x, double y) {
		return rect.contains(x, y);
	}

	@Override
	public void adjustPosition(double dx, double dy) {
		rect.setRect(rect.getX() + dx, rect.getY() + dy, rect.getWidth(), rect.getHeight());	
	}

	@Override
	public void draw(Graphics2D g2) {

		
		Rectangle2D bounds = rect.getBounds2D();
		g2.drawImage(image, (int)bounds.getMinX(), (int)bounds.getMinY(), (int)bounds.getMaxX(), (int)bounds.getMaxY(),
				0, 0, image.getWidth(null), image.getHeight(null), null);
		
	}	
	
	@Override
	public void drawRotated(Graphics2D g2) {
		// TODO Auto-generated method stub
		
		//BufferedImage img = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		
		
	    Rectangle2D bounds = rect.getBounds2D();
	    
	    //g2.rotate(Math.toRadians(180));
    
		g2.drawImage(image, (int)bounds.getMinX(), (int)bounds.getMinY(), (int)bounds.getMaxX(), (int)bounds.getMaxY(),
				0, 0, image.getWidth(null), image.getHeight(null), null);
	}

}
