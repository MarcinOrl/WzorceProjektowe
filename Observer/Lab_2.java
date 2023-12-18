package com.mycompany.lab_2;

public class Lab_2 {

    public static void main(String[] args) {
        Sklep sk1 = new Sklep("Pierwszy sklep");
        Sklep sk2 = new Sklep("Drugi sklep");
        Sklep sk3 = new Sklep("Trzeci sklep");
        PaniKolejkowa pk1 = new PaniKolejkowa("Anna", "Kowalska", sk1);
        PaniKolejkowa pk2 = new PaniKolejkowa("Joanna", "Kowalska", sk2);
        PaniKolejkowa pk3 = new PaniKolejkowa("Beata", "Kowalska", sk2);
        sk3.addObserver(pk3);
        sk1.rzuciliTowar("chleb");
        sk2.rzuciliTowar("ser");
        sk3.rzuciliTowar("mleko");
    }
}
