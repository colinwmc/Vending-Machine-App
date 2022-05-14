package com.techelevator.view;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class UserInputTest {
@Rule
    public final TextFromStandardInputStream systemInMock=emptyStandardInputStream();

//ShowMainMenuTests
@Test
    public void showMainMenuLowerD(){
    systemInMock.provideLines("d");
    String expected="Display";
    String actual=UserInput.showMainMenu();
    Assert.assertEquals(expected,actual);
}
    @Test
    public void showMainMenuCapitalD(){
        systemInMock.provideLines("D");
        String expected="Display";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void showMainMenuCapitalP(){
        systemInMock.provideLines("P");
        String expected="Purchase";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void showMainMenuLowerP(){
        systemInMock.provideLines("p");
        String expected="Purchase";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void showMainMenuLowerE(){
        systemInMock.provideLines("e");
        String expected="Exit";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void showMainMenuCapitalE(){
        systemInMock.provideLines("E");
        String expected="Exit";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void showMainMenuLowerS(){
        systemInMock.provideLines("s");
        String expected="Sales Report";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void showMainMenuCapitalS(){
        systemInMock.provideLines("S");
        String expected="Sales Report";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void showMainMenuLowerq(){
        systemInMock.provideLines("q");
        String expected="Invalid";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void showMainMenuLowerX(){
        systemInMock.provideLines("x");
        String expected="Invalid";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void showMainMenuLowerDP(){
        systemInMock.provideLines("dp");
        String expected="Invalid";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void showMainMenuCapitalED(){
        systemInMock.provideLines("ED");
        String expected="Invalid";
        String actual=UserInput.showMainMenu();
        Assert.assertEquals(expected,actual);
    }
    //BottomOfDisplay Tests
    @Test
    public void bottomOfDisplayLowerP(){
        systemInMock.provideLines("p");
        String expected="Purchase";
        String actual=UserInput.bottomOfDisplay();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void bottomOfDisplayCapitalP(){
        systemInMock.provideLines("P");
        String expected="Purchase";
        String actual=UserInput.bottomOfDisplay();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void bottomOfDisplayLowerB(){
        systemInMock.provideLines("b");
        String expected="Back";
        String actual=UserInput.bottomOfDisplay();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void bottomOfDisplayCapitalB(){
        systemInMock.provideLines("B");
        String expected="Back";
        String actual=UserInput.bottomOfDisplay();
        Assert.assertEquals(expected,actual);
    }
}
