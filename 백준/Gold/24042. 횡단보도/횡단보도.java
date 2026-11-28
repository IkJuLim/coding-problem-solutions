import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        long[] visitTime = new long[n + 1];

        for (int i = 1; i <= m; i++) {
            String node = br.readLine();
            int v = Integer.parseInt(node.split(" ")[0]), u = Integer.parseInt(node.split(" ")[1]);
            graph[v].add(new int[]{u, i});
            graph[u].add(new int[]{v, i});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.add(new long[]{1L, 0L});
        visitTime[1] = 1L;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int currPos = (int) curr[0];
            long turn = curr[1] / (long) m, time = curr[1] % (long) m;
            for (int[] nextNode : graph[currPos]) {
                long nextW = ((time <= nextNode[1]) ? (turn * m) : ((turn + 1) * m)) + nextNode[1];
                if (visitTime[nextNode[0]] == 0 || visitTime[nextNode[0]] > nextW) {
                    visitTime[nextNode[0]] = nextW;
                    pq.add(new long[]{nextNode[0], visitTime[nextNode[0]]});
                }
            }
        }

        bw.write(String.valueOf(visitTime[n]));
        bw.flush();
        bw.close();
        br.close();
    }
}