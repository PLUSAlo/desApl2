package agq.model;

import java.io.Serializable;

public class Book implements Serializable {

	private Long id;
	private String title;
	private String author;
	private String editorial;
	
	

	
	public Book(Long id, String title, String author, String editorial) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.editorial = editorial;
	}


	public Book() {
		this(0L,"","","");
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getEditorial() {
		return editorial;
	}


	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", editorial=" + editorial + "]";
	}

	

}