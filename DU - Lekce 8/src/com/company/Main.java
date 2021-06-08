package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args)
    {
        Ucitel ucitel = new Ucitel("Honza", "Jarousek");

        SkolniTrida skolniTrida = new SkolniTrida("C", 4, ucitel);

        Student student1 = new Student("Tomas", "Pavlik", LocalDate.of(2007, 06, 18), "ID001");
        Student student2 = new Student("Honza", "Hamrla", LocalDate.of(2002, 06, 18), "ID002");
        Student student3 = new Student("Lukas", "Brokl", LocalDate.of(2005, 06, 18), "ID003");
        Student student4 = new Student("Adam", "Batousek", LocalDate.of(2009, 06, 18), "ID003");

        skolniTrida.pridatStudenta(student1);
        skolniTrida.pridatStudenta(student2);
        skolniTrida.pridatStudenta(student3);
        skolniTrida.pridatStudenta(student4);

        System.out.println("####################################");
        System.out.println("Trida: " + skolniTrida.getRocnik() + "." + skolniTrida.getJmenoTridy() + " (rocnik: " + skolniTrida.getRocnik() + ")");
        System.out.println("Tridni ucitel: " + skolniTrida.getUcitel());
        System.out.println("Pocet studentu: " + skolniTrida.pocetStudentu());
        System.out.println("\n####################################");

        for (int i = 0; i < skolniTrida.pocetStudentu(); i++)
        {
            System.out.println("# " + (i + 1) + " # " + skolniTrida.vratStudenta(i).getCisloStudenta() + " - " + skolniTrida.vratStudenta(i).getJmeno() + " " +
                    skolniTrida.vratStudenta(i).getPrijmeni() + " (" + skolniTrida.vratStudenta(i).getDatumNarozeniStudenta().getYear() + ")");
        }
    }
}
