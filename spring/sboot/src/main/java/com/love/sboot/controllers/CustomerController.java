package com.love.sboot.controllers;

import com.love.sboot.models.Customer;
import com.love.sboot.repository.CustomerRepository;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers")
@Data
public class CustomerController {
    private final CustomerRepository customerRepository;
    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public static record RequestCustomerBody(String name, String email, Integer age) {}
    @PostMapping
    public void addCustomer(@RequestBody RequestCustomerBody requestCustomerBody) {
        final Customer customerToSave = new Customer();
        customerToSave.setName(requestCustomerBody.name);
        customerToSave.setEmail(requestCustomerBody.email);
        customerToSave.setAge(requestCustomerBody.age);
        customerRepository.save(customerToSave);
    }

    @DeleteMapping("{_id}")
    public void deleteCustomer(@PathVariable("_id") Integer _ID) {
        customerRepository.deleteById(_ID);
    }

    @PutMapping("{_ID}")

    public Customer updateCustomer(@RequestBody RequestCustomerBody req, @PathVariable("_ID") Integer _id) {
        Optional<Customer> added = customerRepository.findById(_id);
        Optional<Customer> optionalCustomer = customerRepository.findById(_id);
        if (added.isEmpty()) {
            return new Customer();
        }
        Customer customer = added.get();
        customer.setName(req.name);
        customer.setAge(req.age);
        customer.setEmail(req.email);
        customerRepository.save(customer);
        return new Customer();
    }
}
