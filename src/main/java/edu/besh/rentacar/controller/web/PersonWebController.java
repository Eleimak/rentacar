package edu.besh.rentacar.controller.web;

import edu.besh.rentacar.entity.Person;
import edu.besh.rentacar.service.person.impls.PersonServiceImpl;
import edu.besh.rentacar.service.person.impls.PersonServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
