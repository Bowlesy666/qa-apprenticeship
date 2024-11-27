package lab12;

import lab12.StudentInfo;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Student {
    
    public static void main(String[] args) throws Exception {
        printBanner();

        Gson gson = new Gson();
        int[] nos = {1,3,5,7,9};
        String res = gson.toJson(nos);
        System.out.println(res);
        String[] names= {"Bob","Fred","Wilma"};
        res = gson.toJson(names);
        System.out.println(res);
        printDashes();
        StudentInfo[] students = {
            new StudentInfo("Bob",21),
            new StudentInfo("Fred",32), 
            new StudentInfo("Wilma",26)
        };
        res = gson.toJson(students);
        
        System.out.println(res);
        printDashes();
        Files.write(
            Paths.get("C:\\Users\\David.Bowles\\OneDrive - canopius.com\\Citrix\\Desktop\\dev\\qaPython\\qaPythonintro\\student.json"),
            gson.toJson(students[0]).getBytes(),
            StandardOpenOption.CREATE
        );
        System.out.println("\tJson file created with one object");
        printDashes();

        Files.write(
            Paths.get("C:\\Users\\David.Bowles\\OneDrive - canopius.com\\Citrix\\Desktop\\dev\\qaPython\\qaPythonintro\\studentInfo.json"),
            gson.toJson(students).getBytes(),
            StandardOpenOption.CREATE
        );
        System.out.println("\tJson file created with multiple objects");
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

