package main;

public class UniEmployee extends Employee {
    private Position position;
    private static int baseSalary = 500000;

    public UniEmployee(String name, int age, String workplace, Position position) {
        super(name, age, workplace, 0);
        this.position = position;
        switch (position) {
            case PROF: setSalary(baseSalary); break;
            case LECTURER: setSalary(baseSalary*50/100); break;
            case ADMIN: setSalary(baseSalary*30/100); break;
        }
    }

    public UniEmployee() { }

    public void setPosition(Position position) {
        this.position = position;
        switch (position) {
            case PROF -> setSalary(baseSalary);
            case LECTURER -> setSalary(baseSalary * 50 / 100);
            case ADMIN -> setSalary(baseSalary * 30 / 100);
        }
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Position getPosition() {
        return position;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    @Override
    public String toString() {
        return "UniEmployee{" +
                "position=" + position +
                "} " + super.toString();
    }

    public enum Position { PROF, LECTURER, ADMIN }
}
