package main;

import java.util.List;

public class EmployeeIterator implements ListIterator<Employee> {
    private final List<Employee> employeeList;
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
        if (index < employeeList.size()) {
            return employeeList.get(index);
        }
        return null;
    }

    @Override
    public boolean hasMoreElement() {
        return index < employeeList.size();
    }

    @Override
    public void resetIterator() {
        index = 0;
    }
}