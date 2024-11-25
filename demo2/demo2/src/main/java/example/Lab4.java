package example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab4 {
    private Scanner scanner = new Scanner(System.in);

    public int getInt(String prompt){
        System.out.println(prompt);
        int intInput = scanner.nextInt();
        scanner.nextLine();
        return intInput;
    }

    public void part1() {
        int bagPrice = getInt("\n\nPrice of a bag please?");
        int totalCash = getInt("\nHow much money do you have?");
        
        
        if (bagPrice == 0){
            System.out.println("If bags are free then you dont need to calculate this... just don't be greedy and take too many!");
        } else if (bagPrice < 0) {
            System.out.println("That doesnt look like a correct number, they wont be giving you money to take the bags... would they?");
        } else {
            int numBag = totalCash / bagPrice;
            String formattedText = String.format(
                "If the price is '%d'p and you have '%d'p then you will be able to buy '%d' bags",
                bagPrice,
                totalCash,
                numBag
                );
            if (totalCash <= 0) {
                System.out.println("Come back with your pocket money");
            } else {
                System.out.println(formattedText);
            }
        }
    }
}
