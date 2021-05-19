package com.company;

import java.time.LocalDate;

public class Main {

    private static final String INPUT_FILE = "kvetiny.txt";
    private static final String OUTPUT_FILE = "output.txt";

    public static void main(String[] args)
    {
        PlantList plantList1 = new PlantList();

        plantList1.importFromFile(INPUT_FILE);

        for (int i = 0; i < plantList1.size(); i++)
        {
            Plant plant = plantList1.getPlant(i);
            System.out.println(plant.getDescription());
        }

        PlantList plantList2 = new PlantList();

        plantList2.addPlant(new Plant("Amarylis v obyvaku", "", 7, LocalDate.now(), LocalDate.of(2021, 05, 15)));
        plantList2.addPlant(new Plant("Bazalka v kuchyni", "", 5, LocalDate.now(), LocalDate.of(2021, 05, 13)));

//        plantList2.removePlant(1);
//        plantList2.removePlant(0);

        plantList2.exportToFile(OUTPUT_FILE);

        for (int i = 0; i < plantList2.size(); i++)
        {
            Plant plant = plantList2.getPlant(i);
            System.out.println(plant.getDescription());
        }
    }
}
