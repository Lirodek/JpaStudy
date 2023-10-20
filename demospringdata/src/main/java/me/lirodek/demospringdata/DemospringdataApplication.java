package me.lirodek.demospringdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import(GwangminRegistrar.class)
public class DemospringdataApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemospringdataApplication.class, args);
    }

}
