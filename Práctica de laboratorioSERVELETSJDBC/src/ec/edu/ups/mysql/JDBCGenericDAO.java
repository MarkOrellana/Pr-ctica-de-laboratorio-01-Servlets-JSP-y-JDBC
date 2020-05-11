package ec.edu.ups.mysql;

import ec.edu.ups.dao.GenericDAO;

/**
 * Clase JDBCGenericDAO.
 * 
 * La clase abstracta JDBCGenericDAO implementa los métodos de la clase
 * GenericDAO. Teniendo de esta manera una clase generica abstracta que será
 * implementada por cada clase específica y permitirá persistir la información
 * en la base de datos.
 * 
 * Así como también, en esta clase abstracta se obtiene dos conexiones a la base
 * de datos para poder persistir la información.
 *
 * @param <T>  la entidad o modelo que será persistida en la base de datos
 * @param <ID> el id o llave primaria por la cuál se identificara al modelo como
 *             valor único
 **/
public abstract class JDBCGenericDAO<T, ID> implements GenericDAO<T, ID> {
	protected ContextJDBC conexionU = ContextJDBC.getJDBC1();
	protected ContextJDBC conexionD = ContextJDBC.getJDBC2();
}
