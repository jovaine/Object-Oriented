package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Products> products = new ArrayList<Products>();

        Products merch = new Products();
        merch.setItem("Bison Sweater");
        merch.setPrice(55.99);
        products.add(merch);

        merch = new Products();
        merch.setItem("Bison Tee");
        merch.setPrice(14.99);
        products.add(merch);

        merch = new Products();
        merch.setItem("Bison Hoodie");
        merch.setPrice(23.99);
        products.add(merch);

        merch = new Products();
        merch.setItem("Bison Bumpersticker");
        merch.setPrice(4.99);
        products.add(merch);

        String answer = "";
        ArrayList<Order> order = new ArrayList<Order>();
        do {
            System.out.println("What do you want to do?");
            System.out.println("1) add purchase 2) change purchase 3) show purchases 4) finish transaction");
            answer = input.nextLine();
            if (answer.equals("1")) {
                for (int i = 0; i < products.size(); i++) {
                    System.out.println("Item #" + i + "---- " + products.get(i).getItem() + " ---- Price " + products.get(i).getPrice());
                }
                int response;
                System.out.println("Enter the item # you wish to buy?");
                response = input.nextInt();
                if (response >= products.size()-1 || response < 0) {
                    System.out.println("You made an invalid selection");
                } else {
                    String proditems = products.get(response).getItem();
                    double prodprice = products.get(response).getPrice();
                    Order basket = new Order();
                    basket.setItem(proditems);
                    basket.setPrice(prodprice);
                    order.add(basket);
                }
                } else if (answer.equals("2")) {
                System.out.println("You have the following items in your basket");
                for (int i = 0; i < order.size(); i++) {
                    System.out.println("Item #" + i + "---- " + order.get(i).getItem() + " ---- Price " + order.get(i).getPrice());
                }
                int response1;
                System.out.println("Enter the item # you wish to remove from cart.");
                response1 = input.nextInt();
                if ((response1 >= order.size()) || ((response1 < 0))) {
                    System.out.println("You made an invalid selection");
                } else {
                    order.remove(response1);
                }
            } else if (answer.equals("3")) {
                {
                    System.out.println("You have the following items in your basket");
                    for (int i = 0; i < order.size(); i++) {
                        System.out.println("Item #" + i + "---- " + order.get(i).getItem() + " ---- Price " + order.get(i).getPrice());
                    }
                }
            }
        }
        while (!answer.equals("4")) ;

        float totalAmt = 0f;
        for (int i = 0; i < order.size(); i++) {
            double price = order.get(i).getPrice();
            totalAmt += price;
        }
        System.out.println("Your total amount due is $" + totalAmt);


    }
}
