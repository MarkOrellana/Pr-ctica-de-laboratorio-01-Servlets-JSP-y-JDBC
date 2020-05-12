package ec.edu.ups.dao;
import java.util.List;

import ec.edu.ups.modelo.Usuario;

public interface userDao extends GenericDAO<Usuario,String>{
	public abstract Usuario findUser(String correo, String pass);
    public abstract List<Usuario> findByIdOrMail(String context);
}

