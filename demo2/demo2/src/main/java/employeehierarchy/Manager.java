package employeehierarchy;

import java.util.ArrayList;

import lab04.override;

public class Manager extends Employee {
    ArrayList<Employee> employees = new ArrayList<>();

    public Manager(String name, String jobTitle) {
        super(name, jobTitle);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void addEmployee(SkilledWorker skilledWorker) {
        this.employees.add(skilledWorker);
    }

    @override
    public String getInfo() {
        String info = "\n\t**** *****";
        info += super.getInfo();

        for (Employee employee : employees) {
            if (employee instanceof SkilledWorker) {
                SkilledWorker skilledWorker = (SkilledWorker) employee;
                info += skilledWorker.getInfo();
                
            } else {
                info += employee.getInfo();
            }
        }
        return info;
    }

}
