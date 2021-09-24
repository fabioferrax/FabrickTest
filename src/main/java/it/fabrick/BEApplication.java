package it.fabrick;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = { "it.fabrick"})
@PropertySource("classpath:application.properties")
public class BEApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(BEApplication.class);

	 public static void main(String[] args) throws Exception {
		 logger.info("Starting Application gbs-banking-service.");
        new SpringApplication(BEApplication.class).run(args);
		 logger.info("Started Application gbs-banking-service.");
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
