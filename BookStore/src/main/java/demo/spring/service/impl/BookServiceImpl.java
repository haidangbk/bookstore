package demo.spring.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.spring.dao.BookDao;
import demo.spring.entities.Author;
import demo.spring.entities.Book;
import demo.spring.model.AuthorDTO;
import demo.spring.model.BookDTO;
import demo.spring.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;

	@Override
	public List<BookDTO> getAllBook() {
		List<Book> books = bookDao.getAllBook();
		List<BookDTO> bookDTOs = new ArrayList<BookDTO>();
		for (Book book : books) {
			BookDTO bookDTO = new BookDTO();
			bookDTO.setId_book(book.getId_book());
			bookDTO.setName_book(book.getName_book());
			bookDTO.setPrice_book(book.getPrice_book());
			bookDTO.setCategory_book(book.getCategory_book());
			bookDTO.setNumber_book(book.getNumber_book());
			bookDTO.setFlag_delete(book.getFlag_delete());
			bookDTOs.add(bookDTO);
		}
		return bookDTOs;
	}

	@Override
	public BookDTO getBookById(int id) {
		Book book = bookDao.getBookById(id);
		BookDTO bookDTO = new BookDTO();
		bookDTO.setId_book(book.getId_book());
		bookDTO.setName_book(book.getName_book());
		bookDTO.setPrice_book(book.getPrice_book());
		bookDTO.setCategory_book(book.getCategory_book());
		bookDTO.setNumber_book(book.getNumber_book());
		bookDTO.setFlag_delete(book.getFlag_delete());
		
		Set<AuthorDTO> authorDTOs = new HashSet<AuthorDTO>();
		for (Author author : book.getAuthors()) {
			AuthorDTO authorDTO = new AuthorDTO();
			authorDTO.setId_author(author.getId_author());
			authorDTO.setName_author(author.getName_author());
			authorDTOs.add(authorDTO);
		}
		if (authorDTOs != null)
			bookDTO.setAuthorDTOs(authorDTOs);
		return bookDTO;
	}

	@Override
	public void deleteBook(int id) {
		bookDao.deleteBook(id);
	}

	@Override
	public void addBook(BookDTO bookDTO) {
		Book book = new Book();
		book.setId_book(bookDTO.getId_book());
		book.setName_book(bookDTO.getName_book());
		book.setPrice_book(bookDTO.getPrice_book());
		book.setCategory_book(bookDTO.getCategory_book());
		book.setNumber_book(bookDTO.getNumber_book());
		book.setFlag_delete(bookDTO.getFlag_delete());

		Set<Author> authors = new HashSet<Author>();
		for (AuthorDTO authorDTO : bookDTO.getAuthorDTOs()) {
			Author author = new Author();
			author.setId_author(authorDTO.getId_author());
			author.setName_author(authorDTO.getName_author());
			System.out.println("=================>" + author.getName_author());
			authors.add(author);
		}
		if (authors != null)
			book.setAuthors(authors);

		bookDao.addBook(book);
	}

	@Override
	public void editBook(BookDTO bookDTO) {
		Book book = bookDao.getBookById(bookDTO.getId_book());
		book.setId_book(bookDTO.getId_book());
		book.setName_book(bookDTO.getName_book());
		book.setPrice_book(bookDTO.getPrice_book());
		book.setCategory_book(bookDTO.getCategory_book());
		book.setNumber_book(bookDTO.getNumber_book());
		book.setFlag_delete(bookDTO.getFlag_delete());
		bookDao.editBook(book);
	}

	@Override
	public List<BookDTO> findBookByName(String nameBook) {
		List<Book> books = bookDao.findBookByName(nameBook);
		List<BookDTO> bookDTOs = new ArrayList<BookDTO>();
		for (Book book : books) {
			BookDTO bookDTO = new BookDTO();
			bookDTO.setId_book(book.getId_book());
			bookDTO.setName_book(book.getName_book());
			bookDTO.setPrice_book(book.getPrice_book());
			bookDTO.setCategory_book(book.getCategory_book());
			bookDTO.setNumber_book(book.getNumber_book());
			bookDTO.setFlag_delete(book.getFlag_delete());
			bookDTOs.add(bookDTO);
		}
		return bookDTOs;
	}

	@Override
	public List<BookDTO> sortAll(String column, String upOrDown) {
		
		List<Book> books = bookDao.sortAll(column, upOrDown);
		List<BookDTO> bookDTOs = new ArrayList<BookDTO>();
		for (Book book : books) {
			BookDTO bookDTO = new BookDTO();
			bookDTO.setId_book(book.getId_book());
			bookDTO.setName_book(book.getName_book());
			bookDTO.setPrice_book(book.getPrice_book());
			bookDTO.setCategory_book(book.getCategory_book());
			bookDTO.setNumber_book(book.getNumber_book());
			bookDTO.setFlag_delete(book.getFlag_delete());
			bookDTOs.add(bookDTO);
		}
		return bookDTOs;
	}
}
