import java.util.ArrayList;
import java.util.Scanner;

public class KnightsTour {

    public static final int blank = -1;

    private int[][] board;
    private int nummoves = 0;
    private boolean useHeuristic = false;

    public boolean showSteps = false;

    private void fillBlank() {
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[i].length; k++) {
                board[i][k] = blank;
            }
        }
    }

    public KnightsTour() {
        board = new int[8][8];
        fillBlank();
    }

    public KnightsTour(int n) {
        board = new int[n][n];
        fillBlank();
    }

    public void fancyPrint() {
        HWUTIL.clear();
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[i].length; k++) {
                System.out.printf(" | %2d " , board[i][k]);
            }
            System.out.printf("|\n");
        }
    }

    public void solve(int r , int c) {
        if (nummoves >= board.length * board.length) { // Board is filled
            return;
        } else if (r < 0 || c < 0 || r >= board.length || c >= board.length) { // Out of bounds
            return;
        } else if (board[r][c] != blank) { // Already visited
            return;
        } else { // OK to move
            board[r][c] = nummoves; // Use move number as indicator so we can see all the steps
            nummoves++; // Increment the move number

            if (showSteps) {
                HWUTIL.sleep(100); // 0.1 second delay between moves
                fancyPrint(); // Show move
            }

            // Call all possible moves:
            if (useHeuristic) {
                generate_heuristic(r , c);
            } else {
                no_heuristic(r , c);
            }
            if (nummoves < board.length * board.length) { // Not solved :(
                nummoves--; // Decrement the number of moves since not right path after all branches were cycled
                board[r][c] = blank; // Reset the board
                return;
            }
        }
    }

    public void generate_heuristic(int r , int c) {
        /*
         * This heuristic uses Warnsdorff's rule:
         * 
         * Go to the spots with less branches first
         */
        Brancher b = new Brancher(r , c , board);
        ArrayList<int[]> moves = b.rank();
        for (int[] coor : moves) {
            solve(coor[0] , coor[1]);
        }

    }

    public void no_heuristic(int r , int c) {
        solve(r - 2 , c + 1);
        solve(r - 2 , c - 1);
        solve(r + 2 , c + 1);
        solve(r + 2 , c - 1);
        solve(r - 1 , c + 2);
        solve(r - 1 , c - 2);
        solve(r + 1 , c + 2);
        solve(r + 1 , c - 2);
    }

    public void enableHeuristics() {
        useHeuristic = true;
    }

    public void cycleThrough() {
        for (int i = 0; i < board.length && nummoves < board.length * board.length; i++) {
            fillBlank();
            nummoves = 0;
            solve(i , 0);
        }
        if (nummoves < board.length * board.length) {
            System.out.println("No solution found.");
        }
    }

    public static void main(String[] args) {
        KnightsTour k;
        long startTime;
        long runTime;
        boolean show = false;
        Scanner sc = new Scanner(System.in);
        System.out.printf("Show all steps? This will slow down the runtime.\n(Y/N): ");
        if (sc.nextLine().toUpperCase().startsWith("Y")) {
            show = true;
        }

        for (int i = 5; i < 10; i++) {
            k = new KnightsTour(i);
            k.enableHeuristics();
            if (show) {
                k.showSteps = true;
            }
            startTime = System.currentTimeMillis();
            k.cycleThrough();
            runTime = System.currentTimeMillis() - startTime;
            if (!show) { // Print out final solution if not showing all steps
                k.fancyPrint();
            }
            System.out.println("Solved in " + runTime + " ms.");
            HWUTIL.sleep(3000);
            k = null;
        }
    }

}
