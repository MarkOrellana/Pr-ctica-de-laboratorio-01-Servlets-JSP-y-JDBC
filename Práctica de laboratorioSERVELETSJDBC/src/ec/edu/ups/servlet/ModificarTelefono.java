/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.servlet;

import ec.edu.ups.dao.DAOfactory;
import ec.edu.ups.dao.telefonoDao;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author claum
 */
@WebServlet(name = "ModificarTelefono", urlPatterns = { "/editar-telefono" })
public class ModificarTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sesion = request.getParameter("delete");
		String id = request.getParameter("idTelefono");
		if (sesion != null && id != null) {
			if (sesion.equals("true")) {
				telefonoDao phoneDao = DAOfactory.getFactory().getTelefonoDAO();
				Telefono phone = phoneDao.findById(Integer.parseInt(id));
				phoneDao.delete(phone);
				System.out.println("telefono a eliminar.. " + id);
				response.sendRedirect("my-agenda");
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String numero = request.getParameter("numero");
		String tipo = request.getParameter("tipo");
		String operadora = request.getParameter("operadora");
		String idTelefono = request.getParameter("idtel");

		telefonoDao phoneDao = DAOfactory.getFactory().getTelefonoDAO();
		Telefono phone = phoneDao.findById(Integer.parseInt(idTelefono));
		Usuario user = DAOfactory.getFactory().getUsuarioDAO()
				.findById(String.valueOf(request.getSession().getAttribute("userID")));
		phone.setUsuario(user);
		phone.setNumero(numero);
		phone.setTipo(tipo);
		phone.setOperadora(operadora);

		phoneDao.update(phone);

		response.sendRedirect("my-agenda");
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
