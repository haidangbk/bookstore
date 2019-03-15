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

@Entity
@Table(name="author")
public class Author implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_author")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_author;
	
	@Column(name="name_author")
	private String name_author;

	@ManyToMany(mappedBy="authors")
	private Set<Book> books;

	public Author() {
		super();
	}

	public Author(int id_author, String name_author) {
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

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + id_author;
		result = prime * result + ((name_author == null) ? 0 : name_author.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		if (id_author != other.id_author)
			return false;
		if (name_author == null) {
			if (other.name_author != null)
				return false;
		} else if (!name_author.equals(other.name_author))
			return false;
		return true;
	}
	
}
