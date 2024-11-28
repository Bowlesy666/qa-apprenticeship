package employeehierarchy;

import java.util.ArrayList;

import lab04.override;

public class SkilledWorker extends Employee {
    ArrayList<String> skills = new ArrayList<>();

    public SkilledWorker(String name, String jobTitle, ArrayList<String> skills) {
        super(name, jobTitle);
        this.skills = skills;
    }

    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    @override
    public String getInfo() {
        return "\n\t***** *****\n\t" + super.getName() + " | " + super.getJobTitle() + this.getSkills();
    }

    public String getSkills() {
        String skillsText = "\n\n\t" + super.getName() + " skillset:";
        for (String skill : skills) {
            skillsText += "\n\t\t" + skill;
        }
        return skillsText;
    }
}
