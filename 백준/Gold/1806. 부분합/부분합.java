import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken())-1;
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(Integer.parseInt(st.nextToken()));
        int sum = dq.peekLast(), answer = Integer.MAX_VALUE;

        while (!dq.isEmpty()) {
            if (sum >= s) {
                answer = Math.min(answer, dq.size());
                sum -= dq.pollFirst();
                continue;
            }
            if (n==0) break;
            n--;
            dq.addLast(Integer.parseInt(st.nextToken()));
            sum += dq.peekLast();
        }

        bw.write(String.valueOf(answer == Integer.MAX_VALUE ? 0 : answer));
        bw.flush();
        bw.close();
        br.close();
        return;
    }
}