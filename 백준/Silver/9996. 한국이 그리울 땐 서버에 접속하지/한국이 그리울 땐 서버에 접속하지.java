import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        String regex = br.readLine();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) strs[i] = br.readLine();
        sb = new StringBuilder();
        for (String str : strs) isMatch(str, regex.split("\\*")[0], regex.split("\\*")[1]);
        System.out.println(sb);
    }

    private static void isMatch(String str, String start, String end) {
        if (str.length() < start.length() + end.length()) {
            sb.append("NE\n");
            return;
        }
        for (int i = 0; i < start.length(); i++) {
            if (str.charAt(i) != start.charAt(i)) {
                sb.append("NE\n");
                return;
            }
        }
        for (int i = 0; i < end.length(); i++) {
            if (str.charAt(str.length() - i - 1) != end.charAt(end.length() - i - 1)) {
                sb.append("NE\n");
                return;
            }
        }
        sb.append("DA\n");
    }
}