package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args){
        try{
            System.out.println(SecondChallenge.probablyIWillThrowException(2.0, 3.0));
        } catch (Exception e) {
            System.out.println("EXCEPTION:" + e);

        } finally {
            System.out.println("Yea, yea, always here, it's boring...");
        }
    }
}
