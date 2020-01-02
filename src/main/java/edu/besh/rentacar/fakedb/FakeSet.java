package edu.besh.rentacar.fakedb;

import edu.besh.rentacar.entity.Gender;
import edu.besh.rentacar.entity.Person;
import edu.besh.rentacar.entity.Types;
import edu.besh.rentacar.entity.Vehicle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class FakeSet {
    private List<Person> people = new ArrayList<>(
            Arrays.asList(
                    new Person(1, "Ivan", "Ivanov", Gender.MALE),
                    new Person(2, "Lev", "Tolstoy", Gender.MALE),
                    new Person(3, "Mike", "Tyson", Gender.MALE),
                    new Person(4, "Ray", "Charles", Gender.MALE)
            )
    );

    public List<Person> getPeople() {
        return people;
    }

    private List<Vehicle> vehicles = new ArrayList<>(
            Arrays.asList(
                    new Vehicle(1, "Mercedes-Benz", "S-Class", 140000.0, "CE7777BI", Types.SEDAN
                    , 2019, 650, false, false)
                    , new Vehicle(2, "BMW", "X5", 90000.0, "AA8787AI", Types.CROSSOVER
                    , 2018, 500, false, false)
                    , new Vehicle(3, "Tesla", "X", 132000.0, "AT9293AI", Types.ELECTROMOBILE
                    , 2019, 550, true, false)

            )
    );

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}