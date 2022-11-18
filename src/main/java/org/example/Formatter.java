package org.example;

import java.util.List;
import static org.example.Constants.*;

public class Formatter {
    private CharsCounter counter;

    public Formatter(CharsCounter counter) {
        this.counter = counter;
    }

    public String format(List<String> array) {
        StringBuilder result = new StringBuilder();
        int max = maxLineLength(array);
        int count = -1;

        counter.stringCharCounter(array);
        CharsCounterDTO dto = counter.stringCharCounter(array);

        for (String fileString : array) {
            count++;
            result.append(fileString)
                .append(space(max - fileString.length(), CHAR_SPACE_SPLIT))
                .append(SPLIT)
                .append(dto.getLetters().get(count))
                .append(SPLIT)
                .append(dto.getSymbols().get(count))
                .append("\n");
        }
        return result.toString();
    }

    private int maxLineLength(List<String> array) {
        int max = 0;
        for (String fileString : array) {
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