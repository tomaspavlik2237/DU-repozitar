package com.company;

public class VlaknoFilozof extends Thread
{
    private static Integer celkemSnezenychPorci = 0;

    private Integer snezenePorce = 0;
    private Integer porceKeSnezeni = 1000;

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
        try {
            levaVidlicka.lock();
            pravaVidlicka.lock();
            while(porceKeSnezeni > 0)
            {
                if(levaVidlicka.jePouzivana() && pravaVidlicka.jePouzivana())
                {
                    synchronized (synchronizace)
                    {
                        porceKeSnezeni--;
                        snezenePorce++;
                        celkemSnezenychPorci++;
                    }
                    System.out.println("Filozof " + getName() + " snedl " + snezenePorce + " porci. Zbyva mu snist jeste " + porceKeSnezeni + " porci.");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            levaVidlicka.unlock();
            pravaVidlicka.unlock();
        }

        System.out.println(celkemSnezenychPorci);
    }
}
