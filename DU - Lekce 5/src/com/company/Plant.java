package com.company;

import java.time.LocalDate;

public class Plant
{
    private static final String FILE_ITEM_DELIMETER = "\t";
    private String name;
    private String note;
    private LocalDate planted;
    private LocalDate watering;
    private int frequencyOfWatering; //Days

    public static Plant parsePlant(String record) throws PlantException
    {
        String[] item = record.split(FILE_ITEM_DELIMETER);

        int numberOfItems = item.length;

        if(numberOfItems != 5) throw new PlantException(" Wrong number of items " + record);
        {
            String name = item[0];
            String note = item[1];
            int frequencyOfWatering = Integer.parseInt(item[2]);
            LocalDate watering = LocalDate.parse(item[3]);
            LocalDate planted = LocalDate.parse(item[4]);

            return new Plant(name, note, frequencyOfWatering, watering, planted);
        }
    }

    public Plant(String name, String note, int frequencyOfWatering, LocalDate watering, LocalDate planted)
    {
        this.name = name;
        this.note = note;
        this.frequencyOfWatering = frequencyOfWatering;
        this.watering = watering;
        this.planted = planted;
    }

    public Plant(String name, int frequencyOfWatering, LocalDate planted)
    {
        this(name,"", frequencyOfWatering, LocalDate.now(), planted);
    }

    public Plant(String name)
    {
        this(name, "", 7, LocalDate.now(), LocalDate.now());
    }

    public String prepareToWrite()
    {
        return getName() + FILE_ITEM_DELIMETER + getNote() + FILE_ITEM_DELIMETER +
                getFrequencyOfWatering() + FILE_ITEM_DELIMETER + getWatering() + FILE_ITEM_DELIMETER + getPlanted();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
            this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering) throws PlantException
    {
        if (watering.isBefore(planted)) throw new PlantException("Date of watering is before planting.");
        {
            this.watering = watering;
        }
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) throws PlantException
    {
        if(frequencyOfWatering <= 0) throw new PlantException("Number must be bigger than 0.");
        {
            this.frequencyOfWatering = frequencyOfWatering;
        }
    }

    public String getWateringInfo()
    {
        return "Plant " + name + "was watered" + watering + ". " + "The next recommended watering is in " + frequencyOfWatering + " days.";
    }

    public String getDescription()
    {
        return name + " is planted " + planted + " last watering: " + watering + " and frequency of watering: " + frequencyOfWatering;
    }
}
