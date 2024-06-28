package co.decem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "co.decem.dao")
@EnableElasticsearchRepositories(basePackages = "co.decem.search")
public class ShopAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopAPIApplication.class, args);
	}

}
