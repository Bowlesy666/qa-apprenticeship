package genericinterfaces;

import java.util.ArrayList;
import java.util.Collections;

public class Program {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        int[] ages = { 36, 53, 51, 21, 41, 19 };
        String[] names = { "Holland", "Turner", "Powell", "Vicious", "Lyndon", "Spears" };

        if (ages.length == names.length) {
            for (int i = 0; i < ages.length; i++) {
                people.add(new Person(names[i], ages[i]));
            }
            System.out.println("\n\tBoom it done!");
        } else {
            System.out.println("\n\tArrays are a different length.... sort it out!");
        }

        System.out.println("\n*****************************\n");
        System.out.println("normal:");
        displayPeople(people);
        System.out.println("\n*****************************\n");
        System.out.println("age order:");
        Collections.sort(people);
        displayPeople(people);
        System.out.println("\n*****************************\n");
        System.out.println("name order:");
        Collections.sort(people, new PersonNameComparer());
        displayPeople(people);
    }

    public static void displayPeople(ArrayList<Person> people) {
        if (people != null) {
            for (Person person : people) {
                System.out.println("\n\t" + person.name + " is " + person.age + " years old.");
            }
        }
    }
}
