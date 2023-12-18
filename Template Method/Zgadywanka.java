package com.mycompany.lab_3;

import java.util.Random;
import java.util.Scanner;

public class Zgadywanka extends Game{
    
    public int lives = 4;
    boolean game_over = false;
    Scanner scan;
    Random rand;
    int number;
    int shot;
    
    @Override
    protected void initialize(){
        System.out.println("Zgadywanka\nTraf liczbę z przedziału 1-30: ");
        this.scan = new Scanner(System.in);
        this.rand = new Random();
        this.number = rand.nextInt(30) + 1;
        // System.out.println(number);
    }
    @Override
    protected boolean gameOver(){
        if(lives <= 0 || game_over){
            return true;
        }
        else return false;
    }
    @Override
    protected void makeMoves(){
        lives--;
        int shot = scan.nextInt();
        if(shot == number){
            game_over = true;
        } else if(shot < number && lives > 0){
            System.out.println("Poszukiwana liczba jest większa.");
        } else if(shot > number && lives > 0){
            System.out.println("Poszukiwana liczba jest mniejsza.");
        }
        if(shot != number && lives == 0){
            game_over = true;
        }
    }
    @Override
    protected void paintScreen(){
        if(!game_over) System.out.println("Pozostała ilość prób: "+ lives);
    }
    @Override
    protected void onEnd(){
        if(shot == number){
            System.out.println("Wygrana!");
        } else {
            System.out.println("Próby wyczerpane. Szukana liczba to " + number);
        }
    }
}
