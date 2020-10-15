package pl.tk.shoop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tk.shoop.dao.ProductDAO;
import pl.tk.shoop.model.Product;

import java.util.List;

@Service
public class DefaultProductsService implements  ProductService {


    private final ProductDAO productDAO;

    @Autowired // jest ale jak nie będzie to i tak będzie :)
    public DefaultProductsService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getAllProducts() {
        return productDAO.findAllProducts();
    }

    @Override
    public Product getProductById(String id) {
        return productDAO.findProductById(id);
    }

    @Override
    public void addNewProduct(Product product) {
        productDAO.addNewProduct(product);
    }

    @Override
    public void deleteProduct(String id) {
        productDAO.removeProduct(id);
    }
}
