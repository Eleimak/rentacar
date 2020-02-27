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
import java.util.Comparator;
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
        repository.deleteAll();
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
        if (vehicle.getHourBack() == null) vehicle.setHourBack(0);
        return repository.save(vehicle);
    }

    @Override
    public Vehicle edit(Vehicle vehicle) {
        if(vehicle.getHourBack() == null) vehicle.setHourBack(0);
        return repository.save(vehicle); }

    @Override
    public void delete(int id) {repository.deleteById(id);}

    public List<Vehicle> sortByRentalFee(){
        return this.getAll().stream().sorted(Comparator.comparing(Vehicle::getRentalFee))
                .collect(Collectors.toList());
    }

    public double binarySearchByRentalFeeRecursively(
            List<Integer> sortedArrayList, int key, int low, int high) {
        int middle = (low + high) / 2;

        if (high < low) {
            return -1;
        }

        if (key == sortedArrayList.get(middle)) {
            return middle;
        } else if (key < sortedArrayList.get(middle)) {
            return binarySearchByRentalFeeRecursively(
                    sortedArrayList, key, low, middle - 1);
        } else {
            return binarySearchByRentalFeeRecursively(
                    sortedArrayList, key, middle + 1, high);
        }
    }






    public List<Vehicle> search(String letters) { ;
        return this.getAll().stream()
                .filter(car-> car.getBrand().toLowerCase().contains(letters.toLowerCase()))
                .collect(Collectors.toList());
    }


}
