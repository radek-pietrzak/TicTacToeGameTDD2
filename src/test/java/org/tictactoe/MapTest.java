package org.tictactoe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class MapTest {

    private final Map map = new Map();
    @Mock
    private Matrix matrix;


    @Test
    void shouldPrintEmptyMap() {

        //given
        String[][] mockMatrix = {
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}
        };

        given(matrix.getMatrix()).willReturn(mockMatrix);

        String emptyMap = """
                 | |\s
                -+-+-
                 | |\s
                -+-+-
                 | |\s""";

        //when
        //then
        assertEquals(emptyMap, map.getMap(matrix));
    }

    @Test
    void shouldPrintMapAccordingToMatrix() {

        //given
        String[][] mockMatrix = {
                {"X", " ", " "},
                {"X", "O", "O"},
                {" ", " ", "X"}
        };

        given(matrix.getMatrix()).willReturn(mockMatrix);

        String expectedMap = """
                X| |\s
                -+-+-
                X|O|O
                -+-+-
                 | |X""";

        //when
        //then
        assertEquals(expectedMap, map.getMap(matrix));
    }

    @Test
    void shouldPrintEmptyMapIfGetNewMatrix() {

        //given
        Matrix matrix = new Matrix();

        String emptyMap = """
                 | |\s
                -+-+-
                 | |\s
                -+-+-
                 | |\s""";

        //when
        //then
        assertEquals(emptyMap, map.getMap(matrix));
    }

    void x() {

        //given
        //when
        //then
    }

}