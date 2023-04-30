/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.group.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Main {

    public static void main(String[] args) {
        Shopping_app shopping_app = new Shopping_app();
        shopping_app.welcome();

    }

}

class Shopping_app {

    List<String> menu = new ArrayList<>(); //market_menu
    List<String> cart = new ArrayList<>(); //cart List
    List<Integer> calc = new ArrayList<>(); //price 
    Scanner scanner_obj1;
    Scanner scanner_obj2;
    String username;
    int amount;
    Scanner purchase;
    int add_1;
    Scanner scanner_obj3;
    String option_viewcart;
    Scanner scanner_obj4;
    String cart_menu;
    int sum;

    public void welcome() {

        System.out.println("welcome to SHOPLET\n");
        System.out.println("Enter your username and the amount you would like to fund your wallet\n");
        scanner_obj1 = new Scanner(System.in);
        scanner_obj2 = new Scanner(System.in);
        username = scanner_obj1.nextLine();
        amount = scanner_obj2.nextInt();
        System.out.println("welcome " + username + " you have sucessfully funded your wallet with \n" + "#" + amount);
        System.out.println("\n marketplace\n");
        men_u();
    }

    public void men_u() {
        market_menu();
        add_to_cart();
        second_option_menu();
        cart_();

    }

    public void market_menu() {
        String[] menu_ = {"1. #500-Apple", "2. #1500-Rice", "3. #1000-Suya", "4. #2500-Pizza", "5. #300-Sausage", "6. #500 pringles\n"};
        for (String i : menu_) {
            System.out.println(i);
        }

    }

    public void add_to_cart() {
        purchase = new Scanner(System.in);
        add_1 = purchase.nextInt();
        switch (add_1) {
            case 1:
                calc.add(500);
                cart.add("0. #500-Apple");
                System.out.println("item sucesfully added  to cart");
                break;

            case 2:
                calc.add(1500);
                cart.add("1. #1500-Rice");
                System.out.println("item sucesfully added  to cart");
                break;

            case 3:
                System.out.println("item sucesfully added  to cart");
                cart.add("2. #1000-Suya");
                calc.add(1000);
                break;

            case 4:
                System.out.println("item sucesfully added  to cart");
                cart.add("3. #2500-Pizza");
                calc.add(2500);
                break;

            case 5:
                System.out.println("item sucesfully added  to cart");
                cart.add("4. #300-Sausage");
                calc.add(300);
                break;

            case 6:
                System.out.println("item sucesfully added  to cart");
                cart.add("5. #500-pringles");
                calc.add(500);
                break;

            default:
                System.out.println("purchase an item");
                break;

        }

    }

    public void second_option_menu() {
        String[] option = {"\nA. view your cart", "B. continue Shopping", "C. delete an item from cart by id", "D. Exit"};
        for (String i : option) {
            System.out.println(i);
        }
        scanner_obj3 = new Scanner(System.in);
        option_viewcart = scanner_obj3.nextLine();
        viewcart();

    }

    public void viewcart() {
        switch (option_viewcart) {
            case "A":
                System.out.println("\nShopping cart\n");
                cart.forEach((i) -> {
                    System.out.println(i);
                });
              

                break;
            case "B":
                men_u();
                add_to_cart();

                break;

            case "C":
                cart.forEach((i) -> {
                    System.out.println(i);
                });
                Scanner scanner_obj5 = new Scanner(System.in);
                int delete = scanner_obj5.nextInt();
                System.out.println("succesfully deleted " + cart.remove(delete) + " from cart\n");
                second_option_menu();
                break;
             
            case "D":
                System.exit(0);
                break;

            default:
                System.out.println("input right");
                break;

        }
    }

    public void cart_() {
        String[] option_cart = {"\n1. make payment", "2. add an item", "3. delete an item\n"};
        for (String i : option_cart) {
            System.out.println(i);
        }

        scanner_obj4 = new Scanner(System.in);
        cart_menu = scanner_obj4.nextLine();
        switch (cart_menu) {
            case "1":
                sum = 0;
                calc.forEach((i) -> {
                    sum = sum + i;
            });
                    if (amount >= sum) {
                        System.out.println("payment succesfull");
                        System.out.println("thank you for patronizing SHOPLET " + username);
                        int balance = amount-sum;
                        System.out.println("you balance is " + balance);
                        second_option_menu();
                         System.out.println("you balance is " + balance);

                    } else {
                        System.out.println("insuficient fund");
                        System.out.println("please remove an item");
                        Scanner scanner_obj5 = new Scanner(System.in);
                        int delete = scanner_obj5.nextInt();
                        System.out.println("succesfully deleted " + cart.remove(delete) + "" + calc.remove(delete) + " from cart\n");
                        second_option_menu();
                    }
                

                break;


            case "2":
                second_option_menu();
                break;

            case "3":
                Scanner scanner_obj5 = new Scanner(System.in);
                int delete = scanner_obj5.nextInt();
                System.out.println("succesfully deleted " + cart.remove(delete) + "" + calc.remove(delete) + " from cart\n");
                second_option_menu();
                cart_();
                break;

            default:
                System.out.println("input the right option");
                break;
        }

    }
}
     
     
  
