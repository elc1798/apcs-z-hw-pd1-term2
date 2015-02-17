public class KnightsTour {

	private int[][] board;
	private int knightX;
	private int knightY;
	private int knightChar;

	public KnightsTour() {
		board = new int[8][8];
	}

	public KnightsTour(int n) {
		board = new int[n][n];
	}

	//Initiates first step
	public void setup(int r , int c) {
		for (int[] ary : board) {
			for (int i : ary) {
				i = -1;
			}
		}

		board[r][c] = 0;
        System.out.println("Set board");
		knightX = r;
		knightY = c;
		knightChar = 0;
	}

	public void step(int r , int c) {
		if (board[r][c] != -1 || HWUTIL.checkKnightsTour(board)) {
			return;
		}
		HWUTIL.sleep(2000);
		fancyPrint();
		board[r][c] = knightChar;
		knightX = r;
		knightY = c;
		step(r + 1 , c);
		step(r - 1 , c);
		step(r , c + 1);
		step(r , c - 1);
		if (!HWUTIL.checkKnightsTour(board)) {
			board[r][c] = knightChar;
			knightChar++;
		}
	}

	public void fancyPrint() {
	    HWUTIL.clear();
        for (int[] ary : board) {
            for (int i : ary) {
                System.out.printf("| %dd " , i);
            }
            System.out.printf("|\n");
        }
	}

    public static void main(String[] args) {
        KnightsTour test = new KnightsTour(5);
        test.setup(0 , 0);
        System.out.println("Starting solver...");
        test.step(0 , 1);
        System.out.println("========== END ==========");
    }

}
