package fi.haagahelia.shan.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.shan.domain.Book;
import fi.haagahelia.shan.domain.BookRepository;
import fi.haagahelia.shan.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	//show all books
    @RequestMapping(value="/booklist")
    public String Book(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    
    // RESTful service to get all books
    @RequestMapping(value ="/books")
    public @ResponseBody List<Book> bookListRest(){
    	return (List<Book>) repository.findAll();
    }
    
    //RESTful service to get book by id
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId){
    	return repository.findOne(bookId);
    }
    
    //add new book
    @RequestMapping(value = "/add")
    public String addStudent(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categorys", crepository.findAll());
        return "addbook";
    }     
    
    //save new book
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }    
    
    //delete book
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long bookId, Model model) {
    	repository.delete(bookId);
        return "redirect:../booklist";
    }   

	

}
