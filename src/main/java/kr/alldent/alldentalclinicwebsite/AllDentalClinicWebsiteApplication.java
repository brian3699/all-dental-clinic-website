package kr.alldent.alldentalclinicwebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Main class of the project
 */
@EnableJpaAuditing
@SpringBootApplication
public class AllDentalClinicWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllDentalClinicWebsiteApplication.class, args);
	}


}
