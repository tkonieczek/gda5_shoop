package pl.tk.shoop.services;

import pl.tk.shoop.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(String id);

    void addNewProduct(Product product);

    void deleteProduct(String id);
}
