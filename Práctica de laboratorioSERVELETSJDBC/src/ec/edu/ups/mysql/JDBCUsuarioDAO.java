package ec.edu.ups.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ec.edu.ups.dao.DAOfactory;
import ec.edu.ups.dao.userDao;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.modelo.Telefono;

public class JDBCUsuarioDAO extends JDBCGenericDAO<Usuario, String>implements userDao {

	@Override
	public void create(Usuario usuario) {
		conexionU.update("INSERT usuario VALUES ('" + usuario.getCedula() + "','" + usuario.getNombre() + "','"
				+ usuario.getApellido() + "','" + usuario.getCorreo() + "','" + usuario.getContrasena() + "');");
		Set<Telefono> telefonos=usuario.getTelefonos();
		if (telefonos!=null) {
			for (Telefono telefono : telefonos) {
				DAOfactory.getFactory().getTelefonoDAO().create(telefono);
			}
		}
	}
	@Override
	public Usuario findByCorreo(String correo) {
		Usuario usuario=null;
		ResultSet rsUsuario=conexionU.query("SELECT * FROM usuario WHERE usu_correo='"+correo+"';");
		try {
			if (rsUsuario != null && rsUsuario.next()) {
				usuario = new Usuario(rsUsuario.getString("usu_cedula"), rsUsuario.getString("usu_nombre"),
						rsUsuario.getString("usu_apellido"), rsUsuario.getString("usu_correo"),
						rsUsuario.getString("usu_contrasena"));
			}
		} catch (SQLException e) {
			System.out.println("\">>>WARNING (JDBCUsuarioDAO:read): "+e.getMessage());
		}
		if (usuario==null) {
			return null;
		}
		/**
		 * AQUI ESTOY BUSCANDO TODOS LOS TELEFONOS QUE LE PERTENECEN A UN DETERMINADO USUARIO
		 */
		Set<Telefono> telefonos=DAOfactory.getFactory().getTelefonoDAO().findbyPersonaCed(usuario.getCedula());
		if (telefonos !=null ) {
			Set<Telefono> telefonosFinal=new HashSet<Telefono>();
			for (Telefono telefono : telefonos) {
				telefono.setUsuario(usuario);
				telefonosFinal.add(telefono);				
			}
			usuario.setTelefonos(telefonosFinal);
		}		
		return usuario;
	}


	@Override
	public Usuario read(String cedula) {	
		Usuario usuario=null;
		ResultSet rsUsuario=conexionU.query("SELECT * FROM usuario WHERE usu_cedula='"+cedula+"';");
		try {
			if (rsUsuario !=null && rsUsuario.next()) {	
				usuario=new Usuario(rsUsuario.getString("usu_cedula"),rsUsuario.getString("usu_nombre"),rsUsuario.getString("usu_apellido"),rsUsuario.getString("usu_correo"),rsUsuario.getString("usu_contrasenia"));
//				usuario.setCedula(rsUsuario.getString("usu_cedula"));
//				usuario.setNombre(rsUsuario.getString("usu_nombre"));
//				usuario.setApellido(rsUsuario.getString("usu_apellido"));
//				usuario.setCorreo(rsUsuario.getString("usu_correo"));
//				usuario.setContrasenia(rsUsuario.getString("usu_contrasenia"));
			}
		} catch (SQLException e) {
			System.out.println("\">>>WARNING (JDBCUsuarioDAO:read): "+e.getMessage());
		}
		if (usuario==null) {
			return null;
		}
		/**
		 * AQUI ESTOY BUSCANDO TODOS LOS TELEFONOS QUE LE PERTENECEN A UN DETERMINADO USUARIO
		 */
		Set<Telefono> telefonos=DAOfactory.getFactory().getTelefonoDAO().findbyPersonaCed(usuario.getCedula());
		if (telefonos !=null) {
			Set<Telefono> telefonosFinal=new HashSet<Telefono>();
			for (Telefono telefono : telefonos) {
				telefono.setUsuario(usuario);
				telefonosFinal.add(telefono);				
			}
			usuario.setTelefonos(telefonosFinal);
		}
		return usuario;
	}

	@Override
	/**
	 * EN ESTE METODO NO SE VAN A MODIFICAR LOS DATOS DEL USUARIO....!
	 * SE MODIFICARAN LOS TELEFONOS QUE EL USUARIO TENGA...!
	 */
	public void update(Usuario persona) {
		/*
		TelefonoDAO telefonoDAO=DAOFactory.getFactory().getTelefonoDAO();
		Set<Telefono> telefonos=telefonoDAO.findbyPersonaCed(persona.getCedula());
		conexionUno.query("");
		 */
	}

	@Override
	public void delete(Usuario persona) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> find() {
		List<Usuario> usuarios=new ArrayList<Usuario>();
		ResultSet rsUsuario=conexionU.query("SELECT * FROM usuario;");
		try {
			while(rsUsuario.next()) {
				Usuario u=new Usuario(rsUsuario.getString("usu_cedula"),rsUsuario.getString("usu_nombre"),
						rsUsuario.getString("usu_apellido"),rsUsuario.getString("usu_correo"),rsUsuario.getString("usu_contrasena"));
				
//				ResultSet rsTelefonos=conexionDos.query(
//						"SELECT * FROM telefono WHERE usu_cedula="+u.getCedula()+";");
				
				Set<Telefono> telefonos=DAOfactory.getFactory().getTelefonoDAO().findbyPersonaCed(u.getCedula());
				if (telefonos !=null) {
										
//					while (rsTelefonos.next()) {
//						Telefono t=new Telefono(rsTelefonos.getString("tel_numero"),rsTelefonos.getString("tel_tipo"),rsTelefonos.getString("tel_operadora"));												
//						tels.add(t);
//					}
					Set<Telefono> telsFinal= new HashSet<Telefono>();
					for (Telefono telefono : telefonos) {
						telefono.setUsuario(u);
						telsFinal.add(telefono);
						u.setTelefonos(telsFinal);
					}
					
				}				
				usuarios.add(u);
			}
		} catch (SQLException e) {
			System.out.println(">>>>>Error en JDBCUsuarioDAO:find "+e.getMessage());
			return null;
		}
		
		return usuarios;
	}
	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

	
	
}
