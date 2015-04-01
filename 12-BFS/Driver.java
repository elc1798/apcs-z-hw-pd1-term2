public class Driver {
    public static void main(String[] args) {
        long startTime , endTime;

        BFSMaze maze1 = new BFSMaze("MAZE1.dat");
        startTime = System.nanoTime();

        maze1.solve();

        endTime = System.nanoTime() - startTime;

        System.out.println("Solved in " + endTime + " nanoseconds.");
        maze1.printSolution();
        System.out.println();

        BFSMaze maze2 = new BFSMaze("MAZE2.dat");
        startTime = System.nanoTime();

        maze2.solve();

        endTime = System.nanoTime() - startTime;

        System.out.println("Solved in " + endTime + " nanoseconds.");
        maze2.printSolution();
        System.out.println();

        BFSMaze maze3 = new BFSMaze("MAZE3.dat");
        startTime = System.nanoTime();

        maze3.solve();

        endTime = System.nanoTime() - startTime;

        System.out.println("Solved in " + endTime + " nanoseconds.");
        maze3.printSolution();
        System.out.println();
    }
}
