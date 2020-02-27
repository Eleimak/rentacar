/*
 * VehicleWebController
 *
 * Version 1
 *
 * Artem Beshevli
 */

package edu.besh.rentacar.controller.web;

import edu.besh.rentacar.entity.Customer;
import edu.besh.rentacar.entity.Types;
import edu.besh.rentacar.entity.Vehicle;
import edu.besh.rentacar.forms.SearchForm;
import edu.besh.rentacar.forms.VehicleForm;
import edu.besh.rentacar.service.vehicle.impls.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/web/vehicle")
@CrossOrigin("*")
@Controller
public class VehicleWebController {
    @Autowired
    VehicleServiceImpl vehicleService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(Model model){
        List<Vehicle> list = vehicleService.getAll();
        this.recalculateTime(list);
        model.addAttribute("carset", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "vehicleList";
    }



    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        List<Vehicle> list = new ArrayList<>();
        String letters = searchForm.getString();

        if (letters == null || letters == "")
        { list = vehicleService.getAll();
            System.out.println("empty");
        }
        else{
          list = vehicleService.search(letters);
        }
        this.recalculateTime(list);
        model.addAttribute("carset", list);
        model.addAttribute("searchForm", searchForm);
        return "vehicleList";
    }



    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    String sort(Model model){
        List<Vehicle> list = vehicleService.sortByRentalFee();
        this.recalculateTime(list);
        model.addAttribute("carset", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "vehicleList";
    }
    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Vehicle> list = vehicleService.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("carset", list);
        return "vehicleList";
    }




    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable(value = "id")int id){
        vehicleService.delete(id);
        List<Vehicle> list = vehicleService.getAll();
        this.recalculateTime(list);
        model.addAttribute("carset", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "vehicleList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addVehicle(Model model){
        VehicleForm vehicleForm = new VehicleForm();
        vehicleForm.setUrl("");
        List types = Arrays.asList(Types.values());

        model.addAttribute("vehicleForm", vehicleForm);
        model.addAttribute("types", types);
        return "addVehicle";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addVehicle(Model model,
                            @ModelAttribute("vehicleForm") VehicleForm vehicleForm){

        Types type = Types.CROSSOVER;
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
                case "MPV": type = Types.MPV;
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
                , vehicleForm.getRentalFee(), vehicleForm.isMaintenance(), vehicleForm.isTaken(),0);

        if (vehicleForm.getUrl() == null) {
            newVehicle.setUrl("");
        } else newVehicle.setUrl(vehicleForm.getUrl());

        vehicleService.create(newVehicle);
        List<Vehicle> list = vehicleService.getAll();
        this.recalculateTime(list);
        model.addAttribute("carset", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "redirect:/web/vehicle/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editVehicle(Model model,
                              @PathVariable(value = "id") int id){
        VehicleForm vehicleForm = new VehicleForm();
        Vehicle vehicle = vehicleService.get(id);

        vehicleForm.setId(vehicle.getId());
        vehicleForm.setBrand(vehicle.getBrand());
        vehicleForm.setModel(vehicle.getModel());
        vehicleForm.setUrl(vehicle.getUrl());
        if (vehicle.getUrl() == null) vehicleForm.setUrl("");
        vehicleForm.setCost(vehicle.getCost());
        vehicleForm.setLicensePlate(vehicle.getLicensePlate());
        vehicleForm.setYearOfIssue(vehicle.getYearOfIssue());
        vehicleForm.setRentalFee(vehicle.getRentalFee());
        vehicleForm.setMaintenance(vehicle.isMaintenance());
        vehicleForm.setTaken(vehicle.isTaken());

        List types = Arrays.asList(Types.values());

        model.addAttribute("vehicleForm", vehicleForm);
        model.addAttribute("types", types);
        return "addVehicle";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
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
            case "MPV": type = Types.MPV;
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

        if (vehicleForm.getUrl() == null) {
           newVehicle.setUrl("");
       } else newVehicle.setUrl(vehicleForm.getUrl());

        vehicleService.edit(newVehicle);

        model.addAttribute("carset", vehicleService.getAll());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "redirect:/web/vehicle/list";
    }

    private void recalculateTime(List<Vehicle> list){
        list.stream().forEach(
                car -> {
                    if(car.getHourBack()!= 0){
                        LocalDateTime carBackTime = LocalDateTime.now()
                                .withHour(car.getHourBack())
                                .withMinute(0);

                        int minutes = (int) ChronoUnit.MINUTES
                                .between(LocalDateTime.now(), carBackTime);
                        car.setHourBack(minutes);
                    } else {car.setHourBack(0);}
                }
        );

    }

}
