/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6;

/**
 *
 * @author marti
 */
import java.util.Observable;
import java.util.Observer;

public class MoneyPacket extends Observable implements Observer {
    private final Currency currency;
    private double amount;
    private double valueInBaseCurrency;
    private Currency baseCurrency;

    public MoneyPacket(Currency currency, double amount) {
        this.currency = currency;
        this.amount = amount;
        updateValue();

        CurrencyRatios.getInstance().addObserver(this);
        CurrencyRatios.getInstance().getExchangeRatio(currency).addObserver(this);
    }

    private void updateValue() {
        ExchangeRatio ratio = CurrencyRatios.getInstance().getExchangeRatio(currency);
        if (ratio != null) {
            double oldValue = this.valueInBaseCurrency;
            this.valueInBaseCurrency = amount * ratio.getRatio();
            if (oldValue != this.valueInBaseCurrency) {
                setChanged();
                notifyObservers();
            }
        }
    }
    
    private void updateValueInBaseCurrency() {
        baseCurrency = CurrencyRatios.getInstance().getBaseCurrency();
        ExchangeRatio ratio = CurrencyRatios.getInstance().getExchangeRatio(baseCurrency);
        ExchangeRatio localRatio = CurrencyRatios.getInstance().getExchangeRatio(currency);
        if (ratio != null) {
            double oldValue = this.valueInBaseCurrency;
            this.valueInBaseCurrency = amount * (localRatio.getRatio() / ratio.getRatio());
            if (oldValue != this.valueInBaseCurrency) {
                setChanged();
                notifyObservers();
            }
        }
    }

    public double getValueInBaseCurrency() {
        return valueInBaseCurrency;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof ExchangeRatio) {
            updateValue();
        } else {
            updateValueInBaseCurrency();
        }
    }

    @Override
    public String toString() {
        return "MoneyPacket{" +
                "currency=" + currency +
                ", amount=" + amount +
                ", valueInBaseCurrency=" + valueInBaseCurrency +
                "}";
    }
}


