import java.util.Scanner;

public class NQueens {

    private final char blank = ' ';
    private final char queen = 'Q';

    private char[][] board;
    private int numplaced = 0;

    public boolean show = false;

    private void fillBlank() {
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[i].length; k++) {
                board[i][k] = blank;
            }
        }
    }

    public NQueens() {
        board = new char[8][8];
        fillBlank();
    }

    public NQueens(int boardsize) {
        board = new char[boardsize][boardsize];
        fillBlank();
    }

    public void fancyPrint() {
        HWUTIL.clear();
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[i].length; k++) {
                System.out.print("|" + board[i][k]);
            }
            System.out.printf("| \n");
        }
    }

    public boolean checkSafe(int r , int c) {
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[i].length; k++) {
                if (Math.abs(r - i) == Math.abs(c - k) && board[i][k] == queen) { // Diagonals :)
                    return false;
                }
                if (i == r || k == c) { // Vertical and horizontal
                    if (i == r && k == c) {
                        // Disregard self
                    } else if (board[i][k] == queen) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void solve(int r , int c) {
        if (numplaced >= board.length) { // All queens have been placed
            return;
        } else if (r < 0 || c < 0 || r >= board.length || c >= board[r].length) { // Out of bounds
            return;
        } else if (!checkSafe(r , c)) { // Queen intersects kill-path of another queen
            return;
        } else {
            board[r][c] = queen;
            numplaced++;
            if (show) {
                HWUTIL.sleep(100);
                fancyPrint();
            }

            /*
             * Apply soft heuristic first:
             *
             *   X
             * Q X
             *   X
             *
             * Given that the queen is placed in location Q, X marks locations
             * that the next queen cannot be placed
             */

            for (int i = 0; i < board.length; i++) {
                if (Math.abs(r - i) > 1) {
                    solve(i , c + 1);
                }
            }

            if (numplaced < board.length) { // Still not solved
                numplaced--; // Decrement
                board[r][c] = blank;
                return;
            }
        }
    }

    public void cycleThrough() {
        for (int i = 0; i < board.length && numplaced < board.length; i++) {
            fillBlank();
            solve(i , 0);
        }
        if (numplaced < board.length) {
            System.out.println("No solution found");
        }
    }

    public static void main(String[] args) {
        NQueens nq;
        long startTime;
        long runTime;
        boolean showSteps = false;
        Scanner sc = new Scanner(System.in);
        System.out.printf("Show all steps? This will slow down your runtime.\n(Y/N): ");
        if (sc.nextLine().toUpperCase().startsWith("Y")) {
            showSteps = true;
        }
        sc.close();

        // Warmup JVM (See KnightsTour.java for explanation)

        for (int i = 0; i < 10; i++) {
            NQueens warmup = new NQueens(8);
            warmup.cycleThrough();
            warmup = null;
        }

        for (int i = 1; i <= 20; i++) {
            nq = new NQueens(i);
            nq.show = false;
            startTime = System.nanoTime();
            nq.cycleThrough();
            runTime = System.nanoTime() - startTime;
            String msVal = Long.toString(runTime);
            while (msVal.length() < 7) {
                msVal = "0" + msVal;
            }
            msVal = msVal.substring(0 , msVal.length() - 6) + "." + msVal.substring(msVal.length() - 6);
            if (!showSteps) {
                nq.fancyPrint();
            }
            System.out.println(i + "x" + i + " board.");
            System.out.println("Solved in " + msVal + " ms.");
            HWUTIL.sleep(5000);
            nq = null;
        }
    }
}
