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
        System.out.println(animalMap);
    }
}
