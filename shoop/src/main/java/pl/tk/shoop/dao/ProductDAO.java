package pl.tk.shoop.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import pl.tk.shoop.model.Product;

import java.util.List;

public interface ProductDAO {

    Product findProductById(String id);

    List<Product> findAllProducts();

    void removeProduct(String id);

    void addNewProduct(Product product);
}
