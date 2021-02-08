package Controlador;

import DAO.AbsFactoriaDAO;
import DAO.DAOException;
import DAO.FactoriaDAO;
import Modelo.CatalogoUsuarios;
import Modelo.Usuario;

public class ControladorUsuario {

	
	
	private Usuario userActual;
	private static ControladorUsuario controlador;
	private AbsFactoriaDAO factoria;
	
	private ControladorUsuario() {
		userActual = null;
		try {
			factoria = FactoriaDAO.getInstancia();
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	public static ControladorUsuario getUnicaInstancia() {
		if (controlador == null) controlador = new ControladorUsuario();
		return controlador;
	}
	
	public Usuario getUsuarioActual() {
		return userActual;
	}
	
	public boolean esUsuarioRegistrado(String username) {
		return CatalogoUsuarios.getUnicaInstancia().getUsuario(username)!=null;
	}
	
	public boolean loginUsuario(String username, String password) {
		Usuario user = CatalogoUsuarios.getUnicaInstancia().getUsuario(username);
		if (user != null && user.getPassword().equals(password)) {
				this.userActual = user;
				System.out.println("El usuario actual es " + user.getUsername());
				return true;
		}
		return false;
	}
	
	public boolean actualizarElo(String username, String elo) {
		
		userActual.setElo(Integer.parseInt(elo)); // se cambia en el controlador (instancia)
		factoria.getUsuarioDAO().update(username, "elo", elo); // se cambia en la BBDD (persistencia)
		
		return true;
		
	}
	
	
}
