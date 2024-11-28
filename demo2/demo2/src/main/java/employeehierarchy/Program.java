package employeehierarchy;

import java.util.ArrayList;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        Manager manager = new Manager("Dave-o-", "Manager Supreme");

        manager.addEmployee(new Employee("No one special", "Employee"));
        manager.addEmployee(new Employee("No one mentionable", "Employee"));
        manager.addEmployee(new Employee("No one to talk about", "Employee"));


        manager.addEmployee(new SkilledWorker("Shaun the sheep", "Skilled Baahber", new ArrayList<>(Arrays.asList("Sheering", "Black wool"))));
        manager.addEmployee(new SkilledWorker("Timmy Mallet", "Nutter", new ArrayList<>(Arrays.asList("Carpentry", "getting Hammered"))));
        manager.addEmployee(new SkilledWorker("Peppa Piglet", "Out of inspiration", new ArrayList<>(Arrays.asList("Blahhhdy", "Blah"))));

        System.out.println(manager.getInfo());
    }
}
