package demo.spring.book.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.spring.model.BookDTO;
import demo.spring.service.BookService;

// Có thể thay thế @Controller + @ResponseBody = @ RestController

@Controller
public class BookControllerApi {
	@Autowired
	BookService bookService;

	@GetMapping(value = "/list-book-api")
	public @ResponseBody List<BookDTO> getAllBook() {
		return bookService.getAllBook();
	}

	@GetMapping(value = "/book-detail-api/{id}")
	public @ResponseBody BookDTO bookDetail(@PathVariable(name = "id") int id) {
		BookDTO bookDTO = bookService.getBookById(id);
		return bookDTO;
	}

	@PostMapping(value = "/add-book-api")
	public @ResponseBody void addBook(@RequestBody BookDTO bookDTO) {
		bookService.addBook(bookDTO);
	}

	@DeleteMapping(value = "/delete-book-api/{id}")
	public @ResponseBody void deleteBook(@PathVariable(name = "id") int id) {
		bookService.deleteBook(id);
	}

	@PutMapping(value = "/edit-book-api/{id}")
	public @ResponseBody void editBook(@PathVariable(name = "id") int id,
			@RequestBody BookDTO bookDTO) {
		bookService.editBook(bookDTO);
	}
}
