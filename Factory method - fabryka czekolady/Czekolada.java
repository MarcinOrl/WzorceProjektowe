package com.mycompany.lab8;

/**
 *
 * @author marti
 */
abstract class Czekolada {
    protected String about;

    abstract void dawajCzekolade();
    protected abstract void dodajKakao();
}

class Mleczna extends Czekolada {
    
    Mleczna(String extra) {
        if (extra.equals("mocno")) {
            this.about = "Mocno mleczna czekolada ze składnikami: ";
        } else {
            this.about = "Mleczna czekolada ze składnikami: ";
        }
        dodajKakao();
        dodajCukier();
        dodajMleko();
        dawajCzekolade();
    }
    
    void dawajCzekolade() {
        System.out.println(about);
    }
    
    protected void dodajKakao() {
        this.about += "kakao";
    }
    
    void dodajCukier() {
        this.about += ", cukier";
    }
    
    void dodajMleko() {
        this.about += ", mleko";
    }
}

class Gorzka extends Czekolada {
    
    Gorzka(String extra) {
        if (extra.equals("ekstra")) {
            this.about = "Ekstra gorzka czekolada ze składnikami: ";
        } else {
            this.about = "Gorzka czekolada ze składnikami: ";
        }
        dodajKakao();
        dodajEkstraktWaniliowy();
        dawajCzekolade();
    }
    
    void dawajCzekolade() {
        System.out.println(about);
    }
    
    protected void dodajKakao() {
        this.about += "kakao";
    }
    
    void dodajEkstraktWaniliowy() {
        this.about += ", ekstrakt waniliowy";
    }
}

class ZOrzechami extends Czekolada {
    
    ZOrzechami(String extra) {
        this.about = "Czekolada z orzechami";
        if (extra.equals("z bakaliami")) {
            this.about += " i bakaliami";
        }
        this.about += " ze skladnikami: ";
        dodajKakao();
        dodajCukier();
        dodajOrzechy();
        dodajBakalie();
        dawajCzekolade();
    }
    
    void dawajCzekolade() {
        System.out.println(about);
    }
    
    protected void dodajKakao() {
        this.about += "kakao";
    }
    
    void dodajCukier() {
        this.about += ", cukier";
    }
    
    void dodajOrzechy() {
        this.about += ", orzechy";
    }
    
    void dodajBakalie() {
        this.about += ", bakalie";
    }
}

class UnikalnaCzekolada extends Czekolada {
    
    UnikalnaCzekolada() {
        this.about = "Unikalna czekolada ze składnikami: ";
        dodajKakao();
        dodajTruskawki();
        dawajCzekolade();
        // Dodawanie róznych składników
    }
    
    void dawajCzekolade() {
        System.out.println(about);
    }
    
    protected void dodajKakao() {
        this.about += "kakao";
    }
    
    void dodajTruskawki() {
        this.about += ", truskawki";
    }
}

class ProducentCzekolady {
    
    Czekolada produkcjaCzekolady(String type, String extra) {
        switch (type) {
            case "mleczna":
                return new Mleczna(extra);
            case "gorzka":
                return new Gorzka(extra);
            case "z orzechami":
                return new ZOrzechami(extra);
            case "unikalna":
                return new UnikalnaCzekolada();
            default:
                throw new IllegalArgumentException("Nieznany rodzaj czekolady: " + type);
        }
    }
}

