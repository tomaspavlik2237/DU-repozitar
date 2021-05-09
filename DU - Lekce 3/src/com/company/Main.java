package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static int INVALID_INPUT = -1;

    /**
     * Read one integer. If given input cannot be converted to integer,
     * prints error and return -1;
     * @return Integer read or -1 if invalid input entered
     */
    public static int safeReadInt() {
        int result = INVALID_INPUT;
        String inputText = scanner.nextLine();
        try {
            result = Integer.parseInt(inputText);
        } catch (NumberFormatException ex) {
            System.err.println("Zadal jsi text, který nelze převést na celé číslo: "+inputText);
        }
        return result;
    }

    /**
     * Example of use of {@link Main#safeReadInt()}
     *
     * Read one integer from input and print it to output
     * @return integer from input
     */
    public static void readOneIntFromInputAndPrintIt() {
        System.out.println("Zadej číslo: ");
        int input = safeReadInt();
        System.out.println("Zadal jsi: "+input);
    }

    /**
     * Read integers from input and print them until negative
     * input.
     */
    public static void readIntsFromInputAndPrintItUntilNegative()
    {
        int input;
        do
        {
            System.out.print("Zadej cislo kladne pro opakovani: ");
            input = safeReadInt();
            System.out.println("Zadane cislo je: " + input);
        }
        while(input >= 0);

        System.out.println("Zadal jsi zaporne cislo, konec cyklu.");
    }

    /**
     * Sum all input numbers (negative number terminates reading) and return result.
     * @return Sum of input numbers.
     */
    public static int sumAllInputUntilNegative()
    {
        boolean repeat = true;
        int sumInt = 0;
        int input;

        while(repeat) {

            System.out.print("Zadejte cisla pro scitani, zaporne cisla ukonci scitani: ");
            input = safeReadInt();

            if (input < 0)
            {
                break;
            }

            sumInt += input;
        }
        return sumInt;
    }

    /**
     * Store all input numbers in ArrayList (negative number terminates reading)
     * @return ArrayList of read values (terminating negative value is included)
     */
    public static ArrayList storeAllInputInArrayListUntilNegative()
    {
        ArrayList<Integer> list = new ArrayList();

        boolean opakuj = true;
        int sumInt = 0;
        int vstup;

        while(opakuj) {

            System.out.print("Zadejte cisla pro zapsani do seznamu: ");
            vstup = safeReadInt();

            if (vstup < 0)
            {
                break;
            }

            list.add(vstup);
        }
        return list;
    }

    /**
     * Print all integers from given list.
     * @param list List of integers to print.
     */
    public static void printAllIntegersFromList(ArrayList<Integer> list)
    {
        for(int cisla : list)
        {
            System.out.println(cisla);
        }
    }

    public static Integer sumAllIntegersFromList(ArrayList<Integer> list)
    {
        int suma = 0;

        for(int cislo : list)
        {
            suma += cislo;
        }

        return suma;
    }

    public static void main(String[] args) {
        // Example
        System.out.println("--- Example - read and print one number ---");
        readOneIntFromInputAndPrintIt();
        // ---
        System.out.println("--- Task 1 - read and print until negative ---");
        readIntsFromInputAndPrintItUntilNegative();
        // ---
        System.out.println("--- Task 2 - sum all until negative ---");
        System.out.println("Celkový součet je: " + sumAllInputUntilNegative());;
        // ---
        System.out.println("--- Task 3 - read to list until negative ---");
        ArrayList<Integer> list = storeAllInputInArrayListUntilNegative();
        System.out.println(list);
        // ---
        System.out.println("--- Task 4 - print all from list ---");
        printAllIntegersFromList(list);
        // ---
        System.out.println("--- Task 5 - sum all from list ---");
        System.out.println("Celkový součet je: " + sumAllIntegersFromList(list));
    }
}