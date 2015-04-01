public class Driver {
    public static void main(String[] args) {
        long startTime , endTime;

        AStarMaze maze1 = new AStarMaze("MAZE1.dat");
        startTime = System.nanoTime();

        maze1.solve();

        endTime = System.nanoTime() - startTime;

        System.out.println("Solved in " + endTime + " nanoseconds.");
        maze1.printSolution();
        System.out.println();

        AStarMaze maze2 = new AStarMaze("MAZE2.dat");
        startTime = System.nanoTime();

        maze2.solve();

        endTime = System.nanoTime() - startTime;

        System.out.println("Solved in " + endTime + " nanoseconds.");
        maze2.printSolution();
        System.out.println();

        AStarMaze maze3 = new AStarMaze("MAZE3.dat");
        startTime = System.nanoTime();

        maze3.solve();

        endTime = System.nanoTime() - startTime;

        System.out.println("Solved in " + endTime + " nanoseconds.");
        maze3.printSolution();
        System.out.println();
    }
}
