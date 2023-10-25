package Prac_4.Task_02_onlineStore;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private Buyer buyer;
    private Product product;
    private int countProduct;
}