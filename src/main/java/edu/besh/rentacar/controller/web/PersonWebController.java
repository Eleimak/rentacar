package edu.besh.rentacar.controller.web;

import edu.besh.rentacar.entity.Gender;
import edu.besh.rentacar.entity.Person;
import edu.besh.rentacar.forms.PersonForm;
import edu.besh.rentacar.service.person.impls.PersonServiceImpl;
import edu.besh.rentacar.service.person.impls.PersonServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RequestMapping("/web/person")
@CrossOrigin("*")
@Controller
public class PersonWebController {
    @Autowired
    PersonServiceMongoImpl personService;

    @RequestMapping("/list")
    public String showAll(Model model) {
        List<Person> list = personService.getAll();

        model.addAttribute("people", list);
        return "peopleList";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable(value = "id")int id){
        personService.delete(id);
        List<Person> list = personService.getAll();

        model.addAttribute("people", list);

        return "peopleList";
    }

    @RequestMapping(value = "/person/add", method = RequestMethod.GET)
    public String addPerson(Model model){
        PersonForm personForm = new PersonForm();

        model.addAttribute("personForm", personForm);
        return "addPerson";
    }

    @RequestMapping(value = "/person/add", method = RequestMethod.POST)
    public String addPerson(Model model,
                             @ModelAttribute("personForm") PersonForm personForm){

       // Group group = groupService.get(personForm.getGroup());
        Gender gender = null;
        if (personForm.getGender().toUpperCase().equals("MALE")){
            gender = Gender.MALE;
        } else if (personForm.getGender().toUpperCase().equals("FEMALE")){
            gender = Gender.FEMALE;
        } else {
            System.out.println("Invalid input");
        }
        Person newPerson = new Person(personForm.getId(), personForm.getFirstName(), personForm.getLastName(), gender);
        personService.create(newPerson);
        model.addAttribute("people", personService.getAll());
        return "redirect:/web/person/list";
    }


    @RequestMapping(value = "/person/edit/{id}", method = RequestMethod.GET)
    public String editPerson(Model model, @PathVariable(value = "id") int id){
        PersonForm personForm = new PersonForm();
        Person person = personService.get(id);

        personForm.setId(person.getId());
        personForm.setFirstName(person.getFirstName());
        personForm.setLastName(person.getLastName());
        personForm.setGender(person.getGender().toString());

        model.addAttribute("personForm", personForm);
        return "addPerson";
    }
}
