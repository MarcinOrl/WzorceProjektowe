package com.mycompany.lab6;

/**
 *
 * @author marti
 */
public class Lab6 {

    public static void main(String[] args) {
        CurrencyRatios ratios = CurrencyRatios.getInstance();
        ratios.changeBaseCurrency(Currency.PLN);
        ratios.addExchangeRatio(Currency.USD, 4);
        ratios.addExchangeRatio(Currency.PLN, 1);
        ratios.addExchangeRatio(Currency.GBP, 5);
        ratios.addExchangeRatio(Currency.EUR, 4.5);

        MoneyPacket packet1 = new MoneyPacket(Currency.USD, 100);
        MoneyPacket packet2 = new MoneyPacket(Currency.PLN, 200);
        MoneyPacket packet3 = new MoneyPacket(Currency.GBP, 50);
        MoneyPacket packet4 = new MoneyPacket(Currency.EUR, 150);


        BagFullOfMoney bag = new BagFullOfMoney();
        bag.addMoneyPacket(packet1);
        bag.addMoneyPacket(packet2);
        bag.addMoneyPacket(packet3);
        bag.addMoneyPacket(packet4);


        System.out.println("Stan początkowy:");
        System.out.println(bag);

        System.out.println("\nPo zmianie kursu USD:");
        ratios.updateExchangeRatio(Currency.USD, 4.2);
        System.out.println(bag);

        System.out.println("\nPo zmianie wspólnej waluty na GBP:");
        ratios.changeBaseCurrency(Currency.GBP);
        System.out.println(bag);
        
        System.out.println("\nPo zmianie wspólnej waluty na EUR:");
        ratios.changeBaseCurrency(Currency.EUR);
        System.out.println(bag);
    }
}
