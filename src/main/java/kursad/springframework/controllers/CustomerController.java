package kursad.springframework.controllers;

import kursad.springframework.domain.Customer;
import kursad.springframework.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService){this.customerService= customerService;}

    @RequestMapping("/customers")
    public String listAllCustomers(Model model){
        model.addAttribute("customers",customerService.listAllCustomer());
        return "customers";
    }

    @RequestMapping("/customer/{id}")
    public String getCustomer(@PathVariable Integer id,Model model){
        model.addAttribute("customer",customerService.getCustomerById(id));
        return "customer";
    }
    @RequestMapping("/customer/new")
    public String newCustomer(Model model){
        model.addAttribute("customer",new Customer());
        return "customerform";

    }
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String saveOrUpdateCustomer(Customer customer){
        Customer savedcustomer = customerService.saveOrUpdateCustomer(customer);
        return "redirect:/customer/"+savedcustomer.getId();

    }


    @RequestMapping("/customer/edit/{id}")
    public String editCustomer(@PathVariable Integer id,Model model){
        model.addAttribute("customer",customerService.getCustomerById(id));
        return "customerform";

    }

    @RequestMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }

}
