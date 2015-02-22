import java.util.Arraylist;
import java.util.Random;

public class FifteenPuzzle {
    
    /*
     * This version of the fifteen puzzle will ONLY work with a 4x4 board. It
     * uses a specific strategy.
     *
     * 1. Solve 1 and 2
     * 2. Solve 3
     * 3. Setup 4, then solve using known pattern
     * 4. Solve 5 and 6 and 7
     * 5. Solve 8 using known pattern
     * 6. Solve 9 and 13
     * 7. Solve 10 and 14
     * 8. Cycle through 11,12,15 and finish
     *
     */

    private Tile[][] board;
    private Tile blank;
    private int[][] locations;

    public FifteenPuzzle() {
        board = new Tile[4][4];
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 4; k++) {
                if (i ==3 && k == 3) {
                    board[3][3] = new Tile(-1 , i , k , board); // Blank Tile
                } else {
                    board[i][k] = new Tile(i + k + 1 , i , k , board);
                }
            }
        }
        blank = board[3][3];
        scramble();
        locations = new int[16];
    }

    public void scramble() {
        Random r = new Random();
        int initial_direction = r.nextInt(100) % 2;
        /*
         * Directions:
         * 0 = up
         * 1 = left
         * 2 = down
         * 3 = right
         */
        for (int i = 0; i < 24; i++) {
            switch (initial_direction) {
                case 0:
                    blank.swap(blank.r - 1 , blank.c);
                    break;
                case 1:
                    blank.swap(blank.r , blank.c - 1);
                    break;
                case 2:
                    blank.swap(blank.r + 1 , blank.c);
                    break;
                case 3:
                    blank.swap(blank.r , blank.c + 1);
                    break;
                default:
                    // Do nothing
                    break;
            }
        }
        updateLoc();
    }

    public void updateLoc() {
        for (Tile[] ary : board) {
            for (Tile t : ary) {
                locations[t.id - 1] = {t.r , t.c};
            }
        }
    }

    public void step1() {
        
    }
}
