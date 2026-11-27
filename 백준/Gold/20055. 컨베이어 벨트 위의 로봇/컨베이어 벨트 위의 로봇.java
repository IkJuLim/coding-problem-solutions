import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int len = 2 * n;
        int[] a = new int[len];
        boolean[] robot = new boolean[len];

        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (a[i] == 0) {
                cnt++;
            }
        }

        int s = 0;
        int e = n - 1;
        int ret = 0;

        while (cnt < k) {
            ret++;

            s = (s - 1 + len) % len;
            e = (e - 1 + len) % len;
            if (robot[e]) {
                robot[e] = false;
            }

            for (int i = 1; i < n; i++) {
                int cur = (e - i + len) % len;
                int next = (cur + 1) % len;

                if (robot[cur] && !robot[next] && a[next] > 0) {
                    robot[cur] = false;
                    a[next]--;
                    if (a[next] == 0) {
                        cnt++;
                    }
                    if (next != e) {
                        robot[next] = true;
                    }
                }
            }

            if (a[s] > 0 && !robot[s]) {
                robot[s] = true;
                a[s]--;
                if (a[s] == 0) {
                    cnt++;
                }
            }
        }

        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
        br.close();
    }
}