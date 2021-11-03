package main.TicTacToe;

public class Main {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        System.out.println("*** Tic-Tac-Toe ***");
        // Print Board
        new Board().printBoard();
        Thread game1 = new Thread(ticTacToe,"game1");
        Thread game2 = new Thread(ticTacToe,"game2");
        game1.start();
        game2.start();

    }

}

