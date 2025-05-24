import java.util.*;

public class TicTacToe {
    static char[][] board = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };

    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int moves = 0;
        boolean gameEnded = false;

        while (!gameEnded && moves < 9) {

            printBoard();
            System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
            int move = sc.nextInt();

            if (makeMove(move)) {

                moves++;
                if (checkWin()) {

                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameEnded = true;

                } else {

                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';

                }
            } else {

                System.out.println("Invalid move! Try again.");

            }
        }

        if (!gameEnded) {

            printBoard();
            System.out.println("It's a draw!");

        }

        sc.close();
    }

    static void printBoard() {

        System.out.println("-------------");

        for (char[] row : board) {
            System.out.print("| ");
            for (char c : row) {
                System.out.print(c + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    static boolean makeMove(int pos) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == (char) (pos + '0')) {
                    board[i][j] = currentPlayer;
                    return true;
                }
            }
        }

        return false;
    }

    static boolean checkWin() {

        for (int i = 0; i < 3; i++) {

            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;

            }
        }

        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }
}
