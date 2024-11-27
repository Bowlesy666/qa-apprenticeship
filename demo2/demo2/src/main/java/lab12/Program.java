package lab12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) throws Exception {
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
        
        String[] trainerResult = readCSV("C:\\Users\\David.Bowles\\OneDrive - canopius.com\\Citrix\\Desktop\\dev\\qaPython\\qaPythonintro\\demo2\\demo2\\src\\trainer.txt");
        String[] coursesResult = readCSV("C:\\Users\\David.Bowles\\OneDrive - canopius.com\\Citrix\\Desktop\\dev\\qaPython\\qaPythonintro\\demo2\\demo2\\src\\trainer.txt");
        System.out.println(Arrays.toString(trainerResult));
        System.out.println(dashes);
        System.out.println(Arrays.toString(coursesResult));
        System.out.println(dashes);
        String file = "demo2\\demo2\\src\\trainersAndCourses.txt";
        file.createNewFile();
        // System.out.println(Arrays.toString(trainerResult));
        // System.out.println(dashes);
    }

    private static String[] readCSV(String inFile) throws IOException {
        FileReader fileReader = new FileReader(inFile);
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String[] returnSplitLine = bufferedReader.readLine().split(",");
            
            return returnSplitLine;
        }
        catch (IOException ex) {
            String[] blah = {"blah", "blah", "This", ":", "doesnt", "work"};
            return blah;
        }
        
    }
}
