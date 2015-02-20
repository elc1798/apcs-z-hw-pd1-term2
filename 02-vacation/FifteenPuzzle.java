import java.util.Random;

public class FifteenPuzzle {

    private final int blank = -1;

    private int[][] board;
    private int[][] complete;

    public int blankX;
    public int blankY;

    public void swap(int a , int b , int c , int d) {
        int tmp = board[c][d];
        board[c][d] = board[a][b];
        board[a][b] = tmp;
    }

    public void scramble() {
        Random r = new Random();
        int scramble_steps = r.nextInt(8) + 64; // Minumum of 64 steps for scramble
        int tmp = 0;
        for (int i = 0; i < scramble_steps; i++) {
            tmp = r.nextInt(4);
            try {
                switch (tmp) {
                case 0:
                    swap(blankX , blankY , blankX + 1 , blankY);
                    blankX = blankX + 1;
                    break;
                case 1:
                    swap(blankX , blankY , blankX - 1 , blankY);
                    blankX = blankX - 1;
                    break;
                case 2:
                    swap(blankX , blankY , blankX , blankY - 1);
                    blankY = blankY - 1;
                    break;
                case 3:
                    swap(blankX , blankY , blank , blankY - 1);
                    blankY = blankY - 1;
                    break;
                }
            } catch(Exception e) {
                i--;
            }
            
        }
    }

    public void setup() {
        int temp = 1;
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board.length; k++) {
                board[i][k] = temp;
                complete[i][k] = temp;
                temp++;
            }
        }
        board[3][3] = blank;
        complete[3][3] = blank;
        blankX = 3;
        blankY = 3;
        scramble();
    }

    public void fancyPrint() {
        HWUTIL.clear();
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board.length; k++) {
                System.out.printf(" | %2d " , board[i][k]);
            }
            System.out.printf("| \n");
        }
    }

    public boolean isFinished() {
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[i].length; i++) {
                if (board[i][k] != complete[i][k]) { return false; }
            }
        }
        return true;
    }

    public void solve(int targetX , int targetY) {
        if (isFinished()) {
            return;
        } else if (targetX < 0 || targetY < 0 || targetX >= board.length || targetY >= board.length) { // Out of bounds
            return;
        } else {
            swap(blankX , blankY , targetX , targetY);
            HWUTIL.sleep(100);
            fancyPrint();
            solve(targetX + 1 , targetY);
            solve(targetX - 1 , targetY);
            solve(targetX , targetY + 1);
            solve(targetX , targetY - 1);
       }
    }

    public FifteenPuzzle() {
        board = new int[4][4];
        complete = new int[4][4];
        setup();
    }

    public static void main(String[] args) {
        FifteenPuzzle p = new FifteenPuzzle();
        p.fancyPrint();
        p.solve(p.blankX + 1 , p.blankY);    
    
    }

}
