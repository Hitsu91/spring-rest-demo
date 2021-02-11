package con.antsrl.springdemo;

import con.antsrl.springdemo.model.Product;
import con.antsrl.springdemo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@Slf4j
public class SpringdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(ProductRepository repository) {
		return (args) -> {
			// save a few products
			log.info("Adding scaffolding data in memory db");

			var listDummyData = List.of(
					Product.builder().name("Smartphone").price(499.99).build(),
					Product.builder().name("Smartphone").price(599.99).build(),
					Product.builder().name("PC").price(999.99).build(),
					Product.builder().name("Gelato").price(1.50).build(),
					Product.builder().name("Stampante").price(49.99).build()
			);

			repository.saveAll(listDummyData);
			log.info("Added data");
		};
	}
}
