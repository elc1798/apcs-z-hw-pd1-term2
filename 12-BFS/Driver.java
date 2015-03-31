public class Driver {
    public static void main(String[] args) {
        BFSMaze maze = new BFSMaze("MAZE.dat");
        maze.solve();
        maze.printSolution();
    }
}
