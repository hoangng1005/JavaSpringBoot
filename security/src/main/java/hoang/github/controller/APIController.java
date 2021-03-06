package hoang.github.controller;

import hoang.github.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {
    @GetMapping("/products")
    public List<Product> getProducts(){
        List<Product> result = new ArrayList<>();
        result.add(new Product("Coffe Machine", 150));
        result.add(new Product("Apple Watch", 250));
        result.add(new Product("Eink Book Reader", 350));
        return result;
    }
}
