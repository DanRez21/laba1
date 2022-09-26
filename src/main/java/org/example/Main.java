package org.example;

public class Main {
    public static void main(String[] args) {
        StringCalculator sum = new StringCalculator();
        try
        {
            System.out.println(sum.add("-1,-2"));
        }
        catch(Exception exception)
        {
            exception.printStackTrace(System.out);
        }
    }
}
