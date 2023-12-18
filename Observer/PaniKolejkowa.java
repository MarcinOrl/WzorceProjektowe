package com.mycompany.lab_2;

import java.util.Observable;
import java.util.Observer;

public class PaniKolejkowa implements Observer{
    
    private String imie;
    private String nazwisko;
    
    public PaniKolejkowa(String imie, String nazwisko, Sklep sk){
        this.imie = imie;
        this.nazwisko = nazwisko;
        sk.addObserver(this);
    }
    
    public void kupujIleSieDa(Sklep sklep, String towar){
        System.out.println("Pani %s %s wykupuje %s. Siaty pełne. %s".formatted(imie, nazwisko, sklep, towar));
    }
    
    @Override
    public String toString(){
        return "Imie: %s".formatted(imie);
    }

    @Override
    public void update(Observable o, Object arg) {
        kupujIleSieDa((Sklep)o, (String)arg);
    }
}
