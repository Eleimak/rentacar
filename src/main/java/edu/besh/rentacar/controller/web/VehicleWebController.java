package edu.besh.rentacar.controller.web;

import edu.besh.rentacar.entity.Types;
import edu.besh.rentacar.entity.Vehicle;
import edu.besh.rentacar.forms.VehicleForm;
import edu.besh.rentacar.service.vehicle.impls.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/web/vehicle")
@CrossOrigin("*")
@Controller
public class VehicleWebController {
    @Autowired
    VehicleServiceImpl vehicleService;

    @RequestMapping("/list")
    String getAll(Model model){
        List<Vehicle> list = vehicleService.getAll();

        model.addAttribute("carset", list);

        return "vehicleList";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable(value = "id")int id){
        vehicleService.delete(id);
        List<Vehicle> list = vehicleService.getAll();

        model.addAttribute("carset", list);

        return "vehicleList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addVehicle(Model model){
        VehicleForm vehicleForm = new VehicleForm();
        List types = Arrays.asList(Types.values());

        model.addAttribute("vehicleForm", vehicleForm);
        model.addAttribute("types", types);
        return "addVehicle";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addVehicle(Model model,
                            @ModelAttribute("vehicleForm") VehicleForm vehicleForm){

        Types type = null;
        if (vehicleForm.getType().toUpperCase().equals("CROSSOVER")){
            type = Types.CROSSOVER;
        } else if (vehicleForm.getType().toUpperCase().equals("SUV")){
            type = Types.SUV;
        } else {
            System.out.println("Invalid input");
        }

        String carType = vehicleForm.getType();


        switch(carType) {
            case "CROSSOVER": type = Types.CROSSOVER;
                break;
            case "SUV": type = Types.SUV;
                break;
            case "HATCHBACK": type = Types.HATCHBACK;
                break;
            case "SEDAN": type = Types.SEDAN;
                break;
            case "ELECTROMOBILE": type = Types.ELECTROMOBILE;
                break;
             case "COUPE": type = Types.COUPE;
                break;
             case "CONVERTIBLE": type = Types.CONVERTIBLE;
                break;
             case "VAN": type = Types.VAN;
                break;
            case "PICKUP": type = Types.PICKUP;
                break;

        }






        Vehicle newVehicle = new Vehicle(vehicleForm.getId(), vehicleForm.getBrand(), vehicleForm.getModel()
                ,vehicleForm.getCost(), vehicleForm.getLicensePlate(), type, vehicleForm.getYearOfIssue()
                , vehicleForm.getRentalFee(), vehicleForm.isMaintenance(), vehicleForm.isTaken());
        vehicleService.create(newVehicle);
        model.addAttribute("people", vehicleService.getAll());
        return "redirect:/web/vehicle/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editVehicle(Model model, @PathVariable(value = "id") int id){
        VehicleForm vehicleForm = new VehicleForm();
        Vehicle vehicle = vehicleService.get(id);

        vehicleForm.setId(vehicle.getId());
        vehicleForm.setBrand(vehicle.getBrand());
        vehicleForm.setModel(vehicle.getModel());
        vehicleForm.setCost(vehicle.getCost());
        vehicleForm.setLicensePlate(vehicle.getLicensePlate());
       // vehicleForm.setType(vehicle.getType().toString());
        vehicleForm.setYearOfIssue(vehicle.getYearOfIssue());
        vehicleForm.setRentalFee(vehicle.getRentalFee());
        vehicleForm.setMaintenance(vehicle.isMaintenance());
        vehicleForm.setTaken(vehicle.isTaken());

        List types = Arrays.asList(Types.values());

        model.addAttribute("vehicleForm", vehicleForm);
        model.addAttribute("types", types);
        return "addVehicle";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editVehicle(Model model,
                             @ModelAttribute("vehicleForm") VehicleForm vehicleForm){

        Types type = null;
        String carType = vehicleForm.getType();


        switch(carType) {
            case "CROSSOVER": type = Types.CROSSOVER;
                break;
            case "SUV": type = Types.SUV;
                break;
            case "HATCHBACK": type = Types.HATCHBACK;
                break;
            case "SEDAN": type = Types.SEDAN;
                break;
            case "ELECTROMOBILE": type = Types.ELECTROMOBILE;
                break;
            case "COUPE": type = Types.COUPE;
                break;
            case "CONVERTIBLE": type = Types.CONVERTIBLE;
                break;
            case "VAN": type = Types.VAN;
                break;
            case "PICKUP": type = Types.PICKUP;
                break;

        }
        Vehicle newVehicle = new Vehicle(vehicleForm.getId(), vehicleForm.getBrand(), vehicleForm.getModel()
                ,vehicleForm.getCost(), vehicleForm.getLicensePlate(), type, vehicleForm.getYearOfIssue()
                , vehicleForm.getRentalFee(), vehicleForm.isMaintenance(), vehicleForm.isTaken());
        vehicleService.edit(newVehicle);
        model.addAttribute("vehicles", vehicleService.getAll());
        return "redirect:/web/vehicle/list";
    }

}
