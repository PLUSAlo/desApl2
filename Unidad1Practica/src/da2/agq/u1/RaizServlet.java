package da2.agq.u1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RaizServlet
 */
@WebServlet("/RaizServlet")
public class RaizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RaizServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double x= Double.parseDouble(request.getParameter("x"));
		double y= Double.parseDouble(request.getParameter("y"));
		
		RaizCuadrada raiz= new RaizCuadrada();
		
		raiz.setX(x);
		raiz.setY(y);
		request.setAttribute("r", raiz);
		RequestDispatcher dispatcher=request.getRequestDispatcher("raiz.jsp");
		dispatcher.forward(request, response);
		

	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
