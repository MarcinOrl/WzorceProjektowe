package com.mycompany.lab4;

import java.util.Scanner;

public class Lab4 {

    public static void main(String[] args) {
        Matrix matrix = new Matrix(3, 3);

        Scanner scan = new Scanner(System.in);
        
        while(true){
            System.out.println("Macierz:");
            matrix.printMatrix();
            System.out.println("Wpisz komendę np. s 1 2 10\nOpcje: s - set, r - redo, u - undo, e - exit\nWpisz komendę: ");
            String command = scan.nextLine();
            
            String[] parts = command.split(" ");

            // Przypisz wartości do zmiennych
            if (parts.length >= 4) {
                String option = parts[0];
                try {
                    int row = Integer.parseInt(parts[1]);
                    int col = Integer.parseInt(parts[2]);
                    double val = Double.parseDouble(parts[3]);
                    if (option.equals("s")){
                        matrix.set(row, col, val);
                    } else {
                        System.out.println("Błąd: Niepoprawna opcja.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Błąd: Niepoprawny format liczb.");
                }
            }
            else if(parts.length == 1){
                String option = parts[0];
                if (option.equals("e")){
                    break;
                }
                switch (option){
                    case "u":
                    case "undo":
                        matrix.undo();
                        break;
                    case "r":
                    case "redo":
                        matrix.redo();
                        break;
                    default:
                        System.out.println("Błąd: Niepoprawna opcja.");
                        break;
                }
            }
            else {
                System.out.println("Błąd: Niepoprawny zapis polecenia, spróbuj ponownie.");
            }
        }
    }
}
