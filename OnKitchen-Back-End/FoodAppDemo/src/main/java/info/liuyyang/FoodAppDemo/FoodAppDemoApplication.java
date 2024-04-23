package info.liuyyang.FoodAppDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//运行这个文件就行
@SpringBootApplication

public class FoodAppDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodAppDemoApplication.class, args);
	}
}
