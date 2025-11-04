package main;

import java.util.List;

public class FileServiceProxy implements FileService<Employee> {

    private final EmployeeFileService realService;

    public FileServiceProxy(EmployeeFileService realService) {
        this.realService = realService;
    }

    @Override
    public void writeToFile(String filename, List<Employee> employees) {
        System.out.println("[Proxy] Ellenőrzés írás előtt...");

        if (employees == null || employees.isEmpty()) {
            System.out.println("[Proxy] Üres lista – nincs mit fájlba írni.");
            return;
        }

        realService.writeToFile(filename, employees);
        System.out.println("[Proxy] Írás befejezve, fájl frissítve: " + filename);
    }

    @Override
    public List<Employee> readFromFile(String filename) {
        System.out.println("[Proxy] Beolvasás indítása...");

        List<Employee> employees = realService.readFromFile(filename);

        System.out.println("[Proxy] " + employees.size() + " dolgozó beolvasva a fájlból.");
        return employees;
    }
}
