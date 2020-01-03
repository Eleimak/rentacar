package edu.besh.rentacar.service.customer.interfaces;

import edu.besh.rentacar.entity.Customer;
import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();
    Customer get(int id);
    Customer create(Customer customer);
    Customer edit(Customer customer);
    void delete(int id);
}
