package agq.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agq.dao.BookDAO;
import agq.dao.BookDAOImpl;
import agq.model.Book;


/**
 * Servlet implementation class BookController
 */
@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Book book; 
	private List<Book> books;
	private BookDAO bookDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        book = new Book();
        books = new ArrayList<Book>();
        bookDAO = new BookDAOImpl();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btn_save")!=null) {
    		book.setTitle(request.getParameter("title"));
    		book.setAuthor(request.getParameter("author"));
    		book.setEditorial(request.getParameter("editorial"));
    		if(book.getId()==0L) {
    		bookDAO.createBook(book);
    			
    		}else {
    			bookDAO.updateBook(book);
    			
    		}
    			books = bookDAO.readAllBooks();
    			request.setAttribute("books", books);
    			request.getRequestDispatcher("book_list.jsp").forward(request, response);
    			
    	}else if(request.getParameter("btn_new")!=null) {
    		book = new Book();
    		request.getRequestDispatcher("book_form.jsp").forward(request, response);
       	}else if(request.getParameter("btn_edit")!=null) {
       		try {
       			Long id= Long.parseLong(request.getParameter("id"));
       			book = bookDAO.readBook(id);
       		}catch(IndexOutOfBoundsException e) {
       			book = new Book();
       		}
       		request.setAttribute("book",book);
       		request.getRequestDispatcher("book_form.jsp").forward(request, response);
      	}else if(request.getParameter("btn_delete")!=null) {
      		try {
      			Long id= Long.parseLong(request.getParameter("id"));
      			bookDAO.deleteBook(id);
      			books= bookDAO.readAllBooks();
      		}catch(Exception e){
      			e.printStackTrace();
      	}
      		request.setAttribute("books", books);
      		request.getRequestDispatcher("book_list.jsp").forward(request, response);
      	}else {
      		books = bookDAO.readAllBooks();
      		request.setAttribute("books", books);
      		request.getRequestDispatcher("book_list.jsp").forward(request, response);
      	}
    	
    		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
