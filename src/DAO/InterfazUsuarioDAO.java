package DAO;

import java.util.List;

import Modelo.Usuario;

public interface InterfazUsuarioDAO {
	
	void create(Usuario user);
	boolean delete(Usuario user);
	void update(String username, String columna, String valor);
	Usuario get(String username);
	List<Usuario> getAll();
	
}
