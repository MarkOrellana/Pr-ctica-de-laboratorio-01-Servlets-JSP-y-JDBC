package ec.edu.ups.dao;

public abstract class DAOfactory {
	protected static DAOfactory factory = new JDBCDAOFactory();

	public static DAOfactory getFactory() {
		return factory;
	}
	
	public abstract userDao getUsuarioDAO();
	
	public abstract telefonoDao getTelefonoDAO();

}
