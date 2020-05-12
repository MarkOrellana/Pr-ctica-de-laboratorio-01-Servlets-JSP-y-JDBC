package ec.edu.ups.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ec.edu.ups.dao.DAOfactory;
import ec.edu.ups.dao.telefonoDao;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;

public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, Integer> implements telefonoDao {

	@Override
	/***
	 * Se crea el telefono con la clave foranea incluida la cual es el nuemro de
	 * cedula del usuario
	 */
	public boolean create(Telefono telefono) {
		return conexionU.update(
				"INSERT INTO telefono (tel_numero, tel_tipo, tel_operadora,usu_cedula) "
						+ "VALUES ('" + telefono.getNumero() + "','" + telefono.getTipo() + "','"
						+ telefono.getOperadora() + "','" + telefono.getUsuario().getCedula() + "');");
	}
	 @Override
	    public Telefono findById(Integer id) {
	        Telefono phone = null;
	        ResultSet rs = conexionU.query("Select * FROM telefono WHERE tel_id = " + id + ";");
	        try {
	            if (rs != null && rs.next()) {
	                phone = new Telefono(rs.getString("tel_numero"), rs.getString("tel_tipo"), rs.getString("tel_operadora"));
	                phone.setCodigo(rs.getInt("tel_codigo"));
	                phone.setUsuario(DAOfactory.getFactory().getUsuarioDAO().findById(rs.getString("usu_cedula")));
	            }
	        } catch (SQLException e) {
	            System.out.println(">>>WARNING (JDBCPhoneDAO:read): " + e.getMessage());
	        }
	        return phone;
	    }
	    
	    @Override
	    public boolean update(Telefono phone) {
	        return conexionD.update("UPDATE telefono SET "
	                + "	tel_numero = '" + phone.getNumero() + "',"
	                + "	tel_tipo = '" + phone.getTipo() + "',"
	                + "	tel_operadora = '" + phone.getOperadora() + "'"
	                + "WHERE tel_codigo = '" + phone.getCodigo() + "' AND usu_cedula = '" + phone.getUsuario().getCedula() + "';");
	    }
	    
	    @Override
	    public void delete(Telefono telefono) {
			// TODO Auto-generated method stub
			conexionU.update("DELETE FROM telefono  WHERE tel_codigo = " + telefono.getCodigo());
		}
	    
	    @Override
	    public List<Telefono> find() {
	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }
	    
	    @Override
	    public List<Telefono> findByUserId(String cedula) {
	        List<Telefono> phones = new ArrayList<>();
	        ResultSet rs = conexionD.query("SELECT * FROM telefono WHERE usu_cedula = '" + cedula + "';");
	        try {
	            while (rs.next()) {
	                Telefono phone = new Telefono(rs.getString("tel_numero"), rs.getString("tel_tipo"), rs.getString("tel_operadora"));
	                phone.setCodigo(rs.getInt("tel_codigo"));
	                phones.add(phone);
	            }
	        } catch (SQLException e) {
	            System.out.println(">>>WARNING (JDBCPhoneDAO:findByShoppingBasketId): " + e.getMessage());
	        }
	        return phones;
	    }

	    @Override
	    public List<Telefono> findByNumber(String numero, String cedula) {
	        List<Telefono> phones = new ArrayList<>();
	        ResultSet rs = conexionD.query("SELECT * FROM telefono WHERE tel_numero = '" + numero + "' AND usu_cedula = '" + cedula + "';");
	        try {
	            while (rs.next()) {
	                Telefono phone = new Telefono(rs.getString("tel_numero"), rs.getString("tel_tipo"), rs.getString("tel_operadora"));
	                phone.setCodigo(rs.getInt("tel_codigo"));
	                phones.add(phone);
	            }
	        } catch (SQLException e) {
	            System.out.println(">>>WARNING (JDBCPhoneDAO:findByShoppingBasketId): " + e.getMessage());
	        }
	        return phones;
	    }
		@Override
		public void createTable() {
			// TODO Auto-generated method stub
			
		}

}
