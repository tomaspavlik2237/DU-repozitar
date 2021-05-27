package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ObjednanePolozky
{
    private String jidlo;
    private BigDecimal cena;
    private int mnozstvi;

    public ObjednanePolozky(String jidlo, BigDecimal cena, int mnozstvi) {
        this.jidlo = jidlo;
        this.cena = cena;
        this.mnozstvi = mnozstvi;
    }

    public String getJidlo() {
        return jidlo;
    }

    public void setJidlo(String jidlo) {
        this.jidlo = jidlo;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public int getMnozstvi() {
        return mnozstvi;
    }

    public void setMnozstvi(int mnozstvi) {
        this.mnozstvi = mnozstvi;
    }
}
