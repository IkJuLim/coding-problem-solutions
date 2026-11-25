import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(BigInteger.TWO.pow(n).subtract(BigInteger.ONE));

        if (n <= 20) {
            recall(n, 1, 2, 3);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void recall(int n, int from, int empty, int to) throws IOException {
        if (n == 1) {
            bw.write(from + " " + to + "\n");
            return;
        }

        recall(n - 1, from, to, empty);
        bw.write(from + " " + to + "\n");
        recall(n - 1, empty, from, to);
    }
}