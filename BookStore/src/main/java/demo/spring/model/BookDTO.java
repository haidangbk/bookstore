package demo.spring.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class BookDTO {
	private int id_book;
	private String name_book;
	private double price_book;
	private String category_book;
	private int number_book;
	private int flag_delete;
	
	private Set<AuthorDTO> authorDTOs = new HashSet<AuthorDTO>();
	public BookDTO() {
		super();
	}
	public BookDTO(int id_book, String name_book, double price_book, String category_book,
			int number_book, int flag_delete) {
		super();
		this.id_book = id_book;
		this.name_book = name_book;
		this.price_book = price_book;
		this.category_book = category_book;
		this.number_book = number_book;
		this.flag_delete = flag_delete;
	}
	public int getId_book() {
		return id_book;
	}
	public void setId_book(int id_book) {
		this.id_book = id_book;
	}
	public String getName_book() {
		return name_book;
	}
	public void setName_book(String name_book) {
		this.name_book = name_book;
	}
	public double getPrice_book() {
		return price_book;
	}
	public void setPrice_book(double price_book) {
		this.price_book = price_book;
	}
	public String getCategory_book() {
		return category_book;
	}
	public void setCategory_book(String category_book) {
		this.category_book = category_book;
	}
	public int getNumber_book() {
		return number_book;
	}
	public void setNumber_book(int number_book) {
		this.number_book = number_book;
	}
	public int getFlag_delete() {
		return flag_delete;
	}
	public void setFlag_delete(int flag_delete) {
		this.flag_delete = flag_delete;
	}
	public Set<AuthorDTO> getAuthorDTOs() {
		return authorDTOs;
	}
	public void setAuthorDTOs(Set<AuthorDTO> authorDTOs) {
		this.authorDTOs = authorDTOs;
	}
	
}
