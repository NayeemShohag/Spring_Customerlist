package serv_inter;

import Model.Customer;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;




public class CustomerServiceImpl implements CustomerService {

    private static List<Customer> customers = new ArrayList<>();

    static {
        Customer jack1 = new Customer(1, "Jack Rutorial 1", "admin@jackrutorial.com", "This is a Jack 1");
        Customer jack2 = new Customer(2, "Jack Rutorial 2", "support@jackrutorial.com", "This is a Jack 2");
        Customer jack3 = new Customer(3, "Jack Rutorial 3", "test@jackrutorial.com", "This is a Jack 3");

        customers.add(jack1);
        customers.add(jack2);
        customers.add(jack3);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customers;
    }

    @Override
    public Customer getCustomerById(int id) {
        for(Customer customer : customers) {
            if(customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        Random random = new Random();
        int nextId = random.nextInt(1000) + 10;

        customer.setId(nextId);
        customers.add(customer);

        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        for(Customer oldCustomer : customers) {
            if(oldCustomer.getId() == customer.getId()) {
                oldCustomer.setName(customer.getName());
                oldCustomer.setEmail(customer.getEmail());
                oldCustomer.setDescription(customer.getDescription());
            }
        }
    }

    @Override
    public void deleteCustomer(int id) {
        for(Customer c : customers) {
            if(c.getId() == id) {
                customers.remove(c);
                break;
            }
        }
    }

}
