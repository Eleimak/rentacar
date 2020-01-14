package edu.besh.rentacar.service.vehicle.interfaces;

import edu.besh.rentacar.entity.Vehicle;
import java.util.List;

public interface IVehicleService {
    List<Vehicle> getAll();
    Vehicle get(int id);
    Vehicle create(Vehicle vehicle);
    Vehicle edit(Vehicle vehicle);
    void delete(int id);
}
