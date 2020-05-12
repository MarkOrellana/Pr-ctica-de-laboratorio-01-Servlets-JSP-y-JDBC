package ec.edu.ups.dao;

import java.util.List;
import java.util.Set;

import ec.edu.ups.modelo.Telefono;

public interface telefonoDao extends GenericDAO<Telefono, String> {
	public abstract Set<Telefono> findbyPersonaCed(String cedula);
	
	public abstract List<Telefono> findbyNumber(String numero, String cedula);
}
