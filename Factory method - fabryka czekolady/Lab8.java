package com.mycompany.lab8;

/**
 *
 * @author marti
 */
public class Lab8 {

    public static void main(String[] args) {
        ProducentCzekolady producent = new ProducentCzekolady();
        
        Czekolada mleczna = producent.produkcjaCzekolady("mleczna", "mocno");
        Czekolada gorzka = producent.produkcjaCzekolady("gorzka", "ekstra");
        Czekolada orzech = producent.produkcjaCzekolady("z orzechami", "z bakaliami");
        Czekolada unikalna = producent.produkcjaCzekolady("unikalna", "");
    }
}
