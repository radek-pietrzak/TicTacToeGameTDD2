package org.tictactoe;

public class Map {

    public String getMap(Matrix matrix){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(matrix.getMatrix()[i][j]);
                if (j < 2)
                    sb.append("|");
                else if (i < 2)
                    sb.append("\n");
            }
            if (i < 2)
                sb.append("-+-+-\n");
        }

        return sb.toString();
    }
}
