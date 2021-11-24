package org.tictactoe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameTest {

    private final Game game = new Game();
    private final Matrix matrix = new Matrix();
    @Spy
    Game gameSpy = new Game();


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
    void shouldPrintInfoOnStartGame() {

        //given
        String result = """
                Let's start the game!!\r
                 | |\s
                -+-+-
                 | |\s
                -+-+-
                 | |\s\r
                """;

        willDoNothing().given(gameSpy).startTurn(matrix);

        //when
        gameSpy.startGame(matrix);

        //then
        assertEquals(result, byteArrayOutputStream.toString());
    }


    @Test
    void shouldEnterProperPosition() {

        //given
        String[][] result = {
                {" ", " ", " "},
                {"X", " ", "X"},
                {" ", "X", " "}
        };
        matrix.addToMatrix(true, "12");
        matrix.addToMatrix(true, "23");
//        matrix.addToMatrix(true, "32");

        String input = "32";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);

        //when
        game.enterPosition(matrix);
        //then
        assertEquals(Arrays.deepToString(result), Arrays.deepToString(matrix.getMatrix()));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/allWinCases.csv")
    void shouldReturnTrueIfGameIsFinishedForX(String pos1, String pos2, String pos3) {

        //given
        matrix.addToMatrix(true, pos1);
        matrix.addToMatrix(true, pos2);
        matrix.addToMatrix(true, pos3);

        //when
        //then
        assertTrue(gameSpy.isGameFinished(matrix));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/allWinCases.csv")
    void shouldReturnTrueIfGameIsFinishedForO(String pos1, String pos2, String pos3) {

        //given
        matrix.addToMatrix(false, pos1);
        matrix.addToMatrix(false, pos2);
        matrix.addToMatrix(false, pos3);

        //when
        //then
        assertTrue(gameSpy.isGameFinished(matrix));
    }


}