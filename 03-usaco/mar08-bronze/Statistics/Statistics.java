import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.Arrays;

public class Statistics {

    public static double[] data;
    public static double mean;
    public static double median;
    public static double sum;

    public static void readFromFile(File fin) throws IOException {
        FileInputStream fis = new FileInputStream(fin);

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        int n = Integer.parseInt(br.readLine());

        data = new double[n];
        sum = 0.0;

        for (int i = 0; i < n; i++) {
            data[i] = Double.parseDouble(br.readLine());
            sum += data[i];
        }

    }
    public static void process() {
        mean = sum / data.length;
        Arrays.sort(data);
        if (data.length % 2 == 0) {
            median = data[data.length / 2] + data[data.length / 2 - 1];
            median = median / 2;
        } else {
            median = data[data.length / 2];
        }
        
    }

    public static void writeout() throws IOException {
        PrintWriter fout = new PrintWriter(new File("stats.out"));
        fout.println(mean);
        fout.println(median);
        fout.close();
        fout = null;
    }

    public static void main(String[] args) throws IOException {
        File fin = new File("stats.in");
        readFromFile(fin);
        process();
        writeout();
    }

}
