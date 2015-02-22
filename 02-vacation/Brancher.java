import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Brancher {

    private int[][] board;
    private int r;
    private int c;
    private ArrayList<int[]> toCheck = new ArrayList<int[]>();

    public Brancher(int _r , int _c , int[][] _board) {
        board = _board;
        r = _r;
        c = _c;
        // Generate list
        toCheck.add(new int[]{ r - 2 , c - 1 });
        toCheck.add(new int[]{ r - 2 , c + 1 });
        toCheck.add(new int[]{ r - 1 , c - 2 });
        toCheck.add(new int[]{ r - 1 , c + 2 });
        toCheck.add(new int[]{ r + 1 , c - 2 });
        toCheck.add(new int[]{ r + 1 , c + 2 });
        toCheck.add(new int[]{ r + 2 , c - 1 });
        toCheck.add(new int[]{ r + 2 , c + 1 });
    }

    public int numChildren() {
        int children = 0;
        for (int[] coor : toCheck) {
            try {
                if (board[coor[0]][coor[1]] == KnightsTour.blank) {
                    children++;
                }
            } catch(Exception e) {}
        }
        return children;
    }

    public ArrayList<int[]> rank() {
        Collections.sort(toCheck , new Comparator<int[]>() {
            public int compare(int[] a , int[] b) {
                Brancher b_a = new Brancher(a[0] , a[1] , board);
                Brancher b_b = new Brancher(b[0] , b[1] , board);
                return b_a.numChildren() - b_b.numChildren();
            }
        });
        /*
        for (int[] coor : toCheck) {
            System.out.println(new Brancher(coor[0] , coor[1] , board).numChildren());
        }
         */
        return toCheck;
    }

}
