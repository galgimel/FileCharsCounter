package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CharsCounterTest {

    @ParameterizedTest
    @MethodSource("expectedAnswer")
    void stringCharCounter(List<String> fileArray, CharsCounterDTO expected) {
        CharsCounter counter = new CharsCounter();
        CharsCounterDTO actual = counter.stringCharCounter(fileArray);

        assertEquals(expected.toString(), actual.toString());
    }

    private static Stream<Arguments> expectedAnswer() {
        List<String> list1 = new ArrayList<>();
        list1.add("Ешь ананасы, рябчиков жуй,");
        list1.add("день твой последний приходит, буржуй.");
        CharsCounterDTO dto1 = new CharsCounterDTO();
        dto1.getLetters().add(21);
        dto1.getLetters().add(31);
        dto1.getSymbols().add(5);
        dto1.getSymbols().add(6);

        List<String> list2 = new ArrayList<>();
        list2.add("1234567890 074878346`0987-`375");
        list2.add("9809870987");
        CharsCounterDTO dto2 = new CharsCounterDTO();
        dto2.getLetters().add(0);
        dto2.getLetters().add(0);
        dto2.getSymbols().add(4);
        dto2.getSymbols().add(0);

        List<String> list3 = new ArrayList<>();
        list3.add("                                    ");
        list3.add("\\Letter\\ and 'Symbol'");
        CharsCounterDTO dto3 = new CharsCounterDTO();
        dto3.getLetters().add(0);
        dto3.getLetters().add(15);
        dto3.getSymbols().add(36);
        dto3.getSymbols().add(6);

        return Stream.of(
               Arguments.of(list1, dto1),
                Arguments.of(list2, dto2),
                Arguments.of(list3, dto3)
        );
    }
}