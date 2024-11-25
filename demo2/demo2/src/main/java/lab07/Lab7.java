package lab07;

import java.util.Arrays;

public class Lab7 {

    public void start() {
        int[] numbers = { 1, 3, -5, 7, 0, 4, 6, 8 };
        int[] bigArray ={34, 7, 23, 32, 5, 62, 32, 45, 78, 12, 89, 54, 21, 67, 43, 90, 11, 3, 56, 77, 19, 8, 99, 65, 38, 27, 49, 71, 84, 6, 13, 50, 29, 92, 41, 73, 18, 25, 61, 33, 48, 70, 85, 2, 15, 60, 39, 74, 20, 9};

        sumOfNumberInNumbers(numbers);
        findAverage(numbers);
        findMinOfIntArray(numbers);
        findMaxOfIntArray(numbers);
        findIndexOfIntZero(numbers);
        sort(numbers);
        sort(bigArray);
    }

    public void sort(int[] intArray) {
        boolean hasChanged = true;
        int[] newArray = Arrays.copyOf(intArray, intArray.length);
        while (hasChanged) {
            hasChanged = false;

            for (int i = 0; i < newArray.length - 1; i++) {
                if (newArray[i] > newArray[i + 1]) {
                    int swapMe = newArray[i];
                    newArray[i] = newArray[i + 1];
                    newArray[i + 1] = swapMe;
                    hasChanged = true;
                    System.out.println(java.util.Arrays.toString(newArray));
                }
            }
        }
    }

    public int sumOfNumberInNumbers(int[] numbers) {
        int total = 0;

        for (int number : numbers) {
            total += number;
        }

        System.out.println("\nIm a blank line...");
        System.out.println("\nThe total is " + total);

        return total;
    }

    public void findAverage(int[] numbers) {
        int total = sumOfNumberInNumbers(numbers);
        int avg = total / numbers.length;
        System.out.println("Sum of numbers is: " + avg);
    }

    public void findMinOfIntArray(int[] numbers) {
        int lowestNumber = numbers[0];

        for (int number : numbers) {
            if (number < lowestNumber) {
                lowestNumber = number;
            }
        }

        System.out.println("The lowest number is: " + lowestNumber);
    }

    public void findMaxOfIntArray(int[] numbers) {
        int highestNumber = numbers[0];

        for (int number : numbers) {
            if (number > highestNumber) {
                highestNumber = number;
            }
        }

        System.out.println("The highest number is: " + highestNumber);
    }

    public void findIndexOfIntZero(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                System.out.println("The index of integer zero in this array is [" + i + "]");
            }
        }
    }
}
