public class Driver {
    public static void main(String[] args) {
        long startTime , endTime;

        // Warm up JVM for time testing
        for (int i = 0 , a = 0; i < 100000; i++) {
            a += 1;
        }

        AStarMaze maze1 = new AStarMaze("MAZE1.dat");
        startTime = System.nanoTime();

        maze1.solve();

        endTime = System.nanoTime() - startTime;

        System.out.println("Solved in " + nanoToMillis(endTime) + " milliseconds.");
        maze1.printSolution();
        System.out.println();

        AStarMaze maze2 = new AStarMaze("MAZE2.dat");
        startTime = System.nanoTime();

        maze2.solve();

        endTime = System.nanoTime() - startTime;

        System.out.println("Solved in " + nanoToMillis(endTime) + " milliseconds.");
        maze2.printSolution();
        System.out.println();

        AStarMaze maze3 = new AStarMaze("MAZE3.dat");
        startTime = System.nanoTime();

        maze3.solve();

        endTime = System.nanoTime() - startTime;

        System.out.println("Solved in " + nanoToMillis(endTime) + " milliseconds.");
        maze3.printSolution();
        System.out.println();

        AStarMaze maze4 = new AStarMaze("MAZE4.dat");
        startTime = System.nanoTime();

        maze4.solve();

        endTime = System.nanoTime() - startTime;
  
        System.out.println("Solved in " + nanoToMillis(endTime) + " milliseconds.");
        maze4.printSolution();
        System.out.println();
    }

    private static String nanoToMillis(long nano) {
        String tmp = Long.toString(nano);
        while (tmp.length() < 6) {
            tmp = "0" + tmp;
        }
        return tmp.substring(0 , tmp.length() - 6) + "." + tmp.substring(tmp.length() - 6);
    }
}
