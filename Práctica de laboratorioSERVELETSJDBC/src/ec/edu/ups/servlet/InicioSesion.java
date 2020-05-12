package ec.edu.ups.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOfactory;
import ec.edu.ups.dao.userDao;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class InicioSesion
 */
@WebServlet(name = "InicioSesion", urlPatterns = { "/login" })
public class InicioSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InicioSesion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/form-login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = request.getParameter("correo");
		String contrasena = request.getParameter("contrasena");

		userDao usDao = DAOfactory.getFactory().getUsuarioDAO();
		// Usuario usuario=usDao.findByCorreo(usuario);
		List<Usuario> users = usDao.find();
		// Usuario usuariologueado = null;
		for (Usuario user : users) {
			if (user.getCorreo().equals(usuario) && user.getContrasena().equals(contrasena)) {
				System.out.println("USUARIO ENCONTRADO");
				// usuariologueado = user;
				HttpSession objsesion = request.getSession(true);
				System.out.println("Usuario Iniciado con ID: " + request.getSession().getId());
				objsesion.setAttribute("sesionID", String.valueOf(objsesion.getId()));
				objsesion.setAttribute("userID", user.getCedula());
				response.sendRedirect("agenda.jsp");

			} else {
				response.sendRedirect("login");
			}
		}
	}
}
