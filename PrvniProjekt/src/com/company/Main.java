package com.company;

import java.io.File;

public class Main {

    private static final String INPUT_FILE = "stateVat.txt";

    public static void main(String[] args)
    {
        ReadWriteFile readWriteFile = new ReadWriteFile();

        readWriteFile.importFromFile(INPUT_FILE);

        //1.
        for (int i = 0; i < readWriteFile.size(); i++)
        {
            State state = readWriteFile.getState(i);
            System.out.println(state);
        }


        //2.
        for (int i = 0; i < readWriteFile.size(); i++)
        {
            State state = readWriteFile.getState(i);
            float fullVat = readWriteFile.getState(i).getFullVat();
            boolean specialVat = readWriteFile.getState(i).isSpecialVat();

            if(fullVat > 20 && !specialVat)
            {
                System.out.println(state);
            }
        }
    }
}
