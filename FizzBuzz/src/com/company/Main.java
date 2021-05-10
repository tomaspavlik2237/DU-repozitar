package com.company;

public class Main {

    public static void main(String[] args)
    {
        int limit = 100;
        String fizz = "Fizz";
        String buzz = "Buzz";

        for (int i = 1; i <= limit; i++)
        {
            if((i % 3) == 0 && (i % 5) == 0)
            {
                System.out.println(fizz + buzz);
            }

            else if ((i % 3) == 0 && (i % 5) != 0)
            {
                System.out.println(fizz);
            }

            else if ((i % 5) == 0 && (i % 3) != 0)
            {
                System.out.println(buzz);
            }

            else
            {
                System.out.println(i);
            }
        }
    }
}
