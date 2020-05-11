package ec.edu.ups.dao;

import java.util.Set;

import ec.edu.ups.modelo.Telefono;

public interface telefonoDao extends GenericDAO<Telefono, String> {
	public abstract Set<Telefono> findbyPersonaCed(String numCedPersona);
	
	public abstract Telefono findbyTelefonoId(int id_tel);
}
