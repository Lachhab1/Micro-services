package net.ccn36.part3.productservice;

import net.ccn36.part3.productservice.entity.Product;
import net.ccn36.part3.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(
                    Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("smart Watch s3")
                            .price(2000.99)
                            .quantity(100)
                            .build()
            );
            productRepository.save(
                    Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Iphone 13")
                            .price(4999.99)
                            .quantity(100)
                            .build()
            );
            productRepository.save(
                    Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Macbook m4 pro")
                            .price(9999.99)
                            .quantity(100)
                            .build()
            );
            productRepository.findAll().forEach(System.out::println);
        };
    }
}
