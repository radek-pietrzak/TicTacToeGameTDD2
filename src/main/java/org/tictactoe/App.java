package org.tictactoe;

public class App {

    public static void main(String[] args) {

        Matrix matrix = new Matrix();
        Game game = new Game();
        game.startGame(matrix);
    }
}
