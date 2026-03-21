import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.valueOf(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tc; i++) {
            int n = Integer.valueOf(br.readLine()), ret = 1;
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String wearType = br.readLine().split(" ")[1];
                map.put(wearType, map.getOrDefault(wearType, 0) + 1);
            }
            int[] vals = map.values().stream().mapToInt(Integer::valueOf).toArray();
            for (int val : vals) {
                ret *= val + 1;
            }
            sb.append(ret - 1 + "\n");
        }
        System.out.println(sb);
    }
}