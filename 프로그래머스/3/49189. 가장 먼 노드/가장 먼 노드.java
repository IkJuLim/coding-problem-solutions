import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    boolean[] visited;
    int[] minDist;
    List<Integer>[] graph;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visited = new boolean[n + 1];
        minDist = new int[n + 1];

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] v : edge) {
            graph[v[0]].add(v[1]);
            graph[v[1]].add(v[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        minDist[1] = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int nextIndex :graph[cur]) {
                if(!visited[nextIndex]) {
                    visited[nextIndex] = true;
                    minDist[nextIndex] = minDist[cur]+1;
                    queue.add(nextIndex);
                }
            }
        }

        int maxD = -1;
        for (int i = 1; i < n + 1; i++) {
            if (maxD < minDist[i]) {
                maxD = minDist[i];
                answer = 1;
            } else if (maxD == minDist[i]) {
                answer++;
            }
        }

        return answer;
    }
}