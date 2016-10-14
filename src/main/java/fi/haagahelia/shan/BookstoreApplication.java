package fi.haagahelia.shan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.shan.domain.User;
import fi.haagahelia.shan.domain.Book;
import fi.haagahelia.shan.domain.BookRepository;
import fi.haagahelia.shan.domain.Category;
import fi.haagahelia.shan.domain.CategoryRepository;
import fi.haagahelia.shan.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	private UserRepository urepository;
	
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
			
			// Create users: admin/admin user/user
					User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
					User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
					User user3 = new User("user3", "user@gmail.com", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER1");
					urepository.save(user1);
						urepository.save(user2);
						urepository.save(user3);
					
			log.info("fetch all students");
			for (Book book: repository.findAll()) {
				log.info(book.toString());
		};
	
		};
	}
}