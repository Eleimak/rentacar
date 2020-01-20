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
import java.util.stream.Collectors;

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
/*

   @PostConstruct
    void init(){
        System.out.println("Saving in database...");
        repository.saveAll(people);
    }
*/

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

      //  int recentID = 0;
        List<Integer> list = repository.findAll().stream().mapToInt(item -> item.getId())
                .boxed().collect(Collectors.toList());

        /* List<Integer> sortedList = list.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        recentID = sortedList.get(sortedList.size()-1); */

        return repository.save(person);
    }

    @Override
    public Person edit(Person person) {
        return repository.save(person);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }



    public List<Person> search(String word) {

        List<Person>  found = new ArrayList<>();

        List<Person> persons = this.getAll();

        for (Person person : persons) {
           if (person.getLastName().contains(word)){

               found.add(person);
           }
        }
        return found;

    }

}
