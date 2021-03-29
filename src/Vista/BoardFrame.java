package Vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.security.auth.login.Configuration;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Modelo.Partida;
import Modelo.Tablero;

@SuppressWarnings("serial")
public class BoardFrame extends JFrame {
    Tablero tablero;
    
    private JTable table;
    private DefaultTableModel dataModel;
    
    private JPanel panelIzquierdo;
    private JButton jButtonExport;
    private JButton jButtonResign;
    
    private int filas = 0;
    
    private static BoardFrame boardFrame;
    
    
    // aquí siempre va a existir (SE ASUME)
    public static BoardFrame getBoardFrame() {
		//if (boardFrame == null)boardFrame = new BoardFrame(main_color);
		return boardFrame;
	}
    
    // crear según el color que queremos ser
    public static BoardFrame getBoardFrame(boolean color) {
		if (boardFrame == null)boardFrame = new BoardFrame(color);
		return boardFrame;
    }
    
    private BoardFrame(boolean color)
    {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Chess");
        this.setResizable(false);
        tablero = new Tablero(color);
        this.add(tablero, BorderLayout.CENTER);
        
        panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
        
        jButtonResign = new JButton("Resign");
        panelIzquierdo.add(jButtonResign);
        jButtonExport = new JButton("PGN");
        jButtonExport.setVisible(false);
        panelIzquierdo.add(jButtonExport);
        
        
        this.add(panelIzquierdo, BorderLayout.WEST);
        
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    setLocation(x, y);
	    
	    config();
	    
        this.pack();
        this.setVisible(true);
      
    }
    
    public void addExportButton() {
    	
    	jButtonExport.setVisible(true);
    	revalidate();
    	repaint();
    }
    
    private void config() {
    	
    	String[] columnNames = {"N",
                "Blancas",
                "Negras"};
    	
	
    	dataModel = new DefaultTableModel() {
    		
    		@Override
    	    public int getColumnCount() {
    	         return columnNames.length;
    	    }

    	    @Override
    	    public boolean isCellEditable(int row, int col) {
    	         return false;
    	    }

    	   /* @Override
    	    public int getRowCount() {
    	         return filas;
    	    }*/
    		
    	    @Override
    	    public String getColumnName(int index) {
    	        return columnNames[index];
    	    }
    	    
    	};
    
        table = new JTable(dataModel);
        
        
        JScrollPane scrollpane = new JScrollPane(table);

        
        //dataModel.addTableModelListener(table); // la tabla se suscribe para repintar
        
        this.add(scrollpane, BorderLayout.EAST);
        
        jButtonResign.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// el jugador pierde
				tablero.resign();			
			}
		});
        
        // EXPORT TO PGN
        
        jButtonExport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//aquí le tiene que pedir la partida a ControladorPartida (no implementado)
				//DEBUG			
				Partida p = tablero.getPartida(); // trampa (o no? usar controlador?)
				// copy to clipboard!
				String pgn = p.exportToPGN();
				StringSelection stringSelection = new StringSelection(pgn);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null); 
				jButtonExport.setToolTipText("Copy to clipboard!");
			}
		});
    }
    
    public void addDato(String dato, int fila, int columna) { // para escribir la jugada
    	
    	
    	if(columna == 0) { // añadimos nueva fila
    		filas++;
    		Object [] obj = {dato};  		
    		dataModel.addRow(obj);
    		
    	}
    	else {
    		dataModel.setValueAt(dato, fila, columna);
    	}
    	
    }
}