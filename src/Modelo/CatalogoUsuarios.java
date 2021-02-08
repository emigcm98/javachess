package Modelo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import DAO.AbsFactoriaDAO;
import DAO.DAOException;

public class CatalogoUsuarios {
	private static CatalogoUsuarios unicaInstancia;
	private AbsFactoriaDAO factoria;

	private HashMap<String, Usuario> usuariosPorUsername;

	public static CatalogoUsuarios getUnicaInstancia() {
		if (unicaInstancia == null) unicaInstancia = new CatalogoUsuarios();
		return unicaInstancia;
	}

	private CatalogoUsuarios (){
		
		usuariosPorUsername = new HashMap<String,  Usuario>();
		
		try {
			factoria = AbsFactoriaDAO.getInstancia();
			
			List<Usuario> listaUsuarios = factoria.getUsuarioDAO().getAll();
			for (Usuario user: listaUsuarios) {
				//usuariosPorID.put(user.getId(), user);
				usuariosPorUsername.put(user.getUsername(), user);
				System.out.println(user.toString());
			}
		} catch (DAOException eDAO) {
			   eDAO.printStackTrace();
		}
	}
	
	public List<Usuario> getUsuarios() throws DAOException {
		return new LinkedList<Usuario>(usuariosPorUsername.values());
	}
	
	public Usuario getUsuario(String username) {
		return usuariosPorUsername.get(username);
	}

	/*public Usuario getUsuario(int id) {
		return usuariosPorID.get(id);
	}*/
	
	public void addUsuario(Usuario user) {
		//usuariosPorID.put(user.getId(), user);//?
		usuariosPorUsername.put(user.getUsername(), user);
	}
	
	public void removeUsuario(Usuario user) {
		//usuariosPorID.remove(user.getId());//?
		usuariosPorUsername.remove(user.getUsername());
	}

}