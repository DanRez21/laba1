package org.example;

import java.util.ArrayList;

public class StringCalculator
{
    public int add(String numbers)
    {
        Integer sum = 0;
        String delimiter = "", numbers_part = "", delimiters_part = "", negative_numbers_str = "";

        //перевірка рядка з введених чисел на вміст чисел
        if (numbers.isEmpty())
        {
            return 0;
        }

        if (checkDelimiters(numbers)) //якщо є символи "/"
        {
            numbers_part = numbers.substring(numbers.indexOf("\n") + 1); //частина з числами із роздільниками
            delimiters_part = numbers.substring(2, numbers.indexOf("\n")); //частина з роздільниками
            String[] delimiters = delimiters_part.split("]"); //поділ по квадратній дужці

            delimiter = make_string_delimiters(delimiters, delimiters_part);
        }
        else
        {
            delimiter = "\n|,";
            numbers_part = numbers;
        }

        String[] numbers_array = numbers_part.split(delimiter); //ділення по роздільникам

        ArrayList<Integer> negative_numbers = new ArrayList<>(); //список для негативних чисел

        for (String number : numbers_array)
        {
            Integer current = Integer.parseInt(number);

            if (current < 0)
            {
                negative_numbers.add(current);
                negative_numbers_str += number + " ";
                continue;
            }

            if (current < 1001)
            {
                sum += current;
            }
        }

        if (!negative_numbers_str.isEmpty())
        {
            NegativeValues.throwException(negative_numbers_str);
        }

        return sum;
    }

    //перевірка на нестандартні роздільники та правильність їх оформлення
    private static boolean checkDelimiters(String numbers)
    {
        return (numbers.indexOf("/", 0) == 0 && numbers.indexOf("/", 1) == 1);
    }

    //створення рядку з роздільників для регулярного виразу
    private static String make_string_delimiters(String[] delimiters, String delimiters_part)
    {
        String delimiter = "";
        if (delimiters.length >= 2) //більше однієї заданої квадратної дужки
        {
            for (int element = 0; element < delimiters.length; element++)
            {
                delimiter += delimiters[element];

                if (element != delimiters.length - 1)
                {
                    delimiter += "]+|";
                }
                else
                {
                    delimiter += "]+";
                }
            }
        }
        else
        {
            delimiter = delimiters_part + "+";
        }

        delimiter = "\n|,|" + delimiter; //створення регулярного виразу з роздільників
        return delimiter;
    }

}