public class Tile {
    // Instance of a single tile on the Fifteen Puzzle Board
    
    public int id;
    public int r;
    public int c;
    public boolean inPlace = false;

    private Tile[][] myGrid;

    public Tile(int _id , int _r , int _c , Tile[][] board) {
        id = _id;
        r = _r;
        c = _c;
        myGrid = board;
    }

    public void swap(int targetRow , int targetCol) {
        if (manhattanDist(targetRow , targetCol) > 1) {
            return;
        }
        // Backup
        int[] tmp = new int[]{r , c , id};
        // Assign this -> target
        r = board[targetRow][targetCol].r;
        c = board[targetRow][targetCol].c;
        id = board[targetRow][targetCol].id;
        // Assign target -> this
        board[targetRow][targetCol].r = tmp[0];
        board[targetRow][targetCol].c = tmp[1];
        board[targetRow][targetCol].id = tmp[2];
    }

    public int manhattanDist(int targetRow , int targetCol) {
        return Math.abs(r - targetRow) + Math.abs(c - targetCol);
    }

}
