package com.company;

import java.time.LocalDate;

public class Student extends Osoba
{
    private String cisloStudenta;
    private LocalDate datumNarozeniStudenta;

    public Student(String jmeno, String prijmeni, LocalDate datumNarozeniStudenta, String cisloStudenta)
    {
        super(jmeno, prijmeni);
        this.datumNarozeniStudenta = datumNarozeniStudenta;
        this.cisloStudenta = cisloStudenta;
    }

    public LocalDate getDatumNarozeniStudenta() {
        return datumNarozeniStudenta;
    }

    public void setDatumNarozeniStudenta(LocalDate datumNarozeniStudenta) {
        this.datumNarozeniStudenta = datumNarozeniStudenta;
    }

    public String getCisloStudenta() {
        return cisloStudenta;
    }

    public void setCisloStudenta(String cisloStudenta) {
        this.cisloStudenta = cisloStudenta;
    }

//    @Override
//    public String getJmeno()
//    {
//        return ">Student>" + super.getJmeno();
//    }

    @Override
    public String toString()
    {
        return cisloStudenta + " - " + getJmeno() + getPrijmeni() + "(" + datumNarozeniStudenta.getYear() + ")";
    }
}
