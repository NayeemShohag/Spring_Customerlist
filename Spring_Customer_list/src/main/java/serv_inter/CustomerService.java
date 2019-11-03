package serv_inter;

import Model.Customer;

import java.util.List;


public interface CustomerService {
    public List<Customer> getAllCustomer();

    public Customer getCustomerById(int id);

    public Customer addCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(int id);


}
