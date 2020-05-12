package ec.edu.ups.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ec.edu.ups.dao.DAOfactory;
import ec.edu.ups.dao.userDao;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class registrar
 */
@WebServlet(name = "registrar", urlPatterns = { "/registro" })
public class registrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public registrar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cedula = request.getParameter("cedula");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String correo = request.getParameter("correo");
		String contrasena = request.getParameter("contrasena");
		userDao usDAO = DAOfactory.getFactory().getUsuarioDAO();
		Usuario usuario1 = new Usuario(cedula, nombre, apellido, correo, contrasena);
		if (usDAO.create(usuario1)) {
			response.sendRedirect("login");
		} else {
			System.out.println("Usuario no creado");
			response.sendRedirect("registro");
		}
	}

}
