package lab11;

import java.util.HashMap;

public class Zoo {
    HashMap<String, Integer> animalMap = new HashMap<>();

    public void addAnimals(String[] animals) {
        for (String animal : animals) {
            if (animalMap.containsKey(animal)) {
                animalMap.put(animal, (animalMap.get(animal) + 1));
            } else {
                animalMap.put(animal, 1);
            }
        }
    }

    public void displayAnimalData() {
        System.out.println("\n\tWhat up with my zoo!\n");
        for (HashMap.Entry<String, Integer> entry: animalMap.entrySet()) {
            System.out.println("\t" + entry.getKey() + "\t\t" + entry.getValue());
        }
        System.out.println("\n\tSeeya!\n");
    }
}
