package main;

import java.util.List;

public interface FileService<T> {
    void writeToFile(String filename, List<T> list);
    List<T> readFromFile(String filename);
}
