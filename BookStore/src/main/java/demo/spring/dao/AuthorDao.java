package demo.spring.dao;

import java.util.List;

import demo.spring.entities.Author;

public interface AuthorDao {
	public List<Author> getAllAuthor();

	public Author getAuthorById(int id);

	public void deleteAuthorById(int id);
	
	public void addAuthor(Author author);
	
	public Author getAuthorByName(String name);
}
