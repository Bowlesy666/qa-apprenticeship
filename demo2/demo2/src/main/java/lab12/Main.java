package lab12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) throws IOException{

        System.out.println(new File("\\demo2\\demo2\\src\\example.txt").getAbsolutePath());

        FileReader fileReader = new FileReader("C:\\Users\\David.Bowles\\OneDrive - canopius.com\\Citrix\\Desktop\\dev\\qaPython\\qaPythonintro\\demo2\\demo2\\src\\example.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;

        while ((line = bufferedReader.readLine()) != null){
         System.out.println(line);
        }

        bufferedReader.close();

        // write to a file

        FileWriter fileWriter = new FileWriter("C:\\Users\\David.Bowles\\OneDrive - canopius.com\\Citrix\\Desktop\\dev\\qaPython\\qaPythonintro\\demo2\\demo2\\src\\output.txt");

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("this is a new line");
        bufferedWriter.newLine();
        bufferedWriter.write("hello!");

        bufferedWriter.close();

        // reading 
        Path filePath = Paths.get("C:\\Users\\David.Bowles\\OneDrive - canopius.com\\Citrix\\Desktop\\dev\\qaPython\\qaPythonintro\\demo2\\demo2\\src\\example.txt");

        for (String line1 : Files.readAllLines(filePath)){
         System.out.println(line1);
        }

        // writing
        Files.write(Paths.get("C:\\Users\\David.Bowles\\OneDrive - canopius.com\\Citrix\\Desktop\\dev\\qaPython\\qaPythonintro\\demo2\\demo2\\src\\example.txt"), "hello again!".getBytes());

     Person person = new Person("Chris", 30);

     Gson gson = new Gson();

     String json = gson.toJson(person);

     Files.write(Paths.get("data.json"), json.getBytes());

 }
}

class Person{
 private String name;
 private int age;

 Person(String name, int age){
     this.name = name;
     this.age = age;
 }
}
