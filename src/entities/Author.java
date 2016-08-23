package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Kritik Garg
 *
 */
public class Author {

	String authorName;
	List<Book> books;

	/**
	 * Constructor
	 */
	public Author() {
		books = new ArrayList<Book>();
	}

	// Setter author name
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	// getter author name
	public String getAuthorName() {
		return authorName;
	}

	// getter books
	public List<Book> getBooks() {
		return books;
	}

	// setter books
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	/*
	 * Method to add book in author list
	 */
	public void addBook(Book book) {
		books.add(book);
	}

}
