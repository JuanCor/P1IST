package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Uno")
public class Uno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Uno() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String usuario = request.getParameter("nombre_u");
		String clave = request.getParameter("clave");
		//fijamos el usuario
		String usuarioad= "admin";
		String clavead="12345";

		String url="";//Defino url para no tener que ponerle String cada vez que use url.

		if(usuario.equals(usuarioad) && clave.equals(clavead)) {
		
			ArrayList<Usuario> profesores = new ArrayList<Usuario> ();
			Usuario user1 = new Usuario ("José Manuel","Pérez Lorenzo", "jmperez@ujaen.es");
			Usuario user2 = new Usuario ("Alonso","Ruano Ruano","alonso@ujaen.es");
			Usuario user3 = new Usuario ("José Enrique","Muñoz Expósito","jemunoz@ujaen.es");
			profesores.add(user1);
			profesores.add(user2);
			profesores.add(user3);
			request.setAttribute("profesores", profesores);
			
			url="/WEB-INF/TablaUsuarios.jsp";	
		}else {
			url="/WEB-INF/registro.html";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}