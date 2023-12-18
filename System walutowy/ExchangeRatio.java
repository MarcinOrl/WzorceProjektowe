package com.mycompany.lab6;

/**
 *
 * @author marti
 */
import java.util.Observable;

public class ExchangeRatio extends Observable {
    private final Currency currency;
    private double ratio;

    public ExchangeRatio(Currency currency, double ratio) {
        this.currency = currency;
        this.ratio = ratio;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
        setChanged();
        notifyObservers();
    }
}

