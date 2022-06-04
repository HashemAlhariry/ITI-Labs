package gov.iti.jets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Main {

	@GetMapping("/")
	public String hello(){
		return "Hello , Spring";
	}

	public static void main(String[] args) {
		SpringApplication.run(Main.class,args);
	}

}
