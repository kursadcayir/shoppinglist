package kursad.springframework.services;
import kursad.springframework.domain.Customer;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    private Map<Integer, Customer> customers;
    public CustomerServiceImpl(){
        loadCustomer();
    }


    @Override
    public List<Customer> listAllCustomer() {

        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customers.get(id);
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        if (customer!=null){
            if (customer.getId()==null){
                customer.setId(getNextKey());
            }
            customers.put(customer.getId(),customer);
            return customer;
        }
        else {throw new RuntimeException("Customer cannot be empty.");}
    }
    private Integer getNextKey(){
        return Collections.max(customers.keySet())+1;
    }


    @Override
    public void deleteCustomer(Integer id) {
        customers.remove(id);

    }

    private void loadCustomer(){
        customers= new HashMap<>();

        Customer customer1= new Customer();
        customer1.setId(1);
        customer1.setName("muhtar");
        customer1.setSurname("ayazdakalan");
        customer1.setAdressline("bilsen ne gaybana caddesi ali beşir apartmanı");
        customer1.setAdressline2("No :52 Kat:2 Daire:6 Belek/Antalya ");
        customer1.setPhonenumber("05387895412");
        customer1.setEmail("qwer@gmail.com");
        customer1.setCity("antala");
        customer1.setState("Turkey");
        customer1.setZipcode("07080");

        customers.put(1,customer1);

        Customer customer2= new Customer();
        customer2.setId(2);
        customer2.setName("döndü");
        customer2.setSurname("yanabakan");
        customer2.setEmail("ertyu@gmail.com");
        customer2.setPhonenumber("02425898587");
        customer2.setAdressline("karacabey mahellesi ahmet yüksüz sokak");
        customer2.setAdressline2("hacıağzı apartmanı no:47 kat:8 daire:8 ");
        customer2.setCity("Antalya");
        customer2.setState("Turkey");
        customer2.setZipcode("07090");
        customers.put(2,customer2);

    }
}
