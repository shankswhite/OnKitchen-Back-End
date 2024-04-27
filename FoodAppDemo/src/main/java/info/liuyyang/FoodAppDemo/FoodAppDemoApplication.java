package info.liuyyang.FoodAppDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FoodAppDemoApplication class
 * This class is used to start the application.
 */
@SpringBootApplication
public class FoodAppDemoApplication {

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		SpringApplication.run(FoodAppDemoApplication.class, args);
	}
}
