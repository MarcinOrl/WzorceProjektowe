/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6;

/**
 *
 * @author marti
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class BagFullOfMoney implements Observer {
    private final List<MoneyPacket> moneyPackets = new ArrayList<>();
    private double totalValue;

    public void addMoneyPacket(MoneyPacket packet) {
        moneyPackets.add(packet);
        packet.addObserver(this);
        updateTotalValue();
    }

    @Override
    public void update(Observable o, Object arg) {
        updateTotalValue();
    }

    private void updateTotalValue() {
        totalValue = moneyPackets.stream().mapToDouble(MoneyPacket::getValueInBaseCurrency).sum();
    }

    @Override
    public String toString() {
        return "BagFullOfMoney:\n" + moneyPackets +
                "\nTotalValue=" + totalValue +
                '}';
    }
}

