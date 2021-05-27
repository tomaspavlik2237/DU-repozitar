package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Objednavka
{
    private static int dalsiCisloOBjednavky = 0;

    private int cisloObjednavky;
    private int cisloStolu;
    private LocalDate datumObjednavky;
    private Platba typPlatby;
    private ArrayList<ObjednanePolozky> polozky = new ArrayList<>();

    public Objednavka(int cisloStolu, LocalDate datumObjednavky, Platba typPlatby) {
        this.cisloObjednavky = dalsiCisloOBjednavky;
        this.cisloStolu = cisloStolu;
        this.datumObjednavky = datumObjednavky;
        this.typPlatby = typPlatby;
        dalsiCisloOBjednavky++;
    }

    public static String getDalsiCisloOBjednavky() {
        return "Pocet objednavek: " + dalsiCisloOBjednavky;
    }

    public BigDecimal celkovaCena()
    {
        BigDecimal cena = BigDecimal.valueOf(0);

        for (ObjednanePolozky objednanePolozky : polozky)
        {
            BigDecimal vypocetCeny = objednanePolozky.getCena().multiply(BigDecimal.valueOf(objednanePolozky.getMnozstvi()));
            cena = cena.add(vypocetCeny);
        }
        return cena;
    }

    public void pridejObjednanePolozky(ObjednanePolozky objednanePolozky)
    {
        polozky.add(objednanePolozky);
    }

    public ArrayList<ObjednanePolozky> getPolozky() {
        return polozky;
    }

    public int getCisloObjednavky() {
        return cisloObjednavky;
    }

    public void setCisloObjednavky(int cisloObjednavky) {
        this.cisloObjednavky = cisloObjednavky;
    }

    public int getCisloStolu() {
        return cisloStolu;
    }

    public void setCisloStolu(int cisloStolu) {
        this.cisloStolu = cisloStolu;
    }

    public LocalDate getDatumObjednavky() {
        return datumObjednavky;
    }

    public void setDatumObjednavky(LocalDate datumObjednavky) {
        this.datumObjednavky = datumObjednavky;
    }

    public Platba getTypPlatby() {
        return typPlatby;
    }

    public void setTypPlatby(Platba typPlatby) {
        this.typPlatby = typPlatby;
    }

}
