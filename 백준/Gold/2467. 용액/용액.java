import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> alkaliPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> acidPQ = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstAcid = Integer.MAX_VALUE, secondAcid = Integer.MAX_VALUE,
                firstAlkali = Integer.MIN_VALUE, secondAlkali = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int curr = Integer.parseInt(st.nextToken());
            if (curr > 0) {
                if (secondAcid >= curr) {
                    if (firstAcid >= curr) {
                        secondAcid = firstAcid;
                        firstAcid = curr;
                    } else {
                        secondAcid = curr;
                    }
                }
                acidPQ.add(curr);
            } else {
                if (secondAlkali <= curr) {
                    if (firstAlkali <= curr) {
                        secondAlkali = firstAlkali;
                        firstAlkali = curr;
                    } else {
                        secondAlkali = curr;
                    }
                }
                alkaliPQ.add(curr);
            }
        }

        int ret1 = Integer.MAX_VALUE, ret2 = Integer.MAX_VALUE;


        if (firstAcid + secondAcid > -1 * (firstAlkali + secondAlkali)) {
            ret1 = firstAcid;
            ret2 = secondAcid;
        } else {
            ret1 = secondAlkali;
            ret2 = firstAlkali;
        }

        while (!acidPQ.isEmpty() && !alkaliPQ.isEmpty()) {
            if (Math.abs(acidPQ.peek() + alkaliPQ.peek()) < Math.abs(ret1 + ret2)) {
                ret1 = alkaliPQ.peek();
                ret2 = acidPQ.peek();
            }
            if (acidPQ.peek() + alkaliPQ.peek() > 0) {
                alkaliPQ.poll();
            } else {
                acidPQ.poll();
            }
        }

        bw.write(ret1 + " " + ret2);
        bw.flush();
        bw.close();
        br.close();
    }
}