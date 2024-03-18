package cat.insvidreres.inf.primeraentregathreads;

public class Ex7 {
    private static final int bounds = 6;
    private static final int[][] moves = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < bounds; i++) {
            for (int j = 0; j < bounds; j++) {
                System.out.println("Initial horse position: ( " + i + " , " + j + " )");
                int[][] board = new int[bounds][bounds];
                board[i][j] = 1;
                if (solveKnightTour(board, i, j, 2)) {
                    printBoard(board);
                } else {
                    System.out.println("No solution found.");
                }
                System.out.println("-----------------------------");
            }
        }

        long endTime = System.currentTimeMillis();
        long execTime = endTime - startTime;
        System.out.println("Execution Time: " + execTime + " milliseconds");
    }

    private static boolean solveKnightTour(int[][] board, int x, int y, int moveCount) {
        if (moveCount > bounds * bounds) {
            return true;
        }

        for (int[] move : moves) {
            int newX = x + move[0];
            int newY = y + move[1];
            if (isValidMove(board, newX, newY)) {
                board[newX][newY] = moveCount;
                if (solveKnightTour(board, newX, newY, moveCount + 1)) {
                    return true;
                }
                board[newX][newY] = 0;
            }
        }
        return false;
    }

    private static boolean isValidMove(int[][] board, int x, int y) {
        return x >= 0 && x < bounds && y >= 0 && y < bounds && board[x][y] == 0;
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.printf("| %2d ", num);
            }
            System.out.println("|");
        }
    }
}
