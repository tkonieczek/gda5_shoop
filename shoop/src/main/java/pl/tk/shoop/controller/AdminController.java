package pl.tk.shoop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tk.shoop.model.Product;
import pl.tk.shoop.services.DefaultProductsService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final DefaultProductsService productsService;

    //@Autowired - nie musi być autowired i tak jest
    public AdminController(DefaultProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping()
    public String getNewProductFrom(Model model) {
        model.addAttribute("product", new Product());
        return "administration_panel";
    }

    @PostMapping("/addproduct")
    public String addNewProductFromForm(Product product) {
        productsService.addNewProduct(product);
        return "redirect:/products/list";
    }

}
