package com.company;

public class Vidlicka
{
    private boolean jePouzivana = false;

    public void zvednout()
    {
        jePouzivana = true;
    }

    public void polozit()
    {
        jePouzivana = false;
    }

    public boolean jePouzivana()
    {
        return jePouzivana;
    }
}
