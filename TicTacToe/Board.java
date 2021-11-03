package main.TicTacToe;

public class Board {
    public static final int BOARD_SIZE = 3;
    public static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    Board(){
        for(int i = 0; i < BOARD_SIZE; i++){
            for (int j = 0; j < BOARD_SIZE; j++){
                    board[i][j] = '_';
            }

        }
    }
    public void printBoard(){
        System.out.println("--------------------------------");
        for (int i = 0; i < BOARD_SIZE; i++){
            System.out.print("|");
            for(int j = 0; j < BOARD_SIZE; j++){
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }
    public Boolean isPlaceEmpty(int row,int col){
        if (board[row-1][col-1] == 'X' || board[row-1][col-1] == 'O'){
            return true;
        }
        return false;
    }
    public  Boolean isBoardFull(){
        for (int i = 0; i < BOARD_SIZE; i++){
            for(int j = 0; j < BOARD_SIZE; j++){
                if(board[i][j] == '_'){
                    return true;
                }
            }

        }
        return false;
    }
    public Boolean Checkwinner(){
        if (board[0][0] != '_' && board[0][0] == board[0][1] && board[0][0] == board[0][2])
            return false;
        if (board[1][0] != '_' && board[1][0] == board[1][1] && board[1][0] == board[1][2])
            return false;
        if (board[2][0] != '_' && board[2][0] == board[2][1] && board[2][0] == board[2][2])
            return false;
        if (board[0][0] != '_' && board[0][0] == board[1][0] && board[0][0] == board[2][0])
            return false;
        if (board[0][1] != '_' && board[0][1] == board[1][1] && board[0][1] == board[2][1])
            return false;
        if (board[0][2] != '_' && board[0][2] == board[1][2] && board[0][2] == board[2][2])
            return false;
        if (board[0][0] != '_' && board[0][0] == board[1][1] && board[0][0] == board[2][2])
            return false;
        if (board[0][2] != '_' && board[0][2] == board[1][1] && board[0][2] == board[2][0])
            return false;

        return true;
    }
}
