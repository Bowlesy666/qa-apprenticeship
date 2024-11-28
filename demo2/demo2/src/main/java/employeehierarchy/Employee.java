package employeehierarchy;

public class Employee {
    private String name;
    private String jobTitle;
    private int id;
    protected static int idCount;

    public String getName() { return name; }
    private void setName(String name) { this.name = name; }

    public String getJobTitle() { return jobTitle; }
    private void setJobTitle(String jobTitle) { this.jobTitle = jobTitle;}

    private void setId(int id) { this.id = id; }
    public int getId() { return id;}

    public Employee(String name, String jobTitle ) {
        setId(++Employee.idCount * 10);
        setName(name);
        setJobTitle(jobTitle);
    }
    
    public String getInfo() {
        String info = "\n\t**** *****";
        info += "\n\tName: " + getName();
        info += "\n\tJob Title: "+ getJobTitle();
        info += "\n\tEmployee ID: "+ getId()+ "\n";
        return info;
    }
}
