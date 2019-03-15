package demo.spring.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class AuthorDTO {
	private int id_author;
	private String name_author;
	
	private Set<BookDTO> bookDTOs = new HashSet<>();
	public AuthorDTO() {
		super();
	}
	public AuthorDTO(int id_author, String name_author) {
		super();
		this.id_author = id_author;
		this.name_author = name_author;
	}
	public int getId_author() {
		return id_author;
	}
	public void setId_author(int id_author) {
		this.id_author = id_author;
	}
	public String getName_author() {
		return name_author;
	}
	public void setName_author(String name_author) {
		this.name_author = name_author;
	}
	public Set<BookDTO> getBookDTOs() {
		return bookDTOs;
	}
	public void setBookDTOs(Set<BookDTO> bookDTOs) {
		this.bookDTOs = bookDTOs;
	}
	
}
