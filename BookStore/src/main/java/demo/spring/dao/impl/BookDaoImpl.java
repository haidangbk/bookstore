package demo.spring.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import demo.spring.dao.BookDao;
import demo.spring.entities.Book;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Book> getAllBook() {
		String jql = "SELECT b FROM Book b";
		return entityManager.createQuery(jql, Book.class).getResultList();
	}

	@Override
	public Book getBookById(int id) {
		return entityManager.find(Book.class, id);
	}

	@Override
	public void deleteBook(int id) {
		entityManager.remove(getBookById(id));
	}

	@Override
	public void addBook(Book book) {
		entityManager.persist(book);
	}

	@Override
	public void editBook(Book book) {
		entityManager.merge(book);

	}

//	Khi tìm kiếm phân biệt chữ có dấu và chữ viết hoa sử dụng: LIKE BINARY '%':nameBook'%'
	@Override
	public List<Book> findBookByName(String search) {
		String jql = "SELECT b FROM Book b WHERE b.name_book LIKE '%" + search + "%' OR b.category_book LIKE '%"+search+"%'";
		Query query = entityManager.createQuery(jql, Book.class);
		return (List<Book>) query.getResultList();
	}

	@Override
	public List<Book> sortAll(String column, String upOrDown) {
		String jql = "SELECT b FROM Book b ORDER BY "+ column +" " +upOrDown;
		Query query = entityManager.createQuery(jql,Book.class);
		return (List<Book>) query.getResultList();
	}
	

}
