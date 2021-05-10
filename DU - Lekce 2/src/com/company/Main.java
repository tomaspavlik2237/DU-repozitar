package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        // Pro predmet, kde student jeste nemel zkousku napiseme 0
        Student student1 = new Student("Tomas", "Pavlik", "MS4", LocalDate.of(1998, 06, 18), 1,
                2, 1, 1);

        Student student2 = new Student("Daniel", "Skvaril", "MS4", LocalDate.of(1998, 9, 18), 4,
                4, 4, 1);

        Student student3 = new Student("Martin", "Guth", "MS4", LocalDate.of(1999, 10, 03), 1,
                1, 5, 2);

        Student student4 = new Student("Ondra", "Janos", "MS4", LocalDate.of(1999, 11, 06), 0,
                1, 5, 0);

        System.out.println(student1.getJmenoStudenta() + " " + student1.getPrijmeniStudenta() + " " + student1.Prospel());

        System.out.println(student2.getJmenoStudenta() + " " + student2.getPrijmeniStudenta() + " " + student2.Maturoval());

        System.out.println(student3.getJmenoStudenta() + " " + student3.getPrijmeniStudenta() + " " + student3.Prospel());

        System.out.println(student4.getJmenoStudenta() + " " + student4.getPrijmeniStudenta() + " " + student4.Maturoval());

        ArrayList listStudentu = new ArrayList();

        listStudentu.add(student1);
        listStudentu.add(student2);
        listStudentu.add(student3);
        listStudentu.add(student4);


    }
}
