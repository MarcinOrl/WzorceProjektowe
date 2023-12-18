package com.mycompany.lab_1;

public class Lab_1 {

    public static void main(String[] args) {
        Sklep sk = Sklep.getInstance();
        Sklep.getInstance();
        System.out.println(sk);
        sk.kupuj();
        sk.zamknij();
        sk.kupuj();
        sk.remanent();
        sk.kupuj();
    }
}
