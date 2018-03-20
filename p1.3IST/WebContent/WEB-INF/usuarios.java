<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
@WebServlet("/Dos")
public class EjemploUsuarios extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
ArrayList<Usuario> profesores = new ArrayList<Usuario> ();
Usuario user1 = new Usuario ("José Manuel","Pérez Lorenzo", "jmperez@ujaen.es");
Usuario user2 = new Usuario (“Alonso","Ruano Ruano","alonso@ujaen.es");
Usuario user3 = new Usuario ("José Enrique","Muñoz Expósito","jemunoz@ujaen.es");
profesores.add(user1);
profesores.add(user2);
profesores.add(user3);
request.setAttribute("profesores", profesores);
String url = "/Tablausuarios.jsp";
getServletContext().getRequestDispatcher(url).forward(request, response);
}
}