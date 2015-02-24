import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.Arrays;
import java.util.StringTokenizer;

public class CTravel {

    public static final char blank = '.';
    public static final char tree = '*';
    public static final char me = 'c';
    public static final char finish = 'f';
    public static final char visited = 'v';

    public static char[][] maze;
    public static int seconds;
    public static int startX;
    public static int startY;
    public static int answer = 0;
    public static boolean solved;

    public static void readFromFile(File fin) throws IOException {
        FileInputStream fis = new FileInputStream(fin);

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = br.readLine();
	StringTokenizer st = new StringTokenizer(line);
        maze = new char[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
        seconds = Integer.parseInt(st.nextToken());

        String s;
        for (int i = 0; i < maze.length; i++) {
            s = br.readLine();
            for (int k = 0; k < maze[i].length; k++) {
                maze[i][k] = s.charAt(k);
            }
        }

        line = br.readLine();
	st = new StringTokenizer(line);
//        maze[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = me;
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        maze[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = finish;
    }

    public static void solve(int r , int c , int numsteps) {
        if (r < 0 || c < 0 || r > maze.length || c > maze[0].length) {
            return;
        }
        if (maze[r][c] == tree || maze[r][c] == me || maze[r][c] == visited || solved || numsteps >= seconds) {
            return;
        }
        if (maze[r][c] == finish && numsteps == seconds) {
            answer++;
            solved = true;
        } else {
            maze[r][c] = me;
            solve(r + 1 , c , numsteps + 1);
            solve(r - 1 , c , numsteps + 1);
            solve(r , c + 1 , numsteps + 1);
            solve(r , c - 1 , numsteps + 1);

            if (!solved) {
                maze[r][c] = visited;
            }
        }
    }

    public static void process() {
        solve(startX , startY , 0);
    }

    public static void writeout() throws IOException {
        PrintWriter fout = new PrintWriter(new File("ctravel.out"));
        fout.println(answer);
        fout.close();
        fout = null;
    }

    public static void main(String[] args) throws IOException {
        File fin = new File("ctravel.in");
        readFromFile(fin);
        process();
        writeout();
    }

}
