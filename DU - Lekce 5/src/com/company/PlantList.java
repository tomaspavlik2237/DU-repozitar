package com.company;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class PlantList
{
    ArrayList<Plant> plantList = new ArrayList<>();

    public void addPlant(Plant plant)
    {
        plantList.add(plant);
    }

    public void removePlant(int index)
    {
        plantList.remove(index);
    }

    public Plant getPlant(int index)
    {
        return plantList.get(index);
    }

    public int size()
    {
        return plantList.size();
    }

    public void importFromFile(String file)
    {
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(file))))
        {
            while(scanner.hasNextLine())
            {
                String nextLine = scanner.nextLine();
                Plant plant = Plant.parsePlant(nextLine);
                System.out.println(plant.getDescription());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File " + file + "not found. " + e.getLocalizedMessage());
        } catch (PlantException e) {
            System.err.println("Error in " + file + e.getLocalizedMessage());
        }
    }

    public void exportToFile(String file)
    {
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file))))
        {
            for(Plant plant : plantList)
            {
                writer.println(plant.prepareToWrite());
            }
        }
        catch (IOException e) {
            System.err.println("Error in writing " + file + e.getLocalizedMessage());
        }
    }
}
