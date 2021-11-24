package org.tictactoe;

import java.util.Objects;
import java.util.Scanner;

public class Game {

    private final Map map = new Map();
    private boolean isXTurn = true;

    public void startGame(Matrix matrix) {
        System.out.println("Let's start the game!!");
        System.out.println(map.getMap(matrix));
        startTurn(matrix);
    }

    public void startTurn(Matrix matrix) {
        if (isXTurn)
            System.out.println("Type X position.");
        else
            System.out.println("Type O position.");

        enterPosition(matrix);

        if (isGameFinished(matrix)) {
            if (isXTurn) {
                System.out.println("X wins");
            }else {
                System.out.println("O wins");
            }
            return;
        }

        isXTurn = !isXTurn;
    }

    public void enterPosition(Matrix matrix) {
        Scanner scanner = new Scanner(System.in);
        matrix.addToMatrix(isXTurn, scanner.toString());
    }

    public boolean isGameFinished(Matrix matrix) {
        if (isFirstRowMatch(matrix))
            return true;
        if (isSecondRowMatch(matrix))
            return true;
        if (isThirdRowMatch(matrix))
            return true;
        if (isFirstColumnMatch(matrix))
            return true;
        if (isSecondColumnMatch(matrix))
            return true;
        if (isThirdColumnMatch(matrix))
            return true;
        if (isFirstSlantMatch(matrix))
            return true;
        return isSecondSlantMatch(matrix);
    }

    private boolean isFirstRowMatch(Matrix matrix) {
        return (Objects.equals(matrix.getMatrix()[0][0], "X") ||
                Objects.equals(matrix.getMatrix()[0][0], "O")) &&
                Objects.equals(matrix.getMatrix()[0][0], matrix.getMatrix()[0][1]) &&
                Objects.equals(matrix.getMatrix()[0][2], matrix.getMatrix()[0][1]);
    }

    private boolean isSecondRowMatch(Matrix matrix) {
        return (Objects.equals(matrix.getMatrix()[1][0], "X") ||
                Objects.equals(matrix.getMatrix()[1][0], "O")) &&
                Objects.equals(matrix.getMatrix()[1][0], matrix.getMatrix()[1][1]) &&
                Objects.equals(matrix.getMatrix()[1][2], matrix.getMatrix()[1][1]);
    }

    private boolean isThirdRowMatch(Matrix matrix) {
        return (Objects.equals(matrix.getMatrix()[2][0], "X") ||
                Objects.equals(matrix.getMatrix()[2][0], "O")) &&
                Objects.equals(matrix.getMatrix()[2][0], matrix.getMatrix()[2][1]) &&
                Objects.equals(matrix.getMatrix()[2][2], matrix.getMatrix()[2][1]);
    }

    private boolean isFirstColumnMatch(Matrix matrix) {
        return (Objects.equals(matrix.getMatrix()[0][0], "X") ||
                Objects.equals(matrix.getMatrix()[0][0], "O")) &&
                Objects.equals(matrix.getMatrix()[0][0], matrix.getMatrix()[1][0]) &&
                Objects.equals(matrix.getMatrix()[2][0], matrix.getMatrix()[1][0]);
    }

    private boolean isSecondColumnMatch(Matrix matrix) {
        return (Objects.equals(matrix.getMatrix()[0][1], "X") ||
                Objects.equals(matrix.getMatrix()[0][1], "O")) &&
                Objects.equals(matrix.getMatrix()[0][1], matrix.getMatrix()[1][1]) &&
                Objects.equals(matrix.getMatrix()[2][1], matrix.getMatrix()[1][1]);
    }

    private boolean isThirdColumnMatch(Matrix matrix) {
        return (Objects.equals(matrix.getMatrix()[0][2], "X") ||
                Objects.equals(matrix.getMatrix()[0][2], "O")) &&
                Objects.equals(matrix.getMatrix()[0][2], matrix.getMatrix()[1][2]) &&
                Objects.equals(matrix.getMatrix()[2][2], matrix.getMatrix()[1][2]);
    }

    private boolean isFirstSlantMatch(Matrix matrix) {
        return (Objects.equals(matrix.getMatrix()[0][0], "X") ||
                Objects.equals(matrix.getMatrix()[0][0], "O")) &&
                Objects.equals(matrix.getMatrix()[0][0], matrix.getMatrix()[1][1]) &&
                Objects.equals(matrix.getMatrix()[2][2], matrix.getMatrix()[1][1]);
    }

    private boolean isSecondSlantMatch(Matrix matrix) {
        return (Objects.equals(matrix.getMatrix()[0][2], "X") ||
                Objects.equals(matrix.getMatrix()[0][2], "O")) &&
                Objects.equals(matrix.getMatrix()[0][2], matrix.getMatrix()[1][1]) &&
                Objects.equals(matrix.getMatrix()[2][0], matrix.getMatrix()[1][1]);
    }

}
