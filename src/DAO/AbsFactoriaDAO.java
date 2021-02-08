package DAO;

public abstract class AbsFactoriaDAO {
	
	public static final String DAO_TDS = "DAO.FactoriaDAO";

	private static AbsFactoriaDAO unicaInstancia = null;
	
	/** 
	 * Crea un tipo de factoria DAO.
	 */
	
	public static AbsFactoriaDAO getInstancia(String tipo) throws DAOException{
		if (unicaInstancia == null)
			try { 
				unicaInstancia=(AbsFactoriaDAO) Class.forName(tipo).newInstance();
			} catch (Exception e) {	
				throw new DAOException(e.getMessage());
		} 
		return unicaInstancia;
	}
	

	public static AbsFactoriaDAO getInstancia() throws DAOException{
		return getInstancia(AbsFactoriaDAO.DAO_TDS);
	}

	protected AbsFactoriaDAO (){}
	
	
	// Metodos factoria para obtener adaptadores
	
	public abstract UsuarioDAO getUsuarioDAO();	

}
