package com.example.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.concurrent.Executors;

@SpringBootApplication
public class ServiceApplication {

    public static void main(String[] args) {

        Executors.newVirtualThreadPerTaskExecutor()
                .submit(() -> System.out.println("running on virtual threads!"));

        SpringApplication.run(ServiceApplication.class, args);
    }

}

@Controller
@ResponseBody
class CustomerHttpController {

    private final CustomerRepository repository;

    CustomerHttpController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customers")
    Collection<Customer> customers() {
        return this.repository.findAll();
    }

    @GetMapping("/customers/{name}")
    Collection<Customer> customersByName(@PathVariable String name) {
        System.out.println("hello, world");
        return this.repository.findByName(name);
    }
}

interface CustomerRepository extends ListCrudRepository<Customer, Integer> {
    Collection<Customer> findByName(String name);
}

record Customer(@Id Integer id, String name) {
}