package com.techelevator.item;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
Item nachos;
Item walkingTacos;
Item papsi;
Item caramelBar;
    @Before
    public void setUp() throws Exception {
        nachos=new Munchy("Nachos",3.85,"A1");
        walkingTacos=new Sandwich("Walking Tacos",5.25,"A2");
        papsi=new Drink("Papsi",2.45,"B3");
        caramelBar=new Dessert("Caramel Bar",2.25,"B4");
    }
    @Test
    public void nachosMessage(){
        String expected="Munchy, Munchy, so Good!";
        String actual=nachos.printMessage();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void tacosMessage(){
        String expected="Sandwich So Delicious, Yum!";
        String actual=walkingTacos.printMessage();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void papsiMessage(){
        String expected="Drinky, Drinky, Slurp Slurp!";
        String actual=papsi.printMessage();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void caramelBarMessage(){
        String expected="Sugar, Sugar, so Sweet!";
        String actual=caramelBar.printMessage();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void nachosProductInfo(){
        String expected= "A1: Nachos            $3.85 7 available | ";
        String actual=nachos.productInfo();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void tacosProductInfo(){
        String expected= "A2: Walking Tacos     $5.25 7 available | ";
        String actual=walkingTacos.productInfo();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void papsiProductInfo(){
        String expected= "B3: Papsi             $2.45 7 available | ";
        String actual=papsi.productInfo();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void caramelBarProductInfo(){
        String expected= "B4: Caramel Bar       $2.25 7 available | ";
        String actual=caramelBar.productInfo();
        Assert.assertEquals(expected,actual);
    }
}
