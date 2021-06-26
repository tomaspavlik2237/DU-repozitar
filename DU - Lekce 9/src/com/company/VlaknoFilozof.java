package com.company;

public class VlaknoFilozof extends Thread
{
    private static Integer celkemSnezenychPorci = 0;

    private Integer snezenePorce = 0;
    private Integer porceKeSnezeni = 10000;

    private Vidlicka levaVidlicka;
    private Vidlicka pravaVidlicka;

    private Object synchronizace;

    public VlaknoFilozof(String jmeno, Vidlicka levaVidlicka, Vidlicka pravaVidlicka, Object synchronizace)
    {
        super(jmeno);
        this.levaVidlicka = levaVidlicka;
        this.pravaVidlicka = pravaVidlicka;
        this.synchronizace = synchronizace;
    }

    public void run()
    {
        if(!levaVidlicka.jePouzivana() && !pravaVidlicka.jePouzivana()) {
            while (porceKeSnezeni > 0)
            {
                levaVidlicka.zvednout();
                pravaVidlicka.zvednout();

                synchronized (synchronizace) {
                    porceKeSnezeni--;
                    snezenePorce++;
                    celkemSnezenychPorci++;
                    System.out.println("Filozof " + getName() + " snedl " + snezenePorce + " porci. Zbyva mu snist jeste " + porceKeSnezeni + " porci.");
                }
                levaVidlicka.polozit();
                pravaVidlicka.polozit();
            }
            System.out.println(celkemSnezenychPorci);
        }
    }
    // System.out.println("Filozof " + getName() + " snedl " + snezenePorce + " porci. Zbyva mu snist jeste " + porceKeSnezeni + " porci.");
}
