import java.util.*;

class Solution {
    boolean[][] graph;
    boolean[] visited;

    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new boolean[n + 1][n + 1];
        for (int[] wire : wires) {
            graph[wire[0]][wire[1]] = true;
            graph[wire[1]][wire[0]] = true;
        }

        Queue<Integer> q = new LinkedList<>();
        int cnt;
        for (int i = 0; i < wires.length; i++) {
            visited = new boolean[n + 1];
            cnt = 0;
            q.add(1);
            visited[1] = true;
            while (!q.isEmpty()) {
                int curr = q.poll();
                cnt++;

                for (int j = 1; j < n + 1; j++) {
                    if (graph[curr][j] && !visited[j] &&
                            !((wires[i][0] == curr && wires[i][1] == j) || (wires[i][1] == curr && wires[i][0] == j))) {
                        q.add(j);
                        visited[j] = true;
                    }
                }
            }
            answer = Math.min(answer, Math.abs(n - 2 * cnt));
        }
        return answer;
    }
}