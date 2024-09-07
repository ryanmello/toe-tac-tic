import java.util.Scanner;

public class slTTTBoard {
    private char[][] board;
    private char player;

    public slTTTBoard() {
        board = new char[3][3];
        player = 'X';
        initializeBoard();
    }

    public void printBoard(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public void play(){
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while(!gameOver){
            System.out.println("Enter the row and col for your entry: ");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if(row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == '-'){
                board[row][col] = player;
                if (checkWin()) {
                    printBoard();
                    System.out.println("Player " + player + " wins!");
                    gameOver = true;
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("The game is a draw!");
                    gameOver = true;
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                    printBoard();
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        scanner.close();
    }

    private void initializeBoard(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = '-';
            }
        }
    }

    private boolean checkWin() {
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}

