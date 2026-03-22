import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            solution(Integer.valueOf(line.trim()));
        }
    }

    private static void solution(int tar) {
        if (tar == 1) {
            System.out.println(1);
            return;
        }
        int num = 1, len = 2;
        while (true) {
            num = (num * 10 + 1) % tar;
            if (num % tar == 0) {
                System.out.println(len);
                return;
            }
            len++;
        }
    }
}