package demo.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.spring.dao.AuthorDao;
import demo.spring.entities.Author;
import demo.spring.model.AuthorDTO;
import demo.spring.service.AuthorService;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorDao authorDao;

	@Override
	public List<AuthorDTO> getAllAuthor() {

		List<Author> authors = authorDao.getAllAuthor();

		List<AuthorDTO> authorDTOs = new ArrayList<AuthorDTO>();

		for (Author author : authors) {
			AuthorDTO authorDTO = new AuthorDTO();
			authorDTO.setId_author(author.getId_author());
			authorDTO.setName_author(author.getName_author());
			authorDTOs.add(authorDTO);
		}
		return authorDTOs;
	}

	@Override
	public void deleteAuthorById(int id) {
		authorDao.deleteAuthorById(id);

	}

	@Override
	public AuthorDTO getAuthorById(int id) {
		Author author = authorDao.getAuthorById(id);
		AuthorDTO authorDTO = new AuthorDTO();

		authorDTO.setId_author(author.getId_author());
		authorDTO.setName_author(author.getName_author());
		return authorDTO;
	}

	@Override
	public void addAuthor(AuthorDTO authorDTO) {
		Author author = new Author();
		author.setId_author(authorDTO.getId_author());
		author.setName_author(authorDTO.getName_author());
		authorDao.addAuthor(author);

	}

	@Override
	public AuthorDTO getAuthorByName(String name) {
		Author author = authorDao.getAuthorByName(name);
		AuthorDTO authorDTO = new AuthorDTO();
		authorDTO.setId_author(author.getId_author());
		authorDTO.setName_author(author.getName_author());
		return authorDTO;
	}

}
