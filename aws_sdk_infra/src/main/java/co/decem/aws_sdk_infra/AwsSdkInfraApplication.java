package co.decem.aws_sdk_infra;

import co.decem.aws_sdk_infra.config.ExternalApiConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


@SpringBootApplication
@ConfigurationPropertiesScan
public class AwsSdkInfraApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory
			.getLogger(AwsSdkInfraApplication.class);

	private final ExternalApiConfig externalApiConfig;

	public AwsSdkInfraApplication(ExternalApiConfig externalApiConfig) {
		this.externalApiConfig = externalApiConfig;
	}

	public static void main(String[] args) {
		SpringApplication.run(AwsSdkInfraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("External Api URI : {} ", externalApiConfig.getUri());
		log.info("External Api Key : {} ", externalApiConfig.getApiKey());
	}
}
