package pl.tk.shoop.model;

import pl.tk.shoop.services.Cart;

public class CartItem {

    private Product product;
    private int count;
    private double totalPrice;

    public CartItem() {}

    public CartItem(Product product, int count) {
        this.product = product;
        this.count = count;
        this.totalPrice = count * product.getPrice();
    }

    public void increase() {
        count++;
        totalPrice += product.getPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void increase(int numerOfProducts) {
        count+= numerOfProducts;
        totalPrice += (product.getPrice() * numerOfProducts);
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        //this.totalPrice = count * product.getPrice();
    }
}
