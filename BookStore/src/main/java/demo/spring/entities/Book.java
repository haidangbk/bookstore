package demo.spring.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_book")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_book;

	@Column(name = "name_book")
	private String name_book;

	@Column(name = "price_book")
	private double price_book;

	@Column(name = "category_book")
	private String category_book;

	@Column(name = "number_book")
	private int number_book;

	@Column(name = "flag_delete")
	private int flag_delete;

	@ManyToMany
	@JoinTable(name = "book_author", joinColumns = { @JoinColumn(name = "id_book") },
			inverseJoinColumns = {@JoinColumn(name = "id_author") })
	private Set<Author> authors;

	public Book(int id_book, String name_book, double price_book, String category_book, int number_book,
			int flag_delete) {
		super();
		this.id_book = id_book;
		this.name_book = name_book;
		this.price_book = price_book;
		this.category_book = category_book;
		this.number_book = number_book;
		this.flag_delete = flag_delete;
	}

}
