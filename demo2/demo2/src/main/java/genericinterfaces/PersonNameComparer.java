package genericinterfaces;

import java.util.Comparator;

public class PersonNameComparer implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.name.compareTo(o2.name);
    }
}
