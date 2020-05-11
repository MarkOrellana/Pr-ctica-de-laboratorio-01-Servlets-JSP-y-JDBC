package ec.edu.ups.dao;

import ec.edu.ups.mysql.JDBCTelefonoDAO;
import ec.edu.ups.mysql.JDBCUsuarioDAO;
public class JDBCDAOFactory extends DAOfactory {

	@Override
	public userDao getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new JDBCUsuarioDAO();
	}

	@Override
	public telefonoDao getTelefonoDAO() {
		// TODO Auto-generated method stub
		return new JDBCTelefonoDAO();
	}

}
