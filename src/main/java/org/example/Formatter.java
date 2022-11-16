package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;

import static org.example.Constants.*;

public class Formatter {
    private CharsCounter counter;

    public Formatter(CharsCounter counter) {
        this.counter = counter;
    }

    public String format(File file) throws IOException {
        StringBuilder result = new StringBuilder();
        int max = maxLineLength(file);
        int count = -1;

        counter.stringCharCounter(file);
        CharsCounterDTO dto = counter.stringCharCounter(file);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String fileString = scanner.nextLine();
            count++;
            result.append(
                fileString +
                    space(max - fileString.length(), CHAR_SPACE_SPLIT) +
                    SPLIT +
                    dto.getLetters().get(count) +
                    SPLIT +
                    dto.getSymbols().get(count) +
                    "\n"
            );
        }
        scanner.close();
        return result.toString();
    }

    private int maxLineLength(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int max = 0;
        while (scanner.hasNextLine()) {
            String fileString = scanner.nextLine();
            if (fileString.length() > max) {
                max = fileString.length();
            }
        }
        return max;
    }

    public static String space(int length, char c) {
        StringBuilder space = new StringBuilder();
        space.append(String.valueOf(c).repeat(Math.max(0, length + 1)));
        return space.toString();
    }
}