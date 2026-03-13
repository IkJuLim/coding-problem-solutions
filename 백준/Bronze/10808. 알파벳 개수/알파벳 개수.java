import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) cnt[c - 'a']++;

        for (int i : cnt) {
            System.out.print(i + " ");
        }
    }
}