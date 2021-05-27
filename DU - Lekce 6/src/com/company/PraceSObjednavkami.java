package com.company;

import java.math.BigDecimal;
import java.util.*;

public class PraceSObjednavkami
{
    private ArrayList<Objednavka> objednavkaList = new ArrayList<>();

    public void pridejObjednavku(Objednavka objednavka)
    {
        objednavkaList.add(objednavka);
    }

    public HashMap<String, Integer> celkovyPocetKusuProdanehoJidla()
    {
        HashMap<String, Integer> prodaneKusy = new HashMap<>();

        for(Objednavka objednavka : objednavkaList)
        {
            for(ObjednanePolozky objednanePolozky : objednavka.getPolozky())
            {
                String jidlo = objednanePolozky.getJidlo();
                int pocetKusu = 0;
                if(prodaneKusy.containsKey(jidlo))
                {
                    pocetKusu = prodaneKusy.get(jidlo);
                }

                prodaneKusy.put(jidlo, pocetKusu + objednanePolozky.getMnozstvi());
            }
        }
        return prodaneKusy;
    }

    public BigDecimal celkovyObrat()
    {
        BigDecimal obrat = BigDecimal.valueOf(0);

        for(Objednavka objednavka : objednavkaList)
        {
            obrat = obrat.add(objednavka.celkovaCena());
        }
        return obrat;
    }

    public ArrayList<String> vypisPolozek()
    {
        HashSet<String> jidlaHashSet = new HashSet<>();

        for(Objednavka objednavka : objednavkaList)
        {
            for(ObjednanePolozky objednanePolozky : objednavka.getPolozky())
            {
                String jidlo = objednanePolozky.getJidlo();
                jidlaHashSet.add(jidlo);
            }
        }
        ArrayList<String> listObjednavek = new ArrayList<>(jidlaHashSet);
        Collections.sort(listObjednavek);

        return listObjednavek;
    }
}
