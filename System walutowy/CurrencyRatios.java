/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6;

/**
 *
 * @author marti
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class CurrencyRatios extends Observable {
    private static CurrencyRatios instance;
    private final Map<Currency, ExchangeRatio> ratios;
    private Currency baseCurrency;

    private CurrencyRatios() {
        ratios = new HashMap<>();
        baseCurrency = Currency.EUR; // Domyślna waluta
    }

    public static CurrencyRatios getInstance() {
        if (instance == null) {
            instance = new CurrencyRatios();
        }
        return instance;
    }

    public void addExchangeRatio(Currency currency, double ratio) {
        ratios.put(currency, new ExchangeRatio(currency, ratio));
    }

    public ExchangeRatio getExchangeRatio(Currency currency) {
        return ratios.get(currency);
    }

    public void updateExchangeRatio(Currency currency, double newRatio) {
        if (ratios.containsKey(currency)) {
            ratios.get(currency).setRatio(newRatio);
        }
    }

    public void changeBaseCurrency(Currency newBaseCurrency) {
        baseCurrency = newBaseCurrency;
        setChanged();
        notifyObservers();
    }

    public Currency getBaseCurrency() {
        return baseCurrency;
    }
}

