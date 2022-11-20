package org.example;

import java.util.List;

public class CharsCounter {

    public CharsCounterDTO stringCharCounter(List<String> array) {
        CharsCounterDTO dto = new CharsCounterDTO();

        for (String line : array) {
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
        return dto;
    }
}