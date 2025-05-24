import java.util.Scanner;

public class MazeGame {

    private static final char WALL = '#';
    private static final char PLAYER = 'P';
    private static final char EXIT = 'X';
    private static final char PATH = ' ';

    private static char[][] maze;
    private static int playerRow;
    private static int playerCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        maze = new char[][]{
            {'#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', '#'},
            {'#', ' ', '#', 'X', '#'},
            {'#', '#', '#', '#', '#'}
        };

        
        playerRow = 1;
        playerCol = 1;

        while (true) {
            printMaze();

            System.out.print("Move (w/a/s/d): ");
            char move = scanner.next().charAt(0);

            int newRow = playerRow;
            int newCol = playerCol;


            switch (move) {
                case 'w':
                    newRow--;
                    break;
                case 'a':
                    newCol--;
                    break;
                case 's':
                    newRow++;
                    break;
                case 'd':
                    newCol++;
                    break;
                default:
                    System.out.println("Invalid move! Use w/a/s/d.");
                    continue;
            }


            if (maze[newRow][newCol] == WALL) {
                System.out.println("You hit a wall!");
                continue;
            }


            if (maze[newRow][newCol] == EXIT) {
                System.out.println("🎉 You found the exit! You won!");
                break;
            }



            playerRow = newRow;
            playerCol = newCol;
        }

        scanner.close();
    }

    private static void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (i == playerRow && j == playerCol) {
                    System.out.print(PLAYER);
                } else {
                    System.out.print(maze[i][j]);
                }
            }
            System.out.println();
        }
    }
}
