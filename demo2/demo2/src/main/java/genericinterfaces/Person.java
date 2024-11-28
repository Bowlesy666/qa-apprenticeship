package genericinterfaces;

public class Person implements Comparable<Person> {
    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person that) {
        return Integer.compare(this.age, that.age);
    }

    @Override
    public String toString() {
        return "\n\tPerson [name=" + name + ", age=" + age + "]";
    }
    
}
