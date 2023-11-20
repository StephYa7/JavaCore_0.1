package JavaCore.Prac_4.Task_02_onlineStore;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Buyer> buyers;
    static List<Product> products;
    static List<Order> orders;

    public static void main(String[] args) {
        Main.buyers = new ArrayList();
        Main.products = new ArrayList();
        Main.orders = new ArrayList();

        buyers.add(new Buyer("B1", 1, "b1"));
        buyers.add(new Buyer("B2", 1, "b2"));
        buyers.add(new Buyer("B3", 1, "b3"));
        buyers.add(new Buyer("B4", 1, "b4"));
        buyers.add(new Buyer("B5", 1, "b5"));
        products.add(new Product("P1", 1));
        products.add(new Product("P1", 1));
        products.add(new Product("P2", 1));
        products.add(new Product("P3", 1));
        products.add(new Product("P4", 1));
        products.add(new Product("P5", 1));
        products.add(new Product("P6", 1));
        System.out.println(products);

        for (int i = 0; i < 7; i++) {

            try {
                purchase("B" + i, "b" + i,
                        "1", "P" + i,
                        "1", "1");
            } catch (BuyerException e) {
                System.out.println("Неверно указан покупатель");
            } catch (ProductException e) {
                System.out.println("Неверно указан товар");
            }
        }
        System.out.printf("Совершено %d покупок.", Main.orders.size());

    }

    public static Order purchase(String nameBuyer, String phoneBuyer,
                                 String ageBuyer, String productName,
                                 String productPrice, String countProduct
                                 ) throws ProductException, BuyerException {
        Buyer bufferBuyer = new Buyer(nameBuyer, Integer.parseInt(ageBuyer), phoneBuyer);
        Product bufferProduct = new Product(productName, Integer.parseInt(productPrice));
        int countProductInStore = 0;
        boolean buyerExists = false;
        for (Buyer buyer : Main.buyers) {
            if (buyer.equals(bufferBuyer)) {
                buyerExists = true;
            }
        }
        for (Product product : Main.products) {
            if (product.equals(bufferProduct)) {
                countProductInStore++;
            }
        }
        if (countProductInStore < Integer.parseInt(countProduct)) {
            throw new ProductException();
        }
        if (buyerExists == false) {
            throw new BuyerException();
        }
        Order newOrder = new Order(bufferBuyer, bufferProduct, Integer.parseInt(countProduct));
        Main.orders.add(newOrder);

        return newOrder;
    }
}