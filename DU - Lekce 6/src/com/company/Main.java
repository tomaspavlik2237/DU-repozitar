package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args)
    {
        PraceSObjednavkami praceSObjednavkami = new PraceSObjednavkami();

        Objednavka objednavka1 = new Objednavka(1, LocalDate.of(2021, 05, 30),
                Platba.KARTA);
        objednavka1.pridejObjednanePolozky(new ObjednanePolozky("Hranolky", new BigDecimal(89.90), 5));
        objednavka1.pridejObjednanePolozky(new ObjednanePolozky("Rajska", new BigDecimal(89.90), 1));


        Objednavka objednavka2 = new Objednavka(2, LocalDate.of(2021, 05, 30),
                Platba.HOTOVOST);
        objednavka2.pridejObjednanePolozky(new ObjednanePolozky("Hamburger", new BigDecimal(99.90), 2));
        objednavka2.pridejObjednanePolozky(new ObjednanePolozky("Hranolky", new BigDecimal(99.90), 3));
        objednavka2.pridejObjednanePolozky(new ObjednanePolozky("Cina", new BigDecimal(99.90), 3));


        praceSObjednavkami.pridejObjednavku(objednavka1);
        praceSObjednavkami.pridejObjednavku(objednavka2);

        System.out.println(Objednavka.getDalsiCisloOBjednavky());

        System.out.println(objednavka1.celkovaCena());

        System.out.println(praceSObjednavkami.celkovyPocetKusuProdanehoJidla());

        System.out.println(praceSObjednavkami.celkovyObrat());

        System.out.println(praceSObjednavkami.vypisPolozek());
    }
}
