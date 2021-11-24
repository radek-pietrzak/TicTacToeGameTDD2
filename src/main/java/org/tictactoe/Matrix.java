package org.tictactoe;

import java.util.Objects;

public class Matrix {

    private final String[][] matrix = {
            {" ", " ", " "},
            {" ", " ", " "},
            {" ", " ", " "}
    };
    private boolean isLastChoiceBad = false;

    public String[][] getMatrix() {
        return matrix;
    }

    public boolean isLastChoiceBad() {
        return isLastChoiceBad;
    }

    public void setLastChoiceBad(boolean lastChoiceBad) {
        isLastChoiceBad = lastChoiceBad;
    }

    public void addToMatrix(boolean isX, String position) {
        String actor;
        if (isValidPosition(position)) {

            if (isX) {
                actor = "X";
            } else {
                actor = "O";
            }

            int x = Integer.parseInt(position.substring(0, 1));
            int y = Integer.parseInt(position.substring(1, 2));

            if (Objects.equals(matrix[y - 1][x - 1], " "))
                matrix[y - 1][x - 1] = actor;
            else {
                System.out.println("Position already occupied.");
                isLastChoiceBad = !isLastChoiceBad;
            }

        } else {
            if (position.equals("help")) {
                Map helpMap = new Map();
                System.out.println(helpMap.getHelpMap());
            } else {
                System.out.println("Wrong input!! Enter two numbers 1, 2 or 3 each. Type \"help\" to show number positions.");
            }

            isLastChoiceBad = !isLastChoiceBad;
        }
    }

    private boolean isValidPosition(String position) {
        return position.length() == 2 &&
                position.substring(0, 1).matches("[1-3]") &&
                position.substring(1, 2).matches("[1-3]");
    }
}
