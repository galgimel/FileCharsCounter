package org.example;

import java.io.*;

import java.util.Scanner;

public class CharsCounter {
    public void stringCharCounter(File file) throws FileNotFoundException {
        CharsCounterDTO dto = new CharsCounterDTO();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            char[] chars = line.toCharArray();
            int letter = 0;
            int digit = 0;
            int symbol;
            for (char c : chars) {
                if (Character.isLetter(c)) {
                    letter++;
                } else if (Character.isDigit(c)) {
                    digit++;
                }
            }
            symbol = chars.length - letter - digit;
            dto.getLetters().add(letter);
            dto.getSymbols().add(symbol);
        }
        scanner.close();
    }
}