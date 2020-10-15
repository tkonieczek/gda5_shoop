package pl.tk.shoop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tk.shoop.model.Product;
import pl.tk.shoop.services.DefaultProductsService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final DefaultProductsService productsService;

    //@Autowired - nie musi być autowired i tak jest
    public ProductController(DefaultProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/list")
    public String getProducts(Model model) {
        List<Product> allProducts = productsService.getAllProducts();
        model.addAttribute("allProducts", allProducts);
        return "products_list";
    }

    @GetMapping("/details/{id}")
    public String getProducts(@PathVariable String id, Model model) {
        Product product = productsService.getProductById(id);
        model.addAttribute("product", product);
        return "product_details";
    }

}
