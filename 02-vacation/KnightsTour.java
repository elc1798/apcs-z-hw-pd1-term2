public class KnightsTour {

    private int[][] board;
    private int blank = -1;
    private int nummoves = 0;

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
        if (nummoves > board.length * board.length) { // Board is filled
            return;
        } else if (r < 0 || c < 0 || r >= board.length || c >= board.length) { // Out of bounds
            return;
        } else if (board[r][c] != blank) { // Already visited
            return;
        } else { // OK to move
            board[r][c] = nummoves; // Use move number as indicator so we can see all the steps
            nummoves++; // Increment the move number
            HWUTIL.sleep(100); // 0.1 second delay between moves
            fancyPrint(); // Show move
            // Call all possible moves:
            solve(r - 2, c + 1);
            solve(r - 2, c - 1);
            solve(r + 2, c + 1);
            solve(r + 2, c - 1);
            solve(r - 1, c + 2);
            solve(r - 1, c - 2);
            solve(r + 1, c + 2);
            solve(r + 1, c - 2);
            if (nummoves <= board.length * board.length) { // Not solved :(
                nummoves--; // Decrement the number of moves since not right path after all branches were cycled
                board[r][c] = blank; // Reset the board
                return;
            }
        }
    }

    public static void main(String[] args) {
        KnightsTour k = new KnightsTour(5); // Try 5 :)
        k.solve(0 , 0);
        k = null;
        k = new KnightsTour(); // Try 8 :)
        k.solve(0 , 0);
    }

}
