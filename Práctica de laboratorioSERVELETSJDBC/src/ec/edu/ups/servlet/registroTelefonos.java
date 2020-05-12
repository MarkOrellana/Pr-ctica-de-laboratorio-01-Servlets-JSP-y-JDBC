package ec.edu.ups.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOfactory;
import ec.edu.ups.dao.telefonoDao;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class registroTelefonos
 */
@WebServlet("/registroTelefonos")
public class registroTelefonos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Usuario usuario;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public registroTelefonos() {
		super();
		usuario=new Usuario();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		try {
			String numero = request.getParameter("numero");
			String tipo = request.getParameter("tipo");
			String operadora = request.getParameter("operadora");
			//usuario.setCedula(request.getParameter("cedula"));
			String usu_cedula = request.getParameter("usu_cedula");
			Usuario u = new Usuario(usu_cedula, null, null, null, null);
			Telefono telefono = new Telefono(0, numero, tipo, operadora);
			telefono.setUsuario(u);
			telefonoDao telDao = DAOfactory.getFactory().getTelefonoDAO();
			telDao.create(telefono);
			url = "/agenda.jsp";
			System.out.println("Telefono Registrado");

		} catch (Exception e) {
			url = "/error.jsp";

		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
