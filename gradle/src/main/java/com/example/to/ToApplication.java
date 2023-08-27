package com.example.to;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.context.annotation.Bean;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.to.AnimalType.*;

@SpringBootApplication
public class ToApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToApplication.class, args);
    }

    @Bean
    JacksonJsonParser jacksonJsonParser(ObjectMapper objectMapper) {
        return new JacksonJsonParser(objectMapper);
    }

    @Bean
    ApplicationRunner applicationRunner(ObjectMapper objectMapper, JacksonJsonParser jacksonJsonParser) {
        return arguments -> {
            var customers = Set.of(
                            new Customer(1, "Josh", HUMAN),
                            new Customer(2, "Tammie", HUMAN),
                            new Customer(3, "Kimly", HUMAN),
                            new Customer(5, "Peanut the dog", DOG),
                            new Customer(6, "fish #1", FISH),
                            new Customer(7, "fish #2", FISH)
                    )
                    .stream()
                    .collect(Collectors.toMap(Customer::id, customer -> customer));
            var json = objectMapper.writeValueAsString(customers);
            jacksonJsonParser.parseMap(json).forEach((key, value) -> System.out.println(key + "=" + value));
        };
    }
}

/*

@RestController
class CustomerHttpController {

    private final Map<Integer, Customer> customers = Set.of(
                    new Customer(1, "Josh", HUMAN),
                    new Customer(2, "Tammie", HUMAN),
                    new Customer(3, "Kimly", HUMAN),
                    new Customer(5, "Peanut the dog", DOG),
                    new Customer(6, "fish #1", FISH),
                    new Customer(7, "fish #2", FISH)
            )
            .stream()
            .collect(Collectors.toMap(Customer::id, customer -> customer));

    @GetMapping("/customers")
    Collection<Customer> customers() {
        return this.customers.values();
    }

    @GetMapping("/customers/{id}")
    Customer customerById(@PathVariable Integer id) {
        return this.customers.get(id);
    }
}
*/
record Customer(Integer id, String name, AnimalType animalType) {
}

enum AnimalType {
    HUMAN, DOG, FISH
}