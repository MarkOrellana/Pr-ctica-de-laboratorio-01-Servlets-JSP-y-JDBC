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
@WebServlet(name = "registroTelefonos", urlPatterns = { "/agragar-telefono" })
public class registroTelefonos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// processRequest(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String numero = request.getParameter("numero");
		String tipo = request.getParameter("tipo");
		String operadora = request.getParameter("operadora");

		telefonoDao phoneDao = DAOfactory.getFactory().getTelefonoDAO();
		Telefono phone = new Telefono(numero, tipo, operadora);
		Usuario user = DAOfactory.getFactory().getUsuarioDAO()
				.findById(String.valueOf(request.getSession().getAttribute("userID")));
		phone.setUsuario(user);
		phoneDao.create(phone);

		response.sendRedirect("my-agenda");
	}

	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
