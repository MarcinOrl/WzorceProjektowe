package com.mycompany.lab_1;

public class Sklep {
    private static Sklep instance = new Sklep();
    private Sklep() {
        System.out.println("Utworzono sklep.");
    }
    public String nazwa = "Nazwa Sklepu";
    private StanSklepu stan = new StanOtwarty();
    public static Sklep getInstance() {
        return instance;
    }
    @Override
    public String toString(){
        return "Name: %s".formatted(nazwa);
    }
    public void kupuj(){
        stan.kupuj();
    }
    public void zamknij(){
        stan = new StanZamkniety();
    }
    public void remanent(){
        stan = new StanRemanent();
    }
    
}

interface StanSklepu{
    public void kupuj();
}

class StanOtwarty implements StanSklepu {
    public void kupuj(){
        System.out.println("Można kupować. Sklep otwarty.");
    }
}

class StanZamkniety implements StanSklepu {
    public void kupuj(){
        System.out.println("Nie można kupić. Sklep zamknięty.");
    }
}

class StanRemanent implements StanSklepu {
    public void kupuj(){
        System.out.println("Nie można kupić. Trwa remanent.");
    }
}
