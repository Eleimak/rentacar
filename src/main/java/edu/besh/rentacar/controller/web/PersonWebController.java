/*
 * PersonWebController
 *
 * Version 1
 *
 * Artem Beshevli
 */

package edu.besh.rentacar.controller.web;

import edu.besh.rentacar.entity.Gender;
import edu.besh.rentacar.entity.Person;
import edu.besh.rentacar.forms.PersonForm;
import edu.besh.rentacar.forms.SearchForm;
import edu.besh.rentacar.service.person.impls.PersonServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("people", list);
        return "peopleList";
    }

    @PostMapping(value = "/list")
    public String showAll(Model model,
                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Person> list = personService.search(word);
       // SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("people", list);
        return "peopleList";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable(value = "id")int id){
        personService.delete(id);
        List<Person> list = personService.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("people", list);

        return "peopleList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPerson(Model model){
        PersonForm personForm = new PersonForm();

        model.addAttribute("personForm", personForm);
        return "addPerson";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
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
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("people", personService.getAll());
        return "redirect:/web/person/list";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
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


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editPerson(Model model,
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
        personService.edit(newPerson);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("people", personService.getAll());
        return "redirect:/web/person/list";
    }

}
