package com.company;

public class Main {

    public static void main(String[] args) {

        String s = "1;2.34";
        String[] stringArray = s.split(";|\\.");
        System.out.println(stringArray[0]);
        System.out.println(stringArray[1]);
        System.out.println(stringArray[2]);

    }
}
