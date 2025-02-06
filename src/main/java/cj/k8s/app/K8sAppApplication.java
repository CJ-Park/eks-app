package cj.k8s.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class K8sAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(K8sAppApplication.class, args);
	}

}
