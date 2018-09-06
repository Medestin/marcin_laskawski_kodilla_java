package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {

        //Testing class SimpleUser @ com.kodilla.testing.user
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        //Testing class Calculator @ com.kodilla.testing.calculator
        Calculator calculator = new Calculator();

        int a = 10;
        int b = 5;

        if(calculator.add(a, b) == a + b){
            System.out.println("Add successful, test OK.");
        } else {
            System.out.println("Add unsuccessful, test fail.");
        }

        if(calculator.subtract(a, b) == a - b){
            System.out.println("Subtract successful, test OK.");
        } else {
            System.out.println("Subtract unsuccessful, test fail.");
        }

    }
}