package main;

public class Employee extends Person {
    private String workplace;
    private int salary;

    public Employee(String name, int age, String workplace, int salary) {
        super(name, age);
        this.workplace = workplace;
        this.salary = salary;
    }

    public Employee() {  }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "workplace='" + workplace + '\'' +
                ", salary=" + salary +
                "} " + super.toString();
    }
}
