package main;

import main.Lab3Excercises;

public class Main {
    public static void main(String[] args) {
        Lab3Excercises myLab3 = new Lab3Excercises();
        myLab3.theLunchQueue();
        myLab3.convertInputToStonesPounds(15);
        myLab3.convertKgsToStonesPounds(15);
        myLab3.closeScanner(); // Close the scanner properly
    }
}