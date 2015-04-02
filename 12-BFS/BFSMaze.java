import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class BFSMaze {

    private static final char WALL = '#';
    private static final char EMPTY = ' ';
    private static final char ME = 'O';
    private static final char GOAL = 'F';
    private static final char VISITED = '.';
    private static final char START = 'S';

    private String INPUT_FILE;
    private char[][] grid;
    private char[][] clean;
    private MazeQueue queue;

    private int[] startCoor;
    private int[] finishCoor;

    private Node finishNode;

    public BFSMaze(String fin) {
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
        queue = new MazeQueue();
    }

    public Node solve() {
        Node current = null;
        Node buffer = new Node(startCoor[0] , startCoor[1]);
        char ELEMENT = ' ';

        buffer.setParent(null);
        queue.add(buffer);
        while (!queue.empty()) {
            current = queue.pop();
            if (
                    current.r < 0 ||
                    current.c < 0 ||
                    current.r >= grid.length ||
                    current.c >= grid[0].length
                    ) {
                continue;
            }
            ELEMENT = grid[current.r][current.c];
            if (ELEMENT == GOAL) {
                finishNode = current;
                return current;
            }
            if (ELEMENT == WALL || ELEMENT == VISITED) {
                continue;
            }

            grid[current.r][current.c] = VISITED;
            Node iter0 = new Node(current.r - 1 , current.c);
            Node iter1 = new Node(current.r + 1 , current.c);
            Node iter2 = new Node(current.r , current.c - 1);
            Node iter3 = new Node(current.r , current.c + 1);
            iter0.setParent(current);
            iter1.setParent(current);
            iter2.setParent(current);
            iter3.setParent(current);
            queue.add(iter0);
            queue.add(iter1);
            queue.add(iter2);
            queue.add(iter3);
        }
        return null;
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
}
