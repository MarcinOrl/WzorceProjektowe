package com.mycompany.lab7;

import static java.lang.Math.round;

/**
 *
 * @author marti
 */
public class Lab7 {

    public static void main(String[] args) {
        Pizza pizza = new ExtraBasil(new ExtraPepper(new ExtraMozarella(new ExtraMushroom(new ExtraHam(new BasePizza(50))))));
        System.out.println(pizza.getDescription() + ", o cenie " + pizza.getCost() + "zł");
        
        Pizza pizza0 = new ExtraHam(new ExtraHam(new BasePizza(50)));
        System.out.println(pizza0.getDescription() + ", o cenie " + pizza0.getCost() + "zł");
        
        Pizza pizza2 = new BasePizza(50);
        System.out.println(pizza2.getDescription() + ", o cenie " + pizza2.getCost() + "zł");

        Pizza pepperoni = new PepperoniPizza(32);
        System.out.println(pepperoni.getDescription() + ", o cenie " + pepperoni.getCost() + "zł");
        
        Pizza capriciosa = new CapriciosaPizza(60);
        System.out.println(capriciosa.getDescription() + ", o cenie " + capriciosa.getCost() + "zł");
    }
}

// Interfejs Pizza
interface Pizza {
    String getDescription();
    double getCost();
    double getSize();
}

// Bazowa pizza
class BasePizza implements Pizza {
    private double size;

    public BasePizza(double size) {
        this.size = size;
    }

    @Override
    public String getDescription() {
        return "Pizza o średnicy " + size + " cm";
    }

    @Override
    public double getCost() {
        double radius = size / 2.0;
        double area = Math.PI * radius * radius;
        return round(area * 0.02);
    }
    
    @Override
    public double getSize() {
        return size;
    }
}

// Abstrakcyjny dekorator
abstract class PizzaDecorator implements Pizza {
    protected Pizza decoratedPizza;

    public PizzaDecorator(Pizza pizza) {
        this.decoratedPizza = pizza;
    }

    public String getDescription() {
        return decoratedPizza.getDescription();
    }

    public double getCost() {
        return decoratedPizza.getCost();
    }
    
    public double getSize() {
        return decoratedPizza.getSize();
    }
}

// Konkretny dekorator: Szynka
class ExtraHam extends PizzaDecorator {
    private double size;
    
    public ExtraHam(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", z szynką";
    }
    
    @Override
    public double getSize(){
        return size = super.getSize();
    }

    @Override
    public double getCost() {
        return super.getCost() + round(super.getSize() / 5);
    }
}

// Konkretny dekorator: Pieczarki
class ExtraMushroom extends PizzaDecorator {
    private double size;
    
    public ExtraMushroom(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", z pieczarkami";
    }
    
    @Override
    public double getSize(){
        return size = super.getSize();
    }

    @Override
    public double getCost() {
        return super.getCost() + round(super.getSize() / 8);
    }
}

// Konkretny dekorator: Mozarella
class ExtraMozarella extends PizzaDecorator {
    private double size;
    
    public ExtraMozarella(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", z mozarellą";
    }
    
    @Override
    public double getSize(){
        return size = super.getSize();
    }

    @Override
    public double getCost() {
        return super.getCost() + round(super.getSize() / 7);
    }
}

// Konkretny dekorator: Papryka
class ExtraPepper extends PizzaDecorator {
    private double size;
    
    public ExtraPepper(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", z papryką";
    }
    
    @Override
    public double getSize(){
        return size = super.getSize();
    }

    @Override
    public double getCost() {
        return super.getCost() + round(super.getSize() / 8);
    }
}

// Konkretny dekorator: Szynka
class ExtraBasil extends PizzaDecorator {
    private double size;
    
    public ExtraBasil(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", z bazylią";
    }
    
    @Override
    public double getSize(){
        return size = super.getSize();
    }

    @Override
    public double getCost() {
        return super.getCost() + round(super.getSize() / 15);
    }
}

// Predefiniowana pizza: Pepperoni
class PepperoniPizza implements Pizza {
    private Pizza pizza;

    public PepperoniPizza(double size) {
        pizza = new BasePizza(size);
        pizza = new ExtraHam(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
    
    @Override
    public double getSize() {
        return pizza.getSize();
    }
}

// Predefiniowana pizza: Capriciosa
class CapriciosaPizza implements Pizza {
    private Pizza pizza;

    public CapriciosaPizza(double size) {
        pizza = new BasePizza(size);
        pizza = new ExtraHam(pizza);
        pizza = new ExtraMushroom(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
    
    @Override
    public double getSize() {
        return pizza.getSize();
    }
}

