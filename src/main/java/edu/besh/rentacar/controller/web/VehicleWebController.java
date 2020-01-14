package edu.besh.rentacar.controller.web;

import edu.besh.rentacar.entity.Person;
import edu.besh.rentacar.entity.Vehicle;
import edu.besh.rentacar.service.vehicle.impls.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/web/vehicle")
@CrossOrigin("*")
@Controller
public class VehicleWebController {
    @Autowired
    VehicleServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model){
        List<Vehicle> list = service.getAll();

        model.addAttribute("carset", list);

        return "vehicleList";
    }

}
