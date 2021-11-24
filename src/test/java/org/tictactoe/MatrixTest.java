package org.tictactoe;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    private final Matrix matrix = new Matrix();

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

    @TestFactory
    Collection<DynamicTest> shouldGetProperMatrixIfPositionsAreValid() {

        //given
        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        List<String> positions = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                positions.add(String.valueOf(i) + j);
            }
        }

        //when
        positions.forEach(position -> matrix.addToMatrix(true, position));

        //then
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x = j;
                int y = i;
                Executable executable = () -> assertEquals("X", matrix.getMatrix()[y][x]);
                String name = "Test of array position: " + x + y;
                DynamicTest dynamicTest = DynamicTest.dynamicTest(name, executable);
                dynamicTests.add(dynamicTest);
            }
        }

        return dynamicTests;
    }

    @ParameterizedTest
    @CsvSource({"111", "43", "14", "20", "330","a2"})
    void shouldPrintInfoIfInvalidInput(String position) {

        //given
        String expectedPrint = "Type proper position xy. Only two number 1, 2 or 3 each axis\r\n";

        //when
        matrix.addToMatrix(true, position);

        //then
        assertEquals(expectedPrint, byteArrayOutputStream.toString());

    }
}

