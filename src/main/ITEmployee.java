package main;

public class ITEmployee extends Employee {

    private Position position;
    private String project;
    private static int baseSalary = 1500000;
    public enum Position { INTERN, JUNIOR, MEDIOR, SENIOR, MANAGER }
    public ITEmployee(String name, int age, String workplace, Position position, String project) {
        super(name, age, workplace, 0);
        this.project = project;
        this.position = position;
        switch (position) {
            case INTERN: setSalary(baseSalary*25/100); break;
            case JUNIOR: setSalary(baseSalary*50/100); break;
            case MEDIOR: setSalary(baseSalary*70/100); break;
            case SENIOR: setSalary(baseSalary); break;
            case MANAGER: setSalary(baseSalary*2); break;
        }
    }

    public ITEmployee() { }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
        switch (position) {
            case INTERN -> setSalary(baseSalary * 25 / 100);
            case JUNIOR -> setSalary(baseSalary * 50 / 100);
            case MEDIOR -> setSalary(baseSalary * 70 / 100);
            case SENIOR -> setSalary(baseSalary);
            case MANAGER -> setSalary(baseSalary * 2);
        }
    }

    @Override
    public String toString() {
        return "ITEmployee{" +
                "position=" + position +
                ", project='" + project + '\'' +
                "} " + super.toString();
    }
}
