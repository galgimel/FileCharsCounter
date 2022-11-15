package org.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CharsCounter counter = new CharsCounter();
        Formatter formatter = new Formatter(counter);
        File file = new File("Poem");

        System.out.println(formatter.format(file));
    }
}