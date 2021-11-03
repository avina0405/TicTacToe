package main.TicTacToe;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe implements Runnable {

    Board board = new Board();
    Scanner input = new Scanner(System.in);
    char[][] drawBoard = Board.board;
    public char turn = 'X';
    @Override
    public void run(){
        // Print the board

        synchronized (this){
            while(board.Checkwinner()){
                // Scan user input
                if(!board.isBoardFull()){
                    System.out.println("No one is winner!");
                    System.exit(1);
                }
                System.out.println("Game Name: "+Thread.currentThread().getName());
                System.out.println("Enter Row");
                try{
                    int row = input.nextInt();
                    System.out.println("Enter Column");
                    int col = input.nextInt();
                    // Check input is valid ot not.
                    if (row > Board.BOARD_SIZE || col > Board.BOARD_SIZE) {
                        throw new InputErrorHandler("Input is invalid.Try again!");

                    }else{
                        if(board.isPlaceEmpty(row,col)){
                            System.err.println("Place is already taken");
                        }else{
                            drawBoard[row - 1][col - 1] = getTurn();
                            changePlayer();
                            board.printBoard();
                        }
                        notify();
                        wait();
                    }

                }catch(InputMismatchException e){
                    System.out.println("Number is not valid!");
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (InputErrorHandler inputErrorHandler) {
                    System.out.println(inputErrorHandler.toString());
                }


            }
            changePlayer();
            System.out.println("the winner is: "+Thread.currentThread().getName());
            System.exit(1);
        }
    }


    public synchronized char getTurn(){
        return turn;
    }

    public synchronized void changePlayer(){
        if(turn == 'X'){
            turn = 'O';
        }else{
            turn = 'X';
        }
    }
}