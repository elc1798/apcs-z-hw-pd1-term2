import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class AStarMaze {

    private static final char WALL = '#';
    private static final char EMPTY = ' ';
    private static final char ME = 'O';
    private static final char GOAL = 'F';
    private static final char VISITED = '.';
    private static final char START = 'S';

    private String INPUT_FILE;
    private char[][] grid;
    private char[][] clean;

    private int[] startCoor;
    private int[] finishCoor;

    private Node finishNode;

    public AStarMaze(String fin) {
        try {
            INPUT_FILE = fin;
            Scanner ifstream = new Scanner(new File(fin));
            ArrayList<String> DAT = new ArrayList<String>();
            while (ifstream.hasNext()) {
                DAT.add(ifstream.nextLine().trim());
            }
            ifstream.close(); ifstream = null;
            grid = new char[DAT.size()][DAT.get(0).length()];
            clean = new char[DAT.size()][DAT.get(0).length()];
            for (int r = 0; r < DAT.size(); r++) {
                for (int i = 0; i < grid[0].length; i++) {
                    grid[r][i] = DAT.get(r).charAt(i);
                    clean[r][i] = grid[r][i];
                    if (grid[r][i] == START) {
                        startCoor = new int[]{r , i};
                    } else if (grid[r][i] == GOAL) {
                        finishCoor = new int[]{r , i};
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public Node solve() {
        Node current = null;
        Node buffer = new Node(startCoor[0] , startCoor[1]);
        char ELEMENT = 'X';
        MazeQueue open = new MazeQueue();
        MazeQueue closed = new MazeQueue();
        
        buffer.tailCost = 0.0;
        buffer.headCost = 0.0;
        buffer.cost = buffer.tailCost + buffer.headCost;
        open.add(buffer);

        Node[] children = new Node[4];

        while (!open.empty()) {
            current = open.pop();
            if (outOfBounds(current)) {
                continue;
            }
            ELEMENT = grid[current.r][current.c];
            // Setup successors
            children = new Node[]{
                new Node(current.r - 1 , current.c) ,
                new Node(current.r + 1 , current.c) , 
                new Node(current.r , current.c - 1) ,
                new Node(current.r , current.c + 1)
            };
            for (Node n : children) {
                n.setParent(current);
                if (grid[n.r][n.c] == GOAL) {
                    finishNode = n;
                    return n;
                }
                n.tailCost = current.tailCost + 1;
                n.headCost = Math.sqrt(Math.pow(finishCoor[0] - n.r , 2) + Math.pow(finishCoor[1] - n.c , 2));
                n.cost = n.tailCost + n.headCost;

            }
        }
    }

    public void fancyPrint() {
        for (int i = 0; i < grid.length; i++) {
            for (int k = 0; k < grid[0].length; k++) {
                System.out.print(grid[i][k] + " ");
            }
            System.out.print("\n");
        }
    }

    public void printSolution() {
        char[][] board = grid;
        grid = clean;
        Node tmp = finishNode.getParent();
        while (tmp.getParent() != null) {
            grid[tmp.r][tmp.c] = ME;
            tmp = tmp.getParent();
        }
        fancyPrint();
        grid = board;
    }

    private boolean outOfBounds(Node n) {
        return n.r < 0 || n.c < 0 || n.r >= grid.length || n.c >= grid[0].length;
    }
}
