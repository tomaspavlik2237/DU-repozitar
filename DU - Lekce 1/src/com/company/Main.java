package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args)
    {
        //DU prvni cast
        String jmenoKlienta = "Tomas Pavlik"; // Jmeno a prijmeni
        int pocetNakupu = 10;
        String mistoFirmy = "Kromeriz"; // Ve kterem meste firma sidli
        double spotrebaVozidla = 4.7; // V litrech na 100 km
        double delkaKabeluUTP = 25.5; // Delka v metrech
        LocalDate datumNarozeniKlienta = LocalDate.of(1999, Month.JUNE, 2);
        String poznavaciZnacka = "5Z9 26-23";
        String rodneCisloKlienta = "990602/4721";

        System.out.println("Jmeno klienta: " + jmenoKlienta);
        System.out.println("Pocet nakupu: " + pocetNakupu);
        System.out.println("Misto firmy: " + mistoFirmy);
        System.out.printf("Spotreba vozidla %f l/100km: \n", spotrebaVozidla);
        System.out.printf("Delka kabelu UTP: %f m\n", delkaKabeluUTP);
        System.out.println("Datum narozeni klienta: " + datumNarozeniKlienta);
        System.out.println("Poznavaci znacka vozidla: " + poznavaciZnacka);
        System.out.println("Rodne cislo klienta: " + rodneCisloKlienta);

        /////////////////////////////////////////////

        // DU druha cast
        System.out.println("\nOprav chyby a spusť všechny metody!");
        System.out.println("Komentáře odstraníš klávesovou zkratkou <Ctrl>+</> - použij lomítko na numerické klávesnici.");
        ukol1();
        ukol2();
        ukol3();
        ukol4();
        ukol5();
        ukol6();
        ukol7();
        ukol8();
        ukol9();
    }

    public static void ukol1() {
    System.out.println("Hello world!");
    }

    public static void ukol2() {
        String uzivatel = "Karel";
        System.out.println(uzivatel);
    }

    public static void ukol3() {
        int pocetLekci = 10;
        System.out.println(pocetLekci);
    }

    public static void ukol4() {
        double cena = 10.0;
        System.out.println(cena);
    }

    public static void ukol5() {
        BigDecimal cena = BigDecimal.valueOf(0);
        for (int i = 0; i < 10; i++) {
            cena = cena.add(BigDecimal.valueOf(0.1));
        }
        System.out.println(cena);
        // Má vypsat "1.0". Ale vypíše "0.9999" !!!
    }

    public static void ukol6() {
        BigDecimal cena = BigDecimal.valueOf(0);
        cena = cena.add(BigDecimal.valueOf(0.1));
        System.out.println(cena);
    }

    public static void ukol7() {
        int vykonMotoru = 120;
        System.out.println("Výkon Motoru je: "+vykonMotoru+" kW.");
    }

    public static void ukol8() {
        int velikostKosile = 37;
        System.out.println("Velikost košile je: " + velikostKosile + ".");
    }

    public static void ukol9() {
        System.out.println("Metoda *skoro* bez chybičky!");
    }
}

