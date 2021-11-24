package org.tictactoe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

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

    @Test
    void shouldPrintHelpMap() {

        //given
        String result = """
                11|21|31
                --+--+--
                12|22|32
                --+--+--
                13|23|33""";

        //when
        //then
        assertEquals(result, map.getHelpMap());
    }


}