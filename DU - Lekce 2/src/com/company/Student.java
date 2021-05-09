package com.company;

import java.time.LocalDate;

public class Student
{
    private String jmenoStudenta, prijmeniStudenta, tridaStudenta;
    private LocalDate narozeniStudenta;
    private int znamkaCestina;
    private int znamkaAnglictina;
    private int znamkaPraxe;
    private int znamkaUstniZkouseni;

    public Student(String jmenoStudenta, String prijmeniStudenta, String tridaStudenta, LocalDate narozeniStudenta, int znamkaCestina,
                   int znamkaAnglictina, int znamkaPraxe, int znamkaUstniZkouseni)
    {
        this.jmenoStudenta = jmenoStudenta;
        this.prijmeniStudenta = prijmeniStudenta;
        this.tridaStudenta = tridaStudenta;
        this.narozeniStudenta = narozeniStudenta;
        this.znamkaCestina = znamkaCestina;
        this.znamkaAnglictina = znamkaAnglictina;
        this.znamkaPraxe = znamkaPraxe;
        this.znamkaUstniZkouseni = znamkaUstniZkouseni;
    }

    public String Prospel()
    {
        if(znamkaCestina > 0 && znamkaCestina < 5 && znamkaAnglictina > 0 && znamkaAnglictina < 5 && znamkaPraxe > 0 && znamkaPraxe < 5 && znamkaUstniZkouseni > 0 && znamkaUstniZkouseni < 5)
        {
            return "uspesne slozil zkousku.";
        }

        else
        {
            return "neslozil zkousku.";
        }
    }

    public String Maturoval()
    {
        if(znamkaCestina == 0 || znamkaAnglictina == 0 || znamkaPraxe == 0 || znamkaUstniZkouseni == 0)
        {
            return "jeste nebyl zkouseny ze vsech predmetu.";
        }

        else
        {
            return "ma zkousky zasebou.";
        }
    }

    public String getJmenoStudenta()
    {
        return jmenoStudenta;
    }

    public void setJmenoStudenta(String jmenoStudenta) {
        this.jmenoStudenta = jmenoStudenta;
    }

    public String getPrijmeniStudenta() {
        return prijmeniStudenta;
    }

    public void setPrijmeniStudenta(String prijmeniStudenta) {
        this.prijmeniStudenta = prijmeniStudenta;
    }

    public String getTridaStudenta() {
        return tridaStudenta;
    }

    public void setTridaStudenta(String tridaStudenta) {
        this.tridaStudenta = tridaStudenta;
    }

    public LocalDate getNarozeniStudenta() {
        return narozeniStudenta;
    }

    public void setNarozeniStudenta(LocalDate narozeniStudenta) {
        this.narozeniStudenta = narozeniStudenta;
    }

    public int getZnamkaCestina() {
        return znamkaCestina;
    }

    public void setZnamkaCestina(int znamkaCestina) {
        this.znamkaCestina = znamkaCestina;
    }

    public int getZnamkaAnglictina() {
        return znamkaAnglictina;
    }

    public void setZnamkaAnglictina(int znamkaAnglictina) {
        this.znamkaAnglictina = znamkaAnglictina;
    }

    public int getZnamkaPraxe() {
        return znamkaPraxe;
    }

    public void setZnamkaPraxe(int znamkaPraxe) {
        this.znamkaPraxe = znamkaPraxe;
    }

    public int getZnamkaUstniZkouseni() {
        return znamkaUstniZkouseni;
    }

    public void setZnamkaUstniZkouseni(int znamkaUstniZkouseni) {
        this.znamkaUstniZkouseni = znamkaUstniZkouseni;
    }
}
