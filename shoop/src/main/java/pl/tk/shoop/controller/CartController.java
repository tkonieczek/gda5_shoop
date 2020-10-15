package pl.tk.shoop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tk.shoop.model.Product;
import pl.tk.shoop.services.Cart;
import pl.tk.shoop.services.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private Cart cart;

    @Autowired
    private ProductService productService;

    @GetMapping()
    public String getCartItems(Model model) {
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/add/{productId}")
    public String addToCart(@PathVariable String productId) {
        Product product = productService.getProductById(productId);
        cart.addToCart(product);
        return "redirect:/products/details/" + productId;
    }

    @PostMapping("/recalculate")
    public String addToCart(Cart updatedCart) {
        return "redirect:/cart";
    }

}
