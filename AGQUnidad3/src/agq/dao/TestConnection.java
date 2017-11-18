



package agq.dao;

import java.util.List;

import agq.model.Book;

public class TestConnection {
	public static void main(String[] args) {
		BookDAOImpl bookDAOImpl = new BookDAOImpl();
		//bookDAOImpl.createBook(new Book(3L, "Maze Runner","Desconocido","Oceano"));
		
		bookDAOImpl.deleteBook(5L);
		
		
		//bookDAOImpl.updateBook(new Book(2L, "Los Juegos del Hambre","Susans Collins", "Oceano"));
		List<Book> books =bookDAOImpl.readAllBooks();
		for(Book book: books) {
			System.out.println(book);
		}
	}
}
