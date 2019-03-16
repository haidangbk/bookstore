package demo.spring.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demo.spring.entities.Book;
import demo.spring.model.AuthorDTO;
import demo.spring.model.BookDTO;
import demo.spring.service.AuthorService;
import demo.spring.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;

	@Autowired
	AuthorService authorService;

	@GetMapping(value = "/")
	public String home() {
		return "index";
	}

	@GetMapping(value = "/list-book")
	public String listBook(HttpServletRequest request) {
		List<BookDTO> bookDTOs = bookService.getAllBook();
		request.setAttribute("bookDTOs", bookDTOs);
		return "book/listBook";
	}

	@GetMapping(value = "/book-detail/{id}")
	public String bookDetail(HttpServletRequest request, @PathVariable(name = "id") int id) {
		BookDTO bookDTO = bookService.getBookById(id);
		request.setAttribute("book", bookDTO);
		return "book/bookDetail";
	}

	@GetMapping(value = "/delete-book/{id}")
	public String deleteBook(HttpServletRequest request, @PathVariable(name = "id") int id) {
		bookService.deleteBook(id);
		return "redirect:/list-book";
	}

	@GetMapping(value = "/add-book")
	public String addBook(HttpServletRequest request, Model model) {
		Book book = new Book();
		request.setAttribute("book", book);
//		Gửi kèm toàn bộ tên các tác giả để thêm vào sách
		request.setAttribute("authors", authorService.getAllAuthor());
		return "book/addBook";
	}

	@PostMapping(value = "/add-book")
	public String addBook(HttpServletRequest request, @ModelAttribute(name = "book") BookDTO bookDTO) {
		String[] sid_authors = request.getParameterValues("author");
		int[] id_authors = Arrays.stream(sid_authors).mapToInt(Integer::parseInt).toArray();
		Set<AuthorDTO> setAuthorDTO = new HashSet<AuthorDTO>();
		for (int author : id_authors) {
			AuthorDTO authorDTO = authorService.getAuthorById(author);
			setAuthorDTO.add(authorDTO);
		}
		bookDTO.setAuthorDTOs(setAuthorDTO);
		bookService.addBook(bookDTO);
		return "redirect:/list-book";
	}

	@GetMapping(value = "/edit-book/{id}")
	public String editBook(@PathVariable(name = "id") int id, Model model) {
		List<AuthorDTO> authorDTOs = authorService.getAllAuthor();
		model.addAttribute("authorDTOs", authorDTOs);
		BookDTO bookDTO = bookService.getBookById(id);
		model.addAttribute("book", bookDTO);
		return "book/editBook";
	}

	@PostMapping(value = "/edit-book/{id}")
	public String editBook(@ModelAttribute(name = "book") BookDTO bookDTO, @PathVariable(name = "id") int id) {
		bookDTO.setId_book(id);
		bookService.editBook(bookDTO);
		return "redirect:/list-book";
	}

	@GetMapping(value = "/find-book-by-name")
	public String findBook(HttpServletRequest request, @RequestParam(name = "search") String search,HttpSession session) {
		if (search.isEmpty()) {
			return "redirect:/";
		}
		List<BookDTO> bookDTOs = bookService.findBookByName(search);
		request.setAttribute("search", search);
		request.setAttribute("bookDTOs", bookDTOs);
		session.setAttribute("find", 1);
		return "book/listBook";
	}

	@GetMapping(value = "/sort-book-by-{sort}")
	public String sortBook(HttpServletRequest request, @PathVariable(name = "sort") String sort, HttpSession session) {
		List<BookDTO> bookDTOs;
		if (session.getAttribute(sort + "trendSort") == null) {
			session.setAttribute(sort + "trendSort","ASC");
			bookDTOs = bookService.sortAll(sort,"DESC");
		} else {
			if (session.getAttribute(sort + "trendSort").equals("ASC")) {
				bookDTOs = bookService.sortAll(sort, "ASC");
				session.setAttribute(sort + "trendSort", "DESC");
			} else {
				bookDTOs = bookService.sortAll(sort, "DESC");
				session.setAttribute(sort + "trendSort","ASC");
			}
		}
		request.setAttribute("bookDTOs", bookDTOs);
		return "book/listBook";
	}
}
