package main.TicTacToe;

public class Main {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        System.out.println("*** Tic-Tac-Toe ***");
        // Print Board for game 1
        new Board().printBoard();
        Thread game1 = new Thread(ticTacToe,"game1");
        game1.start();
        // Print Board for game 2
        new Board().printBoard();
        Thread game2 = new Thread(ticTacToe,"game2");
        game2.start();

    }

}

