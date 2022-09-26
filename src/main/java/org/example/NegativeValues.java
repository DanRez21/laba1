package org.example;

public class NegativeValues extends RuntimeException{
    public static void throwException(String negative_numbers_str)
    {
        throw new IllegalArgumentException("Negative numbers not allowed. This numbers are: " + negative_numbers_str);
    }

}