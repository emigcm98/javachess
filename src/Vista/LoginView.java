package Vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controlador.ControladorUsuario;

public class LoginView extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JLabel jlblUsername = new JLabel("Username:");
	private final JLabel jlblPassword = new JLabel("Password:");
	
	private final JTextField jtfUsername = new JTextField(15);
	private final JPasswordField jpfPassword = new JPasswordField(15);
	
	private final JButton jbtOk = new JButton("Login");
    private final JButton jbtCancel = new JButton("Cancel");
	
    private static LoginView lv;
    
    
    public static LoginView getLoginView() {
    	
    	if (lv == null)lv= new LoginView();
    	return lv;
    }
    
    
	private LoginView() {
		
		setTitle("Login to Chess");
		setSize(new Dimension(300, 400));
		setResizable(false);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    setLocation(x, y);
				
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		putPanels();
		this.setVisible(true);
	}
	
	public void close() {
		this.close();
	}
	
	private void putPanels() {
		

		JPanel pPrincipal = new JPanel();
		pPrincipal.setLayout(new BoxLayout(pPrincipal, BoxLayout.Y_AXIS));
		
		this.add(pPrincipal);
		
		JPanel pUsername = new JPanel();
		pUsername.add(jlblUsername);
		pUsername.add(jtfUsername);
		
		JPanel pPassword = new JPanel();
		pPassword.add(jlblPassword);
		pPassword.add(jpfPassword);
		
		JPanel pButtons = new JPanel();
		pButtons.add(jbtCancel);
		pButtons.add(jbtOk);
		
		pPrincipal.add(pUsername);
		pPrincipal.add(pPassword);
		pPrincipal.add(pButtons);
		
		jbtCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lv.dispose();
				
			}
		});
		
		jbtOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				char[] password = jpfPassword.getPassword();
				String username = jtfUsername.getText();

				if (password.length>1 && !username.isEmpty()) {
					
					System.out.println("Intentamos registrar con username '"+ username + "' y password '" + password.toString() + "'");
					
					boolean login = ControladorUsuario.getUnicaInstancia().loginUsuario(username, new String(password));
					if (login) {
						System.out.println("Se ha registrado correctamente");						
						@SuppressWarnings("unused")
						MainView mv = MainView.getMainView();					
						lv.dispose();
					}
					else {
						System.out.println("La contraseña o nombre de usuario no coinciden");
					}
				}
			
			}
		});
	}
	
}
