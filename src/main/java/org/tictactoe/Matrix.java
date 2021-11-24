package org.tictactoe;

public class Matrix {

    private String[][] matrix = {
            {" ", " ", " "},
            {" ", " ", " "},
            {" ", " ", " "}
    };

    public String[][] getMatrix() {
        return matrix;
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

            matrix[y - 1][x - 1] = actor;
        } else {
            System.out.println("Type proper position xy. Only two number 1, 2 or 3 each axis");
        }
    }

    private boolean isValidPosition(String position) {
        return position.length() == 2 &&
                position.substring(0, 1).matches("[1-3]") &&
                position.substring(1, 2).matches("[1-3]");
    }
}
