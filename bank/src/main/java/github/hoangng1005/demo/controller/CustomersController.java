package github.hoangng1005.demo.controller;

import github.hoangng1005.demo.model.Customers;
import github.hoangng1005.demo.service.CustomersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomersController {

    private final CustomersService customersService;

    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping
    public List<Customers> getCustomers(){
        return customersService.getCustomers();
    }

}
