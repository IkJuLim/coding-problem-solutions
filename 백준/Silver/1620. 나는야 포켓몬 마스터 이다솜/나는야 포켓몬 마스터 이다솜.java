import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        String[] pocketmonsters = new String[n+1];
        Map<String, Integer> pocketmonsterMap = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            pocketmonsters[i] = br.readLine();
            pocketmonsterMap.put(pocketmonsters[i], i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String question = br.readLine();
            if (question.charAt(0) >= '0' && question.charAt(0) <= '9') {
                sb.append(pocketmonsters[Integer.valueOf(question)] + "\n");
            } else {
                sb.append(pocketmonsterMap.get(question) + "\n");
            }
        }
        System.out.println(sb);
    }
}