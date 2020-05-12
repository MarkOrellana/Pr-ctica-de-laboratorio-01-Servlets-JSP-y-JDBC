package ec.edu.ups.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ec.edu.ups.dao.telefonoDao;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;

public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, String> implements telefonoDao {

	@Override
	/***
	 * Se crea el telefono con la clave foranea incluida la cual es el nuemro de
	 * cedula del usuario
	 */
	public void create(Telefono telefono) {
//		PreparedStatement pst=null;
//		try {
//			String consulta="INSERT INTO PRACTICALEON.TELEFONO (tel_numero, tel_tipo,tel_operadora, usu_cedula) values(????)";
//			//pst=getJDBC
//			pst.setString(1,telefono.getNumero());
//			pst.setString(2,telefono.getTipo());
//			pst.setString(3,telefono.getOperadora());
//			pst.setString(4,telefono.getUsuario().getCedula());
//			conexionU.update(consulta);
//		}catch (Exception e) {
//			System.out.println("Error Ingreso Datos"+e);
//		}
		conexionU.update(
				"INSERT INTO `practicaleon`.`telefono` (`tel_numero`, `tel_tipo`, `tel_operadora`, `usu_cedula`) "
						+ "VALUES ('" + telefono.getNumero() + "','" + telefono.getTipo() + "','"
						+ telefono.getOperadora() + "','" + telefono.getUsuario().getCedula() + "');");
	}

	@Override
	public Telefono read(String contact) {
		// TODO Auto-generated method stub
		Telefono telefono = null;

		ResultSet rsTelefono = conexionU.query("SELECT * FROM telefono WHERE tel_numero=" + contact);
		try {
			if (rsTelefono != null && rsTelefono.next()) {
				telefono = new Telefono(rsTelefono.getInt("tel_codigo"), rsTelefono.getString("tel_numero"),
						rsTelefono.getString("tel_tipo"), rsTelefono.getString("tel_operadora"));
				ResultSet rsUsuario = conexionD
						.query("SELECT * FROM usario WHERE usu_cedula='" + rsTelefono.getString("usu_cedula") + "');");
				if (rsUsuario != null && rsUsuario.next()) {
					Usuario usuario = new Usuario();
					usuario.setCedula(rsUsuario.getString("usu_cedula"));
					usuario.setNombre(rsUsuario.getString("usu_nombre"));
					usuario.setApellido(rsUsuario.getString("usu_apellido"));
					usuario.setCorreo(rsUsuario.getString("usu_correo"));
					usuario.setContrasena(rsUsuario.getString("usu_contrasena"));
					telefono.setUsuario(usuario);

				}
			}
		} catch (SQLException e) {
			System.out.println(">>>ERROR (JDBCTelefonoDAO:read): " + e.getMessage());
		}
		if (telefono == null) {
			return null;
		}

		return telefono;
	}

	@Override
	/**
	 * se Eliminara un telefono especificando el numero de cedula del usuario
	 */
	public void update(Telefono telefono) {
		// TODO Auto-generated method stub
		conexionU.update("UPDATE telefono SET tel_numero = '" + telefono.getNumero() + "', tel_tipo = '"
				+ telefono.getTipo() + "'," + " tel_operadora= '" + telefono.getOperadora() + "' WHERE tel_codigo = "
				+ telefono.getCodigo());
	}

	@Override
	public void delete(Telefono telefono) {
		// TODO Auto-generated method stub
		conexionU.update("DELETE FROM telefono  WHERE tel_codigo = " + telefono.getCodigo());
	}

	@Override
	/**
	 * busca el telefono de una determinada persona
	 */
	public Set<Telefono> findbyPersonaCed(String numCedPersona) {
		// TODO Auto-generated method stub
		Set<Telefono> list = new HashSet<Telefono>();
		ResultSet rsTelefono = conexionD.query("SELECT * FROM telefono WHERE usu_cedula='" + numCedPersona + "';");
		try {
			while (rsTelefono.next()) {
				Telefono telefono = new Telefono(rsTelefono.getInt("tel_codigo"), rsTelefono.getString("tel_numero"),
						rsTelefono.getString("tel_tipo"), rsTelefono.getString("tel_operadora"));
				//
				// ResultSet rsUsuario = conexionDos.query("SELECT * FROM usuario WHERE
				// usu_cedula='" + rsTelefono.getString("usu_cedula") + "';");
				// if (rsUsuario != null && rsUsuario.next()) {
				// Usuario usuario = new Usuario();
				// usuario.setCedula(rsUsuario.getString("usu_cedula"));
				// usuario.setNombre(rsUsuario.getString("usu_nombre"));
				// usuario.setApellido(rsUsuario.getString("usu_apellido"));
				// usuario.setCorreo(rsUsuario.getString("usu_correo"));
				// usuario.setContrasenia(rsUsuario.getString("usu_contrasenia"));
				// telefono.setUsuario(usuario);
				//
				// }
				list.add(telefono);
			}
		} catch (SQLException e) {
			System.out.println("ERROR JDBCTelefonoDAO en el metodo findbyPersonaCed " + e.getMessage());
		}

		return list;
	}

	@Override
	/**
	 * busca todos los telefonos del sistema
	 */
	public List<Telefono> find() {
		List<Telefono> list = new ArrayList<Telefono>();
		ResultSet rsTel = conexionU.query("SELECT * FROM telefono;");
		try {
			while (rsTel.next()) {
				Telefono telefono = new Telefono(rsTel.getInt("tel_codigo"), rsTel.getString("tel_numero"),
						rsTel.getString("tel_tipo"), rsTel.getString("tel_operadora"));
				ResultSet rsUs = conexionD
						.query("SELECT * FROM usuario WHERE usu_cedula='" + rsTel.getString("usu_cedula") + "';");
				if (rsUs != null && rsUs.next()) {
					Usuario usuario = new Usuario();
					usuario.setCedula(rsUs.getString("usu_cedula"));
					usuario.setNombre(rsUs.getString("usu_nombre"));
					usuario.setApellido(rsUs.getString("usu_apellido"));
					usuario.setCorreo(rsUs.getString("usu_correo"));
					usuario.setContrasena(rsUs.getString("usu_contrasena"));
					telefono.setUsuario(usuario);

				}
				list.add(telefono);
			}
		} catch (SQLException e) {
			System.out.println("ERROR JDBCTelefonoDAO en el metodo List<Telefono> find() " + e.getMessage());
		}
		return list;
	}

	@Override
	public Telefono findbyTelefonoId(int id_tel) {
		// TODO Auto-generated method stub
		Telefono telefono = null;
		ResultSet rsTelefono = conexionU.query("SELECT * FROM telefono WHERE tel_codigo=" + id_tel + ";");
		try {
			if (rsTelefono != null && rsTelefono.next()) {
				telefono = new Telefono(rsTelefono.getInt("tel_codigo"), rsTelefono.getString("tel_numero"),
						rsTelefono.getString("tel_tipo"), rsTelefono.getString("tel_operadora"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return telefono;
	}

	@Override
	public void createTable() {
		// TODO Auto-generated method stub

	}

}
