public class NQueens {

    private final char blank = ' ';
    private final char queen = 'Q';

    private char[][] board;
    private int numplaced = 0;
    
    private void fillBlank() {
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[i].length; k++) {
                board[i][k] = blank;
            }
        }
    }

    private NQueens() {
        board = new char[8][8];
        fillBlank();
    }

    private NQueens(int boardsize) {
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
            HWUTIL.sleep(100);
            fancyPrint();

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
        for (int i = 1; i < 9; i++) {
            nq = new NQueens(i);
            nq.cycleThrough();
            HWUTIL.sleep(5000);
            nq = null;
        }
    }
}
