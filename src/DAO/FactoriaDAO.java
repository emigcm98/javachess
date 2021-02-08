package DAO;

/** 
 * Factoria concreta DAO para el Servidor de Persistencia de la asignatura TDS.
 * 
 */

public final class FactoriaDAO extends AbsFactoriaDAO {
	
	public FactoriaDAO() {	}
	
	@Override
	public UsuarioDAO getUsuarioDAO() {	
		System.err.println("COOL!");
		return new UsuarioDAO(); 
	}

}
