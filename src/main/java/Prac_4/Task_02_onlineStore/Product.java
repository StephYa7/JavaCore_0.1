package Prac_4.Task_02_onlineStore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private String productName;
    private int price;
}