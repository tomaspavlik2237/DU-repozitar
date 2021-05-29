package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    private static final String INPUT_FILE = "stateVat.txt";
    private static final String OUTPUT_FILE = "vat-over-20.txt";

    public static void main(String[] args)
    {
        ReadWriteFile readWriteFile = new ReadWriteFile();

        readWriteFile.importFromFile(INPUT_FILE);

        //1.
        for (int i = 0; i < readWriteFile.size(); i++)
        {
            State state = readWriteFile.getState(i);
            //System.out.println(state);
        }

        //2.
        for (int i = 0; i < readWriteFile.size(); i++)
        {
            State state = readWriteFile.getState(i);
            float fullVat = readWriteFile.getState(i).getFullVat();
            boolean specialVat = readWriteFile.getState(i).isSpecialVat();

            if(fullVat > 20 && !specialVat)
            {
                readWriteFile.stateList.add(state);
                //System.out.println(state);
            }

            else
            {
                readWriteFile.smallerThanTwenty.add(state.getStateShortcut());
            }
        }

        //3.
        Collections.sort(readWriteFile.stateList);

        for (State state : readWriteFile.stateList)
        {
            System.out.println(state);
        }

        //4.
        System.out.println("=============================");
        System.out.println("Rate VAT 20 % or lower or using special rate: " + readWriteFile.smallerThanTwenty);

        readWriteFile.exportToFile(OUTPUT_FILE);
    }
}
