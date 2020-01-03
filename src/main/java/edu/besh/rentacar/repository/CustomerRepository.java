package edu.besh.rentacar.repository;

import edu.besh.rentacar.entity.Customer;
import edu.besh.rentacar.entity.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {

}