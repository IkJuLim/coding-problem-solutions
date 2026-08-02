import java.util.*;

class Solution {
    int n; // 정점의 개수
    int[][] graph; // 그래프를 표현하는 인접 리스트
    int[][] distance; // 최단 거리 배열
    final int INF = 1000000; // 무한대를 나타내는 값
    int startNode;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        this.n = n;
        distance = new int[n + 1][n + 1];

        graph = new int[n + 1][n + 1];
        for (int[] fare : fares) {
            graph[fare[0]][fare[1]] = fare[2];
            graph[fare[1]][fare[0]] = fare[2];
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if(graph[i][j] == 0) graph[i][j] = -1;
            }
        }

        for (startNode = 1; startNode <= n; startNode++) {
            dijkstra(startNode);
        }

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, distance[s][i] + distance[i][a] + distance[i][b]);
        }

        return answer;
    }

    private void dijkstra(int start) {
        boolean[] visited = new boolean[n + 1];

        // 최단 거리 배열을 무한대로 초기화 (시작 정점은 0으로 설정)
        Arrays.fill(distance[startNode], INF);
        distance[startNode][start] = 0;

        // 우선순위 큐 (최소 힙) 초기화
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(new int[]{start, 0});

        while (!queue.isEmpty()) {
            // 가장 최단 거리가 짧은 노드를 꺼내기
            int[] edge = queue.poll();

            if (!visited[edge[0]]) {
                visited[edge[0]] = true;

                for (int i = 1; i <= n; i++) {
                    if (graph[edge[0]][i] == -1) continue;
                    int weight = graph[edge[0]][i];

                    // 현재 노드를 거쳐 다른 노드로 가는 거리가 더 짧은 경우 최단 거리 배열 업데이트
                    if (!visited[i] && distance[startNode][edge[0]] + weight < distance[startNode][i]) {
                        distance[startNode][i] = distance[startNode][edge[0]] + weight;
                        queue.add(new int[]{i, distance[startNode][i]});
                    }
                }
            }
        }
    }
}