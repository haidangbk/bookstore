package demo.spring.dao;

import java.util.List;

import demo.spring.entities.Book;

public interface BookDao {
	
	public List<Book> getAllBook();
	
	public Book getBookById(int id);
	
	public void deleteBook(int id);
	
	public void addBook(Book book);
	
	public void editBook(Book book);
	
	public List<Book> findBookByName(String nameBook);
	
	public List<Book> sortAll(String column, String upOrDown);
}
