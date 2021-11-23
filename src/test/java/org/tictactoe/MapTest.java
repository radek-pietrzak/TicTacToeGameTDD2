package org.tictactoe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    private final PrintStream printStream = System.out;
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(printStream);
    }

    @Test
    void shouldPrintEmptyMap() {

        //given
        Map map = new Map();

        String emptyMap = """
                 | |\s
                -+-+-
                 | |\s
                -+-+-
                 | |\s
                """;

        //when
        map.printMap();

        //then
        assertEquals(emptyMap, byteArrayOutputStream.toString());
    }

    void x() {

        //given
        //when
        //then
    }

}