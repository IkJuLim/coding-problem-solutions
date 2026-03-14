import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] price = new int[3], inTime = new int[3], outTime = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            price[i] = Integer.valueOf(st.nextToken()) * (i + 1);
        }
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            inTime[i] = Integer.valueOf(st.nextToken());
            outTime[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(inTime);
        Arrays.sort(outTime);
        int inIdx = 0, outIdx = 0, cnt = 0, ret = 0;

        for (int i = inTime[0]; i < outTime[2]; i++) {
            while (inIdx < 3 && inTime[inIdx] <= i) {
                cnt++;
                inIdx++;
            }
            while (outIdx < 3 && outTime[outIdx] <= i) {
                cnt--;
                outIdx++;
            }
            if (cnt != 0) {
                ret += price[cnt - 1];
            }
        }

        System.out.println(ret);
    }
}
