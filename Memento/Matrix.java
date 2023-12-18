package com.mycompany.lab4;

import java.util.ArrayList;

interface Memento {}

class Matrix {
    private double[][] matrix;
    private Magazyn magazyn;

    public Matrix(int rows, int cols) {
        matrix = new double[rows][cols];
        initializeMatrix();
        magazyn = new Magazyn();
    }

    private void initializeMatrix() {
        int value = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = value++;
            }
        }
    }

    public void printMatrix() {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public Memento set(int row, int col, double value) {
        if (isValidIndex(row, col)) {
            Memento mem = new MatrixMemento(row, col, matrix[row][col], value);
            matrix[row][col] = value;
            magazyn.zapisz((MatrixMemento) mem);
            return mem;
        }
        else {
            System.out.println("Błąd: Niepoprawny indeks macierzy.");
            return null;
        }
    }

    public void undo() {
        MatrixMemento mem = (MatrixMemento) magazyn.odczytaj();
        if (mem != null) {
            matrix[mem.getRow()][mem.getCol()] = mem.getValFrom();
        } else {
        System.out.println("Nie można wykonać undo, brak poprzednich operacji.");
        }
    }

    public void redo() {
        MatrixMemento mem = (MatrixMemento) magazyn.pobierzDoPrzodu();
        if (mem != null) {
            matrix[mem.getRow()][mem.getCol()] = mem.getValTo();
        } else {
        System.out.println("Nie można wykonać redo, brak kolejnych operacji.");
        }
    }
    
    private boolean isValidIndex(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    class MatrixMemento implements Memento {
        private int row, col;
        private double valFrom, valTo;

        public MatrixMemento(int row, int col, double valFrom, double valTo) {
            this.row = row;
            this.col = col;
            this.valFrom = valFrom;
            this.valTo = valTo;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public double getValFrom() {
            return valFrom;
        }

        public double getValTo() {
            return valTo;
        }
    }
}

class Magazyn {
    private ArrayList<Memento> zmiany;
    private int wskaznikAktualnejZmiany;

    public Magazyn() {
        zmiany = new ArrayList<>();
        wskaznikAktualnejZmiany = -1;
    }

    public void zapisz(Matrix.MatrixMemento mm) {
        // Usunięcie zmian po undo i dodanie nowej zmiany
        if (wskaznikAktualnejZmiany < zmiany.size() - 1) {
            zmiany.subList(wskaznikAktualnejZmiany + 1, zmiany.size()).clear();
        }
        zmiany.add(mm);
        wskaznikAktualnejZmiany++;
    }

    public Memento odczytaj() {
        if (wskaznikAktualnejZmiany >= 0) {
            return zmiany.get(wskaznikAktualnejZmiany--);
        }
        return null;
    }

    public Memento pobierzDoPrzodu() {
        if (wskaznikAktualnejZmiany < zmiany.size() - 1) {
            return zmiany.get(++wskaznikAktualnejZmiany);
        }
        return null;
    }
}


