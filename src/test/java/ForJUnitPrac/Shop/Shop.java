package ForJUnitPrac.Shop;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> sortProductsByPrice() {
        return products.stream().sorted(Comparator.comparingInt(Product::getCost)).collect(Collectors.toList());
    }

    public Product getMostExpensiveProduct() {
        return products.stream().max(Comparator.comparingInt(Product::getCost)).get();
    }
}