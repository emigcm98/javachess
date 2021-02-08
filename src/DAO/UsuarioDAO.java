package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Database.ServidorPersistencia;
import Modelo.Usuario;

public class UsuarioDAO implements InterfazUsuarioDAO {

	private ServidorPersistencia servPersistencia;
	private final String nombre_tabla = "usuario";
	
	public UsuarioDAO() {
		servPersistencia = ServidorPersistencia.getServidorPersistencia();
		servPersistencia.connect();
	}
	
	@Override
	public void create(Usuario user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(Usuario user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(String username, String columna, String valor) {
		// TODO Auto-generated method stub
		
		servPersistencia.actualizarEntidad(nombre_tabla, username, "username", columna, valor);
		
	}

	@Override
	public Usuario get(String username) {

		ResultSet rs = servPersistencia.consultarEntidad(username, nombre_tabla);
		String password;
		int elo;
		
		try {
			rs.next(); // el primero
			password = (String)rs.getObject("password");
			elo = (int) rs.getObject("elo");
			Usuario user = new Usuario(username, password);
			user.setElo(elo);
			rs.close(); // se acaba
			
			//System.out.println(user.toString());
			
			return user;
			
		} catch (SQLException e) {
			System.err.println("La consulta ha fallado");
			return null;
		}
		
	}

	@Override
	public List<Usuario> getAll() {
		ResultSet rs = servPersistencia.consultarEntidad("*", nombre_tabla);
		
		List<Usuario> listaUsuarios = new LinkedList<Usuario>();
				
		try {
			while (rs.next()) {
			
				String username = (String)rs.getObject("username");
				String password = (String)rs.getObject("password");
				int elo = (int) rs.getObject("elo");
				Usuario user = new Usuario(username, password);
				user.setElo(elo);
				
				//System.out.println(user.toString());
				
				listaUsuarios.add(user);
			}
			return listaUsuarios;
		
		} catch (SQLException e) {
			System.err.println("La consulta ha fallado");
			return null;
		}
			
	}

}
