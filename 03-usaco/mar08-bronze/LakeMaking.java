import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.Arrays;

public class LakeMaking {

    public static int[][] lake;
    public static int LIMIT;
    public static int[][][] diggydiggyhole;
    public static int[] down;
    public static int answer = 0;

    public static void readFromFile(File fin) throws IOException {
        FileInputStream fis = new FileInputStream(fin);

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        
        String[] line = br.readLine().split("\\s+");
        lake = new int[Integer.parseInt(line[0])][Integer.parseInt(line[1])];
        LIMIT = Integer.parseInt(line[2]);
        
        int N = Integer.parseInt(line[3]);

        for (int i = 0; i < lake.length; i++) {
            line = br.readLine().split("\\s+");
            for (int k = 0; k < line.length; k++) {
                lake[i][k] = Integer.parseInt(line[k]);
            }
        }

        diggydiggyhole = new int[N][lake.length][lake[0].length];
        down = new int[N];

        for (int i = 0; i < diggydiggyhole.length; i++) {
            for (int k = 0; k < diggydiggyhole[i].length; k++) {
                Arrays.fill(diggydiggyhole[i][k] , 0);
            }
        }

        for (int i = 0; i < N; i++) {
            line = br.readLine().split("\\s+");
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    try { diggydiggyhole[i][Integer.parseInt(line[0]) + j][Integer.parseInt(line[1]) + k] += Integer.parseInt(line[2]); } catch(Exception e) {}
                }
            }
            down[i] = Integer.parseInt(line[2]);
        }

        br.close();

        // Verify
        
        System.out.println(LIMIT);

    }

    public static void dig(int[][] target , int d) {
        // Enumerate which ones to decrease
        
        int currmax = 0;

        for (int i = 0; i < target.length; i++) {
            for (int k = 0; k < target[i].length; k++) {
                if (lake[i][k] > currmax) {
                    currmax = lake[i][k];
                }
            }
        }

        for (int i = 0; i < target.length; i++) {
            if (d <= 0) { break; }
            for (int k = 0; k < target[i].length; k++) {
                if (lake[i][k] == currmax) {
                    currmax--;
                    lake[i][k] -= 1;
                    d--;
                }
            }
//            if (d <= 0) { break; }
        }

    }

    public static void invert() {
        for (int i = 0; i < lake.length; i++) {
            for (int k = 0; k < lake[i].length; k++) {
                lake[i][k] = LIMIT - lake[i][k];
                if (lake[i][k] > 0) {
                    answer += lake[i][k];
                }
            }
        }
    }

    public static void process() {
        for (int i = 0; i < diggydiggyhole.length; i++) {
            dig(diggydiggyhole[i] , down[i]);
        }
        invert();
    }

    public static void writeout() throws IOException {
        PrintWriter fout = new PrintWriter(new File("makelake.out"));
        answer = answer * 72 * 72;
        fout.println(answer);
        fout.close();
        fout = null;
    }

    public static void main(String[] args) throws IOException {
        File fin = new File("makelake.in");
        readFromFile(fin);
        process();
        writeout();
    }

}
