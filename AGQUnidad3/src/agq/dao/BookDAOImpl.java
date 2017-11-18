package agq.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import agq.model.Book;

public class BookDAOImpl implements BookDAO{
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public BookDAOImpl() {
		getConnection();
	}
	
	
	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb","alo","12345");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	

	@Override
	public void createBook(Book book) {
		if(connection!=null) {
			try {
				preparedStatement= connection.prepareStatement("INSERT INTO books (title, author, editorial)"+" values(?,?,?);");
				
				preparedStatement.setString(1,book.getTitle());
				preparedStatement.setString(2,book.getAuthor());
				preparedStatement.setString(3,book.getEditorial());
				preparedStatement.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public Book readBook(Long id) {
		Book book =null;
		if(connection!= null) {
			try {
				preparedStatement= connection.prepareStatement("SELECT * FROM books WHERE id=?;");
				preparedStatement.setLong(1, id);
				resultSet= preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					book = new Book(
					resultSet.getLong(1),
					resultSet.getString(2),
					resultSet.getString(3),
					resultSet.getString(4)
							);
				}
				}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return book;
		
	}

	@Override
	public List<Book> readAllBooks() {
		List<Book> books =new ArrayList<Book>();
		if(connection!= null) {
			try {
				preparedStatement= connection.prepareStatement("SELECT * FROM books");
				resultSet= preparedStatement.executeQuery();
				
			while(resultSet.next()) {
			Book book= new Book(
					resultSet.getLong(1),
					resultSet.getString(2),
					resultSet.getString(3),
					resultSet.getString(4)
							);
			books.add(book);
			}
				}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return books;
	}

	@Override
	public void updateBook(Book book) {
		if(connection!=null) {
			try {
				preparedStatement= connection.prepareStatement("UPDATE books SET title=?, author=?, editorial=?  WHERE id=?;");
				
				preparedStatement.setString(1,book.getTitle());
				preparedStatement.setString(2,book.getAuthor());
				preparedStatement.setString(3,book.getEditorial());
				preparedStatement.setLong(4,book.getId());
				preparedStatement.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void deleteBook(Long id) {
		if(connection!=null) {
			try {
				preparedStatement= connection.prepareStatement("DELETE FROM books WHERE id=?;");
				
				preparedStatement.setLong(1, id);
				preparedStatement.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}


}