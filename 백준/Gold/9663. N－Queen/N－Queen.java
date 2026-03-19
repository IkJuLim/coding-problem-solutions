import java.io.*;
import java.util.*;

public class Main {
    private static int ret;
    private static int[] queens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ret = 0;
        queens = new int[n];
        for (int i = 0; i < n; i++) {
            queens[i] = -1;
        }
        recall(n, 0);
        System.out.println(ret);

    }

    private static void recall(int n, int row) {
        if (row >= n) {
            ret++;
        }
        for (int col = 0; col < n; col++) {
            if (isPosable(row, col)) {
                queens[row] = col;
                recall(n, row + 1);
            }
        }
    }

    private static boolean isPosable(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col ||
                    i + queens[i] == row + col ||
                    i - queens[i] == row - col)
                return false;
        }
        return true;
    }
}