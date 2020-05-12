package ec.edu.ups.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.DAOfactory;
import ec.edu.ups.dao.userDao;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.modelo.Telefono;

public class JDBCUsuarioDAO extends JDBCGenericDAO<Usuario, String> implements userDao {

	@Override
	public boolean create(Usuario user) {
		return conexionU.update("INSERT INTO usuario VALUES ('" + user.getCedula() + "', '" + user.getNombre() + "', '"
				+ user.getApellido() + "', '" + user.getCorreo() + "', '" + user.getContrasena() + ");");
	}

	@Override
	public Usuario findById(String cedula) {
		Usuario user = null;
		ResultSet rs = conexionU.query("SELECT * FROM usuario WHERE usu_cedula = '" + cedula + "';");
		try {
			if (rs != null && rs.next()) {
				user = new Usuario(rs.getString("usu_cedula"), rs.getString("usu_nombre"), rs.getString("usu_apellido"),
						rs.getString("usu_correo"), rs.getString("usu_contrasena"));
				List<Telefono> phones = DAOfactory.getFactory().getTelefonoDAO().findByUserId(user.getCedula());
				user.setTelefonos(phones);
				// System.out.println("Usuario buscado...."+user.getNombre());
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUserDAO:findById): " + e.getMessage());
		}
		return user;
	}

	@Override
	public boolean update(Usuario user) {
		return conexionU.update("UPDATE usuario SET " + "	usu_nombre = '" + user.getNombre() + "',"
				+ "	usu_apellido = '" + user.getApellido() + "'," + "	usu_pass  = '" + user.getContrasena() + "'"
				+ "	WHERE usu_cedula = '" + user.getCedula() + "';");
	}

	@Override
	public void delete(Usuario persona) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Usuario> find() {
		List<Usuario> users = new ArrayList<>();

		ResultSet rs = conexionU.query("SELECT * FROM usuario;");
		try {
			while (rs.next()) {
				Usuario user = new Usuario(rs.getString("usu_cedula"), rs.getString("usu_nombre"),
						rs.getString("usu_apellido"), rs.getString("usu_correo"), rs.getString("usu_contrasena"));
				List<Telefono> phones = DAOfactory.getFactory().getTelefonoDAO().findByUserId(user.getCedula());
				user.setTelefonos(phones);
				users.add(user);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUserDAO:find): " + e.getMessage());
		}
		return users;
	}

	@Override
	public Usuario findUser(String correo, String pass) {
		Usuario user = null;
		ResultSet rs = conexionU.query(
				"SELECT * FROM usuario WHERE usu_correo = '" + correo + "' AND usu_contrasena = '" + pass + "';");
		try {
			if (rs != null && rs.next()) {
				user = new Usuario(rs.getString("usu_cedula"), rs.getString("usu_nombre"), rs.getString("usu_apellido"),
						rs.getString("usu_correo"), rs.getNString("usu_contrasena"));
				List<Telefono> phones = DAOfactory.getFactory().getTelefonoDAO().findByUserId(user.getCedula());
				user.setTelefonos(phones);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUserDAO:findUser): " + e.getMessage());
		}
		return user;
	}

	@Override
	public List<Usuario> findByIdOrMail(String context) {
		List<Usuario> users = new ArrayList<>();
		if (context.equals("all")) {
			ResultSet rs = conexionU.query("SELECT * FROM usuario;");
			try {

				while (rs.next()) {
					Usuario user = new Usuario(rs.getString("usu_cedula"), rs.getString("usu_nombre"),
							rs.getString("usu_apellido"), rs.getString("usu_correo"), rs.getString("usu_contrasena"));
					List<Telefono> phones = DAOfactory.getFactory().getTelefonoDAO().findByUserId(user.getCedula());
					user.setTelefonos(phones);

					users.add(user);
				}

			} catch (SQLException e) {
				System.out.println(">>>WARNING (JDBCUserDAO:findByIdOrMail): " + e.getMessage());
			}

		} else {
			ResultSet rs = conexionU.query("SELECT * FROM usuario " + "WHERE usu_cedula = '" + context
					+ "' OR usu_correo = '" + context + "';");
			try {
				if (rs != null && rs.next()) {
					Usuario user = new Usuario(rs.getString("usu_cedula"), rs.getString("usu_nombre"),
							rs.getString("usu_apellido"), rs.getString("usu_correo"), rs.getString("usu_contrasena"));
					List<Telefono> phones = DAOfactory.getFactory().getTelefonoDAO().findByUserId(user.getCedula());
					user.setTelefonos(phones);
					// System.out.println("Todos los usuarios por correo....." +context+" con
					// nombre"+ user.getNombre());
					users.add(user);
				}
			} catch (SQLException e) {
				System.out.println(">>>WARNING (JDBCUserDAO:findByIdOrMail): " + e.getMessage());
			}
		}

		return users;
	}

	@Override
	public void createTable() {
		// TODO Auto-generated method stub

	}

}
