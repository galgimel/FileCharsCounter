package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormatterTest {

    @ParameterizedTest
    @MethodSource("expectedAnswer")
    void format(List fileArray, String expected) {
        CharsCounter counter = new CharsCounter();
        Formatter formatter = new Formatter(counter);
        String actual = formatter.format(fileArray);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> expectedAnswer() {
        List<String> list1 = new ArrayList<>();
        list1.add("Ешь ананасы, рябчиков жуй,");
        list1.add("день твой последний приходит, буржуй.");

        List<String> list2 = new ArrayList<>();
        list2.add("1234567890 074878346`0987-`375");
        list2.add("9809870987");

        List<String> list3 = new ArrayList<>();
        list3.add("                                    ");
        list3.add("\\Letter\\ and \'Symbol\'");
        return Stream.of(
            Arguments.of(list1,
                "Ешь ананасы, рябчиков жуй,            |21|5\n" +
                    "день твой последний приходит, буржуй. |31|6\n"),
            Arguments.of(list2,
                "1234567890 074878346`0987-`375 |0|4\n" +
                    "9809870987                     |0|0\n"),
            Arguments.of(list3,
                "                                     |0|36\n" +
                    "\\Letter\\ and 'Symbol'                |15|6\n")
        );
    }
}