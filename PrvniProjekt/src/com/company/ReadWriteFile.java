package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadWriteFile
{
    ArrayList<State> stateList = new ArrayList<>();

    public void addStateToList(State state)
    {
        stateList.add(state);
    }

    public void removeStateFromList(State state)
    {
        stateList.remove(state);
    }

    public int size()
    {
        return stateList.size();
    }

    public ArrayList<State> getStateList()
    {
        return stateList;
    }

    public State getState(int index)
    {
        return stateList.get(index);
    }

    public void importFromFile(String file)
    {
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(file))))
        {
            while(scanner.hasNextLine())
            {
                String nextLine = scanner.nextLine();
                State state = State.parseState(nextLine);
                addStateToList(state);
            }
        } catch (FileNotFoundException e)
        {
            System.err.println("File " + file + " not found. " + e.getLocalizedMessage());

        } catch (StateException e) {
            System.err.println("Error in " + file + e.getLocalizedMessage());
        }
    }

    public void exportToFile(String file)
    {
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file))))
        {
            for(State state : stateList)
            {
                writer.println(state.prepareToWrite());
            }
        } catch (IOException e)
        {
            System.err.println("Error in writing " + file + e.getLocalizedMessage());
        }
    }
}
