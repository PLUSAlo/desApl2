package agq.dao;

import java.util.List;

import agq.model.Book;

public interface BookDAO {
	void createBook(Book book);
	Book readBook(Long id);
	List<Book> readAllBooks();
	void updateBook(Book book);
	void deleteBook(Long id);
}
