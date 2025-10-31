package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    // Used design patterns: iterator (for the lists), factory method, facade (read/write list elements from/to file)
    static List<Employee> uniEmployeeList = new ArrayList<>();
    static List<Employee> itEmployeeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        EmployeeFactoryImpl employeeFactory = new EmployeeFactoryImpl();
        init();

        /** using facade pattern to read/write from/to file **/
        EmployeeFileService employeeFileService = new EmployeeFileService();
        // read from file
        List<Employee> employeeList = employeeFileService.readFromFile("uniemployees.txt");
        System.out.println("Uni employees: " + employeeList);
        List<Employee> employeeList1 = employeeFileService.readFromFile("itemployees.txt");
        System.out.println("IT employees: " + employeeList1);

        // write to file
        employeeFileService.writeToFile("uniemployees.txt", uniEmployeeList);
        employeeFileService.writeToFile("itemployees.txt", itEmployeeList);

        /** using iterator pattern to process lists **/
        EmployeeIterator employeeIterator = new EmployeeIterator(itEmployeeList);
        System.out.println("current element: " + employeeIterator.getCurrentElement());
        System.out.println("next element: " + employeeIterator.getNextElement());
        System.out.println("current element: " + employeeIterator.getCurrentElement());
        System.out.println("has more element? " + employeeIterator.hasMoreElement());

        // reset the iterator
        employeeIterator.resetIterator();
        System.out.println("current element after reset: " + employeeIterator.getCurrentElement());

        while (employeeIterator.hasMoreElement()) {
            System.out.println(employeeIterator.getNextElement());
        }

        System.out.println("\n");
        EmployeeIterator employeeIterator1 = new EmployeeIterator(uniEmployeeList);
        System.out.println("current element: " + employeeIterator1.getCurrentElement());
        System.out.println("next element: " + employeeIterator1.getNextElement());
        System.out.println("current element: " + employeeIterator1.getCurrentElement());
        System.out.println("has more element? " + employeeIterator1.hasMoreElement());

        // reset the iterator
        employeeIterator1.resetIterator();

        while (employeeIterator1.hasMoreElement()) {
            System.out.println(employeeIterator1.getNextElement());
        }

        System.out.println("\n");

        /** using factory pattern to create instances **/

        List<Employee> employees = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
            System.out.println("Dolgozó munkahelye:");
            String workplace = scanner.nextLine();
            Employee employee = employeeFactory.createEmployee(workplace);
            employee.setWorkplace(workplace);

            System.out.println("Dolgozó neve: ");
            String name = scanner.nextLine();
            employee.setName(name);

            System.out.println("Dolgozó életkora: ");
            String age = scanner.nextLine();
            employee.setAge(Integer.parseInt(age));

            System.out.println("Dolgozó pozíciója: ");
            String positionTemp = scanner.nextLine();

            if(employee instanceof ITEmployee) {
                ITEmployee.Position itPosition = ITEmployee.Position.valueOf(positionTemp.toUpperCase());
                System.out.println("IT dolgozó projektje: ");
                String project = scanner.nextLine();
                ((ITEmployee) employee).setPosition(itPosition);
                ((ITEmployee) employee).setProject(project);

            } else if(employee instanceof UniEmployee) {
                UniEmployee.Position uniPosition = UniEmployee.Position.valueOf(positionTemp.toUpperCase());
                ((UniEmployee) employee).setPosition(uniPosition);
            } else {
                throw new Exception("Position cannot be identified.");
            }
            employees.add(employee);
        }

        System.out.println("Dolgozók kiírása:");
        for (Employee e : employees) {
            System.out.println(e);
        }


        end();
    }

    static void init() {
        uniEmployeeList.add(new UniEmployee("name 1", 25, "BME", UniEmployee.Position.ADMIN));
        uniEmployeeList.add(new UniEmployee("name 2", 41, "ME", UniEmployee.Position.PROF));
        uniEmployeeList.add(new UniEmployee("name 3", 61, "BME", UniEmployee.Position.PROF));
        uniEmployeeList.add(new UniEmployee("name 4", 20, "ME", UniEmployee.Position.LECTURER));
        uniEmployeeList.add(new UniEmployee("name 5", 34, "BME", UniEmployee.Position.LECTURER));

        itEmployeeList.add(new ITEmployee("name 1", 24, "evosoft", ITEmployee.Position.INTERN, "chat app"));
        itEmployeeList.add(new ITEmployee("name 2", 27, "simplesoft", ITEmployee.Position.MEDIOR, "pocket-money"));

    }

    static void end() {
        for (Employee uniEmployee: uniEmployeeList) {
            System.out.println(uniEmployee);
        }
        for (Employee itEmployee: itEmployeeList) {
            System.out.println(itEmployee);
        }

        // create statistics by uni
        int profCount = 0, lecturerCount = 0, adminCount = 0;
        for (Employee uniEmployee : uniEmployeeList) {
            if(((UniEmployee) uniEmployee).getPosition().toString().equalsIgnoreCase("PROF")) {
                profCount++;
            }
            if(((UniEmployee) uniEmployee).getPosition().toString().equalsIgnoreCase("LECTURER")) {
                lecturerCount++;
            }
            if(((UniEmployee) uniEmployee).getPosition().toString().equalsIgnoreCase("ADMIN")) {
                adminCount++;
            }
        }
        System.out.println("Statistics based on position: PROF=" + profCount + "\t LECTURER=" + lecturerCount + "\t ADMIN=" +adminCount);

        Employee testEmp = new ITEmployee("testName", 18, "asdsoft", ITEmployee.Position.JUNIOR, "test project");
        System.out.println("testEmp is instance of ITEmployee: " + (testEmp instanceof ITEmployee));
        System.out.println("testEmp is instance of UniEmployee: " + (testEmp instanceof UniEmployee));

    }
}
