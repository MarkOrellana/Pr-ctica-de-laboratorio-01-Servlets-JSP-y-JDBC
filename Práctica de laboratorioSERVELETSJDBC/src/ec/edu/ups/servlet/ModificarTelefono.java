package ec.edu.ups.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOfactory;
import ec.edu.ups.dao.telefonoDao;

import ec.edu.ups.modelo.Telefono;


/**
 * Servlet implementation class ModificarTelefono
 */
@WebServlet("/ModificarTelefono")
public class ModificarTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarTelefono() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String correo=request.getParameter("correo");
		String contrasenia=request.getParameter("contrasenia");
		//------------------------------------------
		String numero=request.getParameter("numero");
		String operadora=request.getParameter("operadora");
		String tipo=request.getParameter("tipo");
		int id_tel=Integer.valueOf(request.getParameter("id_tel"));
		Telefono tel=new Telefono(id_tel,numero,tipo,operadora);
		telefonoDao telefonoDAO=DAOfactory.getFactory().getTelefonoDAO();
		telefonoDAO.update(tel);
		
		getServletContext().getRequestDispatcher("agenda.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
