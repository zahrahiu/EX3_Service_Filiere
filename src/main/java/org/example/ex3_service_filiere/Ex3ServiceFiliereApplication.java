package org.example.ex3_service_filiere;

import org.example.ex3_service_filiere.Configuration.RsaKeys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeys.class)
public class Ex3ServiceFiliereApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ex3ServiceFiliereApplication.class, args);
    }

}
