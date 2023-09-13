package ch.csbe.backendlb;

import ch.csbe.backendlb.resources.category.CategoryMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@Configuration
public class BackendLbApplication {

    CategoryMapper categoryMapper;

    public static void main(String[] args) {
        SpringApplication.run(BackendLbApplication.class, args);
    }

    @Bean
    @Primary
    public CategoryMapper categoryMapper() {
        if(categoryMapper == null) {
            categoryMapper = Mappers.getMapper(CategoryMapper.class);
        }
        return categoryMapper;
    }
}
