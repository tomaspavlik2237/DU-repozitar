package com.company;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args)
    {
        Methods methods = new Methods();

        System.out.println(methods.loadItemById(9));

        methods.deleteAllOutOfStockItems();

        System.out.println(methods.loadAllAvailableItems());

        Item item = new Item(21, "222", "555", "'Zkouska'", "'popis objektu'", 88, BigDecimal.valueOf(5477));
        methods.saveItem(item);

        methods.updatePrice(2, BigDecimal.valueOf(0));
    }
}
