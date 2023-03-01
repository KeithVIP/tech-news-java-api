package com.technews;

public class VariablePractice {
    public static void main(String[] args) {
        // var 1
        int one = 1;
        double twoandhalf = 2.5;
        // var 2

        // add var 1 + var 2
        var sum = one + twoandhalf;
        // assign result what type is it?
        System.out.println(sum);

        String hello = "Hello!";
        var result = hello + one;
        System.out.println(result); // STRING
        System.out.println(result.getClass());

        // examples

        int a = 4;
        double b = 3.5;
        String c = "cat";

        // calculated variable sum is a double
        double summ = a + b; // 7.5

        // calculated variable concat is a String
        String concat = a + c;

        // value of sum is 7.5
        System.out.println(summ);

        // value of concat is "4cat
        System.out.println(concat);
    }
}
