package Database;

import java.sql.*;

public class ServidorPersistencia {

	// connection attributes
	private final String user = "root";
	private final String password = "";
	private final String database = "mydatabase";
	private final String host = "localhost";
	
	private final String driver = "com.mysql.jdbc.Driver";
	
	private Connection conexion;
	private Statement st;
	private static ServidorPersistencia instancia;
	
	public static ServidorPersistencia getServidorPersistencia() {
		if (instancia == null)return new ServidorPersistencia();
		else return instancia;
	}
	
	private ServidorPersistencia() {
		
	}
	
	public boolean connect() {
	
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.err.println("Clase no encontrada");
			return false;
		}
		
		   try {
			conexion = DriverManager.getConnection("jdbc:mysql://"+ host+"/" + database, user, password);
		} catch (SQLException e) {
			System.err.println("No se ha podido conectar a la BD");
			return false;
		}
		   
		   try {
				st = conexion.createStatement();
			} catch (SQLException e) {
				System.err.println("No se ha podido crear el statement");
			}
		  
		return true;
	}
	
	public boolean crearTabla(String nombre_tabla, String columnas) {
		

		try {		
			st.executeUpdate("CREATE TABLE IF NOT EXISTS " +  nombre_tabla + " ("
					//" id INT AUTO_INCREMENT COMMENT 'identificador',"
					+ " username VARCHAR(20),"
					+ " password VARCHAR(20),"
					+ " elo int(4),"
					+ " PRIMARY KEY (username))");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("No se ha podido crear la tabla");
			return false;
		}
		
		return true;
	}
	
	public boolean borrarTabla(String nombre_tabla) {
		
		try {
			st.executeUpdate("DROP TABLE " + nombre_tabla);
		} catch (SQLException e) {
			System.err.println("No se ha podido borrar la tabla");
			return false;
		}
		return true;
	}
	
	// datos
	public boolean registrarEntidad(String nombre_tabla, String insert) {
		
		
		//" (username, password, elo) VALUES ('emigcm98','practicas','1300')"
		 try {
			st.executeUpdate("INSERT INTO " + nombre_tabla + " "+insert);
		} catch (SQLException e) {
			System.err.println("No se ha podido registrar la entidad");
			return false;
		}
		return true;
	}
	
	public boolean actualizarEntidad(String nombre_tabla, String username, String columnaUsername, String columna, String valor) {
		
		try {
			st.executeUpdate("UPDATE "+nombre_tabla+ " SET "+ columna + "="+ valor + " WHERE " + columnaUsername+"="+"'"+username+"'");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("No se ha podido actualizar la columna " + columna + " de la tabla " + nombre_tabla);
			return false;
		}
		return true;
	}
	
	public boolean consultarTabla(String nombre_tabla) {
		
		ResultSet rs;
		try {
			rs = st.executeQuery("SELECT * FROM " + nombre_tabla);
			while (rs.next())
			{
				//debug, is generic
			   System.out.println("username="+rs.getObject("username")+
			      ", password="+rs.getObject("password")+
			      ", elo="+rs.getObject("elo"));
			}
			rs.close();
		} catch (SQLException e) {
			System.err.println("No se ha podido hacer la consulta");
			return false;
		}
		System.out.println("Consulta correcta");
		return true;

	}
	
	public ResultSet consultarEntidad(String username, String nombre_tabla) {
		
		ResultSet rs;
		try {
			rs = st.executeQuery("SELECT "+ username + " FROM " + nombre_tabla);
		} catch (SQLException e) {
			System.err.println("Error en tabla " + nombre_tabla + " con entidad " + username);
			return null;
		}
				
		return rs;
	}
}
