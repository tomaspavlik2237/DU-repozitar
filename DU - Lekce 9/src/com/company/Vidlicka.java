package com.company;

import java.util.concurrent.Semaphore;

public class Vidlicka
{
    private boolean jePouzivana = false;

    public synchronized void zvednout()
    {
        jePouzivana = true;
    }

    public synchronized void polozit()
    {
        jePouzivana = false;
    }

    public boolean jePouzivana()
    {
        return jePouzivana;
    }
}
