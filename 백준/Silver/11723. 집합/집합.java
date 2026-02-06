import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int set = 0;
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("all")) {
                set = (1 << 21) - 1;
            } else if (cmd.equals("empty")) {
                set = 0;
            } else {
                int n = Integer.parseInt(st.nextToken()) - 1;
                if (cmd.equals("add")) {
                    set |= (1 << n);
                } else if (cmd.equals("remove")) {
                    set &= ~(1 << n);
                } else if (cmd.equals("check")) {
                    sb.append((set & (1 << n)) != 0 ? "1\n" : "0\n");
                } else if (cmd.equals("toggle")) {
                    set ^= (1 << n);
                }
            }
        }
        System.out.println(sb);
    }
}