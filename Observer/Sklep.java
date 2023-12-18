package com.mycompany.lab_2;

import java.util.Observable;

public class Sklep extends Observable{
    
    private String nazwa;
    
    public Sklep(String nazwa){
        this.nazwa = nazwa;
    }
    
    public void setNazwa(String nazwa){
        this.nazwa = nazwa;
    }
    
    public String getNazwa(){
        return nazwa;
    }
    
    public void rzuciliTowar(String komunikat){
        System.out.println("Rzucono dostawę mięsa do MDK! Tłumy szaleją.");
        setChanged();
        notifyObservers(komunikat);
    }
    
    @Override
    public String toString(){
        return nazwa;
    }
}



