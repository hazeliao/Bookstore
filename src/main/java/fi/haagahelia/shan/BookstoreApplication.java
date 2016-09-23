package fi.haagahelia.shan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.shan.domain.Book;
import fi.haagahelia.shan.domain.BookRepository;
import fi.haagahelia.shan.domain.Category;
import fi.haagahelia.shan.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(){
		return(args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("IT"));
			crepository.save(new Category("Business"));
			crepository.save(new Category("Law"));
			
			repository.save(new Book("Emest Hemingway", "A Farewell to Arms", "1232323-21", 1929,crepository.findByName("IT").get(0)));
			repository.save(new Book("George Orwell", "Animal Farm", "2212343-5", 1945, crepository.findByName("Business").get(0)));	
			
			
			log.info("fetch all students");
			for (Book book: repository.findAll()) {
				log.info(book.toString());
		};
	
		};
	}
}