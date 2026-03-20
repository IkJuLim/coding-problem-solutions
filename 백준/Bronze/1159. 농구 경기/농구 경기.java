import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[] chars = new int[26];
        for (int i = 0; i < n; i++) {
            chars[br.readLine().charAt(0) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (chars[i] >= 5) {
                sb.append(Character.toChars(i + 'a'));
            }
        }
        if (sb.length() == 0) sb.append("PREDAJA");

        System.out.println(sb.toString());
    }
}