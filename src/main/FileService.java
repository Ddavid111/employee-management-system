package main;

import java.util.List;

public interface FileService<T> {
    void writeToFile(String filename, List<T> employees);
    List<T> readFromFile(String filename);
}
