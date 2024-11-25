package lab06;

import java.util.Scanner;

public class Lab6 {
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

    public void part1() {
        grades();
    }

    public void grades() {
        String[] names = new String[5];
        int[] marks = new int[5];

        for (int i = 0; i <= 4; i++) {
            names[i] = getString("what is the students name? ");
            marks[i] = getInt("what is the students mark? ");
        }

        for (int i = 0; i <= 4; i++) {
            String studentGrading;
            if (marks[i] > 0 && marks[i] < 101) {
                if (marks[i] < 50) {
                    studentGrading = "Fail";
                } else if (marks[i] <= 60) {
                    studentGrading = "Pass";
                } else if (marks[i] <= 70) {
                    studentGrading = "Merit";
                } else {
                    studentGrading = "Distinction";
                }
            } else {
                studentGrading = "Error: marks must be between 1..100";
            }
            String formattedText = String.format(
                "Student %s with %d marks has received the %s",
                names[i],
                marks[i],
                studentGrading
            );
            System.out.println(formattedText);
        }

    }

    public void account() {
        double initialInvestment = getInt("What is your initial investment?");
        double currentMoney = initialInvestment;
        double interestRate = 0.05;
        int yearsToDouble = 0;

        while (currentMoney < (initialInvestment * 2)) {
            currentMoney += currentMoney * interestRate;
            yearsToDouble++;
            System.out.println(currentMoney);
        }

        System.out.println("It takes " + yearsToDouble + " years to double the investment of £" + initialInvestment);
    }

    public void multiplicationTable() {
        System.out.println("\nYo, here is a multiplication matrix table:\n");
        for (int row = 1; row <= 12; row++) {
            for (int column = 1; column <= 12; column++) {
                System.out.printf("%5d", row * column);
            }
            System.out.println();
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}
