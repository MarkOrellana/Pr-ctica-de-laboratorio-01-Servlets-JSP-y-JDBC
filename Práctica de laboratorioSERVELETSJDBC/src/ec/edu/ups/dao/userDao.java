package ec.edu.ups.dao;
import ec.edu.ups.modelo.Usuario;

public interface userDao extends GenericDAO<Usuario,String>{
	public Usuario findByCorreo(String correo);
}

