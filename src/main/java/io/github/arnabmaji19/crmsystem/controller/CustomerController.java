package io.github.arnabmaji19.crmsystem.controller;

import io.github.arnabmaji19.crmsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        /*
         * Fetch all customers from dao using CustomerService
         * Add customers to model attribute
         * Render JSP page with customers
         */

        var customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @GetMapping("/addCustomer")
    public String addCustomer() {
        /*
         * Render JSP page for add-customer form
         */

        return "add-customer";
    }

}
