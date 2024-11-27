package lab12;

import java.util.ArrayList;

public class StudentInfo {
    String name;
    int age;
    
    ArrayList<String> subjects = new ArrayList<>();
    public StudentInfo(String name, int age) {
        this.name = name; this.age = age;
        subjects.add("Java");
        subjects.add("C#");
        subjects.add("Network");
    }
}
