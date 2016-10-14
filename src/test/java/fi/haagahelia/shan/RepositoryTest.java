package fi.haagahelia.shan;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;







import org.h2.store.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.shan.domain.Book;
import fi.haagahelia.shan.domain.BookRepository;
import fi.haagahelia.shan.domain.Category;
import fi.haagahelia.shan.domain.CategoryRepository;
import fi.haagahelia.shan.domain.User;
import fi.haagahelia.shan.domain.UserRepository;


@RunWith(SpringRunner.class)
@DataJpaTest

public class RepositoryTest {
	
	@Autowired
	private BookRepository brepository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	private UserRepository urepository;
	
	@Test
	public void findByTitleShouldReturnBook(){
		List<Book> books = brepository.findByTitle("A Farewell to Arms");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Emest Hemingway");
		
	}
	
	@Test
	public void createNewBook(){
		Book book = new Book("James Smith", "World History", "10001255-21", 2016, 22.3 );
		brepository.save(book);
		assertThat(book.getId()).isNotNull();
		brepository.delete(book.getId());
		assertThat(book.getId()).isNull();
		
	}
	
	
	
	@Test
	public void findByRoleShouldReturnUser(){		
		List<User> users=urepository.findByRole("USER");		
		assertThat(users).hasSize(1);
		assertThat(users.get(0).getUsername()).isEqualTo("user");
		
	}
	
	@Test
	public void createNewUser(){
		User user= new User("user4", "gooe@email.com", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6","USER2" );
		urepository.save(user);
		assertThat(user.getId()).isNotNull();
		urepository.delete(user);
		assertThat(user.getId()).isNull();
	}
	
	

		
	}



