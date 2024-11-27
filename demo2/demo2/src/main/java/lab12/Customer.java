package lab12;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;

public class Customer {
    String CustomerID, CompanyName, ContactName, ContactTitle;
    String Address, City, Region, PostalCode, Country;

    public static void main(String[] args) throws Exception {
        printBanner();

        Gson gson = new Gson(); String fileName = "C:\\Users\\David.Bowles\\OneDrive - canopius.com\\Citrix\\Desktop\\dev\\qaPython\\qaPythonintro\\demo2\\demo2\\src\\customers.json";
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        Customer[] customers = gson.fromJson(content, Customer[].class);
        System.out.println("\t" + customers[0].CustomerID);
        printDashes();

        for (Customer customer : customers) {
            System.out.println("\t" + customer.CustomerID);
        }
        printDashes();
    }

    static void printBanner() {
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
    }

    static void printDashes() {
        String dashes = "\n------------------------------------------------------------------------\n"; 
        
        System.out.println(dashes);
    }
}
