package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.Constants.*;

public class CharsCounterDTO {
    private List<Integer> letters = new ArrayList<>();
    private List<Integer> symbols = new ArrayList<>();

    public List<Integer> getLetters() {
        return letters;
    }

    public void setLetters(List<Integer> letters) {
        this.letters = letters;
    }

    public List<Integer> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Integer> symbols) {
        this.symbols = symbols;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < letters.size(); i++) {
            result.append(getLetters().get(i));
            result.append(SPLIT);
            result.append(getSymbols().get(i));
            result.append(SPACE_SPLIT);
        }
        return result.toString();
    }
}
