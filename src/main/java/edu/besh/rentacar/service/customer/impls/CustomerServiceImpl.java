package edu.besh.rentacar.service.customer.impls;

import edu.besh.rentacar.entity.Customer;
import edu.besh.rentacar.entity.Person;
import edu.besh.rentacar.fakedb.FakeSet;
import edu.besh.rentacar.repository.CustomerRepository;
import edu.besh.rentacar.repository.PersonRepository;
import edu.besh.rentacar.service.customer.interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    CustomerRepository repository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    FakeSet fakeSet;

    @PostConstruct
    void init(){
        Person person = personRepository.findById(1).orElse(null);
        Customer customer = new Customer(4, person, "", "", "",null, true);
        repository.save(customer);
        //repository.saveAll(fakeSet.getCustomers());
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public Customer get(int id) {
        return fakeSet.getCustomers().stream().filter(customer -> customer.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Customer create(Customer customer) {
        int id = fakeSet.getCustomers().stream().mapToInt(Customer::getId).boxed().max(Integer::compareTo).get();
        customer.setId(id++);
        fakeSet.getCustomers().add(customer);
        return customer;
    }

    @Override
    public Customer edit(Customer customer) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
