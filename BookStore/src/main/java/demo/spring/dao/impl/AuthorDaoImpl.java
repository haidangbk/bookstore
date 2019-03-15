package demo.spring.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import demo.spring.dao.AuthorDao;
import demo.spring.entities.Author;

@Repository
@Transactional
public class AuthorDaoImpl implements AuthorDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Author> getAllAuthor() {
		String jql = "SELECT a FROM Author a";
		return entityManager.createQuery(jql, Author.class).getResultList();
	}

	@Override
	public void deleteAuthorById(int id) {
		entityManager.remove(getAuthorById(id));
	}

	@Override
	public Author getAuthorById(int id) {

		return entityManager.find(Author.class, id);
	}

	@Override
	public void addAuthor(Author author) {
		entityManager.persist(author);
	}

	@Override
	public Author getAuthorByName(String name) {
		String jql = "SElECT a FROM Author a WHERE a.name_author = :name";
		Query query = entityManager.createQuery(jql,Author.class).setParameter("name", name);
		Author author = (Author) query.getSingleResult();
		return author;
	}

}
