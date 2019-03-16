package demo.spring.service;

import java.util.List;

import demo.spring.entities.Book;
import demo.spring.model.BookDTO;

public interface BookService {
	public List<BookDTO> getAllBook();

	public BookDTO getBookById(int id);
	
	public void deleteBook(int id);
	
	public void addBook(BookDTO bookDTO);
	
	public void editBook(BookDTO bookDTO);
	
	public List<BookDTO> findBookByName(String nameBook);
	
	public List<BookDTO> sortAll(String column, String upOrDown);
}
