package ec.edu.ups.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import ec.edu.ups.dao.DAOfactory;
import ec.edu.ups.dao.userDao;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class registrar
 */
@WebServlet("/registrar")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=null;
		response.setContentType("text/html");
		try {
			String cedula=request.getParameter("cedula");
			String nombre=request.getParameter("nombre");
			String apellido=request.getParameter("apellido");
			String correo=request.getParameter("correo");
			String contrasena=request.getParameter("contrasena");
			userDao usDAO=DAOfactory.getFactory().getUsuarioDAO();
			Usuario usuario1=new Usuario(cedula, nombre, apellido, correo, contrasena);
			usDAO.create(usuario1);
			url="/Práctica_de_laboratorioSERVELETSJDBC/index.jsp";
		} catch (Exception e) {
			url="/Práctica_de_laboratorioSERVELETSJDBC/error.jsp";
		}
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String cedula=request.getParameter("cedula");
		String nombre=request.getParameter("nombre");
		String apellido=request.getParameter("apellido");
		String correo=request.getParameter("correo");
		String contrasena=request.getParameter("contrasena");
		userDao usDAO=DAOfactory.getFactory().getUsuarioDAO();
		Usuario usuario1=new Usuario(cedula, nombre, apellido, correo, contrasena);
		usDAO.create(usuario1);
	}

}
