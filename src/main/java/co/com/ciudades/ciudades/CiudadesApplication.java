package co.com.ciudades.ciudades;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CiudadesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CiudadesApplication.class, args);
	}

}
