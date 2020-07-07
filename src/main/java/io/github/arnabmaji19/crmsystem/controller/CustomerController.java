package io.github.arnabmaji19.crmsystem.controller;

import io.github.arnabmaji19.crmsystem.entity.Customer;
import io.github.arnabmaji19.crmsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String addCustomer(Model model) {
        /*
         * Create Customer Model attribute for binding form data
         * Render JSP page for add-customer form
         */

        var customer = new Customer();
        model.addAttribute("customer", customer);
        return "add-customer";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@Valid @ModelAttribute("customer") Customer customer,
                              BindingResult result) {
        /*
         * Save the customer using CustomerService
         * Then redirect to customers list
         */

        System.out.println(customer);
        System.out.println(">> Binding Result: " + result);
        if (result.hasErrors())
            return "add-customer";

        customerService.saveCustomer(customer);
        return "redirect:/customers/list";
    }

    @GetMapping("/updateCustomer")
    public String updateCustomer(@RequestParam("customerId") int id, Model model) {
        /*
         * Show form for Updating Customer
         * Get Customer for the id from Service
         * Add customer in model attribute
         */

        var customer = customerService.getCustomer(id);
        model.addAttribute("customer", customer);
        return "add-customer";
    }

    @GetMapping("/deleteCustomer")
    public String delete(@RequestParam("customerId") int id) {
        /*
         * Delete the customer with the given id
         */

        customerService.deleteCustomer(id);
        return "redirect:/customers/list";

    }

}
