/*
 * VehicleServiceImpl
 *
 * Version 1
 *
 * Artem Beshevli
 */

package edu.besh.rentacar.service.vehicle.impls;

import edu.besh.rentacar.entity.Vehicle;
import edu.besh.rentacar.fakedb.FakeSet;
import edu.besh.rentacar.repository.VehicleRepository;
import edu.besh.rentacar.service.vehicle.interfaces.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

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
        return repository.findById(id).orElse(null);
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        int recentID = repository.findAll().stream().mapToInt(item -> item.getId())
                .boxed().max(Integer::compareTo).orElse(1);
        vehicle.setId(recentID+1);

        List<Integer> list = repository.findAll().stream().mapToInt(item -> item.getId())
                .boxed().collect(Collectors.toList());
        return repository.save(vehicle);
    }

    @Override
    public Vehicle edit(Vehicle vehicle) { return repository.save(vehicle); }

    @Override
    public void delete(int id) {repository.deleteById(id);}

    public List<Vehicle> search(String model) {
        return null;
    }
}
