package main;

import java.util.List;

public class EmployeeIterator implements ListIterator<Employee> {
    private List<Employee> employeeList;
    private int index;

    public EmployeeIterator(List<Employee> employeeList) {
        this.employeeList = employeeList;
        this.index = 0;
    }

    @Override
    public Employee getNextElement() {
            return employeeList.get(index++);
    }

    @Override
    public Employee getCurrentElement() {
        return employeeList.get(index);
    }

    @Override
    public boolean hasMoreElement() {
        if(this.index < employeeList.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void resetIterator() {
        this.index = 0;
    }


    public double calculateAverageAge() {
        if (employeeList.isEmpty()) {
            return 0;
        }

        int totalAge = 0;
        int count = 0;

        resetIterator();

        while (hasMoreElement()) {
            Employee emp = getNextElement();
            totalAge += emp.getAge();
            count++;
        }

        resetIterator();
        return (double) totalAge / count;
    }
}
