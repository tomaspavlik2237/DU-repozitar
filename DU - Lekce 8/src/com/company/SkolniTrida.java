package com.company;

import java.util.ArrayList;
import java.util.List;

public class SkolniTrida
{
    private String jmenoTridy;
    private int rocnik;
    private Ucitel ucitel;

    private ArrayList<Student> listStudentu = new ArrayList<>();

    public SkolniTrida(String jmenoTridy, int rocnik, Ucitel ucitel)
    {
        this.jmenoTridy = jmenoTridy;
        this.rocnik = rocnik;
        this.ucitel = ucitel;
    }

    public String getJmenoTridy() {
        return jmenoTridy;
    }

    public void setJmenoTridy(String jmenoTridy) {
        this.jmenoTridy = jmenoTridy;
    }

    public String getUcitel() {
        return ucitel.getPrijmeni() + ", " + ucitel.getJmeno();
    }

    public void setUcitel(Ucitel ucitel) {
        this.ucitel = ucitel;
    }

    public int getRocnik() {
        return rocnik;
    }

    public void setRocnik(int rocnik) {
        this.rocnik = rocnik;
    }

    public void pridatStudenta(Student student)
    {
        listStudentu.add(student);
    }

    public void vymazatStudenta(Student student)
    {
        listStudentu.remove(student);
    }

    public ArrayList<Student> vratListStudentu()
    {
        return listStudentu;
    }

    public int pocetStudentu()
    {
        return listStudentu.size();
    }

    public Student vratStudenta(int index)
    {
        return listStudentu.get(index);
    }
}
