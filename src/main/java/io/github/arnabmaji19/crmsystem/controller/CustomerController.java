package io.github.arnabmaji19.crmsystem.controller;

import io.github.arnabmaji19.crmsystem.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @RequestMapping("/")
    public String customers(Model model) {
        /*
         * Fetch all customers from database
         * Add customers to model attribute
         * Render JSP page with customers
         */

        var customers = customerDAO.getCustomers();
        model.addAttribute("customers", customers);

        return "customers";
    }

}
