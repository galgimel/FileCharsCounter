package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        CharsCounter counter = new CharsCounter();
        Formatter formatter = new Formatter(counter);
        List<String> fileArray = Files.readAllLines(Path.of("C:\\Users\\ASUS\\OneDrive\\Рабочий стол\\java_projects\\FileCharsCounter\\src\\main\\resources\\Poem"));

        System.out.println(formatter.format(fileArray));
    }
}