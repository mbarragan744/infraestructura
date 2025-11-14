
package com.ecommerce.model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ecommerce.EcommerceApplication;
import com.ecommerce.repository.ProductRepository;

@SpringBootApplication
public class Product {
    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(ProductRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Product());
                repo.save(new Product());
                repo.save(new Product());
            }
        };
    }
}
