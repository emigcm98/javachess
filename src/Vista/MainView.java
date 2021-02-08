package Vista;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.ControladorUsuario;
import Modelo.Usuario;

public class MainView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Usuario userActual;
	
	private final JLabel lblTUsername = new JLabel("Username:");
	private final JLabel lblTElo = new JLabel("Elo:");
	private JLabel lblUsername;
	private JLabel lblElo;
	
	private JTextField tElo;
	private JButton bElo;
	
	private JButton bJugar;
	
    private static MainView mv;
    
    
    public static MainView getMainView() {
    	
    	if (mv == null)mv= new MainView();
    	return mv;
    }
	
	private MainView() {
		
		userActual = ControladorUsuario.getUnicaInstancia().getUsuarioActual();
		lblUsername = new JLabel(userActual.getUsername());
		lblElo = new JLabel(String.valueOf(userActual.getElo()));
		
		setTitle("MainView to Chess");
		setSize(new Dimension(300, 400));
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		config();
		this.setVisible(true);
	}
	
	private void config() {
	
		JPanel pPrincipal = new JPanel();
		pPrincipal.setLayout(new BoxLayout(pPrincipal, BoxLayout.Y_AXIS));
		
		JPanel panelInfo = new JPanel(new GridLayout(2, 2));
		panelInfo.add(lblTUsername);
		panelInfo.add(lblUsername);
		panelInfo.add(lblTElo);
		panelInfo.add(lblElo);
		
		add(pPrincipal);
		
		tElo = new JTextField(10);
		bElo = new JButton("GO");
		
		bJugar = new JButton("+");
		
		JPanel panelElo = new JPanel();
		panelElo.add(tElo);
		panelElo.add(bElo);
		
		pPrincipal.add(panelInfo);
		pPrincipal.add(panelElo);
		pPrincipal.add(bJugar);
		bElo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String elo = tElo.getText().trim();
				if (elo.length() > 2) {
					
					ControladorUsuario.getUnicaInstancia().actualizarElo(userActual.getUsername(), tElo.getText().trim());
					actualizarElo();
				}
			}
		});
		
		bJugar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				// true = blancas, false = negras				
				@SuppressWarnings("unused")
				BoardFrame bf = BoardFrame.getBoardFrame(true);
				mv.dispose();
			}
		});
		
		
		
		
	}
	
	private void actualizarElo() {
		
		lblElo.setText(String.valueOf(userActual.getElo()));
		revalidate();
		repaint();
	}
}
