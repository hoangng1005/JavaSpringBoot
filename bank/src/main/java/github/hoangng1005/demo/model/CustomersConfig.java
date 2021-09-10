package github.hoangng1005.demo.model;

import github.hoangng1005.demo.repository.CustomersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class CustomersConfig {
    @Bean
    CommandLineRunner commandLineRunner(CustomersRepository repository){
        return args -> {
            Customers c1 = new Customers(
                    "CU0001",
                    "Nguyễn Việt Hoàng",
                    LocalDate.of(1998,5,10),
                    "Hà Nội",
                    "0105387309",
                    "0914567893",
                    "Nam",
                    "hoang123@gmail.com",
                    "CN1"
            );
            repository.save(c1);
        };
    }
}
