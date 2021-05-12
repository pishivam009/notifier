package com.piyush.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	BookRepo bookrepo;

	@PostMapping(path = "/saveBook", consumes = "application/json")
	public void saveBook(@RequestBody Book book) {
		if (bookrepo.findBybookId(book.getBookId()) == null)
			bookrepo.save(book);
	}
	
	@PostMapping("/getByType")
	public List<Book> getByType(@RequestParam(value="id") String genre) {
		return bookrepo.getByGenre(genre);
	}
	
	@GetMapping("/getBooks")
	public List<Book> getBooks() {
		return bookrepo.findAll();
	}
	
	@PostMapping("/deleteBook")
	public String deleteBook(@RequestParam(value="bookId") int bookId) {
		if(bookrepo.findBybookId(bookId)!=null) {
			bookrepo.deleteById(bookId);
			return "Deleted Successfully";
		}else
			return "Book does not exist";
	}
	
	@PostMapping(path="/editBook", consumes = "application/json")
	public void updateBook(@RequestParam(value="bookId") int bookId, @RequestBody Map<String, Object> payload){
		if(bookrepo.findBybookId(bookId)!=null) {
			Book b=new Book();
			b.setBookId(bookId);
			b.setBookName((String)payload.get("bookName"));
			b.setGenre((String)payload.get("genre"));
			b.setQuantity((int)payload.get("quantity"));
			
			bookrepo.save(b);
		}
	}
	
}
