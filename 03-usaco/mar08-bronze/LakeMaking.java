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
    public static int down;
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

        for (int i = 0; i < N; i++) {
            line = br.readLine().split("\\s+");
            System.out.println("INSTRUCTION: " + line[0] + " " + line[1] + " " + line[2]);
            down = Integer.parseInt(line[2]);
            dig(new int[]{Integer.parseInt(line[0]) , Integer.parseInt(line[1])} , down);
        }   

        br.close();
    }

    public static void dig(int[] target , int d) {
        // Enumerate which ones to decrease
        
        int currmax = 0;
        int x = target[0] - 1;
        int y = target[1] - 1;
        
        System.out.println();
        for (int i = 0; i < lake.length; i++) {
            System.out.println(Arrays.toString(lake[i]));
        }

        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                try {
                    if (lake[x + i][y + k] > currmax) {
                        currmax = lake[x + i][y + k];
                    }
                } catch(Exception e) {}
            }
        }

        while (d > 0) {
            for (int i = 0; i < 3; i++) {
                for (int k = 0; k < 3; k++) {
                    try {
                        if (lake[x + i][y + k] == currmax) {
                            lake[x + i][y + k] -= 1;
                        }
                    } catch(Exception e) {}
                }
            }
            currmax--;
            d--;
        }
    }

    public static void invert() {

        for (int i = 0; i < lake.length; i++) {
            System.out.println(Arrays.toString(lake[i]));
        }

        for (int i = 0; i < lake.length; i++) {
            for (int k = 0; k < lake[i].length; k++) {
                lake[i][k] = LIMIT - lake[i][k];
                if (lake[i][k] > 0) {
                    answer += lake[i][k];
                }
            }
        }

        System.out.println();

        for (int i = 0; i < lake.length; i++) {
            System.out.println(Arrays.toString(lake[i]));
        }
    }

    public static void process() {
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
