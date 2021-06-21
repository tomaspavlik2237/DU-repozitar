package com.company;

public class Vidlicka
{
    private boolean jePouzivana = false;

    public synchronized void lock() throws InterruptedException {
        while (jePouzivana)
        {
            wait();
        }
        jePouzivana = true;
    }

    public synchronized void unlock()
    {
        jePouzivana = false;
        notify();
    }

    public boolean jePouzivana()
    {
        return jePouzivana;
    }
}
