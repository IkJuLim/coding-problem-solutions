class Solution {
  boolean[][] graph;
  boolean[] visited;
  char[] colors;
  public boolean possibleBipartition(int n, int[][] dislikes) {
    graph = new boolean[n][n];
    visited = new boolean[n];
    colors = new char[n];

    for (int[] dislike : dislikes) {
      graph[dislike[0]-1][dislike[1]-1] = true;
      graph[dislike[1]-1][dislike[0]-1] = true;
    }
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        if (!dfs(n, i, -1, 'B')) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean dfs(int n, int node, int pNode, char color) {
    if (visited[node]) {
      if (colors[node] == color) {
        return true;
      }
      return false;
    }
    visited[node] = true;
    colors[node] = color;
    for (int i = 0; i < n; i++) {
      if (i != pNode && graph[node][i] && !dfs(n, i, node, (color == 'B' ? 'R' : 'B'))) {
        return false;
      }
    }
    return true;
  }
}
//바이파트 그래프 문제로 생각하고 컬러링 했습니다.