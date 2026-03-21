import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] chars = new int[26];

        String str = br.readLine();
        for (char c : str.toCharArray()) {
            chars[c - 'A']++;
        }

        StringBuilder sb = new StringBuilder();
        char oddChar = ' ';
        for (int i = 0; i < 26; i++) {
            if (chars[i] % 2 == 1) {
                if (oddChar != ' ') {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                chars[i]--;
                oddChar = (char) (i + 'A');
            }
            for (int j = 0; j < chars[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }
        }
        System.out.print(sb);
        if (oddChar != ' ') {
            System.out.print(oddChar);
        }
        System.out.println(sb.reverse());
    }
}