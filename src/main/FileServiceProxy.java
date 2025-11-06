package main;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileServiceProxy implements FileService<Employee> {

    private static final Logger logger = Logger.getLogger(FileServiceProxy.class.getName());
    private final EmployeeFileService realService;

    public FileServiceProxy(EmployeeFileService realService) {
        this.realService = realService;
    }

    @Override
    public void writeToFile(String filename, List<Employee> employees) {
        logger.info("Checking before writing...");

        if (employees == null || employees.isEmpty()) {
            logger.warning("Empty list – nothing to write to the file.");
            return;
        }

        try {
            realService.writeToFile(filename, employees);
            logger.info("Write operation completed. File updated: " + filename);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during the write operation: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Employee> readFromFile(String filename) {
        logger.info("Starting read operation...");

        List<Employee> employees = null;

        try {
            employees = realService.readFromFile(filename);
            logger.info(employees.size() + " employees read from file.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during the read operation: " + e.getMessage(), e);
        }

        return employees;
    }
}
