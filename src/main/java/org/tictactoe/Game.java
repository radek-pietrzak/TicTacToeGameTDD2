package org.tictactoe;

import java.util.Objects;
import java.util.Scanner;

public class Game {

    private final Map map = new Map();
    private boolean xTurn = true;
    private boolean draw = false;
    private byte winner = 0;

    public boolean isDraw() {
        return draw;
    }

    public byte getWinner() {
        return winner;
    }

    public void startGame(Matrix matrix) {
        System.out.println("Let's start the game!!");
        System.out.println(map.getMap(matrix));
        startTurn(matrix);
    }

    public void startTurn(Matrix matrix) {

        checkWinner(matrix);

        if (winner == 1) {
            System.out.println("X wins");
            return;
        }

        if (winner == -1) {
            System.out.println("O wins");
            return;
        }

        checkDraw(matrix);

        if (draw) {
            System.out.println("Draw!!");
            return;
        }

        if (xTurn)
            System.out.println("Type X position.");
        else
            System.out.println("Type O position.");

        enterPosition(matrix);

        if (matrix.isLastChoiceBad()) {
            matrix.setLastChoiceBad(false);
            startTurn(matrix);
            return;
        }

        xTurn = !xTurn;

        startTurn(matrix);

    }


    public void enterPosition(Matrix matrix) {
        Scanner scanner = new Scanner(System.in);
        matrix.addToMatrix(xTurn, scanner.nextLine());
        System.out.println(map.getMap(matrix));
    }

    public void checkWinner(Matrix matrix) {
        checkFirstRowMatch(matrix);
        checkSecondRowMatch(matrix);
        checkThirdRowMatch(matrix);
        checkFirstColumnMatch(matrix);
        checkSecondColumnMatch(matrix);
        checkThirdColumnMatch(matrix);
        checkFirstSlantMatch(matrix);
        checkSecondSlantMatch(matrix);
    }

    public void checkDraw(Matrix matrix) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(matrix.getMatrix()[j][i], " "))
                    return;
            }
        }

        draw = true;
    }

    private void checkFirstRowMatch(Matrix matrix) {
        if (Objects.equals(matrix.getMatrix()[0][0], matrix.getMatrix()[0][1]) &&
                Objects.equals(matrix.getMatrix()[0][2], matrix.getMatrix()[0][1])) {
            if (Objects.equals(matrix.getMatrix()[0][0], "X"))
                winner = 1;
            if (Objects.equals(matrix.getMatrix()[0][0], "O"))
                winner = -1;
        }
    }

    private void checkSecondRowMatch(Matrix matrix) {
        if (Objects.equals(matrix.getMatrix()[1][0], matrix.getMatrix()[1][1]) &&
                Objects.equals(matrix.getMatrix()[1][2], matrix.getMatrix()[1][1])) {
            if (Objects.equals(matrix.getMatrix()[1][1], "X"))
                winner = 1;
            if (Objects.equals(matrix.getMatrix()[1][1], "O"))
                winner = -1;
        }
    }

    private void checkThirdRowMatch(Matrix matrix) {
        if (Objects.equals(matrix.getMatrix()[2][0], matrix.getMatrix()[2][1]) &&
                Objects.equals(matrix.getMatrix()[2][2], matrix.getMatrix()[2][1])) {
            if (Objects.equals(matrix.getMatrix()[2][1], "X"))
                winner = 1;
            if (Objects.equals(matrix.getMatrix()[2][1], "O"))
                winner = -1;
        }
    }

    private void checkFirstColumnMatch(Matrix matrix) {
        if (Objects.equals(matrix.getMatrix()[0][0], matrix.getMatrix()[1][0]) &&
                Objects.equals(matrix.getMatrix()[2][0], matrix.getMatrix()[1][0])) {
            if (Objects.equals(matrix.getMatrix()[1][0], "X"))
                winner = 1;
            if (Objects.equals(matrix.getMatrix()[1][0], "O"))
                winner = -1;
        }
    }

    private void checkSecondColumnMatch(Matrix matrix) {
        if (Objects.equals(matrix.getMatrix()[0][1], matrix.getMatrix()[1][1]) &&
                Objects.equals(matrix.getMatrix()[2][1], matrix.getMatrix()[1][1])) {
            if (Objects.equals(matrix.getMatrix()[1][1], "X"))
                winner = 1;
            if (Objects.equals(matrix.getMatrix()[1][1], "O"))
                winner = -1;
        }
    }

    private void checkThirdColumnMatch(Matrix matrix) {
        if (Objects.equals(matrix.getMatrix()[0][2], matrix.getMatrix()[1][2]) &&
                Objects.equals(matrix.getMatrix()[2][2], matrix.getMatrix()[1][2])) {
            if (Objects.equals(matrix.getMatrix()[1][2], "X"))
                winner = 1;
            if (Objects.equals(matrix.getMatrix()[1][2], "O"))
                winner = -1;
        }
    }

    private void checkFirstSlantMatch(Matrix matrix) {
        if (Objects.equals(matrix.getMatrix()[0][0], matrix.getMatrix()[1][1]) &&
                Objects.equals(matrix.getMatrix()[2][2], matrix.getMatrix()[1][1])) {
            if (Objects.equals(matrix.getMatrix()[1][1], "X"))
                winner = 1;
            if (Objects.equals(matrix.getMatrix()[1][1], "O"))
                winner = -1;
        }
    }

    private void checkSecondSlantMatch(Matrix matrix) {
        if (Objects.equals(matrix.getMatrix()[0][2], matrix.getMatrix()[1][1]) &&
                Objects.equals(matrix.getMatrix()[2][0], matrix.getMatrix()[1][1])) {
            if (Objects.equals(matrix.getMatrix()[1][1], "X"))
                winner = 1;
            if (Objects.equals(matrix.getMatrix()[1][1], "O"))
                winner = -1;
        }
    }

}
