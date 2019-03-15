package demo.spring.service;

import java.util.List;

import demo.spring.entities.Author;
import demo.spring.model.AuthorDTO;

public interface AuthorService {
	public List<AuthorDTO> getAllAuthor();

	public AuthorDTO getAuthorById(int id);

	public void deleteAuthorById(int id);

	public void addAuthor(AuthorDTO authorDTO);
	
	public AuthorDTO getAuthorByName(String name);
}
