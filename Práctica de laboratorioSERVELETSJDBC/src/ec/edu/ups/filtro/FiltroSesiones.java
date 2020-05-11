package ec.edu.ups.filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



/**
 * Servlet Filter implementation class FiltroSesiones
 */
@WebFilter({"/FiltroSesiones","/index.jsp","/agenda.jsp"})
//@WebFilter(description = "FILTRO INICIAR SESION", urlPatterns = {"/*"})

//@WebFilter("/FiltroSesiones")
public class FiltroSesiones implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroSesiones() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// pass the request along the filter chain
		HttpServletRequest reqHttp= (HttpServletRequest)request;
		HttpSession sesion=reqHttp.getSession();
		System.out.println("FILTRO EN APLICACION ......");
		 if (sesion.getAttribute("logueado") !=null) {
			 	System.out.println("FILTRO PERMITE ACCESO");
				chain.doFilter(request, response);
			}else{
				System.out.println("FILTRO NO ENCUENTRA SESSION .....");
				//((HttpServletResponse)response).sendRedirect("/publica/login.jsp");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
