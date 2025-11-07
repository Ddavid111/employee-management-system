package main;

public class EmployeeAggregator {
    
    public static double calculateAverageAge(ListIterator<Employee> iterator) {
        int totalAge = 0;
        int count = 0;

        iterator.resetIterator();

        while (iterator.hasMoreElement()) {
            Employee emp = iterator.getNextElement();
            totalAge += emp.getAge();
            count++;
        }

        iterator.resetIterator();
        return count == 0 ? 0 : (double) totalAge / count;
    }

}
