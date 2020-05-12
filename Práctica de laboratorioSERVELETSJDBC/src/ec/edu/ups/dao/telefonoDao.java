package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.modelo.Telefono;

public interface telefonoDao extends GenericDAO<Telefono, Integer> {
	public abstract List<Telefono> findByUserId(String cedula);

	public abstract List<Telefono> findByNumber(String numero, String cedula);
}
