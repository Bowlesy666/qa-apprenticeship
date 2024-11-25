package lab05;

import java.util.Scanner;

public class Lab5 {
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

    public void grades() {
        int mark = getInt("\nWhat is the students mark?");

        if (mark > 0 && mark < 101) {
            if (mark < 50) {
                System.out.println("Fail");
            } else if (mark <= 60) {
                System.out.println("Pass");
            } else if (mark <= 70) {
                System.out.println("Merit");
            } else {
                System.out.println("Distinction");
            }
        } else {
            System.out.println("Error: marks must be between 1..100");
        }
    }

    public void part2() {
        Boolean summerTime = getString("\nIs it summer time?").toLowerCase() == "yes" ? true : false ;
        Boolean eveningTime = getString("\nIs it the evening?").toLowerCase() == "yes" ? true : false ;

        String shower = "Action: Take a shower\n";
        String eatOut = "Action: Eat outside\n";
        String eatIn = "Action: Eat inside\n";
        String hobby = "Action: Do outdoors hobby\n";
        String walk = "Action: Take a walk\n";
        String friends = "Action: Contact friends\n";

        System.out.println("\nIn that case I suggest...\n");
        if (summerTime && eveningTime) {
            System.out.println(shower + eatOut + hobby + friends);
        } else if (summerTime && !eveningTime) {
            System.out.println(shower + eatIn + hobby + friends);
        } else if (!summerTime && eveningTime) {
            System.out.println(shower + eatIn + walk + friends);
        } else if (!summerTime && !eveningTime) {
            System.out.println(shower + eatIn + friends);
        }
    }
}
