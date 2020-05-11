package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	private int codigous;
	private String cedula;
	private String nombre;
	private String apellido;
	private String correo;
	private String contrasena;
	private Set<Telefono> telefonos;
	// private List<Telefono> telefonos=new ArrayList<Telefono>();

	public Usuario() {

	}

	public Usuario(String cedula, String nombre, String apellido, String correo, String contrasena) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasena = contrasena;
	}

	public void setTelefonos(Set<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public Set<Telefono> getTelefonos() {
		return telefonos;
	}

	public String getCedula() {
		return cedula;
	}

	public int getCodigous() {
		return codigous;
	}

	public void setCodigous(int codigous) {
		this.codigous = codigous;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo
				+ ", contrasena=" + contrasena + "]";
	}

}
