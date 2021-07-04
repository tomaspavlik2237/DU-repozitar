package com.company;

import java.util.Random;

public class VlaknoFilozof extends Thread
{
    private static Integer celkemSnezenychPorci = 0;

    private Integer snezenePorce = 0;
    private Integer porceKeSnezeni = 10000;

    private Vidlicka levaVidlicka;
    private Vidlicka pravaVidlicka;

    private Object synchronizace;

    Random randomNumber = new Random();

    public VlaknoFilozof(String jmeno, Vidlicka levaVidlicka, Vidlicka pravaVidlicka, Object synchronizace)
    {
        super(jmeno);
        this.levaVidlicka = levaVidlicka;
        this.pravaVidlicka = pravaVidlicka;
        this.synchronizace = synchronizace;
    }

    public void chceJist()
    {
        try {
            Thread.sleep(randomNumber.nextInt(100));
            System.out.println(this.getName() + " chce jist.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void jeNajezeny()
    {
        try {
            Thread.sleep(randomNumber.nextInt(100));
            System.out.println(this.getName() + " je najezeny.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cekaNaDruhouVidlicku()
    {
        try {
            Thread.sleep(randomNumber.nextInt(100));
            System.out.println(this.getName() + " nema druhou vidlicku.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run()
    {
        while (porceKeSnezeni > 0)
        {
            if(!levaVidlicka.jePouzivana())
            {
                levaVidlicka.zvednout();
                if(!pravaVidlicka.jePouzivana())
                {
                    pravaVidlicka.zvednout();

                    synchronized (synchronizace)
                    {
                        snezenePorce++;
                        celkemSnezenychPorci++;
                        porceKeSnezeni--;
                        jeNajezeny();
                        System.out.println("Filozof " + getName() + " snedl " + snezenePorce + " porci. Zbyva mu snist jeste " + porceKeSnezeni + " porci.");
                        levaVidlicka.polozit();
                        pravaVidlicka.polozit();
                    }
                }
                else
                {
                    levaVidlicka.polozit();
                    cekaNaDruhouVidlicku();
                }
            }
            else
            {
                chceJist();
            }
        }
        System.out.println(celkemSnezenychPorci);
    }
    // System.out.println("Filozof " + getName() + " snedl " + snezenePorce + " porci. Zbyva mu snist jeste " + porceKeSnezeni + " porci.");
}
