package edu.besh.rentacar.controller.web;

import edu.besh.rentacar.entity.Customer;
import edu.besh.rentacar.forms.CustomerForm;
import edu.besh.rentacar.service.customer.impls.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/web/customer")
@CrossOrigin("*")
@Controller

public class CustomerWebController {
        @Autowired
        CustomerServiceImpl customerService;

        @RequestMapping("/list")
        public String showAll(Model model) {
            List<Customer> list = customerService.getAll();

            model.addAttribute("customers", list);
            return "customerList";
        }

        @RequestMapping("/delete/{id}")
        public String delete(Model model, @PathVariable(value = "id")int id){
            customerService.delete(id);
            List<Customer> list = customerService.getAll();

            model.addAttribute("customers", list);

            return "customersList";
        }

        @RequestMapping(value = "/add", method = RequestMethod.GET)
        public String addCustomer(Model model){
            CustomerForm customerForm = new CustomerForm();

            model.addAttribute("customerForm", customerForm);
            return "addCustomer";
        }

        @RequestMapping(value = "/add", method = RequestMethod.POST)
        public String addCustomer(Model model,
                                @ModelAttribute("customerForm") CustomerForm customerForm){

            Customer newCustomer = new Customer(customerForm.getId(), customerForm.getClient(), customerForm.getAddress()
                    , customerForm.getPhone(), customerForm.getEmail(), customerForm.getCar(), customerForm.isTookCar());
            customerService.create(newCustomer);
            model.addAttribute("customers", customerService.getAll());
            return "redirect:/web/customer/list";
        }


        @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
        public String editCustomer(Model model, @PathVariable(value = "id") int id){
            CustomerForm customerForm = new CustomerForm();
            Customer customer = customerService.get(id);

            customerForm.setId(customer.getId());
            customerForm.setClient(customer.getClient());
            customerForm.setAddress(customer.getAddress());
            customerForm.setPhone(customer.getPhone());
            customerForm.setEmail(customer.getEmail());
            customerForm.setCar(customer.getCar());
            customerForm.setTookCar(customer.isTookCar());

            model.addAttribute("customerForm", customerForm);
            return "addCustomer";
        }


        @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
        public String editCustomer(Model model,
                                 @ModelAttribute("customerForm") CustomerForm customerForm){

            Customer newCustomer = new Customer(customerForm.getId(), customerForm.getClient(), customerForm.getAddress()
                    , customerForm.getPhone(), customerForm.getEmail(), customerForm.getCar(), customerForm.isTookCar());
            customerService.edit(newCustomer);
            model.addAttribute("customers", customerService.getAll());
            return "redirect:/web/customer/list";
        }

}