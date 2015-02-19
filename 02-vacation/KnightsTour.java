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
		for (int asdf = 0; asdf < board.length; asdf++) {
            for (int qwerty = 0; qwerty < board[asdf].length; qwerty++) {
                board[asdf][qwerty] = -1;
            }
        }

//		board[r][c] = 0;
        System.out.println("Set board");
		knightX = r;
		knightY = c;
		knightChar = 0;
	}

	public void step_no_heuristic(int r , int c) {
		if (board[r][c] != -1 || HWUTIL.checkKnightsTour(board)) {
			return;
		}
		HWUTIL.sleep(500);
		fancyPrint();
		board[r][c] = knightChar;
		knightX = r;
		knightY = c;
		try {step_no_heuristic(r + 2 , c + 1);} catch(Exception e){}
		try {step_no_heuristic(r + 2 , c - 1);} catch(Exception e){}
		try {step_no_heuristic(r - 2 , c + 1);} catch(Exception e){}
		try {step_no_heuristic(r - 2 , c - 1);} catch(Exception e){}
		try {step_no_heuristic(r + 1 , c + 2);} catch(Exception e){}
		try {step_no_heuristic(r + 1 , c - 2);} catch(Exception e){}
		try {step_no_heuristic(r - 1 , c + 2);} catch(Exception e){}
		try {step_no_heuristic(r - 1 , c - 2);} catch(Exception e){}
		if (!HWUTIL.checkKnightsTour(board)) {
			board[r][c] = knightChar;
		}
	}

	public void fancyPrint() {
	    HWUTIL.clear();
        for (int asdf = 0; asdf < board.length; asdf++) {
            for (int qwerty = 0; qwerty < board[asdf].length; qwerty++) {
                System.out.printf("| %2d " , board[asdf][qwerty]);
            }
            System.out.printf("|\n");
        }
	}

    public static void main(String[] args) {
        KnightsTour test = new KnightsTour(5);
        test.setup(0 , 0);
        test.fancyPrint();
        System.out.println("Starting solver...");
        test.step_no_heuristic(0 , 0);
        System.out.println("========== END ==========");
        test = null;
        test = new KnightsTour();
        test.setup(0 , 0);
        test.fancyPrint();
        test.step_no_heuristic(0 , 1);
    }

}
