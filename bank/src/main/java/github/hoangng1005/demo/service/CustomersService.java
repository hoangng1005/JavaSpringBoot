package github.hoangng1005.demo.service;

import github.hoangng1005.demo.model.Customers;
import github.hoangng1005.demo.repository.CustomersRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomersService {

    public final CustomersRepository customersRepository;

    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public List<Customers> getCustomers() {
        return customersRepository.findAll();
    }
}
