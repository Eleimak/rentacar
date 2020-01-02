package edu.besh.rentacar.service.car.interfaces;

import edu.besh.rentacar.entity.Vehicle;

import java.util.List;

public interface ICarService {
    List<Vehicle> getAll();
    Vehicle get(int id);
    Vehicle create(Vehicle vehicle);
    Vehicle edit(Vehicle vehicle);
    void delete(int id);
}
