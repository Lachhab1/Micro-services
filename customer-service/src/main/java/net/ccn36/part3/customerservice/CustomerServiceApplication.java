package net.ccn36.part3.customerservice;

import net.ccn36.part3.customerservice.entity.Customer;
import net.ccn36.part3.customerservice.repository.CustomerRepository;
import org.apache.hc.core5.reactor.Command;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(
                    Customer.builder()
                            .name("mohammed")
                            .email("med@mail.ma")
                            .build()
            );
            customerRepository.save(
                    Customer.builder()
                            .name("Aymane")
                            .email("aymna@mail.ma")
                            .build()
            );
            customerRepository.save(
                    Customer.builder()
                            .name("Zakaria")
                            .email("zak@mail.ma")
                            .build()
            );
            customerRepository.findAll().forEach(System.out::println);
        };
    }
}
