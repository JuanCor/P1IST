package Servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Dos")
public class Dos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String idSesion="";
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dos() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Inicio de sesion
		HttpSession sesion = request.getSession(true);
		String url="";
		if(idSesion.equals("")){
		idSesion =sesion.getId();
		}
		String nombre = request.getParameter("nombre_u");
		sesion.setAttribute("Nombre", nombre);
		request.setAttribute("Nombre", nombre);
		
		String cpostal = request.getParameter("cpostal");
		sesion.setAttribute("CodigoPostal", cpostal);
		request.setAttribute("CodigoPostal", cpostal);
		
		String email = request.getParameter("email");
		sesion.setAttribute("Email", email);
		request.setAttribute("Email", email);
	
		sesion.setMaxInactiveInterval(5);
		
		if(idSesion.equals(sesion.getId())) {
		url="/WEB-INF/sesion.jsp";	
		}else {
			url="/formulario.html";
			sesion.invalidate();
			idSesion="";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);				
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
