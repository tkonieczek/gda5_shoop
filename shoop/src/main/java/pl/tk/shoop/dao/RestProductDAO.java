package pl.tk.shoop.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.tk.shoop.model.Product;

import java.util.Arrays;
import java.util.List;

@Repository
@Primary
public class RestProductDAO implements  ProductDAO{

    @Value("${rest.students.url}")
    private String productsUrl;

    RestTemplate restTemplate;

    public RestProductDAO(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product findProductById(String id) {
        return restTemplate.getForObject(productsUrl + "/products/" + id.toString(), Product.class);
    }

    @Override
    public List<Product> findAllProducts() {
        ResponseEntity<Product[]> students = restTemplate.getForEntity(productsUrl + "/products", Product[].class, HttpStatus.OK);
        Product[] body = students.getBody();
        return Arrays.asList(body);
    }

    @Override
    public void removeProduct(String productId) {
        restTemplate.delete(productsUrl + "/products/" + productId.toString());
    }

    @Override
    public void addNewProduct(Product product) {
        restTemplate.postForObject(productsUrl + "/products", product, Product.class);
    }
}
