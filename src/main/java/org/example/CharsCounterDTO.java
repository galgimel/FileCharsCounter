package org.example;

import java.util.ArrayList;
import java.util.List;

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
}
