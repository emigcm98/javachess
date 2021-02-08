package Run;

import Vista.LoginView;

public class Main {

	public static void main(String[] args) {
		
		//ServidorPersistencia p = ServidorPersistencia.getServidorPersistencia();
		
		/*p.connect();
		p.crearTabla("usuario", "");
		p.registrarEntidad("usuario", "(username, password, elo) VALUES ('emigcm98','practicas','1300')"); // prueba
		p.consultar("usuario");*/
		@SuppressWarnings("unused")
		LoginView l = LoginView.getLoginView();
	}
}
