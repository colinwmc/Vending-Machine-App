package com.techelevator.view;

import com.techelevator.Utilities.Colors;
import com.techelevator.item.Item;

import java.util.Map;

public class UserOutput{



    public static void displayItems(Map<String, Item> items){
            System.out.println("");
            System.out.println(Colors.Cyan+"|**************************************************************************"+Colors.Purple+"   Our Products   "+Colors.Cyan+"**************************************************************************|"+Colors.Reset);
            System.out.print("|"+items.get("A1").productInfo());
            System.out.print(items.get("A2").productInfo());
            System.out.print(items.get("A3").productInfo());
            System.out.print(items.get("A4").productInfo());
            System.out.println();
            System.out.print("|"+items.get("B1").productInfo());
            System.out.print(items.get("B2").productInfo());
            System.out.print(items.get("B3").productInfo());
            System.out.print(items.get("B4").productInfo());
            System.out.println();
            System.out.print("|"+items.get("C1").productInfo());
            System.out.print(items.get("C2").productInfo());
            System.out.print(items.get("C3").productInfo());
            System.out.print(items.get("C4").productInfo());
            System.out.println();
            System.out.print("|"+items.get("D1").productInfo());
            System.out.print(items.get("D2").productInfo());
            System.out.print(items.get("D3").productInfo());
            System.out.print(items.get("D4").productInfo());
            System.out.println("\n" + Colors.Cyan+"|**********************************************************************************************************************************************************************|"+Colors.Reset);
        }

        public static void goodByeMessage(){
            System.out.println(Colors.Cyan+"*********************************");
            System.out.println(Colors.Purple+"  Thank You! Please Come Again!  ");
            System.out.println(Colors.Cyan+"*********************************"+Colors.Reset);
        }
    }
