package org.example;

public class NegativeValues extends IllegalArgumentException{
    public static void throwException(String negative_numbers_str) {
        if (!negative_numbers_str.isEmpty()){
            System.out.print(negative_numbers_str);
        }
    }

}