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
    private boolean SHOW_STEPS = false;

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

    public AStarMaze(String fin , boolean show) {
        this(fin);
        SHOW_STEPS = show;
    }

    public Node solve() {

        Node current = null;
        Node buffer = new Node(startCoor[0] , startCoor[1]);
        char ELEMENT = 'X';
        MazeHeap open = new MazeHeap();
        MazeHeap closed = new MazeHeap();

        buffer.tailCost = 0.0;
        buffer.headCost = 0.0;
        buffer.cost = buffer.tailCost + buffer.headCost;
        open.add(buffer);

        Node[] children = new Node[4];

        while (!open.empty()) {
            if (SHOW_STEPS) {
                sleepThenShow();
            }
            // Get node with priority from queue
            current = open.pop();
            closed.add(current);
            // Exit immediately if out of bounds
            if (outOfBounds(current)) {
                continue;
            }
            // Load element for easy access
            ELEMENT = grid[current.r][current.c];
            // Set the current grid element to a visited element
            if (ELEMENT == EMPTY) {
                grid[current.r][current.c] = VISITED;
            }
            if (ELEMENT == EMPTY || ELEMENT == START || ELEMENT == GOAL) {
                // Setup successors
                children = new Node[]{
                        new Node(current.r - 1 , current.c) ,
                        new Node(current.r + 1 , current.c) ,
                        new Node(current.r , current.c - 1) ,
                        new Node(current.r , current.c + 1)
                };
                // Check to see if successor should be added based on priority
                for (Node n : children) {
                    // If child is out of bounds or a wall or has been visited, do not process
                    if (outOfBounds(n) || grid[n.r][n.c] == WALL || grid[n.r][n.c] == VISITED) {
                        continue;
                    }
                    n.setParent(current);
                    if (grid[n.r][n.c] == GOAL) {
                        finishNode = n;
                        return n;
                    }
                    // Use costs to implement heuristics
                    n.tailCost = current.tailCost + distance(current , n);
                    n.headCost = (finishCoor[0] - n.r) * (finishCoor[0] - n.r) + (finishCoor[1] - n.c) * (finishCoor[1] - n.c);
                    n.cost = n.tailCost + n.headCost;

                    // Check if the node is best case for current position
                    boolean insert = true;
                    for (Node a : open.toArray()) {
                        if (a != null && a.r == n.r && a.c == n.c && a.cost < n.cost) {
                            insert = false;
                            break;
                        }
                    }
                    for (Node a : closed.toArray()) {
                        if (!insert) {
                            break;
                        }
                        if (a != null && a.r == n.r && a.c == n.c && a.cost < n.cost) {
                            insert = false;
                            break;
                        }
                    }
                    if (insert) {
                        open.add(n);
                    }
                }
            } else {
                continue;
            }
        }
        return null;
    }

    public void fancyPrint() {
        for (int i = 0; i < grid.length; i++) {
            for (int k = 0; k < grid[0].length; k++) {
                if (grid[i][k] == ME || grid[i][k] == VISITED) {
                    System.out.print("\033[1;31m" + grid[i][k] + " \033[m");
                } else if (grid[i][k] == START || grid[i][k] == GOAL) {
                    System.out.print("\033[1;32m" + grid[i][k] + " \033[m");
                } else {
                    System.out.print(grid[i][k] + " ");
                }
            }
            System.out.print("\n");
        }
    }

    public void printSolution() {
        char[][] board = grid;
        grid = clean;
        if (finishNode == null || finishNode.getParent() == null) {
            System.out.println("No solution");
            return;
        }
        Node tmp = finishNode.getParent();
        while (tmp.getParent() != null) {
            grid[tmp.r][tmp.c] = ME;
            tmp = tmp.getParent();
        }
        fancyPrint();
        grid = board;
    }

    private void sleepThenShow() {
        try {
            Thread.sleep(120);
        } catch(Exception e) {}
        System.out.println("\033\143");
        fancyPrint();
    }

    private boolean outOfBounds(Node n) {
        return n.r < 0 || n.c < 0 || n.r >= grid.length || n.c >= grid[0].length;
    }

    private double distance(Node n1 , Node n2) {
        return (n1.r - n2.r) * (n1.r - n2.r) + (n1.c - n2.c) * (n1.c - n2.c);
    }
}
