package my.bikram.project.covid;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import my.bikram.project.covid.controller.AppController;
import my.bikram.project.covid.controller.UserNavController;

@SpringBootTest
class Covid19ApplicationTests {

	@Autowired
	private AppController appController;
	
	@Autowired
	private UserNavController navController;
	
	@Test
	void contextLoads() {
		assertThat(appController).isNotNull();
		assertThat(navController).isNotNull();
	}

}
