package ch.csbe.backendlb;

import ch.csbe.backendlb.resources.category.CategoryMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories
public class BackendLbApplication {


    public static void main(String[] args) {
        SpringApplication.run(BackendLbApplication.class, args);
    }

}
