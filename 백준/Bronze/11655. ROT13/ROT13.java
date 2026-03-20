import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == ' ' || (c >= '0' && c <= '9')) {
                sb.append(c);
            } else if (c >= 'a' && c <= 'z') {
                c += 13;
                if (c > 'z') c -= 26;
                sb.append(c);
            } else if (c >= 'A' && c <= 'Z') {
                c += 13;
                if (c > 'Z') c -= 26;
                sb.append(c);
            }

        }

        System.out.println(sb);
    }
}