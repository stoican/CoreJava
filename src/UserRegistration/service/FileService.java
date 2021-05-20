package UserRegistration.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileService {
    public static List<String> read(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }

    public static void write(String path, List<String> lines) throws IOException {
        Files.write(Paths.get(path), lines);
    }

    public static void append(String path, String s) throws IOException {
        final String ss = "\n" + s;
        Files.write(Paths.get(path), ss.getBytes(), StandardOpenOption.APPEND);
    }
}
