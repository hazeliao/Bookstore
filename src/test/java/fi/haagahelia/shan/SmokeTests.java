package fi.haagahelia.shan;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.shan.web.BookController;
import fi.haagahelia.shan.web.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTests {
	@Autowired
	private BookController bcontroller;
	
	@Autowired
	private UserController ucontroller;
	
	@Test
	public void contexLoads() throws Exception{
		assertThat(bcontroller).isNotNull();
		assertThat(ucontroller).isNotNull();
	}
	
	
}
