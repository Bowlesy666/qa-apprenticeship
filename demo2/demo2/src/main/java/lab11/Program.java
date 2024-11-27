package lab11;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Program {
    public static Queue<ShoppingBasket> baskets = new LinkedList<>();

    public static void main(String[] args) {
        String banner = """
        
 ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄               ▄  ▄▄▄▄▄▄▄▄▄▄▄                     
▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌             ▐░▌▐░░░░░░░░░░░▌                    
 ▀▀▀▀▀█░█▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌ ▐░▌           ▐░▌ ▐░█▀▀▀▀▀▀▀█░▌                    
      ▐░▌    ▐░▌       ▐░▌  ▐░▌         ▐░▌  ▐░▌       ▐░▌                    
      ▐░▌    ▐░█▄▄▄▄▄▄▄█░▌   ▐░▌       ▐░▌   ▐░█▄▄▄▄▄▄▄█░▌                    
      ▐░▌    ▐░░░░░░░░░░░▌    ▐░▌     ▐░▌    ▐░░░░░░░░░░░▌                    
      ▐░▌    ▐░█▀▀▀▀▀▀▀█░▌     ▐░▌   ▐░▌     ▐░█▀▀▀▀▀▀▀█░▌                    
      ▐░▌    ▐░▌       ▐░▌      ▐░▌ ▐░▌      ▐░▌       ▐░▌                    
 ▄▄▄▄▄█░▌    ▐░▌       ▐░▌       ▐░▐░▌       ▐░▌       ▐░▌                    
▐░░░░░░░▌    ▐░▌       ▐░▌        ▐░▌        ▐░▌       ▐░▌                    
 ▀▀▀▀▀▀▀      ▀         ▀          ▀          ▀         ▀                     
                                                                              
 ▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄  ▄               ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄         
▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌▐░▌             ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░▌        
▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌ ▐░▌           ▐░▌  ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌       
▐░▌       ▐░▌▐░▌       ▐░▌  ▐░▌         ▐░▌       ▐░▌     ▐░▌       ▐░▌       
▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄█░▌   ▐░▌       ▐░▌        ▐░▌     ▐░▌       ▐░▌       
▐░▌       ▐░▌▐░░░░░░░░░░░▌    ▐░▌     ▐░▌         ▐░▌     ▐░▌       ▐░▌       
▐░▌       ▐░▌▐░█▀▀▀▀▀▀▀█░▌     ▐░▌   ▐░▌          ▐░▌     ▐░▌       ▐░▌       
▐░▌       ▐░▌▐░▌       ▐░▌      ▐░▌ ▐░▌           ▐░▌     ▐░▌       ▐░▌       
▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌       ▐░▐░▌        ▄▄▄▄█░█▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌       
▐░░░░░░░░░░▌ ▐░▌       ▐░▌        ▐░▌        ▐░░░░░░░░░░░▌▐░░░░░░░░░░▌        
 ▀▀▀▀▀▀▀▀▀▀   ▀         ▀          ▀          ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀         
                                                                              
 ▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄  ▄         ▄  ▄            ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄ 
▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░▌          ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░▌       ▐░▌▐░▌          ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ 
▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░▌          ▐░▌          ▐░▌          
▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌▐░▌   ▄   ▐░▌▐░▌          ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄ 
▐░░░░░░░░░░▌ ▐░▌       ▐░▌▐░▌  ▐░▌  ▐░▌▐░▌          ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
▐░█▀▀▀▀▀▀▀█░▌▐░▌       ▐░▌▐░▌ ▐░▌░▌ ▐░▌▐░▌          ▐░█▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀█░▌
▐░▌       ▐░▌▐░▌       ▐░▌▐░▌▐░▌ ▐░▌▐░▌▐░▌          ▐░▌                    ▐░▌
▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌▐░▌░▌   ▐░▐░▌▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄█░▌
▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌▐░░▌     ▐░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
 ▀▀▀▀▀▀▀▀▀▀   ▀▀▀▀▀▀▀▀▀▀▀  ▀▀       ▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀ 
                """;
        String dashes = "\n------------------------------------------------------------------------\n"; 
        
        System.out.println(dashes);
        System.out.println(banner);
        System.out.println(dashes);
        buy();
        processBaskets();
        System.out.println(dashes);
        
        String[] originalAnimals = {"Zebra", "Lion", "Buffalo"};
        String[] newAnimals = {"Zebra", "Gazelle", "Buffalo", "Zebra"};
        
        Zoo zoo = new Zoo();
        
        zoo.addAnimals(originalAnimals);
        zoo.addAnimals(newAnimals);
        zoo.displayAnimalData();
        System.out.println(dashes);
    }

    public static void buy() {
        baskets.add(new ShoppingBasket("basket1", 21, 12.12));
        baskets.add(new ShoppingBasket("basket2", 28, 44.21));
        baskets.add(new ShoppingBasket("basket3", 28, 44.21));
        baskets.add(new ShoppingBasket("basket4", 28, 44.21));
        baskets.add(new ShoppingBasket("basket5", 28, 44.21));
    }

    public static void processBaskets() {
        while (!baskets.isEmpty()) {
            ShoppingBasket currentBasket = baskets.remove();
            currentBasket.displayDetails();
        }
    }
}
