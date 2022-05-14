package com.techelevator.Utilities;

import com.techelevator.item.Item;
import com.techelevator.item.Sandwich;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class StockerTest {

    Stocker stocker=new Stocker();
    String keyB2 = "B2";
    String keyC1 = "C1";
    String keyA4 = "A4";
    Map<String, Item> testMap = stocker.stockItems();



    @Test
    public void map_is_correct_size(){
       int linesInFile = 16;

       int actual = stocker.stockItems().size();

        Assert.assertEquals(linesInFile,actual);
    }

    @Test
    public void map_value_name_is_correct(){
        String actualB2 = testMap.get(keyB2).getName();
        String expectedB2 = "Turkey Sandwich";
        Assert.assertEquals(expectedB2, actualB2);

        String actualC1 = testMap.get(keyC1).getName();
        String expectedC1 = "Popcorn";
        Assert.assertEquals(expectedC1, actualC1);

        String actualA4 = testMap.get(keyA4).getName();
        String expectedA4 = "Chocolate Bar";
        Assert.assertEquals(expectedA4, actualA4);

    }

    @Test
    public void map_price_is_accurate(){
        double actualB2 = testMap.get(keyB2).getPrice();
        double expectedB2 = 4.85;
       Assert.assertEquals(expectedB2, actualB2, 1e-15);
        double actualC1 = testMap.get(keyC1).getPrice();
        double expectedC1 = 1.75;
        Assert.assertEquals(expectedC1, actualC1, 1e-15);

        double actualA4 = testMap.get(keyA4).getPrice();
        double expectedA4 = 1.75;
        Assert.assertEquals(expectedA4, actualA4,1e-15);
    }
}
