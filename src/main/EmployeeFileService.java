package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeFileService implements FileService<Employee> {
    @Override
    public void writeToFile(String filename, List<Employee> employees) {
        try {
            File file = new File(filename);
            FileWriter fileWriter = new FileWriter(file);

            for(Employee employee : employees) {
                if(employee instanceof UniEmployee) {
                    fileWriter.write(employee.getName() + ";" + employee.getAge() + ";" + employee.getWorkplace() + ";" + ((UniEmployee) employee).getPosition());
                    fileWriter.write("\n");
                } else if (employee instanceof ITEmployee) {
                    fileWriter.write(employee.getName() + ";" + employee.getAge() + ";" + employee.getWorkplace() + ";" + ((ITEmployee) employee).getPosition() + ";" + ((ITEmployee) employee).getProject());
                    fileWriter.write("\n");
                } else {
                    throw new Exception("The given list is not instance of UniEmployee or ITEmployee.");
                }
            }
            fileWriter.close();
            System.out.println("Data wrote successfully to file " + file.getName());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> readFromFile(String filename) {
        List<Employee> employeeList = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()) {
                String line = reader.nextLine();
                String [] parts = line.split(";");
                if(parts.length == 5) {
                   employeeList.add(new ITEmployee(parts[0], Integer.parseInt(parts[1]), parts[2], ITEmployee.Position.valueOf(parts[3].toUpperCase()), parts[4]));
                } else if (parts.length == 4) {
                    employeeList.add(new UniEmployee(parts[0], Integer.parseInt(parts[1]), parts[2], UniEmployee.Position.valueOf(parts[3].toUpperCase())));
                } else {
                    throw new Exception("Number of arguments does not match.");
                }
            }
            reader.close();
            System.out.println("Data read successfully from file " + file.getName());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employeeList;
    }
}
