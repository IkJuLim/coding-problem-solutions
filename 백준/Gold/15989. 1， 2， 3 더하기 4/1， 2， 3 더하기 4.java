import java.io.*;
import java.util.*;

public class Main {
    static int[] dp = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp(n));
        }
    }

    private static int dp(int n) {
        if (n <= 1) return 1;
        if (dp[n] == 0) {
            int tmp = n / 3;
            boolean isOdd = n % 2 == 1;
            int p = n % 2 == 1 ? 0 : 1;

            while (tmp >= 1) {
                if (n - (n / 3 - tmp) * 3 != 4) {
                    p += 1;
                }
                tmp -= 2;
            }

            dp[n] = dp(n-1) + p;
        }

        return dp[n];
    }
}
