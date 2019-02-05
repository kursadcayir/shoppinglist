package kursad.springframework.services;

import kursad.springframework.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> listAllCustomer();
    Customer getCustomerById(Integer id);
    Customer saveOrUpdateCustomer(Customer customer);
    void deleteCustomer(Integer id);
}
