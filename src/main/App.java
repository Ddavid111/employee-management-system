package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static List<Employee> uniEmployeeList = new ArrayList<>();
    static List<Employee> itEmployeeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        EmployeeFactoryImpl employeeFactory = new EmployeeFactoryImpl();
        init();

        FileService<Employee> employeeFileService = new FileServiceProxy(new EmployeeFileService());
        List<Employee> employeeList = employeeFileService.readFromFile("uniemployees.txt");
        System.out.println("University employees: " + employeeList);
        List<Employee> employeeList1 = employeeFileService.readFromFile("itemployees.txt");
        System.out.println("IT employees: " + employeeList1);

        employeeFileService.writeToFile("uniemployees.txt", uniEmployeeList);
        employeeFileService.writeToFile("itemployees.txt", itEmployeeList);

        EmployeeIterator employeeIterator = new EmployeeIterator(itEmployeeList);
        System.out.println("Current element: " + employeeIterator.getCurrentElement());
        System.out.println("Next element: " + employeeIterator.getNextElement());
        System.out.println("Current element: " + employeeIterator.getCurrentElement());
        System.out.println("Has more elements? " + employeeIterator.hasMoreElement());

        employeeIterator.resetIterator();
        System.out.println("Current element after reset: " + employeeIterator.getCurrentElement());

        while (employeeIterator.hasMoreElement()) {
            System.out.println(employeeIterator.getNextElement());
        }

        double avgITAge = employeeIterator.calculateAverageAge();
        System.out.println("Average age of IT employees: " + avgITAge);

        System.out.println("\n");
        EmployeeIterator employeeIterator1 = new EmployeeIterator(uniEmployeeList);
        System.out.println("Current element: " + employeeIterator1.getCurrentElement());
        System.out.println("Next element: " + employeeIterator1.getNextElement());
        System.out.println("Current element: " + employeeIterator1.getCurrentElement());
        System.out.println("Has more elements? " + employeeIterator1.hasMoreElement());

        employeeIterator1.resetIterator();

        while (employeeIterator1.hasMoreElement()) {
            System.out.println(employeeIterator1.getNextElement());
        }

        System.out.println("\n");

        double avgUniAge = employeeIterator1.calculateAverageAge();
        System.out.println("Average age of university employees: " + avgUniAge);

        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            System.out.println("Employee workplace:");
            String workplace = scanner.nextLine();
            Employee employee = employeeFactory.createEmployee(workplace);
            employee.setWorkplace(workplace);

            System.out.println("Employee name:");
            String name = scanner.nextLine();
            employee.setName(name);

            System.out.println("Employee age:");
            String age = scanner.nextLine();
            employee.setAge(Integer.parseInt(age));

            System.out.println("Employee position:");
            String positionTemp = scanner.nextLine();

            if (employee instanceof ITEmployee) {
                ITEmployee.Position itPosition = ITEmployee.Position.valueOf(positionTemp.toUpperCase());
                System.out.println("IT employee project:");
                String project = scanner.nextLine();
                ((ITEmployee) employee).setPosition(itPosition);
                ((ITEmployee) employee).setProject(project);

            } else if (employee instanceof UniEmployee) {
                UniEmployee.Position uniPosition = UniEmployee.Position.valueOf(positionTemp.toUpperCase());
                ((UniEmployee) employee).setPosition(uniPosition);
            } else {
                throw new Exception("Position cannot be identified.");
            }
            employees.add(employee);
        }

        System.out.println("Printing all employees:");
        for (Employee e : employees) {
            System.out.println(e);
        }

        end();
    }

    static void init() {
        uniEmployeeList.add(new UniEmployee("Alice Johnson", 29, "Oxford University", UniEmployee.Position.LECTURER));
        uniEmployeeList.add(new UniEmployee("Robert Smith", 45, "University of Cambridge", UniEmployee.Position.PROF));
        uniEmployeeList.add(new UniEmployee("Michael Brown", 53, "Harvard University", UniEmployee.Position.ADMIN));
        uniEmployeeList.add(new UniEmployee("Emma Davis", 38, "MIT", UniEmployee.Position.LECTURER));
        uniEmployeeList.add(new UniEmployee("Olivia Wilson", 33, "Stanford University", UniEmployee.Position.PROF));

        itEmployeeList.add(new ITEmployee("James Taylor", 25, "Evosoft", ITEmployee.Position.JUNIOR, "Online Store"));
        itEmployeeList.add(new ITEmployee("William Miller", 42, "Simplesoft", ITEmployee.Position.MANAGER, "Payment System"));
    }

    static void end() {
        for (Employee uniEmployee : uniEmployeeList) {
            System.out.println(uniEmployee);
        }
        for (Employee itEmployee : itEmployeeList) {
            System.out.println(itEmployee);
        }

        int profCount = 0, lecturerCount = 0, adminCount = 0;
        for (Employee uniEmployee : uniEmployeeList) {
            if (((UniEmployee) uniEmployee).getPosition().toString().equalsIgnoreCase("PROF")) {
                profCount++;
            }
            if (((UniEmployee) uniEmployee).getPosition().toString().equalsIgnoreCase("LECTURER")) {
                lecturerCount++;
            }
            if (((UniEmployee) uniEmployee).getPosition().toString().equalsIgnoreCase("ADMIN")) {
                adminCount++;
            }
        }
        System.out.println("Statistics based on positions: PROF=" + profCount +
                "\tLECTURER=" + lecturerCount + "\tADMIN=" + adminCount);

        Employee testEmp = new ITEmployee("testName", 18, "asdsoft", ITEmployee.Position.JUNIOR, "test project");
        System.out.println("testEmp is instance of ITEmployee: " + (testEmp instanceof ITEmployee));
        System.out.println("testEmp is instance of UniEmployee: " + (testEmp instanceof UniEmployee));
    }
}
