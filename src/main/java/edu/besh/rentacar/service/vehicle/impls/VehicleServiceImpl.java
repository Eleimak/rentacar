package edu.besh.rentacar.service.vehicle.impls;

import edu.besh.rentacar.entity.Vehicle;
import edu.besh.rentacar.fakedb.FakeSet;
import edu.besh.rentacar.repository.VehicleRepository;
import edu.besh.rentacar.service.vehicle.interfaces.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    VehicleRepository repository;

    @Autowired
    FakeSet fakeSet;

    @PostConstruct
    void init(){
        repository.saveAll(fakeSet.getVehicles());
    }

    @Override
    public List<Vehicle> getAll() {
        return repository.findAll();
    }

    @Override
    public Vehicle get(int id) {
        return null;
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle edit(Vehicle vehicle) {
        return null;
    }

    @Override
    public void delete(int id) {

    }


}