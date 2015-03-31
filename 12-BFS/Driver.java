public class Driver {
    public static void main(String[] args) {
        BFSMaze maze1 = new BFSMaze("MAZE1.dat");
        maze1.solve();
        maze1.printSolution();
        BFSMaze maze2 = new BFSMaze("MAZE2.dat");
        maze2.solve();
        maze2.printSolution();
        BFSMaze maze3 = new BFSMaze("MAZE3.dat");
        maze3.solve();
        maze3.printSolution();
    }
}
