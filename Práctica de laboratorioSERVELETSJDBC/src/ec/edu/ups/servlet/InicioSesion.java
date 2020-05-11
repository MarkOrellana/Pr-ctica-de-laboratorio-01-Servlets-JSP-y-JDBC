package ec.edu.ups.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
@WebServlet("/InicioSesion")
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String usuario = request.getParameter("correo");
		String contrasena = request.getParameter("contrasena");
		userDao usDao = DAOfactory.getFactory().getUsuarioDAO();
		List<Usuario> users = usDao.find();
		Usuario logueado = null;
		for (Usuario user : users) {
			if (user.getCorreo().equals(usuario) && user.getContrasena().equals(contrasena)) {
				System.out.println("USUARIO VALIDADO");
				logueado = user;
				HttpSession objsesion = request.getSession(true);
				request.getSession().setAttribute("logueado", objsesion);
				String url = null;
				//response.sendRedirect("agenda.jsp");
				try {
					request.setAttribute("usuario", logueado);

					url = "/agenda.jsp";
				} catch (Exception e) {

					System.out.println("Error:" + e);
				}
				getServletContext().getRequestDispatcher(url).forward(request, response);
				break;
			}
		}
		// Consultas co=new Consultas();
		// if(co.auntentificacion(usuario, contrasena)) {
		// HttpSession objsesion=request.getSession(true);
		// objsesion.setAttribute("usuario", usuario);
		// response.sendRedirect("menu.jsp");
		// }else {
		// response.sendRedirect("index.jsp");
		// }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Consultas co=new Consultas();
		// if(co.auntentificacion(usuario, contrasena)) {
		// HttpSession objsesion=request.getSession(true);
		// objsesion.setAttribute("usuario", usuario);
		// response.sendRedirect("menu.jsp");
		// }else {
		// response.sendRedirect("index.jsp");
		// }
	}

}
