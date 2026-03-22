import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine()), ret = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (char c : str.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) {
                ret++;
            }

        }
        System.out.println(ret);
    }
}