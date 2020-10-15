package pl.tk.shoop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.tk.shoop.model.Product;

import java.util.List;

@Repository
public class DefaultProductsDAO implements ProductDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Product findProductById(String id) {
        String sql = "SELECT * FROM products WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ProductRowMapper());
    }

    public List<Product> findAllProducts() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    @Override
    public void removeProduct(String id) {
        String sql = "DELETE FROM products WHERE id = ?";
        jdbcTemplate.update(sql, new Object[] {id});
    }

    @Override
    public void addNewProduct(Product product) {
        String sql = "INSERT INTO products " +
                "(name, description, image, price) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[] { product.getName(),
                product.getDescription(), product.getImage(), product.getPrice()
        });
    }

/*    public Product findByProductId2(Long id) {
        String sql = "SELECT * FROM products WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Product.class));

    }*/

/*    public Product findByProductId3(Long id) {
        String sql = "SELECT * FROM products WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("image"),
                        rs.getInt("price")
                ));

    }*/


}
