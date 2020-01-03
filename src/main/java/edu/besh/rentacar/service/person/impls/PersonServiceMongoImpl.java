package edu.besh.rentacar.service.person.impls;

import edu.besh.rentacar.entity.Gender;
import edu.besh.rentacar.entity.Person;
import edu.besh.rentacar.repository.PersonRepository;
import edu.besh.rentacar.service.person.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PersonServiceMongoImpl implements IPersonService {

    @Autowired
    PersonRepository repository;

    private List<Person> people = new ArrayList<>(
            Arrays.asList(
                    new Person(1, "Ivan", "Ivanov", Gender.MALE),
                    new Person(2, "Lev", "Tolstoy", Gender.MALE),
                    new Person(3, "Mike", "Tyson", Gender.MALE),
                    new Person(4, "Ray", "Charles", Gender.MALE)
            )
    );

     @PostConstruct
    void init(){
        System.out.println("Saving in database...");
        repository.saveAll(people);
    }

    @Override
    public List<Person> getAll() {
        return repository.findAll();
    }

    @Override
    public Person get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Person create(Person person) {
        int recentID = repository.findAll().stream().mapToInt(item -> item.getId())
                .boxed().max(Integer::compareTo).orElse(1);
        person.setId(recentID+1);
        return repository.save(person);
    }

    @Override
    public Person edit(Person person) {
        return null;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<Person> search(String name) {
        return null;
    }

}
