package main;

import java.util.Scanner;

public class Lab3Excercises {
    private Scanner scanner = new Scanner(System.in);

    public int getInt(String prompt){
        System.out.println(prompt);
        int intInput = scanner.nextInt();
        scanner.nextLine();
        return intInput;
    }

    public String getString(String prompt){
        System.out.println(prompt);
        String stringInput = scanner.nextLine();
        return stringInput;
    }

    public void theLunchQueue(){
        String mainCourse = getString("What main dish would you like(Fish, Burgers or veg) ?");
        int requestedPotatoes = getInt("How many roast potatos would you like?");
        int requestedBrussels = getInt("How many Brussel Sprouts would you like?");

        String formattedText = String.format(
            "Hello, your lunch is %s with %d roast potatoes and %d Brussel sprouts.",
            mainCourse,
            requestedPotatoes,
            requestedBrussels
        );
        System.out.println(formattedText);
    }

    public void convertInputToStonesPounds(int pounds){
        if (pounds > 0){
            int stones = pounds / 14;
            int remainingPounds = pounds % 14;
            String formattedText = String.format(
                "Pounds to Stone: %d pounds or %d stone and %d pounds",
                pounds,
                stones,
                remainingPounds
            );
            System.out.println(formattedText);
        } else {
            System.out.println("ERROR: There is no point trying to convert a zero silly....its going to be a zero no matter what!");
        }
    }

    public void convertKgsToStonesPounds(int kg){
        if (kg > 0){
            int pounds = (int)(kg * 2.20462);
            String formattedText = String.format(
                "You have inputted: %d Kgs. this is equal to...",
                kg
            );
            System.out.println(formattedText);
            convertInputToStonesPounds(pounds);
        } else {
            System.out.println("There is no point trying to convert a zero silly....its going to be a zero no matter what!");
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}
