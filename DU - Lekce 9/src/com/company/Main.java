package com.company;

public class Main {

    public static void main(String[] args)
    {
        String synchronizace = new String("Synchro");

        Vidlicka vidlicka1 = new Vidlicka();
        Vidlicka vidlicka2 = new Vidlicka();
        Vidlicka vidlicka3 = new Vidlicka();
        Vidlicka vidlicka4 = new Vidlicka();
        Vidlicka vidlicka5 = new Vidlicka();
        Vidlicka vidlicka6 = new Vidlicka();
        Vidlicka vidlicka7 = new Vidlicka();
        Vidlicka vidlicka8 = new Vidlicka();
        Vidlicka vidlicka9 = new Vidlicka();
        Vidlicka vidlicka10 = new Vidlicka();

        VlaknoFilozof filozof1 = new VlaknoFilozof("Franta", vidlicka1, vidlicka2, synchronizace);
        VlaknoFilozof filozof2 = new VlaknoFilozof("Lojza", vidlicka2, vidlicka3, synchronizace);
        VlaknoFilozof filozof3 = new VlaknoFilozof("Honza", vidlicka3, vidlicka4, synchronizace);
        VlaknoFilozof filozof4 = new VlaknoFilozof("Petr", vidlicka4, vidlicka5, synchronizace);
        VlaknoFilozof filozof5 = new VlaknoFilozof("Daniel", vidlicka5, vidlicka6, synchronizace);
        VlaknoFilozof filozof6 = new VlaknoFilozof("Tomas", vidlicka6, vidlicka7, synchronizace);
        VlaknoFilozof filozof7 = new VlaknoFilozof("Richard", vidlicka7, vidlicka8, synchronizace);
        VlaknoFilozof filozof8 = new VlaknoFilozof("Radek", vidlicka8, vidlicka9, synchronizace);
        VlaknoFilozof filozof9 = new VlaknoFilozof("Jirka", vidlicka9, vidlicka10, synchronizace);
        VlaknoFilozof filozof10 = new VlaknoFilozof("Zbynek", vidlicka10, vidlicka1, synchronizace);

        filozof1.start();
        filozof2.start();
        filozof3.start();
        filozof4.start();
        filozof5.start();
        filozof6.start();
        filozof7.start();
        filozof8.start();
        filozof9.start();
        filozof10.start();
    }
}
