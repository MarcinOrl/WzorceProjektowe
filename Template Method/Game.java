package com.mycompany.lab_3;

abstract class Game {
    public final void run(){
        initialize();
        while(!gameOver()){
            makeMoves();
            paintScreen();
        }
        onEnd();
    }
    abstract void initialize();
    
    abstract void makeMoves();

    abstract void paintScreen();
    
    abstract void onEnd();
    
    abstract boolean gameOver();
}
