package demo.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import demo.spring.entities.Author;
import demo.spring.model.AuthorDTO;
import demo.spring.service.AuthorService;

@Controller
public class AuthorController {

	@Autowired
	AuthorService authorService;

	@GetMapping(value = "/list-author")
	public String listAuthor(HttpServletRequest request) {
		List<AuthorDTO> authorDTOs = authorService.getAllAuthor();
		request.setAttribute("listAuthor", authorDTOs);
		return "author/listAuthor";
	}

	@GetMapping(value = "/delete-author/{id}")
	public String deleteAuthor(@PathVariable(name = "id") int id) {
		authorService.deleteAuthorById(id);
		return "redirect:/list-author";
	}
	
	@GetMapping(value="/add-author")
	public String addAuthor(Model model) {
		Author author = new Author();
		model.addAttribute("author", author);
		return "author/addAuthor";
	}
	
	@PostMapping(value="/add-author")
	public String addAuthor(@ModelAttribute (name="author") AuthorDTO authorDTO) {
		authorService.addAuthor(authorDTO);
		return "redirect:/list-author";
	}
	

}
